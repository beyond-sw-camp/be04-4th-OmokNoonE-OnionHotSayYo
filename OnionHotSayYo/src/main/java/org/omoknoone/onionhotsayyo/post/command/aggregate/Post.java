package org.omoknoone.onionhotsayyo.post.command.aggregate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
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

    public void markAsDeleted() {
        this.isDeleted = true;
    }

}
