package org.omoknoone.onionhotsayyo.bookmark.command.dto;

public class BookmarkDTO {

	private String memberId;
	private int postingId;

	public BookmarkDTO() {
	}

	public BookmarkDTO(String memberId, int postingId) {
		this.memberId = memberId;
		this.postingId = postingId;
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
		return "BookmarkDTO{" +
			"memberId='" + memberId + '\'' +
			", postingId=" + postingId +
			'}';
	}
}
