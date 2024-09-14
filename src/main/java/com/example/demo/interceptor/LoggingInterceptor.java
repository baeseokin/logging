package com.example.demo.interceptor;

import com.example.demo.service.PageInfoService;
import com.example.demo.util.RequestInfoHolder;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private static final ThreadLocal<String> uuidHolder = new ThreadLocal<>();

    @Autowired
    private PageInfoService pageInfoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uuid = UUID.randomUUID().toString();
        uuidHolder.set(uuid);
        return true; // true이면 계속 진행
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        // 세션 ID, 현재 스레드 정보, 호출 시간 및 응답 상태 수집
        String requestId = uuidHolder.get();
        String threadName = Thread.currentThread().getName();
        LocalDateTime requestTime = LocalDateTime.now();
        //String userId = userIdHolder.get();
        String userId ="";
        HttpSession session = request.getSession(false);
        if(session!=null){
            Object useIdo = session.getAttribute("userId");
            if(useIdo!=null){
                userId = (String)useIdo;
            }
        }
        String requestURI = request.getRequestURI();
        String responseStatus = String.valueOf(response.getStatus());
        RequestInfoHolder.RequestInfo requestInfo = new RequestInfoHolder.RequestInfo(requestId, threadName, requestTime, responseStatus, userId, requestURI);
        RequestInfoHolder.setRequestInfo(requestInfo);
        // 호출전 로그 전송
        pageInfoService.sendPageInfoToServer(requestInfo);
        // 요청이 끝나면 ThreadLocal에서 UUID 제거
        uuidHolder.remove();

    }

    public static String getUUID() {
        return uuidHolder.get();
    }
}