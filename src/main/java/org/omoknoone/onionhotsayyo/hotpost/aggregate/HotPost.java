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

    @CreationTimestamp
    @Column(name = "hot_post_date")
    private LocalDateTime hotPostDate;

    @JoinColumn(name = "post_id")
    private Integer postId;
}
