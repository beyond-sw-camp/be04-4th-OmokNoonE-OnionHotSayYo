package org.omoknoone.onionhotsayyo.comment.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class CommentDTO {

	private int commentId;

	private String content;

	private LocalDateTime postedDate;

	private LocalDateTime lastModifiedDate;

	private boolean isDeleted;

	private Integer postId;

	private String memberId;


}
