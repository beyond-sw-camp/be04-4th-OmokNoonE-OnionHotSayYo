package org.omoknoone.bookmark.aggregate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "bookmark")
public class Bookmark {

	@Id
	@Column(name = "bookmark_id")
	private Integer bookmarkId;

	@JoinColumn(name = "post_id")
	private Integer postId;

	@JoinColumn(name = "member_id")
	private String memberId;
}
