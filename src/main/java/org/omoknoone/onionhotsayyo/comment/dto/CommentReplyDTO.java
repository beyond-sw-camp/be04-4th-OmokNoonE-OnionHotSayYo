package org.omoknoone.onionhotsayyo.comment.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
/* 내가 작성한 댓글 + 대댓글 조회 시 필요한 댓글 대댓글 DTO */
public class CommentReplyDTO {

	private String memberId;
	private String nickname;
	private String content;
	private LocalDateTime postedDate;
	private LocalDateTime lastModifiedDate;
	private boolean isDeleted;

}
