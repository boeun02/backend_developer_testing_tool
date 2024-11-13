package com.port_api.pa_test.api.dto;

public class ErrorResponseDto {
    private int statusCode;
    private String statusMessage;
    private String errorType;
    private String details;

    public ErrorResponseDto(int statusCode, String statusMessage, String errorType, String details) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.errorType = errorType;
        this.details = details;
    }

    // Getters and Setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}