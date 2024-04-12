package org.omoknoone.onionhotsayyo.notification.command.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.omoknoone.onionhotsayyo.comment.command.dto.CommentDTO;
import org.omoknoone.onionhotsayyo.comment.command.service.CommentService;
import org.omoknoone.onionhotsayyo.follow.command.dto.FollowDTO;
import org.omoknoone.onionhotsayyo.member.aggregate.Member;
import org.omoknoone.onionhotsayyo.member.dto.MemberDTO;
import org.omoknoone.onionhotsayyo.member.service.MemberService;
import org.omoknoone.onionhotsayyo.post.command.service.PostService;
import org.omoknoone.onionhotsayyo.post.command.vo.PostDetailVO;
import org.omoknoone.onionhotsayyo.reply.command.dto.ReplyDTO;
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
	@Pointcut("execution(* org.omoknoone.onionhotsayyo.comment.command.service.CommentService.createComment(..)) && args(commentDTO)")
	private void commentServiceCreateComment(CommentDTO commentDTO) {}

	// 대댓글 알림
	@Pointcut("execution(* org.omoknoone.onionhotsayyo.reply.command.service.ReplyService.createReply(..)) && args(replyDTO)")
	private void replyServiceCreateReply(ReplyDTO replyDTO) {}

	// 팔로우 알림
	@Pointcut("execution(* org.omoknoone.onionhotsayyo.follow.command.service.FollowService.followMember(..)) && args(followDTO)")
	private void followServiceFollowMember(FollowDTO followDTO) {}





	// 이 곳에 원하는 어드바이스 로직 작성
	// 댓글 알림
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

	// 대댓글 알림 (부모 댓쓰니랑 글쓰니에게)
	@After("replyServiceCreateReply(replyDTO)")
	public void afterCreateReply(JoinPoint joinPoint, ReplyDTO replyDTO) {

		// 대댓글 작성자 닉네임 가져오기
		MemberDTO replyAuthor = memberService.getMemberDetailsByMemberId(replyDTO.getMemberId());

		// 부모 댓글 작성자에게 알림 전송
		CommentDTO comment = commentService.getCommentById(replyDTO.getCommentId());
		notificationService.send(comment.getMemberId(),
			replyAuthor.getNickname() + "님이 대댓글을 남겼습니다: " + replyDTO.getContent());

		// 게시글 작성자에게 알림 전송
		PostDetailVO post = postService.viewPostById(comment.getPostId());

		/* 댓글 작성자랑 글쓴이가 똑같은 경우 중복 발생 예외 처리 -> 댓쓴이와 글쓴이가 다를 경우에만 글쓴이에게 알림 발송*/
		if(!(comment.getMemberId().equals(post.getMemberId()))) {
			notificationService.send(post.getMemberId(),
				replyAuthor.getNickname() + "님이 대댓글을 남겼습니다: " + replyDTO.getContent());
		}

		System.out.println("[After CreateReply]: " + joinPoint.getSignature());
		System.out.println("새 대댓글 알림 전송 됨");
	}

	// 팔로우 알림
	@After("followServiceFollowMember(followDTO)")
	public void afterFollowMember(FollowDTO followDTO) {
		
		MemberDTO fromMember = memberService.getMemberDetailsByMemberId(followDTO.getFromMemberId());
		notificationService.send(followDTO.getToMemberId(), fromMember.getNickname() + "님이 나를 팔로우 했습니다.");

		System.out.println("새 팔로우 알림 전송 됨");

	}









}
