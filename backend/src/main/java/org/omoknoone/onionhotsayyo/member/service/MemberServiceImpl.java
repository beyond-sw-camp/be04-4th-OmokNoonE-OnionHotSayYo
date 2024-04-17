package org.omoknoone.onionhotsayyo.member.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.omoknoone.onionhotsayyo.member.dto.MemberDTO;
import org.omoknoone.onionhotsayyo.member.aggregate.Member;
import org.omoknoone.onionhotsayyo.member.repository.MemberRepository;
import org.omoknoone.onionhotsayyo.nationality.aggregate.Nationality;
import org.omoknoone.onionhotsayyo.nationality.repository.NationalityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class MemberServiceImpl implements MemberService {

    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;
    private final NationalityRepository nationalityRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    public MemberServiceImpl(ModelMapper modelMapper,
                            MemberRepository memberRepository, NationalityRepository nationalityRepository,
                            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.modelMapper = modelMapper;
        this.memberRepository = memberRepository;
        this.nationalityRepository = nationalityRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public void signUp(MemberDTO newMember) {

//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        Member member = modelMapper.map(newMember, Member.class);
        member.setPassword(bCryptPasswordEncoder.encode(newMember.getPassword()));

        memberRepository.save(member);
    }

    @Override
    @Transactional
    public void withdraw(MemberDTO memberDTO) {

        Member member = memberRepository.findById(memberDTO.getMemberId()).orElseThrow(IllegalArgumentException::new);
        member.setWithdraw(true);     // 회원 탈퇴 상태값 true

        memberRepository.flush();
    }

    @Override
    @Transactional
    public MemberDTO modify(MemberDTO memberDTO) {

        Member member = memberRepository.findById(memberDTO.getMemberId()).orElseThrow(IllegalArgumentException::new);
        member.setNickname(memberDTO.getNickname());
        member.setEmail(memberDTO.getEmail());

        Nationality nationality = nationalityRepository.findById(memberDTO.getNationalityId()).orElseThrow(IllegalArgumentException::new);
        member.setNationalityId(nationality.getNationalityId());

        memberRepository.flush();

        return modelMapper.map(member, MemberDTO.class);
    }

    @Override
    public MemberDTO getMemberDetailsByMemberId(String memberId) {

        Member member = memberRepository.findByMemberId(memberId);

        if(member == null)
            throw new UsernameNotFoundException(memberId + " 아이디의 유저는 존재하지 않음");

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper.map(member, MemberDTO.class);
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        Member member = memberRepository.findByMemberId(memberId);

        if(member == null)
            throw new UsernameNotFoundException(memberId + " 아이디의 유저는 존재하지 않습니다.");

        return new User(member.getMemberId(), member.getPassword(),
                true, true, true, true,
                new ArrayList<>());
    }
}
