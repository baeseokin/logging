package com.example.demo.controller;

import com.example.demo.service.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public abstract class BaseController {

    private final Logger logger = LogManager.getLogger(BaseController.class);

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        // 에러 코드, 메시지, 스택 트레이스를 로그로 출력
        logger.error("--> Error Start");
        logger.error("Error Code: {}", ex.getErrorCode());
        logger.error("Error Message: {}", ex.getMessage());
        logger.error("Stack Trace: ", ex);
        logger.error("--> Error End");

        // 클라이언트에 보낼 응답
        return new ResponseEntity<>(ex.getErrorCode() + ": " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // 다른 일반적인 예외 처리를 할 수 있는 핸들러를 추가할 수 있음
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        logger.error("An unexpected error occurred: ", ex);
        return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}