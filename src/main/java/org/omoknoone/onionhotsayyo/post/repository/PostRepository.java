package org.omoknoone.onionhotsayyo.post.repository;

import org.omoknoone.onionhotsayyo.post.aggregate.Post;
import org.omoknoone.onionhotsayyo.post.dto.MyPostListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    // 카테고리 ID에 해당하는 게시물 목록 조회 메소드
    List<Post> findByCategoryId(Integer categoryId);
    
    List<Post> findByMemberId(String memberId);

    @Query("SELECT" +
        " new org.omoknoone.onionhotsayyo.post.dto.MyPostListDTO" +
        "(a.postId, a.title, a.memberId, a.postedDate, a.hits)" +
        "FROM Post a " +
        "WHERE a.title LIKE %:title%")
    List<MyPostListDTO> searchPostByTitle(@Param("title") String title);
}
