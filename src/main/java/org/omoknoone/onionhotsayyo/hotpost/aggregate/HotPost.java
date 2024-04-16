package org.omoknoone.onionhotsayyo.hotpost.aggregate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "hotpost")
public class HotPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hot_post_id")
    private Integer hotPostId;

    @Column(name = "is_active")
    private boolean isActive;

    @CreationTimestamp
    @Column(name = "hot_post_date")
    private LocalDateTime hotPostDate;

    @JoinColumn(name = "post_id")
    private Integer postId;

    @JoinColumn(name = "title")
    private String title;

    @JoinColumn(name = "category_id")
    private Integer categoryId;

    @JoinColumn(name = "hits")
    private int hits;

    @JoinColumn(name = "is_deleted")
    private boolean isDeleted;

    // 상태 변경 메소드
    public void activate() {
        this.isActive = true;
    }

    public void deactivate() {
        this.isActive = false;
    }

}
