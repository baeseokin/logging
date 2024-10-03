package com.example.demo.service;

public class CustomException extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;

    public CustomException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}

