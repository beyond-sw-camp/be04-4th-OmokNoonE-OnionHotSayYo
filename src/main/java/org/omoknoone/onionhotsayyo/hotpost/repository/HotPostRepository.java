package org.omoknoone.onionhotsayyo.hotpost.repository;

import org.omoknoone.onionhotsayyo.hotpost.aggregate.HotPost;
import org.omoknoone.onionhotsayyo.hotpost.dto.HotPostListByCategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotPostRepository extends JpaRepository<HotPost, Integer> {

}
