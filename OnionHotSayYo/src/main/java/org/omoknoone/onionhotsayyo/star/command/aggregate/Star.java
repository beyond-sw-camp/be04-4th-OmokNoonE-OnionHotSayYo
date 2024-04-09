package org.omoknoone.onionhotsayyo.star.command.aggregate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "star")
public class Star {

	@Id
	@Column(name = "star_id")
	private int starId;

	@JoinColumn(name = "posting_id")
	private int postingId;

	@JoinColumn(name = "member_id")
	private String memberId;

	// true = 좋아요 , false = 싫어요
	@Column(name = "status")
	private boolean status;

	public Star() {
	}

	public Star(int starId, int postingId, String memberId, boolean status) {
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
		return "Star{" +
			"starId=" + starId +
			", postingId=" + postingId +
			", memberId='" + memberId + '\'' +
			", status=" + status +
			'}';
	}
}
