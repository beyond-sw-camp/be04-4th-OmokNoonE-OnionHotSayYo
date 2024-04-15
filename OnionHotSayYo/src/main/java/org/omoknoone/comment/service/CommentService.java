package org.omoknoone.comment.service;

import java.util.List;

import org.omoknoone.comment.dto.CommentDTO;
import org.omoknoone.comment.dto.CommentReplyDTO;

public interface CommentService {
	void createComment(CommentDTO commentCreateDTO);
	void modifyComment(CommentDTO commentDetailDTO);
	void removeComment(int commentid);
	List<CommentReplyDTO> viewCommentListByMe(String memberId);

	CommentDTO getCommentById(Integer commentId);
}
