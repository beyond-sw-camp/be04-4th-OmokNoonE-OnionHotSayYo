package org.omoknoone.onionhotsayyo.reply.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class ReplyDTO {

	private int reply_id;

	private String content;

	private LocalDateTime postedDate;

	private LocalDateTime lastModifiedDate;

	private boolean isDeleted;

	private int commentId;

	private String memberId;


}
