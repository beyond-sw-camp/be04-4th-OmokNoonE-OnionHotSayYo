package org.omoknoone.onionhotsayyo.reply.command.repository;

import java.util.List;

import org.omoknoone.onionhotsayyo.comment.command.aggregate.Comment;
import org.omoknoone.onionhotsayyo.reply.command.aggregate.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    List<Reply> findAllByMemberId(String memberId);
}
