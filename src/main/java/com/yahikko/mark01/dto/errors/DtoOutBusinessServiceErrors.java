package com.yahikko.mark01.dto.errors;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class DtoOutBusinessServiceErrors {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String detail;
    private String path;

    public DtoOutBusinessServiceErrors(HttpStatus status, String message, String detail, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = message;
        this.detail = detail;
        this.path = path;
    }
}
