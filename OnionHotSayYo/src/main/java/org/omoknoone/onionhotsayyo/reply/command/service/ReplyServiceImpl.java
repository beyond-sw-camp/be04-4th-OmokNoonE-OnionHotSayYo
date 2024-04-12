package org.omoknoone.onionhotsayyo.reply.command.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.omoknoone.onionhotsayyo.comment.command.aggregate.Comment;
import org.omoknoone.onionhotsayyo.comment.command.dto.CommentDTO;
import org.omoknoone.onionhotsayyo.comment.command.service.CommentService;
import org.omoknoone.onionhotsayyo.comment.command.service.CommentServiceImpl;
import org.omoknoone.onionhotsayyo.member.dto.MemberDTO;
import org.omoknoone.onionhotsayyo.member.service.MemberService;
import org.omoknoone.onionhotsayyo.notification.command.service.NotificationService;
import org.omoknoone.onionhotsayyo.post.command.service.PostService;
import org.omoknoone.onionhotsayyo.post.command.vo.PostDetailVO;
import org.omoknoone.onionhotsayyo.reply.command.aggregate.Reply;
import org.omoknoone.onionhotsayyo.reply.command.dto.ReplyDTO;
import org.omoknoone.onionhotsayyo.reply.command.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplyServiceImpl implements ReplyService{
	private final ModelMapper modelMapper;
	private final ReplyRepository replyRepository;
	private final NotificationService notificationService;
	private final CommentService commentService;
	private final MemberService memberService;
	private final PostService postService;

	@Autowired
	public ReplyServiceImpl(ModelMapper modelMapper, ReplyRepository replyRepository,
		NotificationService notificationService, CommentService commentService, MemberService memberService,
		PostService postService) {
		this.modelMapper = modelMapper;
		this.replyRepository = replyRepository;
		// this.commentService = commentService;
		this.notificationService = notificationService;
		this.commentService = commentService;
		this.memberService = memberService;
		this.postService = postService;
	}

	@Transactional
	@Override
	public void createReply(ReplyDTO replyDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Reply reply = modelMapper.map(replyDTO, Reply.class);
		replyRepository.save(reply);

		/* 대댓글 작성 시 알림 (부모 댓글 작성자와 글쓰니에게) */

		// 대댓글 작성자 닉네임 가져오기 위함
		MemberDTO replyAuthor = memberService.getMemberDetailsByMemberId(reply.getMemberId());

		// 부모 댓글 작성자에게 알림 전송
		CommentDTO comment = commentService.getCommentById(reply.getCommentId());
		notificationService.send(comment.getMemberId(),
								replyAuthor.getNickname() + "님이 대댓글을 남겼습니다: " + reply.getContent());

		// 게시글 작성자에게 알림 전송
		PostDetailVO post = postService.viewPostById(comment.getPostId());

		/* 댓글 작성자랑 글쓴이가 똑같은 경우 중복 발생 예외 처리 -> 댓쓴이와 글쓴이가 다를 경우에만 글쓴이에게 알림 발송*/
		if(!(comment.getMemberId().equals(post.getMemberId()))) {
		notificationService.send(post.getMemberId(),
								replyAuthor.getNickname() + "님이 대댓글을 남겼습니다: " + reply.getContent());
		}
	}

	@Transactional
	@Override
	public void modifyReply(ReplyDTO replyDTO) {
		Reply findreply = replyRepository.findById(replyDTO.getReply_id())
			.orElseThrow(() -> new RuntimeException("대댓글을 찾을 수 없습니다."));

		if(findreply != null) {
		findreply.setLastModifiedDate(LocalDateTime.now());
		findreply.setContent(replyDTO.getContent());
		replyRepository.save(findreply);
		}
	}

	@Transactional
	@Override
	public void removeReply(int replyid) {
		Reply findreply = replyRepository.findById(replyid)
			.orElseThrow(() -> new RuntimeException("대댓글을 찾을 수 없습니다."));
		findreply.setDeleted(true);
	}

	@Override
	public List<ReplyDTO> viewReplyListByMemberId(String memberId) {
		List<Reply> replyList = replyRepository.findAllByMemberId(memberId);
		
		return modelMapper.map(replyList, new TypeToken<List<ReplyDTO>>() {}.getType());
	}


}
