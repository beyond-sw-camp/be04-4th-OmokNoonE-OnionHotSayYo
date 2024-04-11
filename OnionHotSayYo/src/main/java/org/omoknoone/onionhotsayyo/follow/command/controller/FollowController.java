package org.omoknoone.onionhotsayyo.follow.command.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.follow.command.aggregate.Follow;
import org.omoknoone.onionhotsayyo.follow.command.dto.FollowDTO;
import org.omoknoone.onionhotsayyo.follow.command.service.FollowService;
import org.omoknoone.onionhotsayyo.member.dto.MemberDTO;
import org.omoknoone.onionhotsayyo.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/follows")
public class FollowController {

	private FollowService followService;
	private ModelMapper modelMapper;
	private MemberService memberService;

	public FollowController(FollowService followService, ModelMapper modelMapper, MemberService memberService) {
		this.followService = followService;
		this.modelMapper = modelMapper;
		this.memberService = memberService;
	}

	// 팔로우
	@PostMapping("/follow")
	public ResponseEntity<Follow> followMember (@RequestBody FollowDTO newFollow) {

		System.out.println(newFollow);
		followService.followMember(newFollow);

		Follow responseFollow = modelMapper.map(newFollow, Follow.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(responseFollow);
	}

	// 언팔로우
	@DeleteMapping("/unfollow/{fromMemberId}/{toMemberId}")
	public void unfollowMember(@PathVariable(name = "fromMemberId") String fromMemberId,
								@PathVariable(name = "toMemberId") String toMemberId) {
		followService.unfollowMember(fromMemberId, toMemberId);
	}

	// // 내가 팔로우 한 목록 조회
	// @GetMapping("list/myfollow/{memberId}")
	// public ResponseEntity<List<MemberDTO>> viewFollowListByMe (@PathVariable(name = "memberId") String memberId) {
	// 	List<FollowDTO> followingDTOList = followService.selectAllFollowing(memberId);
	//
	// 	/* memberId로 user 정보 모두 조회 하는 메소드 생성 요망 */
	// 	List<MemberDTO> memberDTOList = memberService.selectAllByMemberId(followingDTOList);
	//
	// 	return ResponseEntity.status(HttpStatus.OK).body(memberDTOList);
	// }
	//
	// // 나를 팔로우 한 목록 조회
	// @GetMapping("/list/myfollowers/{memberId}")
	// public ResponseEntity<List<MemberDTO>> viewMyFollowerList (@PathVariable(name = "memberId") String memberId) {
	// 	List<FollowDTO> followerDTOList = followService.selectAllFollower(memberId);
	// 	List<MemberDTO> memberDTOList = memberService.selectAllByMemberId(followerDTOList);
	//
	// 	return ResponseEntity.status(HttpStatus.OK).body(memberDTOList);
	// }



}

