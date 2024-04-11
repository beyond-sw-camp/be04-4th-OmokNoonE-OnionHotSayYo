package org.omoknoone.onionhotsayyo.post.command.repository;

import org.omoknoone.onionhotsayyo.post.command.aggregate.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    // 카테고리 ID에 해당하는 게시물 목록 조회 메소드
    List<Post> findByCategoryId(String categoryId);

    // JPQL
//    @Query("SELECT p FROM Post p WHERE p.categoryId = :categoryId AND p.isDeleted = false")
//    List<Post> findActivePostsByCategoryId(@Param("categoryId") String categoryId);

    List<Post> findByMemberId(String memberId);
}
