package org.omoknoone.onionhotsayyo.hotpost.service;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.hotpost.aggregate.HotPost;
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

import java.time.LocalDate;
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
//    @Scheduled(cron = "0 0 0 * * ?") // 매일 자정 실행
    @Scheduled(cron = "0 */10 * * * *")  // 매 10분마다 실행
    @Transactional
    @Override
    public void dailyUpdateHotPosts() {
//        LocalDate yesterday = LocalDate.now().minusDays(1); // 어제 날짜 계산
        LocalDate yesterday = LocalDate.now(); // 현재 날짜 계산
        log.info("일일 추천 게시물 업데이트 시작");

        Integer[] categoryIds = {1, 2, 3, 4, 5, 6, 7, 8, 9};  //카테고리 ID가 1~9까지 있음
        for (Integer categoryId : categoryIds) {
            updateHotPosts(categoryId, yesterday);
        }
        log.info("모든 카테고리에 대한 게시물 업데이트 완료");
    }

    @Transactional
    @Override
    public List<HotPostListByCategoryDTO> updateHotPosts(Integer categoryId, LocalDate day) {
        log.info("카테고리 ID {}의 추천 게시물 업데이트 시작", categoryId);

        // 기존 추천 게시물 비활성화
        hotPostRepository.deactivateHotPostsByCategory(categoryId);

        // 카테고리별 상위 게시물 조회
        List<PostListByCategoryDTO> posts = postService.findTopPostsByCategory(categoryId, day, 5);
        List<HotPostListByCategoryDTO> updatedHotPosts = posts.stream()
                .map(post -> {
                    HotPostListByCategoryDTO dto = modelMapper.map(post, HotPostListByCategoryDTO.class);
                    dto.setActive(true);  // 새로운 게시물은 활성화
                    saveNewHotPost(dto);
                    return dto;
                })
                .collect(Collectors.toList());
        log.info("카테고리 ID {}의 추천 게시물 업데이트 완료, 업데이트된 게시물 수: {}", categoryId, updatedHotPosts.size());

        return updatedHotPosts;
    }

    private void saveNewHotPost(HotPostListByCategoryDTO dto) {
        HotPost newHotPost = modelMapper.map(dto, HotPost.class);
        newHotPost.activate();  // 새 게시물을 활성화
        hotPostRepository.save(newHotPost);
        log.info("새로운 추천 게시물 저장: {}", newHotPost);
    }

    @Transactional(readOnly = true)
    @Override
    public List<HotPostListByCategoryDTO> getHotPostsByCategory(Integer categoryId, LocalDate day) {
        log.info("카테고리 ID {}에 대한 활성화된 추천 게시물 목록 조회를 시작합니다.", categoryId);

//        List<HotPost> hotPosts = hotPostRepository.findAllByCategoryIdAndIsActive(categoryId, true);
        List<HotPostListByCategoryDTO> hotPosts = hotPostRepository.findHotPostsDetailsByCategory(categoryId);

        if (hotPosts.isEmpty()) {
            log.warn("카테고리 ID {}에 활성화된 추천 게시물이 없습니다.", categoryId);
        } else {
            log.info("카테고리 ID {}에 대한 추천 게시물 목록 조회가 완료되었습니다. 게시물 수: {}", categoryId, hotPosts.size());
        }

//        return hotPosts.stream()
//                .map(hotPost -> modelMapper.map(hotPost, HotPostListByCategoryDTO.class))
//                .collect(Collectors.toList());
        return hotPosts;
    }
}
