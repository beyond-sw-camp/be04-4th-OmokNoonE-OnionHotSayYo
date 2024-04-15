package org.omoknoone.onionhotsayyo.post.dto;

import lombok.*;

import java.time.LocalDateTime;

// 카테고리별 게시글 목록 조회 시
@Getter
@Setter
@ToString
public class PostListByCategoryDTO {

    private Integer categoryId;
    private Integer PostId;
    private String title;
    private LocalDateTime postedDate;
    private int hits;
    private boolean isDeleted;

    public PostListByCategoryDTO() {
    }

    public PostListByCategoryDTO(Integer categoryId, Integer postId,
                                 String title, LocalDateTime postedDate, int hits, boolean isDeleted) {
        this.categoryId = categoryId;
        PostId = postId;
        this.title = title;
        this.postedDate = postedDate;
        this.hits = hits;
        this.isDeleted = isDeleted;
    }

}
