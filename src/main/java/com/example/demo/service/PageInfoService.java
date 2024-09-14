package com.example.demo.service;

import com.example.demo.util.RequestInfoHolder;
import com.example.demo.util.SessionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
public class PageInfoService {
    // Log4j Logger
    private final Logger logger = LogManager.getLogger(PageInfoService.class);

    @Async
    public void sendPageInfoToServer(RequestInfoHolder.RequestInfo requestInfo) {

        // 서버로 수집된 정보를 전송하는 로직 (간단하게 출력으로 대체)
        logger.info("----------------- Page Info start -------------------");
        logger.info("Request ID: " + requestInfo.getRequestId());
        logger.info("Thread Name: " + requestInfo.getThreadName());
        logger.info("Request Time: " + requestInfo.getRequestTime());
        logger.info("user ID: " + requestInfo.getUserId());
        logger.info("Response Status: " + requestInfo.getResponseStatus());
        logger.info("Request URI: " + requestInfo.getRequestURI());


/*        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        logger.info("----------------- Page Info end -------------------");

        // 실제로 HTTP API 호출하는 로직이 들어갈 수 있음
    }
}
