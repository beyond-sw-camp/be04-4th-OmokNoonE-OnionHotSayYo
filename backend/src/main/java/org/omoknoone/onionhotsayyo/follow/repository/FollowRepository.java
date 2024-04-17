package org.omoknoone.onionhotsayyo.follow.repository;

import org.omoknoone.onionhotsayyo.follow.aggregate.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FollowRepository extends JpaRepository<Follow, Integer> {
	List<Follow> findAllByFromMemberId(String memberId);

	List<Follow> findAllByToMemberId(String memberId);
}
