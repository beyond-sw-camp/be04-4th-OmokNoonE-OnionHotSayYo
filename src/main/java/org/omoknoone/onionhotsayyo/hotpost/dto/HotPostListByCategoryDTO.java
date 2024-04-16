package org.omoknoone.onionhotsayyo.hotpost.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class HotPostListByCategoryDTO {

    private Integer categoryId;
    private Integer postId;
    private String title;
    private LocalDateTime postedDate;
    private int hits;
    private boolean isDeleted;
    private boolean isActive;
}
