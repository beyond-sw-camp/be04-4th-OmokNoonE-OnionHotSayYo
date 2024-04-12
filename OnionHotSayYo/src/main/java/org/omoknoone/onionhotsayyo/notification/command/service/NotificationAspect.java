package org.omoknoone.onionhotsayyo.notification.command.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.omoknoone.onionhotsayyo.comment.command.dto.CommentDTO;
import org.omoknoone.onionhotsayyo.member.dto.MemberDTO;
import org.omoknoone.onionhotsayyo.member.service.MemberService;
import org.omoknoone.onionhotsayyo.post.command.service.PostService;
import org.omoknoone.onionhotsayyo.post.command.vo.PostDetailVO;
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
	private final MemberService memberService;

	@Autowired
	public NotificationAspect(NotificationService notificationService, PostService postService,
		MemberService memberService) {
		this.notificationService = notificationService;
		this.postService = postService;
		this.memberService = memberService;
	}

	// 특정 서비스의 특정 메소드에만 적용되도록 설정
	@Pointcut("execution(* org.omoknoone.onionhotsayyo.comment.command.service.CommentService.createComment(..)) && args(commentDTO)")
	private void commentServiceCreateComment(CommentDTO commentDTO) {}

	// 이 곳에 원하는 어드바이스 로직 작성
	@After("commentServiceCreateComment(commentDTO)")
	public void afterCreateComment(JoinPoint joinPoint, CommentDTO commentDTO) {

		PostDetailVO post = postService.viewPostById(commentDTO.getPostId());
		MemberDTO postAuthor = memberService.getMemberDetailsByMemberId(post.getMemberId());
		MemberDTO commentAuthor = memberService.getMemberDetailsByMemberId(commentDTO.getMemberId());
		notificationService.send(postAuthor.getMemberId(),
			commentAuthor.getNickname() + "님이 내 글에 댓글을 달았습니다: " + commentDTO.getContent());

		System.out.println("[After CreateComment]: " + joinPoint.getSignature());
		System.out.println("새 댓글 알림 전송 됨");

	}








}
