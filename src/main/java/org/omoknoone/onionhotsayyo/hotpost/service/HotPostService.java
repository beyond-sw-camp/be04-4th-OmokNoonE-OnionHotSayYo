package org.omoknoone.onionhotsayyo.hotpost.service;

import org.omoknoone.onionhotsayyo.hotpost.dto.HotPostListByCategoryDTO;

import java.util.List;

public interface HotPostService {

    void dailyUpdateHotPosts();

    // 추천글 목록 조회
    List<HotPostListByCategoryDTO> updateAndFetchHotPosts(String categoryId);

}
