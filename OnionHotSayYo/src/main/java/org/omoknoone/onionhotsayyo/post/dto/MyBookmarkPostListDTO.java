package org.omoknoone.onionhotsayyo.post.dto;

import lombok.*;

import java.time.LocalDateTime;

// 회원이 북마크한 게시물 목록 조회 시
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MyBookmarkPostListDTO {
    private Integer postId;
    private String title;
    private LocalDateTime postedDate;
    private int hits;
}
