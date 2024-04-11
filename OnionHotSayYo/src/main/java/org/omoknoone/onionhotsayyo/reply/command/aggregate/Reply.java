package org.omoknoone.onionhotsayyo.reply.command.aggregate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.omoknoone.onionhotsayyo.comment.command.aggregate.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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

	@ManyToOne
	@JoinColumn(name = "comment_id")
	private Comment commentId;

	@JoinColumn(name = "member_id")
	@ManyToOne
	private Member memberId;

	public Reply() {
	}

	public Reply(int reply_id, String content, LocalDateTime postedDate, LocalDateTime lastModifiedDate,
		boolean isDeleted,
		Comment commentId, Member memberId) {
		this.reply_id = reply_id;
		this.content = content;
		this.postedDate = postedDate;
		this.lastModifiedDate = lastModifiedDate;
		this.isDeleted = isDeleted;
		this.commentId = commentId;
		this.memberId = memberId;
	}

	public int getReply_id() {
		return reply_id;
	}

	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
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

	public Comment getCommentId() {
		return commentId;
	}

	public void setCommentId(Comment commentId) {
		this.commentId = commentId;
	}

	public Member getMemberId() {
		return memberId;
	}

	public void setMemberId(Member memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Reply{" +
			"reply_id=" + reply_id +
			", content='" + content + '\'' +
			", postedDate=" + postedDate +
			", lastModifiedDate=" + lastModifiedDate +
			", isDeleted=" + isDeleted +
			", commentId=" + commentId +
			", memberId=" + memberId +
			'}';
	}
}
