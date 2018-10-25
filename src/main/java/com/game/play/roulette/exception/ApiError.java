package com.game.play.roulette.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * ApiError.java - This class is used to hold values on error response.
 * 

 * @since 23 Sep 2018
 */
class ApiError {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    ApiError(HttpStatus status, String message, Throwable ex) {
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
        timestamp = LocalDateTime.now();
    }

    ApiError(HttpStatus status, String message, String exceptionMessage) {
        this.status = status;
        this.message = message;
        this.debugMessage = exceptionMessage;
        timestamp = LocalDateTime.now();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

}
