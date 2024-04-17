package org.omoknoone.onionhotsayyo.star.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

public class StarDTO {

	private int starId;
	private int postingId;
	private String memberId;
	private boolean status;

	public StarDTO() {
	}

	public StarDTO(int starId, int postingId, String memberId, boolean status) {
		this.starId = starId;
		this.postingId = postingId;
		this.memberId = memberId;
		this.status = status;
	}

	public int getStarId() {
		return starId;
	}

	public void setStarId(int starId) {
		this.starId = starId;
	}

	public int getPostingId() {
		return postingId;
	}

	public void setPostingId(int postingId) {
		this.postingId = postingId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "StarDTO{" +
			"starId=" + starId +
			", postingId=" + postingId +
			", memberId='" + memberId + '\'' +
			", status=" + status +
			'}';
	}
}
