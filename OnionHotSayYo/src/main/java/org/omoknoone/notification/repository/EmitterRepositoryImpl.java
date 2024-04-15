package org.omoknoone.notification.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Repository
public class EmitterRepositoryImpl implements EmitterRepository{

	private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();
	private final Map<String, Object> eventCache = new ConcurrentHashMap<>();


	public EmitterRepositoryImpl() {
	}


	@Override
	public SseEmitter save(String emitterId, SseEmitter sseEmitter) {
		emitters.put(emitterId, sseEmitter);
		return sseEmitter;
	}

	@Override
	public void saveEventCache(String eventCacheId, Object event) {
		eventCache.put(eventCacheId, event);
	}

	@Override
	public Map<String, SseEmitter> findAllEmitterStartWithByMemberId(String memberId) {
		System.out.println("memberId = " + memberId);
		System.out.println("emitters = " + emitters);
		Map<String, SseEmitter> tempMap = emitters.entrySet().stream()
			.filter(entry -> entry.getKey().startsWith(memberId))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("tempMap = " + tempMap);
		for (String s : tempMap.keySet()) {
			System.out.println(s + " | tempMap = " + tempMap.get(s));
		}
		return emitters.entrySet().stream()
			.filter(entry -> entry.getKey().startsWith(memberId))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	@Override
	public Map<String, Object> findAllEventCacheStartWithByMemberId(String memberId) {
		return eventCache.entrySet().stream()
			.filter(entry -> entry.getKey().startsWith(memberId))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	@Override
	public void deleteById(String id) {
		emitters.remove(id);
	}

	@Override
	public void deleteAllEmitterStartWithId(String memberId) {
		emitters.forEach(
			(key, emitter) -> {
				if (key.startsWith(memberId)) {
					emitters.remove(key);
				}
			}
		);
	}

	@Override
	public void deleteAllEventCacheStartWithId(String memberId) {
		eventCache.forEach(
			(key, emitter) -> {
				if (key.startsWith(memberId)) {
					eventCache.remove(key);
				}
			}
		);
	}
}
