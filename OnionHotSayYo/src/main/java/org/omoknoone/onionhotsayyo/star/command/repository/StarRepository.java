package org.omoknoone.onionhotsayyo.star.command.repository;

import java.util.List;

import org.omoknoone.onionhotsayyo.star.command.aggregate.Star;
import org.omoknoone.onionhotsayyo.star.command.dto.StarDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepository extends JpaRepository<Star, Integer> {

	List<StarDTO> findAllByMemberId(String memberId);
}
