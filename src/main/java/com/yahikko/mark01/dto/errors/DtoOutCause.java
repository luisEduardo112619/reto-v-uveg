package com.yahikko.mark01.dto.errors;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class DtoOutCause {

    private int status;
    private String description;
    private String message;
    private LocalDateTime date;


    public DtoOutCause (HttpStatus status, String message){
        this.status = status.value();
        this.description = status.getReasonPhrase();
        this.date = LocalDateTime.now();
        this.message = message;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
