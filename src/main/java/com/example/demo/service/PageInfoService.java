package com.example.demo.service;

import com.example.demo.util.RequestInfoHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PageInfoService {
    // Log4j Logger
    private final Logger logger = LogManager.getLogger(PageInfoService.class);

    @Autowired
    private ApiService apiService;

    @Async
    public void sendPageInfoToLogstash(RequestInfoHolder.RequestInfo requestInfo){
        // 서버로 수집된 정보를 전송하는 로직 (간단하게 출력으로 대체)
        String s = requestInfo.toJsonString();
        System.out.println(s);
        Mono<String> response = apiService.sendJsonToExternalApi(s);
        response.subscribe(result -> System.out.println("send to logstash directly :" + result));
    }



    @Async
    public void sendPageInfoToFileBeat(RequestInfoHolder.RequestInfo requestInfo) {
        String s = requestInfo.toJsonString();
        System.out.println("send to filebeat :" + s);
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(s);
            JSONObject jobj = (JSONObject) obj;
            //logger.info(jobj);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
