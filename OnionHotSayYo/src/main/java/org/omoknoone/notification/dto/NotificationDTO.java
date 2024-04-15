package org.omoknoone.notification.dto;

import java.time.LocalDateTime;

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
