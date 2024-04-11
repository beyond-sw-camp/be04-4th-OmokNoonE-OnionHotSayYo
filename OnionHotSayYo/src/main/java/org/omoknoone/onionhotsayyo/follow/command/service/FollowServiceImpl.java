package org.omoknoone.onionhotsayyo.follow.command.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.omoknoone.onionhotsayyo.follow.command.aggregate.Follow;
import org.omoknoone.onionhotsayyo.follow.command.dto.FollowDTO;
import org.omoknoone.onionhotsayyo.follow.command.repository.FollowRepository;
import org.omoknoone.onionhotsayyo.member.aggregate.Member;
import org.omoknoone.onionhotsayyo.member.repository.MemberRepository;
import org.omoknoone.onionhotsayyo.notification.command.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FollowServiceImpl implements FollowService {

	private final FollowRepository followRepository;
	private final NotificationService notificationService;
	private final ModelMapper modelMapper;
	private final MemberRepository memberRepository;

	@Autowired
	public FollowServiceImpl(FollowRepository followRepository, NotificationService notificationService,
		ModelMapper modelMapper, MemberRepository memberRepository) {
		this.followRepository = followRepository;
		this.notificationService = notificationService;
		this.modelMapper = modelMapper;
		this.memberRepository = memberRepository;
	}

	@Transactional
	@Override
	// 사용자가 다른 사용자를 팔로우하는 메소드 followMember
	public void followMember(FollowDTO followDTO) {
		// if(!existsByFromMemberIdAndToMemberId(followDTO)) {
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			Follow follow = modelMapper.map(followDTO, Follow.class);
			followRepository.save(follow);

			// 팔로우 당한 사람에게 팔로우 알림 전송
			Member fromMember = memberRepository.findByMemberId(follow.getFromMemberId());
			notificationService.send(follow.getToMemberId(), fromMember.getNickname() + "님이 나를 팔로우 했습니다.");
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

	// 팔로우 중인지 확인하는 메소드
	@Override
	public boolean existsByFromMemberIdAndToMemberId(FollowDTO followDTO) {
		List<Follow> followList = followRepository.findAll();

		for (Follow follow : followList) {
			if(follow.getFromMemberId().equals(followDTO.getFromMemberId()) &&
				follow.getToMemberId().equals(followDTO.getToMemberId())) {
				return true;
			}
		}
		return false;
	}

}
