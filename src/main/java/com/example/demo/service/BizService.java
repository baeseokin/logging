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



    public void execute() {


        // 서버로 수집된 정보를 전송하는 로직 (간단하게 출력으로 대체)
        logger.info("######################### start biz #############################");

        //호출후 로그 전송
        //pageInfoService.sendPageInfoToServer(requestInfo);

        logger.info("######################### end biz #############################");


        // 실제로 HTTP API 호출하는 로직이 들어갈 수 있음
    }
}
