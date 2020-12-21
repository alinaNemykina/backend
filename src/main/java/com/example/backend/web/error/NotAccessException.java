package com.example.backend.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class NotAccessException extends RuntimeException{

    public NotAccessException(String resourceName) {
        super(resourceName);
    }
}
