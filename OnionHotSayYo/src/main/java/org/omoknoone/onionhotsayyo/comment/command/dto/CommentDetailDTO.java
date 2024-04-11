package org.omoknoone.onionhotsayyo.comment.command.dto;

import java.time.LocalDateTime;

public class CommentDetailDTO {

	private int commentId;

	private String memberId;

	private String content;

	private LocalDateTime postedDate;

	private LocalDateTime lastModifiedDate;

	private boolean isDeleted;

	private int postingId;

	public CommentDetailDTO() {
	}

	public CommentDetailDTO(int commentId, String memberId, String content, LocalDateTime postedDate,
		LocalDateTime lastModifiedDate, boolean isDeleted, int postingId) {
		this.commentId = commentId;
		this.memberId = memberId;
		this.content = content;
		this.postedDate = postedDate;
		this.lastModifiedDate = lastModifiedDate;
		this.isDeleted = isDeleted;
		this.postingId = postingId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public int getPostingId() {
		return postingId;
	}

	public void setPostingId(int postingId) {
		this.postingId = postingId;
	}

	@Override
	public String toString() {
		return "CommentDetailDTO{" +
			"commentId=" + commentId +
			", memberId='" + memberId + '\'' +
			", content='" + content + '\'' +
			", postedDate=" + postedDate +
			", lastModifiedDate=" + lastModifiedDate +
			", isDeleted=" + isDeleted +
			", postingId=" + postingId +
			'}';
	}
}

