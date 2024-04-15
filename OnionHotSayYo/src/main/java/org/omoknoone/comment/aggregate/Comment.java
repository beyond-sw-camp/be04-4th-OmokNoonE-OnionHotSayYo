package org.omoknoone.comment.aggregate;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="comment")
public class Comment {

	@Id
	@Column(name = "comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;

	@Column(name = "content")
	private String content;

	@CreationTimestamp
	@Column(name = "posted_date", updatable = false)
	private LocalDateTime postedDate;

	@UpdateTimestamp
	@Column(name = "last_modified_date")
	private LocalDateTime lastModifiedDate;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@Column(name = "post_id")
	private Integer postId;

	@Column(name = "member_id")
	private String memberId;
}
