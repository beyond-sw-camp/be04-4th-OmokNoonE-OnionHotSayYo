package org.omoknoone.onionhotsayyo.comment.command.aggregate;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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

	@JoinColumn(name = "posting_id")
	@ManyToOne
	private Post postingId;

	@JoinColumn(name = "member_id")
	@ManyToOne
	private Member memberId;

	public Comment() {
	}

	public Comment(int commentId, String content, LocalDateTime postedDate, LocalDateTime lastModifiedDate,
		boolean isDeleted, Post postingId, Member memberId) {
		this.commentId = commentId;
		this.content = content;
		this.postedDate = postedDate;
		this.lastModifiedDate = lastModifiedDate;
		this.isDeleted = isDeleted;
		this.postingId = postingId;
		this.memberId = memberId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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

	public Post getPostingId() {
		return postingId;
	}

	public void setPostingId(Post postingId) {
		this.postingId = postingId;
	}

	public Member getMemberId() {
		return memberId;
	}

	public void setMemberId(Member memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Comment{" +
			"commentId=" + commentId +
			", content='" + content + '\'' +
			", postedDate=" + postedDate +
			", lastModifiedDate=" + lastModifiedDate +
			", isDeleted=" + isDeleted +
			", postingId=" + postingId +
			", memberId=" + memberId +
			'}';
	}
}
