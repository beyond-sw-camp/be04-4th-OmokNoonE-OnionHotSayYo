package org.omoknoone.onionhotsayyo.post.vo;

import org.omoknoone.onionhotsayyo.post.command.aggregate.Location;

import java.time.LocalDateTime;

// 게시물의 목록에 포함되어야 하는 데이터
public class PostSummaryVO {

    private int postingId;
    private String title;
    private LocalDateTime postedDate;
    private int hits;
    private String categoryId;
    private Location location;

    public PostSummaryVO() {
    }

    public PostSummaryVO(int postingId, String title, LocalDateTime postedDate, int hits, String categoryId, Location location) {
        this.postingId = postingId;
        this.title = title;
        this.postedDate = postedDate;
        this.hits = hits;
        this.categoryId = categoryId;
        this.location = location;
    }

    public int getPostingId() {
        return postingId;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getPostedDate() {
        return postedDate;
    }

    public int getHits() {
        return hits;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "PostSummaryDTO{" +
                "postingId=" + postingId +
                ", title='" + title + '\'' +
                ", postedDate=" + postedDate +
                ", hits=" + hits +
                ", categoryId='" + categoryId + '\'' +
                ", location=" + location +
                '}';
    }
}
