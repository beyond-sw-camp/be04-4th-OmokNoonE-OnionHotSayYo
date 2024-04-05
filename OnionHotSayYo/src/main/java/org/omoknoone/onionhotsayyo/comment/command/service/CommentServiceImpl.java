package org.omoknoone.onionhotsayyo.comment.command.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.omoknoone.onionhotsayyo.comment.command.aggregate.Comment;
import org.omoknoone.onionhotsayyo.comment.command.dto.CommentDTO;
import org.omoknoone.onionhotsayyo.comment.command.dto.CommentReplyDTO;
import org.omoknoone.onionhotsayyo.comment.command.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements CommentService {
	private final ModelMapper modelMapper;
	private final CommentRepository commentRepository;

	@Autowired
	public CommentServiceImpl(ModelMapper modelMapper, CommentRepository commentRepository) {
		this.modelMapper = modelMapper;
		this.commentRepository = commentRepository;
	}

	@Transactional
	@Override
	public void createComment(CommentDTO commentDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		Comment comment = modelMapper.map(commentDTO, Comment.class);
		commentRepository.save(comment);

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
	public void removeComment(int commentid) {
		Comment findcomment = commentRepository.findById(commentid)
			.orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));
		findcomment.setDeleted(true);
	}

	@Override
	public List<CommentReplyDTO> viewCommentListByMe(String memberId) {
		return commentRepository.findAllCommentsByMemberId(memberId);
	}
}
