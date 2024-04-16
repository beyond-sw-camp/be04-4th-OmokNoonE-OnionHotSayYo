package org.omoknoone.onionhotsayyo.post.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 작성자가 작성한 게시물 리스트 목록 조회 시
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SearchTranslatedPostListDTO {

    private Integer postId;
    private String title;
    private String memberId;
    private LocalDateTime postedDate;
    private int hits;
    private String content;
}