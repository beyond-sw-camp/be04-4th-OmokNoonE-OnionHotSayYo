package org.omoknoone.star.controller;

import org.modelmapper.ModelMapper;
import org.omoknoone.star.dto.MyStarPostListDTO;
import org.omoknoone.star.dto.StarDTO;
import org.omoknoone.star.service.StarService;
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
	public ResponseEntity<List<MyStarPostListDTO>> viewPostListByStar(@PathVariable String memberId) {
		List<MyStarPostListDTO> myStarredPosts = starService.findLikedPostsByMemberId(memberId);
		if (myStarredPosts.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(myStarredPosts);
	}
}
