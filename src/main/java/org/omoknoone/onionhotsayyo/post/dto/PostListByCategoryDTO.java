package org.omoknoone.onionhotsayyo.post.dto;

import lombok.*;

import java.time.LocalDateTime;

// 카테고리별 게시글 목록 조회 시
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostListByCategoryDTO {

    private Integer categoryId;
    private Integer PostId;
    private String title;
    private LocalDateTime postedDate;
    private int hits;
}
