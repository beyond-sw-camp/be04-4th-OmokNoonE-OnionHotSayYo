package org.omoknoone.onionhotsayyo.post.command.vo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.omoknoone.onionhotsayyo.post.command.aggregate.Location;

import java.time.LocalDateTime;

public class PostDetailVO {

    private Integer postingId;
    private String title;
    private String content;
    private LocalDateTime postedDate;
    private int hits = 0;   // 초기 조회수는 0으로 설정됨
    private LocalDateTime lastModifiedDate;
    private boolean isDeleted = false;  // 초기 삭제 상태는 false 삭제 되지 않음으로 설정
    private String categoryId;
    private String memberId;
    private String image;
    private String location;

    public PostDetailVO() {
    }

    public PostDetailVO(Integer postingId, String title, String content,
                        LocalDateTime postedDate, int hits, LocalDateTime lastModifiedDate,
                        boolean isDeleted, String categoryId, String memberId, String image, String location) {
        this.postingId = postingId;
        this.title = title;
        this.content = content;
        this.postedDate = postedDate;
        this.hits = hits;
        this.lastModifiedDate = lastModifiedDate;
        this.isDeleted = isDeleted;
        this.categoryId = categoryId;
        this.memberId = memberId;
        this.image = image;
        this.location = location;
    }

    public Integer getPostingId() {
        return postingId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getPostedDate() {
        return postedDate;
    }

    public int getHits() {
        return hits;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getImage() {
        return image;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "PostDetailVO{" +
                "postingId=" + postingId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", postedDate=" + postedDate +
                ", hits=" + hits +
                ", lastModifiedDate=" + lastModifiedDate +
                ", isDeleted=" + isDeleted +
                ", categoryId='" + categoryId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", image='" + image + '\'' +
                ", location=" + location +
                '}';
    }
}
