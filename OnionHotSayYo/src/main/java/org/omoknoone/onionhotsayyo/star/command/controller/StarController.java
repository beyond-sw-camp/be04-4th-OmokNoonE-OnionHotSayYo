package org.omoknoone.onionhotsayyo.star.command.controller;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.star.command.aggregate.Star;
import org.omoknoone.onionhotsayyo.star.command.dto.StarDTO;
import org.omoknoone.onionhotsayyo.star.command.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
