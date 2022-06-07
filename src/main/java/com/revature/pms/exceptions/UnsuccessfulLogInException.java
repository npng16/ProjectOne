package com.revature.pms.exceptions;

public class UnsuccessfulLogInException extends RuntimeException{
    public UnsuccessfulLogInException() {

    }

    public UnsuccessfulLogInException(String message) {
        super(message);
    }

}
