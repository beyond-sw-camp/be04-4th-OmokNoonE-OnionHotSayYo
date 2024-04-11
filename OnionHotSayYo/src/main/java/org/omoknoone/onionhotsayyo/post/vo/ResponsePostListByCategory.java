package org.omoknoone.onionhotsayyo.post.vo;

import lombok.*;
import org.omoknoone.onionhotsayyo.post.dto.PostListByCategoryDTO;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@ToString
// 카테고리 별 게시물 리스트 응답
public class ResponsePostListByCategory {

    private final List<PostListByCategoryDTO> categoryPosts;

    public ResponsePostListByCategory(List<PostListByCategoryDTO> categoryPosts) {
        this.categoryPosts = categoryPosts;
    }
}
