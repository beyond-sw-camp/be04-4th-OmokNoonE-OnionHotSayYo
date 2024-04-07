package org.omoknoone.onionhotsayyo.post.command.repository;

import org.omoknoone.onionhotsayyo.post.command.aggregate.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    // 카테고리 ID에 해당하는 게시물 목록 조회 메소드
    List<Post> findByCategoryId(String categoryId);
}
