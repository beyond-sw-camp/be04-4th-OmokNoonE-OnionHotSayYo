package org.omoknoone.onionhotsayyo.member.service;

import org.omoknoone.onionhotsayyo.member.dto.MemberDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    void signUp(MemberDTO memberDTO);

    MemberDTO modify(MemberDTO memberDTO);

    void withdraw(MemberDTO memberDTO);

    MemberDTO getMemberDetailsByMemberId(String memberId);
}
