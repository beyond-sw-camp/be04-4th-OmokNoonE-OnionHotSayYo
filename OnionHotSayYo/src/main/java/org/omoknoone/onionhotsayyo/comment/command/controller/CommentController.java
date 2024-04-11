package org.omoknoone.onionhotsayyo.comment.command.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.comment.command.aggregate.Comment;
import org.omoknoone.onionhotsayyo.comment.command.dto.CommentDTO;
import org.omoknoone.onionhotsayyo.comment.command.dto.CommentReplyDTO;
import org.omoknoone.onionhotsayyo.comment.command.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController {

	private final CommentService commentService;
	private final ModelMapper modelMapper;

	public CommentController(CommentService commentService, ModelMapper modelMapper) {
		this.commentService = commentService;
		this.modelMapper = modelMapper;
	}

	/* 댓글 작성 */
	@PostMapping("/create")
	public ResponseEntity<Comment> createComment(@RequestBody CommentDTO newcomment) {

		// CommentDTO commentDTO = modelMapper.map(newcomment, CommentDTO.class);

		commentService.createComment(newcomment);

		Comment responseComment = modelMapper.map(newcomment, Comment.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(responseComment);
	}


	/* 댓글 수정 */
	@PutMapping("/modify/{commentId}")
	public ResponseEntity<Comment> modifyComment(@RequestBody CommentDTO modifycomment) {

		// CommentModifyDTO commentModifyDTO = modelMapper.map(modifycomment, CommentModifyDTO.class);
		commentService.modifyComment(modifycomment);
		Comment responseComment = modelMapper.map(modifycomment, Comment.class);

		return ResponseEntity.status(HttpStatus.OK).body(responseComment);
	}

	/* 댓글 삭제 */
	@PutMapping("/remove/{commentId}")
	public void removeComment(@PathVariable("commentId") int commentid) {
		commentService.removeComment(commentid);
	}

	/* 내가 작성한 댓글(+대댓글) 목록 조회 */
	@GetMapping("/list/mycomments/{memberId}")
	public ResponseEntity<List<CommentReplyDTO>> viewCommentListByMe(@PathVariable("memberId") String memberId) {
		List<CommentReplyDTO> comments = commentService.viewCommentListByMe(memberId);
		return new ResponseEntity<>(comments, HttpStatus.OK);
	}



}
