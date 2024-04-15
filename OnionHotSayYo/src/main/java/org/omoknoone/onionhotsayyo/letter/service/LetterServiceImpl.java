package org.omoknoone.onionhotsayyo.letter.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.letter.aggregate.Letter;
import org.omoknoone.onionhotsayyo.letter.dto.LetterDTO;
import org.omoknoone.onionhotsayyo.letter.repository.LetterRepository;
import org.omoknoone.onionhotsayyo.member.dto.MemberDTO;
import org.omoknoone.onionhotsayyo.member.service.MemberService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LetterServiceImpl implements LetterService {
	private final LetterRepository letterRepository;
	private final MemberService memberService;
	private final ModelMapper modelMapper;

	public LetterServiceImpl(LetterRepository letterRepository, MemberService memberService, ModelMapper modelMapper) {
		this.letterRepository = letterRepository;
		this.memberService = memberService;
		this.modelMapper = modelMapper;
	}

	@Override
	public LetterDTO sendLetter(LetterDTO letterDTO) {

		Letter sendLetter = modelMapper.map(letterDTO, Letter.class);
		letterRepository.save(sendLetter);

		return modelMapper.map(sendLetter, LetterDTO.class);

	}

	@Override
	public LetterDTO checkLetter(int letterId) {
		Letter checkLetter = letterRepository.findById(letterId)
			.orElseThrow(() -> new IllegalArgumentException("쪽지를 찾을 수 없습니다."));

		checkLetter.setChecked(true);
		letterRepository.save(checkLetter);

		return modelMapper.map(checkLetter, LetterDTO.class);
	}


	@Override
	public List<LetterDTO> viewSendLetter(String memberId) {
		MemberDTO sender = memberService.getMemberDetailsByMemberId(memberId);
		if(sender == null) {
			throw new UsernameNotFoundException("맴버 ID " + memberId + " 를 찾을 수 없습니다.");
		}

		List<Letter> letters = letterRepository.findBySendId(memberId);
		return letters.stream()
			.map(letter -> modelMapper.map(letter, LetterDTO.class))
			.collect(Collectors.toList());
	}

	@Override
	public List<LetterDTO> viewReceiveLetter(String memberId) {

		/* 여기서부터 */
		MemberDTO receiver = memberService.getMemberDetailsByMemberId(memberId);
		if(receiver == null) {
			throw new UsernameNotFoundException("맴버 ID " + memberId + " 를 찾을 수 없습니다.");
		}
		/* 여기까지 부분 추후에 메소드로 분리해서 사용하면 좋을 것 같아요 */

		List<Letter> letters = letterRepository.findByReceiveId(memberId);
		return letters.stream()
			.map(letter -> modelMapper.map(letter, LetterDTO.class))
			.collect(Collectors.toList());
	}

	@Override
	public List<LetterDTO> viewUnreadLetter(String memberId) {

		List<Letter> letters = letterRepository.findByReceiveIdAndIsChecked(memberId, false);
		return letters.stream()
			.map(letter -> modelMapper.map(letter, LetterDTO.class))
			.collect(Collectors.toList());
	}

	private LetterDTO entityToDto(Letter letter) {
		return modelMapper.map(letter, LetterDTO.class);
	}
}
