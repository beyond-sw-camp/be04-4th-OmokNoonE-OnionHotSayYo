package org.omoknoone.onionhotsayyo.notification.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.omoknoone.onionhotsayyo.comment.dto.CommentDTO;
import org.omoknoone.onionhotsayyo.comment.service.CommentService;
import org.omoknoone.onionhotsayyo.follow.dto.FollowDTO;
import org.omoknoone.onionhotsayyo.letter.dto.LetterDTO;
import org.omoknoone.onionhotsayyo.member.dto.MemberDTO;
import org.omoknoone.onionhotsayyo.member.service.MemberService;
import org.omoknoone.onionhotsayyo.post.service.PostService;
import org.omoknoone.onionhotsayyo.post.vo.ResponsePostDetail;
import org.omoknoone.onionhotsayyo.reply.dto.ReplyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class NotificationAspect {

	Logger log = LoggerFactory.getLogger(this.getClass());

	private final NotificationService notificationService;
	private final PostService postService;
	private	final CommentService commentService;
	private final MemberService memberService;

	@Autowired
	public NotificationAspect(NotificationService notificationService, PostService postService,
		CommentService commentService,
		MemberService memberService) {
		this.notificationService = notificationService;
		this.postService = postService;
		this.commentService = commentService;
		this.memberService = memberService;
	}

	// 특정 서비스의 특정 메소드에만 적용되도록 설정
	// 댓글 알림
	@Pointcut("execution(* org.omoknoone.onionhotsayyo.comment.service.CommentService.createComment(..)) && args(commentDTO)")
	private void commentServiceCreateComment(CommentDTO commentDTO) {}

	// 대댓글 알림
	@Pointcut("execution(* org.omoknoone.onionhotsayyo.reply.service.ReplyService.createReply(..)) && args(replyDTO)")
	private void replyServiceCreateReply(ReplyDTO replyDTO) {}

	// 팔로우 알림
	@Pointcut("execution(* org.omoknoone.onionhotsayyo.follow.service.FollowService.followMember(..)) && args(followDTO)")
	private void followServiceFollowMember(FollowDTO followDTO) {}

	// 쪽지 알림
	@Pointcut("execution(* org.omoknoone.onionhotsayyo.letter.service.LetterService.sendLetter(..)) && args(letterDTO)")
	private void letterServiceSendLetter(LetterDTO letterDTO) {}




	// 이 곳에 원하는 어드바이스 로직 작성
	// 댓글 알림
	@AfterReturning("commentServiceCreateComment(commentDTO)")
	public void afterCreateComment(JoinPoint joinPoint, CommentDTO commentDTO) {

		ResponsePostDetail post = postService.viewPostById(commentDTO.getPostId());
		MemberDTO postAuthor = memberService.getMemberDetailsByMemberId(post.getMemberId());
		MemberDTO commentAuthor = memberService.getMemberDetailsByMemberId(commentDTO.getMemberId());

		notificationService.send(postAuthor.getMemberId(),
			commentAuthor.getNickname() + "님이 내 글에 댓글을 달았습니다: " + commentDTO.getContent(),null);

		System.out.println("[After CreateComment]: " + joinPoint.getSignature());
		System.out.println("새 댓글 알림 전송 됨");
	}

	// 대댓글 알림 (부모 댓쓰니랑 글쓰니에게)
	@AfterReturning("replyServiceCreateReply(replyDTO)")
	public void afterCreateReply(JoinPoint joinPoint, ReplyDTO replyDTO) {

		// 대댓글 작성자 닉네임 가져오기
		MemberDTO replyAuthor = memberService.getMemberDetailsByMemberId(replyDTO.getMemberId());

		// 부모 댓글 작성자에게 알림 전송
		CommentDTO comment = commentService.getCommentById(replyDTO.getCommentId());
		notificationService.send(comment.getMemberId(),
			replyAuthor.getNickname() + "님이 대댓글을 남겼습니다: " + replyDTO.getContent(), null);

		// 게시글 작성자에게 알림 전송
		ResponsePostDetail post = postService.viewPostById(comment.getPostId());

		/* 댓글 작성자랑 글쓴이가 똑같은 경우 중복 발생 예외 처리 -> 댓쓴이와 글쓴이가 다를 경우에만 글쓴이에게 알림 발송*/
		if(!(comment.getMemberId().equals(post.getMemberId()))) {
			notificationService.send(post.getMemberId(),
				replyAuthor.getNickname() + "님이 대댓글을 남겼습니다: " + replyDTO.getContent(), null);
		}

		System.out.println("[After CreateReply]: " + joinPoint.getSignature());
		System.out.println("새 대댓글 알림 전송 됨");
	}

	// 팔로우 알림
	@AfterReturning("followServiceFollowMember(followDTO)")
	public void afterFollowMember(FollowDTO followDTO) {

		MemberDTO fromMember = memberService.getMemberDetailsByMemberId(followDTO.getFromMemberId());
		notificationService.send(followDTO.getToMemberId(), fromMember.getNickname() + "님이 나를 팔로우 했습니다.", "localhost:5173/mypage/" + followDTO.getFromMemberId());

		System.out.println("새 팔로우 알림 전송 됨");

	}

	// 쪽지 알림
	@AfterReturning("letterServiceSendLetter(letterDTO)")
	public void afterSendLetter(LetterDTO letterDTO) {

		MemberDTO sender = memberService.getMemberDetailsByMemberId(letterDTO.getSendId());
		notificationService.send(letterDTO.getReceiveId(), sender.getNickname() + "님에게서 새로운 쪽지가 도착했습니다.", null);

		System.out.println("새 쪽지 알림 전송 됨");
	}







}
