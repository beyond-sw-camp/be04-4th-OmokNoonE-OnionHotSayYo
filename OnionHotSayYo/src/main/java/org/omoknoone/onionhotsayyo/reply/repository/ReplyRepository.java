package org.omoknoone.onionhotsayyo.reply.repository;

import java.util.List;

import org.omoknoone.onionhotsayyo.reply.aggregate.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    List<Reply> findAllByMemberId(String memberId);
}
