package org.omoknoone.onionhotsayyo.notification.command.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.member.aggregate.Member;
import org.omoknoone.onionhotsayyo.member.repository.MemberRepository;
import org.omoknoone.onionhotsayyo.member.service.MemberService;
import org.omoknoone.onionhotsayyo.notification.command.aggregate.Notification;
import org.omoknoone.onionhotsayyo.notification.command.dto.NotificationDTO;
import org.omoknoone.onionhotsayyo.notification.command.repository.EmitterRepository;
import org.omoknoone.onionhotsayyo.notification.command.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class NotificationService {

	private final MemberRepository memberRepository;
	private static final Long DEFAULT_TIMEOUT = 60L * 1000 * 60;
	private final NotificationRepository notificationRepository;
	private final EmitterRepository emitterRepository;
	private final ModelMapper modelMapper;

	public NotificationService(MemberRepository memberRepository, NotificationRepository notificationRepository,
		EmitterRepository emitterRepository, ModelMapper modelMapper) {
		this.memberRepository = memberRepository;
		this.notificationRepository = notificationRepository;
		this.emitterRepository = emitterRepository;
		this.modelMapper = modelMapper;
	}

	// 로그인 한 유저 emitter 생성
	public SseEmitter subscribe(String userId, String lastEventId) {

		// Last-Event-Id 값에서 데이터가 유실된 시점을 파악하기 위하여 시간까지 표시되게 함
		String id = userId + "_" + System.currentTimeMillis();

		// emitter 저장
		SseEmitter emitter = emitterRepository.save(id, new SseEmitter(DEFAULT_TIMEOUT));

		// 연결 종료 처리
		emitter.onCompletion(() -> emitterRepository.deleteById(id));
		emitter.onTimeout(() -> emitterRepository.deleteById(id));

		// 503 에러를 방지하기 위해 접속되었을 때 더미 이벤트 전송
		sendToClient(emitter, id, "EventStream Created. [userId=" + userId + "]");

		// 클라이언트가 미수신한 Event 목록이 존재할 경우 전송하여 Event 유실을 예방
		if (!lastEventId.isEmpty()) {
			Map<String, SseEmitter> events = emitterRepository.findAllEmitterStartWithByMemberId(userId);
			events.entrySet().stream()
				.filter(entry -> lastEventId.compareTo(entry.getKey()) < 0)
				.forEach(entry -> sendToClient(emitter, entry.getKey(), entry.getValue()));
		}

		return emitter;
	}

	private void sendToClient(SseEmitter emitter, String id, Object data) {
		System.out.println("[sendToClient] emitter = " + emitter);
		System.out.println("id = " + id);
		System.out.println("data = " + data);
		try {
			emitter.send(SseEmitter.event()
				.id(id)
				.name("sse")
				.data(data));
		} catch (IOException exception) {
			emitterRepository.deleteById(id);
			throw new RuntimeException("emitter 연결 오류");
		}
	}

	public void send(String receiverName, String content) {
		System.out.println("[send] receiverName = " + receiverName);
		Member receiver = memberRepository.findByMemberId(receiverName);
		System.out.println("receiver = " + receiver);
		Notification notification = notificationRepository.save(createNotification(receiver, content));
		System.out.println("notification = " + notification);

		// String eventCreatedTime = receiverName + "_" + System.currentTimeMillis();

		// 로그인 한 유저의 emitter 모두 가져오기
		Map<String, SseEmitter> emitters = emitterRepository.findAllEmitterStartWithByMemberId(receiverName);
		System.out.println("[send] emitters = " + emitters);
		emitters.forEach(
			(keyOfReceiverName, emitter) -> {
				System.out.println("keyOfReceiverName = " + keyOfReceiverName);
				System.out.println("emitter = " + emitter);
				emitterRepository.saveEventCache(keyOfReceiverName, notification);

				sendToClient(emitter, keyOfReceiverName, modelMapper.map(notification, NotificationDTO.class));
			}
		);
	}

	private Notification createNotification(Member receiver, String content) {
		// return Notification.builder()
		// 	.receiver(receiver)
		// 	.content(content)
		// 	.review(review)
		// 	.url("/reviews/" + review.getId())
		// 	.isRead(false)
		// 	.build();
		Notification notification = new Notification();
		notification.setMemberId(receiver.getMemberId());
		notification.setChecked(false);
		notification.setMessage(content);
		// notification.setUrl();
		notification.setEventTime(LocalDateTime.now());

		return notification;
	}


	// 알림을 '읽음' 상태로 만듦
	public void checkNotification (Notification notification) {
		notification.setChecked(true);
		notificationRepository.save(notification);
	}




}
