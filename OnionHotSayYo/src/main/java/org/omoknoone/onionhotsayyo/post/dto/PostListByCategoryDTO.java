package org.omoknoone.onionhotsayyo.post.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostListByCategoryDTO {

    private Integer categoryId;
    private String title;
    private LocalDateTime postedDate;
    private int hits;
}
