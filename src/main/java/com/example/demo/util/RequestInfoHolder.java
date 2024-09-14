package com.example.demo.util;

import java.time.LocalDateTime;

public class RequestInfoHolder {

    private static final ThreadLocal<RequestInfo> requestInfoThreadLocal = new ThreadLocal<>();

    public static void setRequestInfo(RequestInfo requestInfo) {
        requestInfoThreadLocal.set(requestInfo);
    }

    public static RequestInfo getRequestInfo() {
        return requestInfoThreadLocal.get();
    }

    public static void clear() {
        requestInfoThreadLocal.remove();
    }

    public static class RequestInfo {
        private String requestId;
        private String threadName;
        private LocalDateTime requestTime;
        private String responseStatus;
        private String userId;
        private String requestURI;

        // Constructor, getters, and setters
        public RequestInfo(String requestId, String threadName, LocalDateTime requestTime, String responseStatus, String userId,String requestURI) {
            this.requestId = requestId;
            this.threadName = threadName;
            this.requestTime = requestTime;
            this.responseStatus = responseStatus;
            this.userId = userId;
            this.requestURI = requestURI;
        }

        // Getters and Setters
        public String getRequestId() {
            return requestId;
        }

        public void setRequest(String request) {
            this.requestId = request;
        }

        public String getThreadName() {
            return threadName;
        }

        public void setThreadName(String threadName) {
            this.threadName = threadName;
        }

        public LocalDateTime getRequestTime() {
            return requestTime;
        }

        public void setRequestTime(LocalDateTime requestTime) {
            this.requestTime = requestTime;
        }

        public String getResponseStatus() {
            return responseStatus;
        }

        public void setResponseStatus(String responseStatus) {
            this.responseStatus = responseStatus;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }


        public String getRequestURI() {
            return requestURI;
        }

        public void setRequestURI(String requestURI) {
            this.requestURI = requestURI;
        }
    }
}
