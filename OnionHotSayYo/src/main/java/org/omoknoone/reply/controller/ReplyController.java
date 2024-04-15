package org.omoknoone.reply.controller;

import org.modelmapper.ModelMapper;
import org.omoknoone.reply.aggregate.Reply;
import org.omoknoone.reply.dto.ReplyDTO;
import org.omoknoone.reply.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/replies")
public class ReplyController {

	private final ReplyService replyService;
	private final ModelMapper modelMapper;

	public ReplyController(ReplyService replyService, ModelMapper modelMapper) {
		this.replyService = replyService;
		this.modelMapper = modelMapper;
	}

	/* 대댓글 작성 */
	@PostMapping("/create")
	public ResponseEntity<Reply> createReply(@RequestBody ReplyDTO newreply) {
		// ReplyDTO replyDTO = modelMapper.map(newreply, ReplyDTO.class);

		replyService.createReply(newreply);

		Reply responseReply = modelMapper.map(newreply, Reply.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(responseReply);
	}

	/* 대댓글 수정 */
	@PutMapping("/modify/{replyId}")
	public ResponseEntity<Reply> modifyReply(@RequestBody ReplyDTO modifyReply) {

		// ReplyDTO replyDTO = modelMapper.map(modifyReply, ReplyDTO.class);
		replyService.modifyReply(modifyReply);
		Reply responseReply = modelMapper.map(modifyReply, Reply.class);
		return ResponseEntity.status(HttpStatus.OK).body(responseReply);
	}

	/* 대댓글 삭제 */
	@PutMapping("/remove/{ReplyId}")
	public void removeReply(@PathVariable("replyId") int replyId) {
		replyService.removeReply(replyId);
	}

}
