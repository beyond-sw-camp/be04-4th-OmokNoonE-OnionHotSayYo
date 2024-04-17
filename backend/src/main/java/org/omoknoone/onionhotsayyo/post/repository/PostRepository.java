package org.omoknoone.onionhotsayyo.post.repository;

import org.omoknoone.onionhotsayyo.post.aggregate.Post;
import org.omoknoone.onionhotsayyo.post.dto.SearchTranslatedPostListDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    // 카테고리 ID에 해당하는 게시물 목록 조회 메소드
    List<Post> findByCategoryId(Integer categoryId);

    // 회원 ID에 해당하는 게시물 목록 조회 메소드
    List<Post> findByMemberId(String memberId);

    /* 필기.
     *  카테고리 ID에 따라 삭제되지 않은 게시물들 중 조회수가 높은 순으로 정렬된 결과를 반환합니다.
     *  @param categoryId 조회할 카테고리 ID
     *  @param pageable   페이징 처리를 위한 파라미터 (주로 상위 n개의 결과를 제한하기 위해 사용)
     *  @return 조회수 순으로 정렬된 게시물 목록
    * */
    @Query("SELECT p FROM Post p WHERE p.categoryId = :categoryId AND p.isDeleted = false " +
            "AND p.postedDate BETWEEN :start AND :end ORDER BY p.hits DESC")
    List<Post> findTopPostsByCategoryAndDate(Integer categoryId, LocalDateTime start, LocalDateTime end, Pageable pageable);

    @Query("SELECT" + " new org.omoknoone.onionhotsayyo.post.dto.SearchTranslatedPostListDTO" +
        "(a.postId, a.title, a.memberId, a.postedDate, a.hits, a.content) " +
        "FROM Post a " +
        "WHERE a.title LIKE %:title%")
    List<SearchTranslatedPostListDTO> searchPostByTitle(@Param("title") String title);


}
