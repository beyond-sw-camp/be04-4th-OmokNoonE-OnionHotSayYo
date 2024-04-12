package org.omoknoone.onionhotsayyo.letter.command.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.omoknoone.onionhotsayyo.letter.command.dto.LetterDTO;
import org.omoknoone.onionhotsayyo.letter.command.service.LetterService;
import org.omoknoone.onionhotsayyo.notification.command.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/letters")
public class LetterController {
	private final LetterService letterService;
	private final NotificationService notificationService;
	private final ModelMapper modelMapper;

	@Autowired
	public LetterController(LetterService letterService, NotificationService notificationService,
		ModelMapper modelMapper) {
		this.letterService = letterService;
		this.notificationService = notificationService;
		this.modelMapper = modelMapper;
	}

	// 쪽지 발송
	@PostMapping("/send")
	public ResponseEntity<LetterDTO> sendLetter(@RequestBody LetterDTO letterDTO) {
		LetterDTO sendLetter = letterService.sendLetter(letterDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(sendLetter);
	}

	// 쪽지 수신 확인
	@PutMapping("/check/{letterId}")
	public ResponseEntity<LetterDTO> checkLetter(@PathVariable(name = "letterId") int letterId) {
		LetterDTO readLetter = letterService.checkLetter(letterId);
		return ResponseEntity.status(HttpStatus.OK).body(readLetter);
	}


	// // 송수신 쪽지 모두 확인
	// @GetMapping("/list/myletter/{memberId}")
	// public ResponseEntity<List<LetterDTO>> viewLetterByMe(@PathVariable(name = "memberId") String memberId) {
	// 	List<LetterDTO> letterList = letterService.viewLetterByMe(memberId);
	// 	return ResponseEntity.status(HttpStatus.OK).body(letterList);
	// }

	// 내가 보낸 쪽지
	@GetMapping("/mysendletter/{memberId}")
	public ResponseEntity<List<LetterDTO>> viewSendLetter(@PathVariable(name = "memberId") String memberId) {
		List<LetterDTO> sendLetterList = letterService.viewSendLetter(memberId);
		return ResponseEntity.status(HttpStatus.OK).body(sendLetterList);
	}

	// 내가 받은 쪽지
	@GetMapping("/myreceiveletter/{memberId}")
	public ResponseEntity<List<LetterDTO>> viewReceiveLetter(@PathVariable(name = "memberId") String memberId) {
		List<LetterDTO> receiveLetter = letterService.viewReceiveLetter(memberId);
		return ResponseEntity.status(HttpStatus.OK).body(receiveLetter);
	}

	// 안 읽은 상태의 쪽지 조회
	@GetMapping("/unreadletter/{memberId}")
	public ResponseEntity<List<LetterDTO>> viewUnreadLetter(@PathVariable(name = "memberId") String memberId) {
		List<LetterDTO> unreadletter = letterService.viewUnreadLetter(memberId);
		return ResponseEntity.status(HttpStatus.OK).body(unreadletter);
	}




	@GetMapping("/health_check")
	public String healthCheck() {
		return "Good";
	}
}
