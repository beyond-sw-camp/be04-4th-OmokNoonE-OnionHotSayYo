package org.omoknoone.onionhotsayyo.member.controller;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.member.dto.MemberDTO;
import org.omoknoone.onionhotsayyo.member.service.MemberService;
import org.omoknoone.onionhotsayyo.member.vo.RequestMember;
import org.omoknoone.onionhotsayyo.member.vo.ResponseMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final ModelMapper modelMapper;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public MemberController(MemberService memberService, ModelMapper modelMapper) {
        this.memberService = memberService;
        this.modelMapper = modelMapper;
    }

    /* 회원가입 */
    @PostMapping("/signup")
    public ResponseEntity<ResponseMember> signUp(@RequestBody RequestMember member) {

        MemberDTO memberDTO = modelMapper.map(member, MemberDTO.class);

        memberService.signUp(memberDTO);

        ResponseMember responseMember = modelMapper.map(memberDTO, ResponseMember.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMember);
    }

    /* 회원 정보 수정 */
    @PutMapping("/modify")
    public ResponseEntity<ResponseMember> modify(@RequestBody RequestMember member) {

        MemberDTO memberDTO = modelMapper.map(member, MemberDTO.class);

        ResponseMember responseMember = modelMapper.map(memberService.modify(memberDTO), ResponseMember.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseMember);
    }

    /* 회원탈퇴 */
    @PutMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody RequestMember member) {

        MemberDTO memberDTO = modelMapper.map(member, MemberDTO.class);

        memberService.withdraw(memberDTO);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/health_check")
    public String healthCheck() {
        return "Good";
    }
}
