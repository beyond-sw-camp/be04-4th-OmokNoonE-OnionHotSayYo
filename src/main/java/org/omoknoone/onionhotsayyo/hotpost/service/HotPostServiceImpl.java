package org.omoknoone.onionhotsayyo.hotpost.service;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.hotpost.dto.HotPostListByCategoryDTO;
import org.omoknoone.onionhotsayyo.hotpost.repository.HotPostRepository;
import org.omoknoone.onionhotsayyo.post.service.PostServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotPostServiceImpl implements HotPostService {

    private static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);
    private final ModelMapper modelMapper;
    private final HotPostRepository hotPostRepository;

    @Autowired
    public HotPostServiceImpl(ModelMapper modelMapper, HotPostRepository hotPostRepository) {
        this.modelMapper = modelMapper;
        this.hotPostRepository = hotPostRepository;
    }

    @Transactional(readOnly = true)
    @Scheduled(cron = "0 0 0 * * ?")  // 매일 자정에 실행
    @Override
    public List<HotPostListByCategoryDTO> updateAndFetchHotPosts(String categoryId) {
        log.info("카테고리 ID {}에 대한 인기 게시글 조회를 시작합니다.", categoryId);

        List<HotPostListByCategoryDTO> hotPosts = hotPostRepository.findTopHotPostsByCategory(categoryId);
        if (hotPosts.isEmpty()) {
            log.warn("카테고리 ID {}에 대한 인기 게시글이 없습니다.", categoryId);
        } else {
            log.info("카테고리 ID {}에 대한 인기 게시글 조회가 성공적으로 완료되었습니다. 조회된 게시글 수: {}",
                    categoryId, hotPosts.size());
        }

        return hotPosts;
    }
}
