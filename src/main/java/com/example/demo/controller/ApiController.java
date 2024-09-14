package com.example.demo.controller;

import com.example.demo.interceptor.LoggingInterceptor;
import com.example.demo.service.BizService;
import com.example.demo.service.PageInfoService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private BizService bizService;

    @Autowired
    private LoggingInterceptor loggingInterceptor;

    @Autowired
    private PageInfoService pageInfoService;

    // Log4j Logger
    private final Logger logger = LogManager.getLogger(ApiController.class);

    @PostMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request, @RequestBody String data) {

        //logger.info("data :"+ data);
        JSONParser parser = new JSONParser(data);
        try {
            Object obj = parser.parse();
            String userId = (String) ((HashMap<String, String>)obj).get("userId");
            System.out.println("userId :"+ userId);
            //사용자의 정보를 가져와서 Session에 넣는다.
            request.getSession(true).setAttribute("userId", userId);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // Response
        return ResponseEntity.ok("login successfully.");
    }


    @GetMapping("/collect")
    public ResponseEntity<String> collectPageInfo(HttpServletRequest request) {

        /*// 세션 ID, 현재 스레드 정보, 호출 시간 및 응답 상태 수집
        System.out.println("--------------------start logging -------------------------");
        String requestId = uuidInterceptor.getUUID();
        String threadName = Thread.currentThread().getName();
        LocalDateTime requestTime = LocalDateTime.now();
        String userId = (String)SessionUtil.getSession().getAttribute("userId");
        String responseStatus = "OK";*/

        //비즈니스로직 수행
        bizService.execute();

//        RequestInfoHolder.RequestInfo requestInfo = new RequestInfoHolder.RequestInfo(requestId, threadName, requestTime, responseStatus, userId);
//        RequestInfoHolder.setRequestInfo(requestInfo);
//        //호출전 로그 전송
//        pageInfoService.sendPageInfoToServer(requestInfo);

        // Response
        return ResponseEntity.ok("bizService successfully.");
    }
}
