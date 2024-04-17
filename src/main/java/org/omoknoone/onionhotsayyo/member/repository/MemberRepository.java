package org.omoknoone.onionhotsayyo.member.repository;

import org.omoknoone.onionhotsayyo.member.aggregate.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

    Member findByMemberId(String memberId);
}
