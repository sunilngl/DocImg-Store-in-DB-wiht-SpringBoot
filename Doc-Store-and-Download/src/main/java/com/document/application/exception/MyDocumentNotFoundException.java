package com.document.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Author : Sunil Ngl 
 * */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyDocumentNotFoundException extends RuntimeException {
    public MyDocumentNotFoundException(String message) {
        super(message);
    }

    public MyDocumentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
