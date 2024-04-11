package org.omoknoone.onionhotsayyo.notification.command.aggregate;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.omoknoone.onionhotsayyo.member.aggregate.Member;
import org.springframework.stereotype.Service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "notification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notification {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notificationId;

	@Column
	private String message;

	@Column
	@CreationTimestamp
	private LocalDateTime eventTime;

	@JoinColumn(name = "member_id")
	// @ManyToOne(fetch = FetchType.LAZY)
	private String memberId;

	@Column
	private String url;

	@Column
	private boolean isChecked;

	@Column
	private String type;



}
