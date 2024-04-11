package org.omoknoone.onionhotsayyo.post.command.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class MyPostListDTO implements Serializable {

    private Integer postId;
    private String title;
    private LocalDateTime postedDate;
    private int hits;
    private String categoryId;
    private String location;

    public MyPostListDTO() {
    }
}