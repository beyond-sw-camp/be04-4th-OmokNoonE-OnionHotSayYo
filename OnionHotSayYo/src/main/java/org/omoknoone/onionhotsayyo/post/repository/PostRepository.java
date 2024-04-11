package org.omoknoone.onionhotsayyo.post.repository;

import org.omoknoone.onionhotsayyo.post.aggregate.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    // 카테고리 ID에 해당하는 게시물 목록 조회 메소드
    List<Post> findByCategoryId(String categoryId);

    // JPQL
//    @Query("SELECT new org.omoknoone.onionhotsayyo.post.command.dto.PostWithCategoryNameDTO(p.postId, p.title, p.content, c.categoryName) " +
//            "FROM Post p JOIN p.category c " +
//            "WHERE p.memberId = :memberId")

//    @Query("SELECT p FROM Post p WHERE p.categoryId = :categoryId AND p.isDeleted = false")
//    List<Post> findActivePostsByCategoryId(@Param("categoryId") String categoryId);

    List<Post> findByMemberId(String memberId);
}
