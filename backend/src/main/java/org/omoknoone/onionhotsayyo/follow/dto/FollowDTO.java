package org.omoknoone.onionhotsayyo.follow.dto;

public class FollowDTO {
	private int followId;
	private String fromMemberId;
	private String toMemberId;

	public FollowDTO() {
	}

	public FollowDTO(int followId, String fromMemberId, String toMemberId) {
		this.followId = followId;
		this.fromMemberId = fromMemberId;
		this.toMemberId = toMemberId;
	}

	public FollowDTO(String fromMemberId, String toMemberId) {
		this.fromMemberId = fromMemberId;
		this.toMemberId = toMemberId;
	}

	public int getFollowId() {
		return followId;
	}

	public void setFollowId(int followId) {
		this.followId = followId;
	}

	public String getFromMemberId() {
		return fromMemberId;
	}

	public void setFromMemberId(String fromMemberId) {
		this.fromMemberId = fromMemberId;
	}

	public String getToMemberId() {
		return toMemberId;
	}

	public void setToMemberId(String toMemberId) {
		this.toMemberId = toMemberId;
	}

	@Override
	public String toString() {
		return "FollowDTO{" +
			"followId=" + followId +
			", fromMemberId='" + fromMemberId + '\'' +
			", toMemberId='" + toMemberId + '\'' +
			'}';
	}
}
