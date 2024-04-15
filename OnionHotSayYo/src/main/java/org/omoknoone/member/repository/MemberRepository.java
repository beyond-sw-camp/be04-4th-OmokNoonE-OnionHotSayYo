package org.omoknoone.member.repository;

import org.omoknoone.member.aggregate.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

    Member findByMemberId(String memberId);
}
