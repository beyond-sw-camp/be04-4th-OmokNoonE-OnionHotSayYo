package org.omoknoone.onionhotsayyo.post.command.aggregate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posting_id")
    private Integer postingId;

    @NotNull(message = "제목은 필수입니다.")
    @Size(min = 1, max = 30, message = "제목은 1자 이상, 30자 이하이어야 합니다.")
    @Column(name = "title")
    private String title;

    @NotNull(message = "내용은 필수입니다.")
    @Size(min = 1, message = "내용은 최소 1자 이상이어야 합니다.")
    @Column(name = "content")
    private String content;

    @CreationTimestamp
    @Column(name = "posted_date", updatable = false)
    private LocalDateTime postedDate;

    @Column(name = "hits")
    private int hits = 0;   // 초기 조회수는 0으로 설정됨

    @UpdateTimestamp
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

//    @Enumerated(EnumType.STRING)
    @Column(name = "is_deleted")
    private boolean isDeleted = false;  // 초기 삭제 상태는 false 삭제 되지 않음으로 설정

//    @ManyToOne
    @Column(name = "category_id")
    private String categoryId;

//    @ManyToOne
//    @JoinColumn(name = "member_id")
    @Column(name = "member_id")
    private String memberId;

    @Column(name = "image")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    // 조회수 증가
    public void increaseHits() {
        this.hits += 1;
    }

    public void markAsDeleted() {
        this.isDeleted = true;
    }

    public Post() {
    }

    public Post(Integer postingId, String title, String content, LocalDateTime postedDate, int hits,
                LocalDateTime lastModifiedDate, boolean isDeleted,
                String categoryId, String memberId, String image, Location location) {
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

    public void setPostingId(Integer postingId) {
        this.postingId = postingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDateTime postedDate) {
        this.postedDate = postedDate;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Post{" +
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
