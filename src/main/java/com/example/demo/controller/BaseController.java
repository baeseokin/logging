package com.example.demo.controller;

import com.example.demo.service.CustomException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public abstract class BaseController {

    private final Logger logger = LogManager.getLogger(BaseController.class);

    @Autowired
    private HttpServletRequest request;

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {

        String userId ="";
        HttpSession session = request.getSession(false);
        if(session!=null){
            Object useIdo = session.getAttribute("userId");
            if(useIdo!=null){
                userId = (String)useIdo;
            }
        }else{
            userId = (String)request.getParameter("userId");
        }

        String requestURI = request.getRequestURI();
        String pageId = "";
        if(request.getParameter("pageId")!=null){
            pageId = (String)request.getParameter("pageId");
        }
        String serviceId = "";
        if(request.getParameter("serviceId")!=null){
            serviceId = (String)request.getParameter("serviceId");
        }

        // 에러 코드, 메시지, 스택 트레이스를 로그로 출력
        logger.error("-->");
        logger.error("Error Code: {}", ex.getErrorCode());
        logger.error("Error Message: {}", ex.getMessage());
        logger.error("UserId: {}", userId);
        logger.error("PageId: {}", pageId);
        logger.error("ServiceId: {}", serviceId);
        logger.error("RequestURI: {}", requestURI);
        logger.error("Stack Trace: ", ex);
        logger.error("<--");

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