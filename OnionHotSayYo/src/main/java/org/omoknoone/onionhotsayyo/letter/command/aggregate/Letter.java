package org.omoknoone.onionhotsayyo.letter.command.aggregate;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.omoknoone.onionhotsayyo.member.aggregate.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "letter")
public class Letter {

	@Id
	@Column(name = "letter_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int letterId;

	@Column(name = "message")
	private String message;

	@Column(name = "event_time")
	@CreationTimestamp
	private LocalDateTime eventTime;

	@Column(name = "is_checked")
	@ColumnDefault("false")
	private boolean isChecked;

	@JoinColumn(name = "send_id")
	private String sendId;

	@JoinColumn(name = "receive_id")
	private String receiveId;

	public Letter() {
	}

	public Letter(int letterId, String message, LocalDateTime eventTime, boolean isChecked, String sendId,
		String receiveId) {
		this.letterId = letterId;
		this.message = message;
		this.eventTime = eventTime;
		this.isChecked = isChecked;
		this.sendId = sendId;
		this.receiveId = receiveId;
	}

	public int getLetterId() {
		return letterId;
	}

	public void setLetterId(int letterId) {
		this.letterId = letterId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalDateTime eventTime) {
		this.eventTime = eventTime;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean checked) {
		isChecked = checked;
	}

	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public String getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
	}

	@Override
	public String toString() {
		return "Letter{" +
			"letterId=" + letterId +
			", message='" + message + '\'' +
			", eventTime=" + eventTime +
			", isChecked=" + isChecked +
			", sendId='" + sendId + '\'' +
			", receiveId='" + receiveId + '\'' +
			'}';
	}
}
