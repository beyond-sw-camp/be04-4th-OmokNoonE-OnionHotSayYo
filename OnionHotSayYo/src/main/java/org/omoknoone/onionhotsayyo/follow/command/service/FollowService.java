package org.omoknoone.onionhotsayyo.follow.command.service;

import java.util.List;

import org.omoknoone.onionhotsayyo.follow.command.dto.FollowDTO;

public interface FollowService {

	// public boolean existsByFromMemberIdAndToMemberId(FollowDTO followDTO);
	public void followMember(FollowDTO followDTO);

	public void unfollowMember(String fromMemberId, String toMemberId);

	List<FollowDTO> selectAllFollowing(String memberId);

	List<FollowDTO> selectAllFollower(String memberId);
}
