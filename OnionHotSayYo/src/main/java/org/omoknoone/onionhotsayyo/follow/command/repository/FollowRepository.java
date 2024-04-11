package org.omoknoone.onionhotsayyo.follow.command.repository;

import java.util.List;

import org.omoknoone.onionhotsayyo.follow.command.aggregate.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Integer> {
	List<Follow> findAllByFromMemberId(String memberId);

	List<Follow> findAllByToMemberId(String memberId);
}
