package org.omoknoone.onionhotsayyo.post.command.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.exceptions.BusinessRuleViolationException;
import org.omoknoone.onionhotsayyo.post.command.aggregate.Location;
import org.omoknoone.onionhotsayyo.post.command.aggregate.Post;
import org.omoknoone.onionhotsayyo.post.command.dto.PostFormDTO;
import org.omoknoone.onionhotsayyo.post.command.repository.LocationRepository;
import org.omoknoone.onionhotsayyo.post.command.vo.PostDetailVO;
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

    @MockBean
    private LocationRepository locationRepository;

    @MockBean
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

            String categoryId = "여행";

            // Given
            List<Post> mockPosts = Arrays.asList(
                    new Post(1, "첫 번째 게시물", "내용1", LocalDateTime.now(), 100,
                            LocalDateTime.now(), false,
                            categoryId, "회원1", "image1.jpg", "서울"),

                    new Post(2, "두 번째 게시물", "내용2", LocalDateTime.now(), 200,
                            LocalDateTime.now(), false,
                            categoryId, "회원2", "image2.jpg", "부산")
            );

            List<PostSummaryVO> expectedVOs = Arrays.asList(
                    new PostSummaryVO(1, "첫 번째 게시물",
                            LocalDateTime.now(), 100, categoryId, "서울"),

                    new PostSummaryVO(2, "두 번째 게시물",
                            LocalDateTime.now(), 200, categoryId, "부산")
            );

            when(postRepository.findByCategoryId(categoryId)).thenReturn(mockPosts);
            for (int i = 0; i < mockPosts.size(); i++) {
                when(modelMapper.map(mockPosts.get(i), PostSummaryVO.class)).thenReturn(expectedVOs.get(i));
            }

            // When
            List<PostSummaryVO> actualVOs = postService.viewPostsByCategory(categoryId);

            // Then
            assertNotNull(actualVOs);
            assertEquals(expectedVOs.size(), actualVOs.size());
            // 여기서는 VO 객체들의 실제 값을 비교하는 로직이 필요합니다.
            // 예: assertEquals(expectedVOs.get(i).getTitle(), actualVOs.get(i).getTitle());

            verify(postRepository).findByCategoryId(categoryId);
            mockPosts.forEach(post -> verify(modelMapper).map(post, PostSummaryVO.class));

    }

    @Nested
    @DisplayName("게시글 ID로 조회 테스트")
    class ViewPostByIdTests {
        @Test
        @DisplayName("상세 게시글 조회 성공")
        void viewPostById_Success() {
            int postId = 1;
            String location =  "서울";

            // Post 인스턴스 생성
            Post mockPost = new Post(postId, "샘플 제목", "샘플 내용", LocalDateTime.now(), 100,
                    LocalDateTime.now(), false, "trip", "회원1", "image1.jpg", location);

            // 예상되는 PostDetailVO 객체 생성
            PostDetailVO expectedDetailVO = new PostDetailVO(postId, "샘플 제목", "샘플 내용",
                    LocalDateTime.now(), 100, LocalDateTime.now(), false,
                    "trip", "회원1", "image1.jpg", location);

            // PostRepository와 ModelMapper의 동작을 모킹
            when(postRepository.findById(postId)).thenReturn(Optional.of(mockPost));
            when(modelMapper.map(mockPost, PostDetailVO.class)).thenReturn(expectedDetailVO);

            // 실제 서비스 메소드를 호출하여 결과를 검증
            PostDetailVO result = postService.viewPostById(postId);

            assertNotNull(result);
            assertEquals(expectedDetailVO.getTitle(), result.getTitle());
            assertEquals(expectedDetailVO.getContent(), result.getContent());
            assertEquals(expectedDetailVO.getHits(), result.getHits());
            assertEquals(expectedDetailVO.getLocation(), result.getLocation());
            logger.info("게시글 상세 조회 성공: {}", result);

            // 저장소 및 ModelMapper 사용 확인
            verify(postRepository).findById(postId);
            verify(modelMapper).map(mockPost, PostDetailVO.class);
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

    private Post createMockPostSummary(String categoryId, String title,
                                       LocalDateTime postedDate, int hits, String image) {
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

