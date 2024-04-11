package org.omoknoone.onionhotsayyo.reply.command.service;

import org.omoknoone.onionhotsayyo.reply.command.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {

	public void createReply(ReplyDTO replyDTO);
	public void modifyReply(ReplyDTO replyDTO);
	public void removeReply(int replyid);
	List<ReplyDTO> viewReplyListByMemberId(String memberId);
}

