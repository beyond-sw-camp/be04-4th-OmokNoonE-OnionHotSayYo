package org.omoknoone.onionhotsayyo.notification.command.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.omoknoone.onionhotsayyo.member.aggregate.Member;
import org.omoknoone.onionhotsayyo.notification.command.aggregate.Notification;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NotificationDTO {

	private int notificationId;
	private String message;
	private LocalDateTime eventTime;
	private String memberId;
	private String url;
	private boolean isChecked;
	private String type;
}
