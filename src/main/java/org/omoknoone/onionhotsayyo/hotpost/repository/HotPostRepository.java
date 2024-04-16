package org.omoknoone.onionhotsayyo.hotpost.repository;

import org.omoknoone.onionhotsayyo.hotpost.aggregate.HotPost;
import org.omoknoone.onionhotsayyo.hotpost.dto.HotPostListByCategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HotPostRepository extends JpaRepository<HotPost, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE HotPost h SET h.isActive = false WHERE h.categoryId = :categoryId")
    void deactivateHotPostsByCategory(Integer categoryId);

    List<HotPost> findAllByCategoryIdAndIsActive(Integer categoryId, boolean isActive);
}
