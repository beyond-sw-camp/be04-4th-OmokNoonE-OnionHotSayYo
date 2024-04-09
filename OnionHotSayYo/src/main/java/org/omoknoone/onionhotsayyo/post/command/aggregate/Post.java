package org.omoknoone.onionhotsayyo.post.command.aggregate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;

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
    private String postedDate;

    @Column(name = "hits")
    private int hits = 0;   // 초기 조회수는 0으로 설정됨

    @UpdateTimestamp
    @Column(name = "last_modified_date")
    private String lastModifiedDate;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;  // 초기 삭제 상태는 false 삭제 되지 않음으로 설정

    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "image")
    private String image;

    @Column(name = "location")
    private String location;

    // 조회수 증가
    public void increaseHits() {
        this.hits += 1;
    }

    // 소프트 삭제
    public void markAsDeleted() {
        this.isDeleted = true;
    }

    public Post() {
    }

    public Post(Integer postId, String title, String content, String postedDate, int hits,
                String lastModifiedDate, boolean isDeleted,
                String categoryId, String memberId, String image, String location) {
        this.postId = postId;
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

    public Integer getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public int getHits() {
        return hits;
    }

    public String getLastModifiedDate() {
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
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", postedDate='" + postedDate + '\'' +
                ", hits=" + hits +
                ", lastModifiedDate='" + lastModifiedDate + '\'' +
                ", isDeleted=" + isDeleted +
                ", categoryId='" + categoryId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", image='" + image + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
