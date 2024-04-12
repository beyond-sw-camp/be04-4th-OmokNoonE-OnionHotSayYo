package org.omoknoone.onionhotsayyo.letter.command.dto;

import java.time.LocalDateTime;


public class LetterDTO {
	private int letterId;
	private String sendId;
	private String receiveId;
	private String message;
	private LocalDateTime eventTime;
	private boolean isChecked;

	public LetterDTO() {
	}

	public LetterDTO(int letterId, String sendId, String receiveId, String message, LocalDateTime eventTime,
		boolean isChecked) {
		this.letterId = letterId;
		this.sendId = sendId;
		this.receiveId = receiveId;
		this.message = message;
		this.eventTime = eventTime;
		this.isChecked = isChecked;
	}

	public int getLetterId() {
		return letterId;
	}

	public void setLetterId(int letterId) {
		this.letterId = letterId;
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

	@Override
	public String toString() {
		return "LetterDTO{" +
			"letterId=" + letterId +
			", sendId='" + sendId + '\'' +
			", receiveId='" + receiveId + '\'' +
			", message='" + message + '\'' +
			", eventTime=" + eventTime +
			", isChecked=" + isChecked +
			'}';
	}
}
