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
        private String pageId;
        private String serviceId;

        // Constructor, getters, and setters
        public RequestInfo(String requestId, String threadName, LocalDateTime requestTime, String responseStatus, String userId,String requestURI, String pageId, String serviceId) {
            this.requestId = requestId;
            this.threadName = threadName;
            this.requestTime = requestTime;
            this.responseStatus = responseStatus;
            this.userId = userId;
            this.requestURI = requestURI;
            this.pageId = pageId;
            this.serviceId = serviceId;
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

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }


        public String getPageId() {
            return pageId;
        }

        public void setPageId(String pageId) {
            this.pageId = pageId;
        }

        public String toJsonString(){
            String s = "{"
                    +"\"RequestID\":\"" + this.getRequestId()+ "\","
                    +"\"ThreadName\":\"" + this.getThreadName()+ "\","
                    +"\"RequestTime\":\"" + this.getRequestTime()+ "\","
                    +"\"userID\":\"" + this.getUserId()+ "\","
                    +"\"ResponseStatus\":\"" + this.getResponseStatus()+ "\","
                    +"\"RequestURI\":\"" + this.getRequestURI()+ "\","
                    +"\"PageId\":\"" + this.getPageId()+ "\","
                    +"\"ServiceId\":\"" + this.getServiceId()
                    +"\"}";
            return s;
        }
    }
}
