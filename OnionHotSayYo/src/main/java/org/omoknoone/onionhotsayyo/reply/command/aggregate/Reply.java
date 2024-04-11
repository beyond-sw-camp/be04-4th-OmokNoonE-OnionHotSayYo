package org.omoknoone.onionhotsayyo.reply.command.aggregate;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import org.omoknoone.onionhotsayyo.member.aggregate.Member;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@Entity
@Table(name = "reply")
public class Reply {

	@Id
	@Column(name = "reply_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reply_id;

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

	@Column(name = "comment_id")
	private Integer commentId;

	@Column(name = "member_id")
	private String memberId;

}
