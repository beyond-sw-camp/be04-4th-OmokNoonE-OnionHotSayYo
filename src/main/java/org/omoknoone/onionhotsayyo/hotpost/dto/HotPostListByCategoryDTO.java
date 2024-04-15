package org.omoknoone.onionhotsayyo.hotpost.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class HotPostListByCategoryDTO {

    private Integer postId;
    private String title;
    private int hit;
    private LocalDateTime postedDate;
    private boolean isDeleted;

}
