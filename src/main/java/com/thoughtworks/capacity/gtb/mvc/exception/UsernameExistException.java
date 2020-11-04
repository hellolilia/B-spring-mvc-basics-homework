package com.thoughtworks.capacity.gtb.mvc.exception;

public class UsernameExistException extends RuntimeException {

    public UsernameExistException(String message) {
        super(message);
    }

}
