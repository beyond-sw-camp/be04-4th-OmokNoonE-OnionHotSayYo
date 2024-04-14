package org.omoknoone.onionhotsayyo.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<String> handlePostNotFoundException(PostNotFoundException ex) {
        logger.error("게시물을 찾을 수 없음: {}", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND).body("요청하신 게시물을 찾을 수 없네요(ㅇㅅㅇ).");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        logger.error("에러 발생: {}", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR).body("저런ㅋ 서버 내부에서 예상치 못한 에러가 발생했네요(ㅠ.ㅠ).");
    }
}
