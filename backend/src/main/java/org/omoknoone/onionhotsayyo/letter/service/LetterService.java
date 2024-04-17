package org.omoknoone.onionhotsayyo.letter.service;

import java.util.List;

import org.omoknoone.onionhotsayyo.letter.dto.LetterDTO;

public interface LetterService {
	LetterDTO sendLetter(LetterDTO letterDTO);

	LetterDTO checkLetter(int letterId);

	List<LetterDTO> viewSendLetter(String memberId);

	List<LetterDTO> viewReceiveLetter(String memberId);

	List<LetterDTO> viewUnreadLetter(String memberId);
}
