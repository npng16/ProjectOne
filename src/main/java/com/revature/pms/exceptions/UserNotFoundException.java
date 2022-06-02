package com.revature.pms.exceptions;

import org.omg.CORBA.UserException;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {

    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
