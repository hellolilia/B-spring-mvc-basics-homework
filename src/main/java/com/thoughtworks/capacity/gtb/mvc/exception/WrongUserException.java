package com.thoughtworks.capacity.gtb.mvc.exception;

public class WrongUserException extends RuntimeException {

    public WrongUserException(String message) {
        super(message);
    }
}
