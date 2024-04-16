package org.omoknoone.onionhotsayyo.hotpost.service;

import org.omoknoone.onionhotsayyo.hotpost.dto.HotPostListByCategoryDTO;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface HotPostService {

    void dailyUpdateHotPosts();

    // 카테고리별 조회수 상위 5건의 추천글 목록 조회 (자정마다 업데이트)
    List<HotPostListByCategoryDTO> updateHotPosts(Integer categoryId, LocalDate day);

    // 조회된 카테고리별 5건의 추천글을 컨트롤러에서 호출
    List<HotPostListByCategoryDTO> getHotPostsByCategory(Integer categoryId, LocalDate yesterday);
}
