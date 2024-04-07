package org.omoknoone.onionhotsayyo.follow.command.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.follow.command.aggregate.Follow;
import org.omoknoone.onionhotsayyo.follow.command.dto.FollowDTO;
import org.omoknoone.onionhotsayyo.follow.command.repository.FollowRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FollowServiceImpl implements FollowService {

	private final FollowRepository followRepository;
	private final ModelMapper modelMapper;

	public FollowServiceImpl(FollowRepository followRepository, ModelMapper modelMapper) {
		this.followRepository = followRepository;
		this.modelMapper = modelMapper;
	}

	@Transactional
	@Override
	// 사용자가 다른 사용자를 팔로우하는 메소드 followMember
	public void followMember(FollowDTO followDTO) {
		// if(!existsByFromMemberIdAndToMemberId(followDTO)) {
		Follow follow = modelMapper.map(followDTO, Follow.class);
		followRepository.save(follow);
		// }
	}

	@Transactional
	@Override
	// 언팔로우
	public void unfollowMember(String fromMemberId, String toMemberId) {
		List<Follow> followList = followRepository.findAll();

		for (Follow follow : followList) {
			if (follow.getFromMemberId().equals(fromMemberId) &&
				follow.getToMemberId().equals(toMemberId)) {
				followRepository.deleteById(follow.getFollowId());
			}
		}
	}

	@Override
	public List<FollowDTO> selectAllFollowing(String memberId) {
		List<Follow> followList = followRepository.findAllByFromMemberId(memberId);
		return followList.stream().map(follow -> modelMapper.map(followList, FollowDTO.class)).toList();
	}

	@Override
	public List<FollowDTO> selectAllFollower(String memberId) {
		List<Follow> followList = followRepository.findAllByToMemberId(memberId);
		return followList.stream().map(follow -> modelMapper.map(followList, FollowDTO.class)).toList();
	}

	// @Override
	// public boolean existsByFromMemberIdAndToMemberId(FollowDTO followDTO) {
	//
	// 	return false;
	// }

}
