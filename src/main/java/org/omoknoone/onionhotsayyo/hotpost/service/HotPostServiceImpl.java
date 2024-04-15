package org.omoknoone.onionhotsayyo.hotpost.service;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.hotpost.dto.HotPostListByCategoryDTO;
import org.omoknoone.onionhotsayyo.hotpost.repository.HotPostRepository;
import org.omoknoone.onionhotsayyo.post.dto.PostListByCategoryDTO;
import org.omoknoone.onionhotsayyo.post.service.PostService;
import org.omoknoone.onionhotsayyo.post.service.PostServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotPostServiceImpl implements HotPostService {

    private static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);
    private final ModelMapper modelMapper;
    private final HotPostRepository hotPostRepository;
    private final PostService postService;

    @Autowired
    public HotPostServiceImpl(ModelMapper modelMapper, HotPostRepository hotPostRepository, PostService postService) {
        this.modelMapper = modelMapper;
        this.hotPostRepository = hotPostRepository;
        this.postService = postService;
    }


    /* 필기. 카테고리별 조회 수 상위 5건의 메소드 구현 */
    @Scheduled(cron = "0 0 0 * * ?") // 매일 자정 실행
    @Transactional
    @Override
    public void dailyUpdateHotPosts() {
        Integer[] categoryIds = {1, 2, 3, 4, 5, 6, 7, 8, 9};  //카테고리 ID가 1~9까지 있음
        for (Integer categoryId : categoryIds) {
            updateHotPosts(categoryId);
        }
    }

    @Override
    public List<HotPostListByCategoryDTO> updateHotPosts(Integer categoryId) {
        log.info("카테고리 ID {}의 상위 5개 추천 게시물 업데이트를 시작합니다.", categoryId);

        List<PostListByCategoryDTO> posts = postService.findTopPostsByCategory(categoryId, 5);
        List<HotPostListByCategoryDTO> updatedHotPosts = posts.stream()
                .map(post -> modelMapper.map(post, HotPostListByCategoryDTO.class))
                .collect(Collectors.toList());
        log.info("카테고리 ID {}의 추천 게시물 업데이트가 완료되었습니다.", categoryId);

        return updatedHotPosts;
    }
}
