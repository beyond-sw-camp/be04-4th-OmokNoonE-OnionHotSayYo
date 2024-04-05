package org.omoknoone.onionhotsayyo.post.command.dto;

import org.omoknoone.onionhotsayyo.post.command.aggregate.Location;

import java.time.LocalDateTime;

public class PostDetailDTO {

    private int postingId;
    private String title;
    private String content;
    private LocalDateTime postedDate;
    private int hits;
    private LocalDateTime lastModifiedDate;
    private boolean isDeleted;
//    private Category categoryId;
//    private Member memberId;
    private String image;
    private Location location;

    public PostDetailDTO() {
    }


}
