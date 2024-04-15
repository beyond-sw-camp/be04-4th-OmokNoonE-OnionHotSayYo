package org.omoknoone.onionhotsayyo.hotpost.repository;

import org.omoknoone.onionhotsayyo.hotpost.aggregate.HotPost;
import org.omoknoone.onionhotsayyo.hotpost.dto.HotPostListByCategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotPostRepository extends JpaRepository<HotPost, Integer> {
    @Query("SELECT new org.omoknoone.onionhotsayyo.hotpost.dto.HotPostListByCategoryDTO(p.postId, p.title, p.hits, p.postedDate, p.isDeleted) " +
            "FROM Post p WHERE p.categoryId = :categoryId AND p.isDeleted = false " +
            "ORDER BY p.hits DESC, p.postedDate DESC")
    List<HotPostListByCategoryDTO> findTopHotPostsByCategory(@Param("categoryId") String categoryId);
}
