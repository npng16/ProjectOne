package com.revature.pms.exceptions;

public class NotAuthorizedException extends RuntimeException{
    public NotAuthorizedException() {

    }

    public NotAuthorizedException(String message) {
        super(message);
    }
}
