package com.sanjay.flightmanagement.dto;

import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime timeStamp;

    private int status;

    private String error;

    private String message;

    public ErrorResponse(
            LocalDateTime timeStamp,
            int status,
            String error,
            String message
    ) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
