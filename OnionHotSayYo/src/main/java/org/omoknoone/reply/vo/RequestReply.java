package org.omoknoone.reply.vo;

import java.time.LocalDateTime;

public class RequestReply {

	private int reply_id;

	private String content;

	private LocalDateTime postedDate;

	private LocalDateTime lastModifiedDate;

	private boolean isDeleted;

	private int commendId;

	public RequestReply() {
	}

	public RequestReply(int reply_id, String content, LocalDateTime postedDate, LocalDateTime lastModifiedDate,
		boolean isDeleted, int commendId) {
		this.reply_id = reply_id;
		this.content = content;
		this.postedDate = postedDate;
		this.lastModifiedDate = lastModifiedDate;
		this.isDeleted = isDeleted;
		this.commendId = commendId;
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

	public int getCommendId() {
		return commendId;
	}

	public void setCommendId(int commendId) {
		this.commendId = commendId;
	}

	@Override
	public String toString() {
		return "RequestReply{" +
			"reply_id=" + reply_id +
			", content='" + content + '\'' +
			", postedDate=" + postedDate +
			", lastModifiedDate=" + lastModifiedDate +
			", isDeleted=" + isDeleted +
			", commendId=" + commendId +
			'}';
	}
}
