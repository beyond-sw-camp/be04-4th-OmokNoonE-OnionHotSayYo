package org.omoknoone.onionhotsayyo.post.command.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.exceptions.BusinessRuleViolationException;
import org.omoknoone.onionhotsayyo.post.command.aggregate.Location;
import org.omoknoone.onionhotsayyo.post.command.aggregate.Post;
import org.omoknoone.onionhotsayyo.post.command.dto.PostFormDTO;
import org.omoknoone.onionhotsayyo.post.command.vo.PostSummaryVO;
import org.omoknoone.onionhotsayyo.post.command.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class PostServiceImplTests {

    private static final Logger logger = LoggerFactory.getLogger(PostServiceImplTests.class);

    @MockBean
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostService postService;

    // @Nested를 활용하여 테스트 메소드를 그룹화
    @Nested
    @DisplayName("Category ID로 게시물 조회 테스트")
    class ViewPostsByCategoryTests {
        @Test
        @DisplayName("조회 성공 테스트")
        void viewPostsByCategorySuccessTest() {

            String categoryId = "trip";

            // Given
            Post post1 = createMockPostSummary(categoryId, "첫 번째 게시물",
                    LocalDateTime.now().minusDays(2), 100, "image1.jpg");

            Post post2 = createMockPostSummary(categoryId, "두 번째 게시물",
                    LocalDateTime.now().minusDays(1), 150, "image2.jpg");

            Post post3 = createMockPostSummary(categoryId, "세 번째 게시물",
                    LocalDateTime.now().minusDays(3), 150, "image3.jpg");

            when(postRepository.findByCategoryId(anyString())).thenReturn(Arrays.asList(post1, post2, post3));

            // When
            List<PostSummaryVO> postSummaryVOs = postService.viewPostsByCategory(categoryId).stream()
                    .map(post -> modelMapper.map(post, PostSummaryVO.class))
                    .collect(Collectors.toList());

            // Then
            if (!postSummaryVOs.isEmpty()) {
                logger.info("카테고리별 조회된 게시물 수: " + postSummaryVOs.size() + ", 카테고리 Id: " + categoryId);
                assertEquals(3, postSummaryVOs.size(), "조회된 게시물 수가 예상과 다름.");

                // 로깅을 사용하여 결과 출력
                logger.info("카테고리별 조회된 게시물 요약 정보:");
                postSummaryVOs.forEach(dto -> logger.info(dto.toString()));
            } else {
                logger.warn("해당 카테고리에서 조회된 게시물이 없습니다. 그럴 수가 있나요!");
            }

            verifyInteractionsAndAssertFields(postSummaryVOs);
        }

    }

    @Nested
    @DisplayName("게시글 ID로 조회 테스트")
    class ViewPostByIdTests {
        @Test
        @DisplayName("상세 게시글 조회 성공")
        void viewPostById_Success() {
            int postId = 1;

            Location location = new Location(1, "서울");

            Post mockPostDetail = createMockPostDetail(1, "샘플 제목", "샘플 내용",
                    LocalDateTime.now(), 100, "image1.jpg", "trip",
                    "member1", false, LocalDateTime.now(), location);

            when(postRepository.findById(anyInt())).thenReturn(Optional.of(mockPostDetail));

            PostFormDTO result = modelMapper.map(postService.viewPostById(postId), PostFormDTO.class);

            assertNotNull(result);
            assertEquals("샘플 제목", result.getTitle());
            assertEquals("샘플 내용", result.getContent());
            assertEquals(100, result.getHits());
            assertNotNull(result.getLocation());
            assertEquals("서울", result.getLocation().getLocation());
            logger.info("게시글 상세 조회 성공: {}", result);

            verify(postRepository).findById(postId);
        }

        @Test
        @DisplayName("게시글 미존재 시 예외 발생")
        void viewPostById_NotFound() {
            int postId = 999;

            when(postRepository.findById(postId)).thenReturn(Optional.empty());

            Exception exception = assertThrows(BusinessRuleViolationException.class, () -> {
                postService.viewPostById(postId);
            });

            String expectedMessage = "게시글 ID " + postId + "에 해당하는 게시글을 찾을 수 없습니다!";
            assertEquals(expectedMessage, exception.getMessage());

            logger.info("게시글 ID {} 조회 실패: 게시글을 찾을 수 없습니다.", postId);

            verify(postRepository).findById(postId);
        }

    }

    private void verifyInteractionsAndAssertFields(List<PostSummaryVO> postSummaryVOs) {
        assertEquals("첫 번째 게시물", postSummaryVOs.get(0).getTitle());
        assertEquals("두 번째 게시물", postSummaryVOs.get(1).getTitle());
        assertNotNull(postSummaryVOs.get(0).getPostedDate());
        assertNotNull(postSummaryVOs.get(1).getPostedDate());
        assertEquals(100, postSummaryVOs.get(0).getHits());
        assertEquals(150, postSummaryVOs.get(1).getHits());

        String categoryId = "trip";

        // 저장소와의 상호작용 확인
        verify(postRepository, times(1)).findByCategoryId(categoryId);
        logger.info("postRepository의 findByCategoryId 메소드가 " + categoryId + " 인자와 함께 정확히 한 번 호출됨");
    }

    private Post createMockPostSummary(String categoryId, String title, LocalDateTime postedDate, int hits, String image) {
        Post post = new Post();
        post.setCategoryId(categoryId);
        post.setTitle(title);
        post.setPostedDate(postedDate);
        post.setHits(hits);
        post.setImage(image);
        return post;
    }

    private Post createMockPostDetail(int postingId, String title, String content, LocalDateTime postedDate,
                                      int hits, String image, String categoryId, String memberId,
                                      boolean isDeleted, LocalDateTime lastModifiedDate, Location location) {
        Post post = new Post();
        post.setPostingId(postingId);
        post.setTitle(title);
        post.setContent(content);
        post.setPostedDate(postedDate);
        post.setHits(hits);
        post.setImage(image);
        post.setCategoryId(categoryId);
        post.setMemberId(memberId);
        post.setDeleted(isDeleted);
        post.setLastModifiedDate(lastModifiedDate);
        post.setLocation(location); // 지역 직접 설정
        return post;
    }

}
