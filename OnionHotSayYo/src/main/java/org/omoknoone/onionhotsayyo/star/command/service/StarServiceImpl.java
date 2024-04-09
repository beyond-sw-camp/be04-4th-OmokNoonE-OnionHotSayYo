package org.omoknoone.onionhotsayyo.star.command.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.star.command.aggregate.Star;
import org.omoknoone.onionhotsayyo.star.command.dto.StarDTO;
import org.omoknoone.onionhotsayyo.star.command.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StarServiceImpl implements StarService{

	private final StarRepository starRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public StarServiceImpl(StarRepository starRepository, ModelMapper modelMapper) {
		this.starRepository = starRepository;
		this.modelMapper = modelMapper;
	}

	// 좋아요(또는 싫어요) 추가
	@Transactional
	@Override
	public void addStar(StarDTO starDTO) {
		Star star = modelMapper.map(starDTO, Star.class);
		starRepository.save(star);
	}

	// 좋아요(또는 싫어요) 삭제
	@Transactional
	@Override
	public void removeStar(StarDTO starDTO) {
		Star star = modelMapper.map(starDTO, Star.class);
		starRepository.delete(star);
	}

}
