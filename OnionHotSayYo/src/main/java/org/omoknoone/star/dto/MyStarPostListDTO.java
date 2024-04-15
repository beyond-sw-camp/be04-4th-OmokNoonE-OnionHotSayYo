package org.omoknoone.star.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MyStarPostListDTO {

    private Integer starId;
    private Integer postId;
    private String title;
    private LocalDateTime postedDate;
    private int hits;
}
