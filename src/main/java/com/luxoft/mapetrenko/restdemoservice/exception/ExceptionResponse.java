package com.luxoft.mapetrenko.restdemoservice.exception;

import java.util.Date;

public class ExceptionResponse {
    Date timestamp;
    String message;
    String description;

    public ExceptionResponse(Date timestamp, String message, String description) {
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
