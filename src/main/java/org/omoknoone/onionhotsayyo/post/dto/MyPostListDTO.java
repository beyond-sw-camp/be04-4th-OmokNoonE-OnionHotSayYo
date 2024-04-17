package org.omoknoone.onionhotsayyo.post.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

// 작성자가 작성한 게시물 리스트 목록 조회 시
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MyPostListDTO {

    private Integer postId;
    private String title;
    private String memberId;
    private LocalDateTime postedDate;
    private int hits;
}