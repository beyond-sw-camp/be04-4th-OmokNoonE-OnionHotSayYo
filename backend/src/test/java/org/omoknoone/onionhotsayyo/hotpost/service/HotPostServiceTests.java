//package org.omoknoone.onionhotsayyo.hotpost.service;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.omoknoone.onionhotsayyo.hotpost.repository.HotPostRepository;
//import org.omoknoone.onionhotsayyo.post.dto.PostListByCategoryDTO;
//import org.omoknoone.onionhotsayyo.post.service.PostService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//
//@SpringBootTest
//class HotPostServiceTests {
//
//    @MockBean
//    private PostService postService;
//
//    @MockBean
//    private HotPostRepository hotPostRepository;
//
//    @Autowired
//    private HotPostServiceImpl hotPostService;
//
//    private List<PostListByCategoryDTO> mockPosts;
//
//    @BeforeEach
//    void setup() {
//        mockPosts = generateMockData(100); // 100개의 더미 데이터 생성
//    }
//
//    @Test
//    @Transactional
//    public void testUpdateHotPostsMultipleCategories() {
//        // 모의 설정
//        LocalDate testDate = LocalDate.now().minusDays(1);  // 어제 날짜
//        Mockito.when(postService.findTopPostsByCategory(any(Integer.class), eq(testDate), eq(5)))
//                .thenAnswer(invocation -> mockPosts.stream()
//                        .filter(post -> post.getCategoryId().equals(invocation.getArgument(0)))
//                        .sorted((p1, p2) -> Integer.compare(p2.getHits(), p1.getHits())) // 가장 높은 조회수부터 정렬
//                        .limit(5)
//                        .collect(Collectors.toList()));
//
//        Mockito.doNothing().when(hotPostRepository).deactivateHotPostsByCategory(any(Integer.class));
//
//        // 각 카테고리별 업데이트 테스트
//        IntStream.range(1, 10).forEach(categoryId -> {
//            hotPostService.updateHotPosts(categoryId, testDate);
//        });
//
//        // 로그 출력 및 결과 검증
//        Mockito.verify(hotPostRepository, Mockito.atLeastOnce()).deactivateHotPostsByCategory(any());
//        Mockito.verify(hotPostRepository, Mockito.times(45)).save(any());    }
//
//    private List<PostListByCategoryDTO> generateMockData(int count) {
//        return IntStream.rangeClosed(1, count)
//                .mapToObj(i -> new PostListByCategoryDTO(
//                        (i % 9) + 1, // 9개 카테고리 순환
//                        i,
//                        "Post Title " + i,
//                        LocalDate.now().minusDays(i % 30).atStartOfDay(),  // 게시 날짜도 다양하게
//                        100 + i, // 조회수는 ID에 따라 증가
//                        false
//                ))
//                .collect(Collectors.toList());
//    }
//}