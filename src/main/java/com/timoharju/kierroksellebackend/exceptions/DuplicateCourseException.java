package com.timoharju.kierroksellebackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateCourseException extends RuntimeException{

    public DuplicateCourseException() {
        super();
    }

    public DuplicateCourseException(String message) {
        super(message);
    }

    public DuplicateCourseException(String message, Throwable cause) {
        super(message, cause);
    }

}
