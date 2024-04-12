package org.omoknoone.onionhotsayyo.comment.command.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.omoknoone.onionhotsayyo.comment.command.aggregate.Comment;
import org.omoknoone.onionhotsayyo.comment.command.dto.CommentDTO;
import org.omoknoone.onionhotsayyo.comment.command.dto.CommentReplyDTO;
import org.omoknoone.onionhotsayyo.comment.command.repository.CommentRepository;
import org.omoknoone.onionhotsayyo.member.dto.MemberDTO;
import org.omoknoone.onionhotsayyo.member.service.MemberService;
import org.omoknoone.onionhotsayyo.notification.command.service.NotificationService;
import org.omoknoone.onionhotsayyo.post.command.repository.PostRepository;
import org.omoknoone.onionhotsayyo.post.command.service.PostService;
import org.omoknoone.onionhotsayyo.post.command.vo.PostDetailVO;
import org.omoknoone.onionhotsayyo.reply.command.aggregate.Reply;
import org.omoknoone.onionhotsayyo.reply.command.dto.ReplyDTO;
import org.omoknoone.onionhotsayyo.reply.command.repository.ReplyRepository;
import org.omoknoone.onionhotsayyo.reply.command.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements CommentService {
	private final ModelMapper modelMapper;
	private final CommentRepository commentRepository;
	// private final ReplyService replyService;
	private final ReplyRepository replyRepository;
	private final MemberService memberService;
	private final NotificationService notificationService;
	private final PostService postService;
	private final PostRepository postRepository;


	@Autowired
	public CommentServiceImpl(ModelMapper modelMapper, CommentRepository commentRepository,
		ReplyRepository replyRepository, MemberService memberService,
		NotificationService notificationService, PostService postService, PostRepository postRepository) {
		this.modelMapper = modelMapper;
		this.commentRepository = commentRepository;
		this.replyRepository = replyRepository;

		/* 순환 참조 일어남 */
        // this.replyService = replyService;

        this.memberService = memberService;
		this.notificationService = notificationService;
		this.postService = postService;
		this.postRepository = postRepository;
	}

	@Transactional
	@Override
	public void createComment(CommentDTO commentDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		Comment comment = modelMapper.map(commentDTO, Comment.class);
		commentRepository.save(comment);
		System.out.println("[comment] = " + comment);

		// 새 댓글 등록 시 알림
		// PostDetailVO post = postService.viewPostById(commentDTO.getPostId());
		PostDetailVO post = postService.viewPostById(comment.getPostId());
		MemberDTO postAuthor = memberService.getMemberDetailsByMemberId(post.getMemberId());
		MemberDTO commentAuthor = memberService.getMemberDetailsByMemberId(comment.getMemberId());
		notificationService.send(postAuthor.getMemberId(), commentAuthor.getNickname() + "님이 내 글에 댓글을 달았습니다: " + comment.getContent());
	}

	@Transactional
	@Override
	public void modifyComment(CommentDTO commentDTO) {
		Comment findcomment = commentRepository.findById(commentDTO.getCommentId())
			.orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));

		if(findcomment != null) {
		findcomment.setContent(commentDTO.getContent());
		findcomment.setLastModifiedDate(LocalDateTime.now());

		commentRepository.save(modelMapper.map(findcomment, Comment.class));
		}
	}

	@Transactional
	@Override
	public void removeComment(int commentId) {
		Comment findcomment = commentRepository.findById(commentId)
			.orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));
		findcomment.setDeleted(true);
	}

	public CommentDTO getCommentById(int commentId) {
		Comment findcomment = commentRepository.findById(commentId)
			.orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));
		return modelMapper.map(findcomment, CommentDTO.class);
	}

	@Override
	public List<CommentReplyDTO> viewCommentListByMe(String memberId) {

		MemberDTO memberDTO = memberService.getMemberDetailsByMemberId(memberId);

		List<Comment> commentList = commentRepository.findAllByMemberId(memberId);
		List<CommentDTO> commentDTOList = modelMapper.map(commentList, new TypeToken<List<CommentDTO>>() {}.getType());

		// List<ReplyDTO> replyDTOList = replyService.viewReplyListByMemberId(memberId);
		List<Reply> replyList = replyRepository.findAllByMemberId(memberId);
		List<ReplyDTO> replyDTOList = modelMapper.map(replyList, new TypeToken<List<ReplyDTO>>() {}.getType());


		List<CommentReplyDTO> commentReplyDTOList = new ArrayList<>();
		for (CommentDTO commentDTO : commentDTOList) {
			CommentReplyDTO commentReplyDTO = new CommentReplyDTO(
					commentDTO.getMemberId(),
					memberDTO.getNickname(),
					commentDTO.getContent(),
					commentDTO.getPostedDate(),
					commentDTO.getLastModifiedDate(),
					commentDTO.isDeleted());
			commentReplyDTOList.add(commentReplyDTO);
		}

		for (ReplyDTO replyDTO : replyDTOList) {
			CommentReplyDTO commentReplyDTO = new CommentReplyDTO(
					replyDTO.getMemberId(),
					memberDTO.getNickname(),
					replyDTO.getContent(),
					replyDTO.getPostedDate(),
					replyDTO.getLastModifiedDate(),
					replyDTO.isDeleted());
			commentReplyDTOList.add(commentReplyDTO);
		}

		return commentReplyDTOList;
	}

	@Override
	public CommentDTO getCommentById(Integer commentId) {
		Comment comment = commentRepository.findById(commentId).orElseThrow(IllegalArgumentException::new);
		return modelMapper.map(comment, CommentDTO.class);
	}
}
