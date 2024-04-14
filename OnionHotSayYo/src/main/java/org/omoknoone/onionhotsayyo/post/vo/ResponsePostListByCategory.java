package org.omoknoone.onionhotsayyo.post.vo;

import lombok.*;
import org.omoknoone.onionhotsayyo.post.dto.PostListByCategoryDTO;

import java.util.List;


// 카테고리 별 게시물 목록 응답
@Getter
@ToString
public class ResponsePostListByCategory {

    private final List<PostListByCategoryDTO> categoryPosts;

    public ResponsePostListByCategory(List<PostListByCategoryDTO> categoryPosts) {
        this.categoryPosts = categoryPosts;
    }
}
