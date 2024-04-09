package org.omoknoone.onionhotsayyo.post.command.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


// 게시물의 목록에 포함되어야 하는 데이터
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class PostSummaryVO {

    private int postingId;
    private String title;
    private String postedDate;
    private int hits;
    private String categoryId;
    private String location;

}
