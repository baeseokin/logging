package com.example.demo.controller;

import com.example.demo.interceptor.LoggingInterceptor;
import com.example.demo.service.BizService;
import com.example.demo.service.PageInfoService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController extends BaseController{

    @Autowired
    private BizService bizService;

    @Autowired
    private LoggingInterceptor loggingInterceptor;

    @Autowired
    private PageInfoService pageInfoService;

    // Log4j Logger
    private final Logger logger = LogManager.getLogger(ApiController.class);

    @GetMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request) {

        if(request!=null){
            if(!"".equals(request.getParameter("userId"))){
                String userId = (String)request.getParameter("userId");
                //사용자의 정보를 가져와서 Session에 넣는다.
                request.getSession(true).setAttribute("userId", userId);
            }else{
                System.out.println("userId not exists !!!");
            }
        }

        // Response
        return ResponseEntity.ok("login successfully.");
    }


    @GetMapping("/bizserviceSuccess")
    public ResponseEntity<String> bizserviceSuccess(HttpServletRequest request) {
        //비즈니스로직 수행
        bizService.executeSuccess();
        // Response
        return ResponseEntity.ok("executeSuccess successfully.");
    }
    @GetMapping("/bizserviceError")
    public ResponseEntity<String> bizserviceError(HttpServletRequest request) {
        //비즈니스로직 수행
        bizService.executeError();
        // Response
        return ResponseEntity.ok("bizserviceError successfully.");
    }


    @GetMapping("favicon.ico")
    @ResponseBody
    public void returnNoFavicon() {
    }
}
