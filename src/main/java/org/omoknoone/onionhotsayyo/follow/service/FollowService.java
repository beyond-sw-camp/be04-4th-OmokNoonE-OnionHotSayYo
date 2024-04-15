package org.omoknoone.onionhotsayyo.follow.service;

import java.util.List;

import org.omoknoone.onionhotsayyo.follow.dto.FollowDTO;

public interface FollowService {

	public void followMember(FollowDTO followDTO);

	public void unfollowMember(String fromMemberId, String toMemberId);

	List<FollowDTO> selectAllFollowing(String memberId);

	List<FollowDTO> selectAllFollower(String memberId);

	// 팔로우 중인지 확인하는 메소드
	boolean existsByFromMemberIdAndToMemberId(FollowDTO followDTO);
}
