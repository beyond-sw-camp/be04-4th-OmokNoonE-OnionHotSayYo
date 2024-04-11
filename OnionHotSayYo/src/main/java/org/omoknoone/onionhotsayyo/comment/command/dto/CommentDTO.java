package org.omoknoone.onionhotsayyo.comment.command.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CommentDTO {

	private int commentId;

	private String content;

	private LocalDateTime postedDate;

	private LocalDateTime lastModifiedDate;

	private boolean isDeleted;

	private Post postingId;

	private Member memberId;

	public CommentDTO() {
	}

	public CommentDTO(int commentId, String content, LocalDateTime postedDate, LocalDateTime lastModifiedDate,
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
		return "CommentDTO{" +
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
