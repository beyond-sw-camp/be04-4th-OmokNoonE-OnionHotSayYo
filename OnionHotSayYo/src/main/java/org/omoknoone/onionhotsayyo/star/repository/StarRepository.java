package org.omoknoone.onionhotsayyo.star.repository;

import java.util.List;

import org.omoknoone.onionhotsayyo.star.aggregate.Star;
import org.omoknoone.onionhotsayyo.star.dto.MyStarPostListDTO;
import org.omoknoone.onionhotsayyo.star.dto.StarDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StarRepository extends JpaRepository<Star, Integer> {

	List<StarDTO> findAllByMemberId(String memberId);

	@Query("SELECT" +
			" new org.omoknoone.onionhotsayyo.star.dto.MyStarPostListDTO" +
			"(b.starId, a.postId, a.title, a.postedDate, a.hits) " +
			"FROM Post a JOIN Star b ON a.postId = b.postId " +
			"WHERE b.memberId = :memberId AND a.isDeleted = false AND b.status = true ")
	List<MyStarPostListDTO> findLikedPostsByMemberId(@Param("memberId") String memberId);

}
