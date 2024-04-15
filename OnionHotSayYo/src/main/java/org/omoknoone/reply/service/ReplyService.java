package org.omoknoone.reply.service;

import org.omoknoone.reply.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {

	public void createReply(ReplyDTO replyDTO);
	public void modifyReply(ReplyDTO replyDTO);
	public void removeReply(int replyid);
	List<ReplyDTO> viewReplyListByMemberId(String memberId);
}

