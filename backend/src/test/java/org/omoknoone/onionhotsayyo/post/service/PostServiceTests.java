//package org.omoknoone.onionhotsayyo.post.service;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.junit.jupiter.api.Test;
//import org.omoknoone.onionhotsayyo.post.aggregate.Post;
//import org.omoknoone.onionhotsayyo.post.dto.PostListByCategoryDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Random;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//class PostServiceTests {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Autowired
//    private PostService postService;
//
//    @Test
//    @Transactional
//    public void testFindTopPostsByCategory() {
//        // 더미 데이터 생성
//        insertDummyPost();
//
//        // 테스트할 날짜 설정 (테스트 당일 날짜를 사용)
//        LocalDate testDate = LocalDate.now();
//
//        // 카테고리별 상위 5개 게시물 조회 테스트 (카테고리 ID 1)
//        Integer categoryId = 1; // 테스트 대상 카테고리 ID
//        int limit = 5;
//        List<PostListByCategoryDTO> topPosts = postService.findTopPostsByCategory(categoryId, testDate, limit);
//
//        // 상세 결과 로그 출력
//        if (topPosts.isEmpty()) {
//            System.out.println("No posts found for category ID: " + categoryId);
//        } else {
//            topPosts.forEach(post ->
//                    System.out.println("Post ID: " + post.getPostId() +
//                            ", Title: " + post.getTitle() +
//                            ", Hits: " + post.getHits() +
//                            ", Posted Date: " + post.getPostedDate())
//            );
//        }
//
//        // 검증: 조회된 게시물 수가 limit 이하인지 확인
//        assertThat(topPosts.size()).isLessThanOrEqualTo(limit);
//    }
//
//    private void insertDummyPost() {
//        Random random = new Random();
//        int postCount = 15; // 15개의 게시글을 생성
//        String[] members = {"member1", "member2", "member3", "member4", "membertest1"};
//
//        for (int i = 1; i <= postCount; i++) {
//            int categoryId = random.nextInt(3) + 1;  // 카테고리는 1, 2, 3 중 하나
//            int hits = random.nextInt(1000) + 1;  // 조회수는 1에서 1000 사이
//            LocalDateTime postedDate = LocalDateTime.now().minusDays(random.nextInt(2)).withHour(12); // 게시일은 최근 2일 이내, 시간은 무작위로 설정하지 않고 정오로 고정
//
//            Post post = new Post(
//                    null,
//                    "Title " + i,
//                    "Content " + i,
//                    postedDate,
//                    hits,
//                    postedDate,
//                    false,
//                    categoryId,
//                    members[random.nextInt(members.length)],
//                    "abc",
//                    "English",
//                    33
//            );
//            entityManager.persist(post);
//        }
//        entityManager.flush(); // 모든 변경 사항을 데이터베이스에 적용
//        System.out.println("Inserted " + postCount + " dummy posts with varied hits and dates."); // 로그 추가
//    }
//}
