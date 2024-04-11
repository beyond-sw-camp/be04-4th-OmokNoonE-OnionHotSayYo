package org.omoknoone.onionhotsayyo.reply.command.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.omoknoone.onionhotsayyo.comment.command.aggregate.Comment;
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

	@Autowired
	public ReplyServiceImpl(ModelMapper modelMapper, ReplyRepository replyRepository) {
		this.modelMapper = modelMapper;
		this.replyRepository = replyRepository;
	}

	@Transactional
	@Override
	public void createReply(ReplyDTO replyDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Reply reply = modelMapper.map(replyDTO, Reply.class);
		replyRepository.save(reply);
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
