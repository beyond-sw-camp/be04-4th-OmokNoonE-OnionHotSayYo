package org.omoknoone.onionhotsayyo.bookmark.command.aggregate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookmark")
public class Bookmark {

	@Id
	@Column(name = "bookmark_id")
	private int bookmarkId;

	@JoinColumn(name = "member_id")
	private String memberId;

	@JoinColumn(name = "posting_id")
	private int postingId;

	public Bookmark() {
	}

	public Bookmark(int bookmarkId, String memberId, int postingId) {
		this.bookmarkId = bookmarkId;
		this.memberId = memberId;
		this.postingId = postingId;
	}

	public int getBookmarkId() {
		return bookmarkId;
	}

	public void setBookmarkId(int bookmarkId) {
		this.bookmarkId = bookmarkId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getPostingId() {
		return postingId;
	}

	public void setPostingId(int postingId) {
		this.postingId = postingId;
	}

	@Override
	public String toString() {
		return "Bookmark{" +
			"bookmarkId=" + bookmarkId +
			", memberId='" + memberId + '\'' +
			", postingId=" + postingId +
			'}';
	}
}
