package org.omoknoone.onionhotsayyo.star.repository;

import java.util.List;

import org.omoknoone.onionhotsayyo.star.aggregate.Star;
import org.omoknoone.onionhotsayyo.star.dto.StarDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepository extends JpaRepository<Star, Integer> {

	List<StarDTO> findAllByMemberId(String memberId);
}
