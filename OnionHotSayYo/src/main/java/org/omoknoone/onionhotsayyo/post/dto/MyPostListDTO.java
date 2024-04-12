package org.omoknoone.onionhotsayyo.post.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MyPostListDTO {

    private Integer postId;
    private String title;
    private LocalDateTime postedDate;
    private int hits;
}