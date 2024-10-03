package com.example.demo.service;

import com.example.demo.controller.ApiController;
import com.example.demo.util.RequestInfoHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class BizService {

    // Log4j Logger
    private final Logger logger = LogManager.getLogger(BizService.class);

    public void executeSuccess() throws CustomException{
        // 서버로 수집된 정보를 전송하는 로직 (간단하게 출력으로 대체)
        logger.info("######################### start executeSuccess #############################");
        logger.info("######################### end executeSuccess #############################");
    }

    public void executeError() throws CustomException{
        // 서버로 수집된 정보를 전송하는 로직 (간단하게 출력으로 대체)
        logger.info("######################### start executeError #############################");
        //호출후 로그 전송
        //pageInfoService.sendPageInfoToServer(requestInfo);
        //Exception 발생
        throw new CustomException("ERR001","예외 테스트 입니다.");
    }
}
