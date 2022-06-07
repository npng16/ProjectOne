package com.revature.pms.exceptions;

public class NotLoggedInException extends RuntimeException{
    public NotLoggedInException() {

    }

    public NotLoggedInException(String message) {
        super(message);
    }
}
