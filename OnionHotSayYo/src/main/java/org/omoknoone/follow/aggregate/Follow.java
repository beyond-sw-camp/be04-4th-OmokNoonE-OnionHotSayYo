package org.omoknoone.follow.aggregate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "follow")
public class Follow {

	@Id
	@Column(name = "follow_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int followId;

	@Column(name = "from_member_id")
	private String fromMemberId;

	@Column(name = "to_member_id")
	private String toMemberId;

	public Follow() {
	}

	public Follow(int followId, String fromMemberId, String toMemberId) {
		this.followId = followId;
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
		return "Follow{" +
			"followId=" + followId +
			", fromMemberId='" + fromMemberId + '\'' +
			", toMemberId='" + toMemberId + '\'' +
			'}';
	}
}
