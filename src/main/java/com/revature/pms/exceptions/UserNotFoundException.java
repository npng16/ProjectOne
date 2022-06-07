package com.revature.pms.exceptions;

import com.revature.pms.model.User;

import javax.jws.soap.SOAPBinding;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {

    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
