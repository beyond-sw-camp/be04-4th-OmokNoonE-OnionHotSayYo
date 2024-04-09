package org.omoknoone.onionhotsayyo.post.command.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class PostDetailVO {

    private Integer postingId;
    private String title;
    private String content;
    private String postedDate;
    private int hits = 0;   // 초기 조회수는 0으로 설정됨
    private String lastModifiedDate;
    private boolean isDeleted = false;  // 초기 삭제 상태는 false 삭제 되지 않음으로 설정
    private String categoryId;
    private String memberId;
    private String image;
    private String location;

}
