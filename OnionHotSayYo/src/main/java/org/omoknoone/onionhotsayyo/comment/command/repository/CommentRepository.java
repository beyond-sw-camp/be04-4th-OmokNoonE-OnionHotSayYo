package org.omoknoone.onionhotsayyo.comment.command.repository;

import java.util.List;

import org.omoknoone.onionhotsayyo.comment.command.aggregate.Comment;
import org.omoknoone.onionhotsayyo.comment.command.dto.CommentReplyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	@Query("SELECT c FROM Comment c WHERE c.memberId = :memberId UNION SELECT r FROM Reply r WHERE r.memberId = :memberId")
	List<CommentReplyDTO> findAllCommentsByMemberId(String memberId);

}
