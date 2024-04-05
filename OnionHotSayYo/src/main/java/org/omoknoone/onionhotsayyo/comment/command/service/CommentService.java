package org.omoknoone.onionhotsayyo.comment.command.service;

import java.util.List;

import org.omoknoone.onionhotsayyo.comment.command.aggregate.Comment;
import org.omoknoone.onionhotsayyo.comment.command.dto.CommentCreateDTO;
import org.omoknoone.onionhotsayyo.comment.command.dto.CommentDTO;
import org.omoknoone.onionhotsayyo.comment.command.dto.CommentReplyDTO;

public interface CommentService {
	public void createComment(CommentDTO commentCreateDTO);
	public void modifyComment(CommentDTO commentDetailDTO);
	public void removeComment(int commentid);
	List<CommentReplyDTO> viewCommentListByMe(String memberId);
}
