package org.omoknoone.onionhotsayyo.post.command.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostListByCategoryDTO {

    private String categoryName;
    private String title;
    private LocalDateTime postedDate;
    private int hits;
}
