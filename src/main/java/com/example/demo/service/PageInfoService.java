package com.example.demo.service;

import com.example.demo.util.RequestInfoHolder;
import com.example.demo.util.SessionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpSession;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
public class PageInfoService {
    // Log4j Logger
    private final Logger logger = LogManager.getLogger(PageInfoService.class);

    @Autowired
    private ApiService apiService;

    @Async
    public void sendPageInfoToLogstash(RequestInfoHolder.RequestInfo requestInfo){
        // 서버로 수집된 정보를 전송하는 로직 (간단하게 출력으로 대체)
        String s = "{ " + "\"RequestID\":\"" + requestInfo.getRequestId()+ "\","
                +"\"ThreadName\":\"" + requestInfo.getThreadName()+ "\","
                +"\"RequestTime\":\"" + requestInfo.getRequestTime()+ "\","
                +"\"userID\":\"" + requestInfo.getUserId()+ "\","
                +"\"ResponseStatus\":\"" + requestInfo.getResponseStatus()+ "\","
                +"\"RequestURI\":\"" + requestInfo.getRequestURI()+ "\"}";

        System.out.println(s);
        Mono<String> response = apiService.sendJsonToExternalApi(s);
        response.subscribe(result -> System.out.println("send to logstash directly :" + result));

    }



    @Async
    public void sendPageInfoToFileBeat(RequestInfoHolder.RequestInfo requestInfo) {

        // 서버로 수집된 정보를 전송하는 로직 (간단하게 출력으로 대체)
        String s = "{ " + "\"RequestID\":\"" + requestInfo.getRequestId()+ "\","
                +"\"ThreadName\":\"" + requestInfo.getThreadName()+ "\","
                +"\"RequestTime\":\"" + requestInfo.getRequestTime()+ "\","
                +"\"userID\":\"" + requestInfo.getUserId()+ "\","
                +"\"ResponseStatus\":\"" + requestInfo.getResponseStatus()+ "\","
                +"\"RequestURI\":\"" + requestInfo.getRequestURI()+ "\"}";

        System.out.println("send to filebeat :" + s);
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(s);
            JSONObject jobj = (JSONObject) obj;
            logger.info(jobj);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

/*        logger.info("---Page Info start");
        logger.info("Request ID: " + requestInfo.getRequestId());
        logger.info("Thread Name: " + requestInfo.getThreadName());
        logger.info("Request Time: " + requestInfo.getRequestTime());
        logger.info("user ID: " + requestInfo.getUserId());
        logger.info("Response Status: " + requestInfo.getResponseStatus());
        logger.info("Request URI: " + requestInfo.getRequestURI());*/


/*        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        //logger.info("---Page Info end");

        // 실제로 HTTP API 호출하는 로직이 들어갈 수 있음
    }
}
