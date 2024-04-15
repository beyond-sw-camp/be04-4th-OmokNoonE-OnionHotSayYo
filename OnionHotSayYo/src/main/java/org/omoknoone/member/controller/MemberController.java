package org.omoknoone.member.controller;

import org.modelmapper.ModelMapper;
import org.omoknoone.member.dto.MemberDTO;
import org.omoknoone.member.service.MemberService;
import org.omoknoone.member.vo.RequestMember;
import org.omoknoone.member.vo.ResponseMember;
import org.omoknoone.responseEntity.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;


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
    public ResponseEntity<ResponseMessage> modify(@RequestBody RequestMember member) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        MemberDTO memberDTO = modelMapper.map(member, MemberDTO.class);

        ResponseMember responseMember = modelMapper.map(memberService.modify(memberDTO), ResponseMember.class);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("result", responseMember);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "회원가입 성공", responseMap));
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
