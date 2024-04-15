package org.omoknoone.post.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

// 게시물 작성, 수정 시 응답
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ResponsePostDetail {

    private Integer postId;
    private String title;
    private String content;
    private LocalDateTime postedDate;
    private int hits = 0;   // 초기 조회수는 0으로 설정됨
    private LocalDateTime lastModifiedDate;
    private boolean isDeleted = false;  // 초기 삭제 상태는 false 삭제 되지 않음으로 설정
    private Integer categoryId;
    private String memberId;
    private String image;
    private Integer locationId;
}
