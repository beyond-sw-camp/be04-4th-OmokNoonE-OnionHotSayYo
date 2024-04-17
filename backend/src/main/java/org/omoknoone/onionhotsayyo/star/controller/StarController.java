package org.omoknoone.onionhotsayyo.star.controller;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.star.dto.MyStarPostListDTO;
import org.omoknoone.onionhotsayyo.star.dto.StarDTO;
import org.omoknoone.onionhotsayyo.star.service.StarService;
import org.omoknoone.onionhotsayyo.star.vo.ResponseMyStarPostList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stars")
public class StarController {
	private final StarService starService;
	private final ModelMapper modelMapper;

	@Autowired
	public StarController(StarService starService, ModelMapper modelMapper) {
		this.starService = starService;
		this.modelMapper = modelMapper;
	}

	// 좋아요 추가
	@PostMapping("/create")
	public void addStar(@RequestBody StarDTO starDTO) {
		starService.addStar(starDTO);
		// Star responseStar = modelMapper.map(starDTO, Star.class);
		// return ResponseEntity.status(HttpStatus.CREATED).body(responseStar);
	}

	// 좋아요 취소
	@DeleteMapping("/remove")
	public void removeStar (@RequestBody StarDTO starDTO) {
		starService.removeStar(starDTO);
	}

	@GetMapping("/list/mystar/{memberId}")
	public ResponseEntity<ResponseMyStarPostList> viewPostListByStar(@PathVariable String memberId) {

		List<MyStarPostListDTO> myStarredPosts = starService.findLikedPostsByMemberId(memberId);
		if (myStarredPosts.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		ResponseMyStarPostList myStarredList = new ResponseMyStarPostList(myStarredPosts);

		return ResponseEntity.ok(myStarredList);
	}
}
