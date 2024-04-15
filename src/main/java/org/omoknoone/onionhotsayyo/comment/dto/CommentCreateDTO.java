package org.omoknoone.onionhotsayyo.comment.dto;

public class CommentCreateDTO {

	private String memberId;
	private String content;
	private int postingId;

	public CommentCreateDTO() {
	}

	public CommentCreateDTO(String memberId, String content, int postingId) {
		this.memberId = memberId;
		this.content = content;
		this.postingId = postingId;
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

	public int getPostingId() {
		return postingId;
	}

	public void setPostingId(int postingId) {
		this.postingId = postingId;
	}

	@Override
	public String toString() {
		return "CommentCreateDTO{" +
			"memberId='" + memberId + '\'' +
			", content='" + content + '\'' +
			", postingId=" + postingId +
			'}';
	}
}
