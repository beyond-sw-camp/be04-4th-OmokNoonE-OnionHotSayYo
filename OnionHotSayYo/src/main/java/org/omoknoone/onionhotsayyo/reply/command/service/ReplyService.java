package org.omoknoone.onionhotsayyo.reply.command.service;

import org.omoknoone.onionhotsayyo.reply.command.dto.ReplyDTO;

public interface ReplyService {

	public void createReply(ReplyDTO replyDTO);
	public void modifyReply(ReplyDTO replyDTO);
	public void removeReply(int replyid);
}

