package org.omoknoone.onionhotsayyo.comment.command.dto;

import java.time.LocalDateTime;

/* 내가 작성한 댓글 + 대댓글 조회 시 필요한 댓글 대댓글 DTO */
public class CommentReplyDTO {

	private String memberId;
	private String content;
	private LocalDateTime postedDate;
	private LocalDateTime lastModifiedDate;
	private boolean isDeleted;

	public CommentReplyDTO() {
	}

	public CommentReplyDTO(String memberId, String content, LocalDateTime postedDate, LocalDateTime lastModifiedDate,
		boolean isDeleted) {
		this.memberId = memberId;
		this.content = content;
		this.postedDate = postedDate;
		this.lastModifiedDate = lastModifiedDate;
		this.isDeleted = isDeleted;
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

	@Override
	public String toString() {
		return "CommentReplyDTO{" +
			"memberId='" + memberId + '\'' +
			", content='" + content + '\'' +
			", postedDate=" + postedDate +
			", lastModifiedDate=" + lastModifiedDate +
			", isDeleted=" + isDeleted +
			'}';
	}
}
