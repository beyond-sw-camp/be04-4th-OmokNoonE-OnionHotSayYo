package org.omoknoone.onionhotsayyo.hotpost.controller;

import org.omoknoone.onionhotsayyo.hotpost.dto.HotPostListByCategoryDTO;
import org.omoknoone.onionhotsayyo.hotpost.service.HotPostService;
import org.omoknoone.onionhotsayyo.hotpost.vo.ResponseHotPostListByCategory;
import org.omoknoone.onionhotsayyo.post.service.PostServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class HotPostController {

    private static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

    private final HotPostService hotPostService;

    @Autowired
    public HotPostController(HotPostService hotPostService) {
        this.hotPostService = hotPostService;
    }

    @GetMapping("/hotlist/{categoryId}")
    public ResponseEntity<ResponseHotPostListByCategory> viewHotPostList(@PathVariable Integer categoryId) {
        List<HotPostListByCategoryDTO> hotPosts = hotPostService.updateHotPosts(categoryId);
        if (hotPosts.isEmpty()) {
            log.warn("카테고리 ID {}에 해당하는 상위 게시물이 없습니다.", categoryId);
            return ResponseEntity.noContent().build();
        }
        ResponseHotPostListByCategory response = new ResponseHotPostListByCategory(hotPosts);
        log.info("카테고리 ID {}에 대한 추천 게시물 목록 조회 완료", categoryId);
        return ResponseEntity.ok(response);
    }
}
