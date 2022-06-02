package com.revature.pms.utilities;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class CheckEmail {

    public boolean checkEmail(String email) {
        String regexPattern = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        return Pattern.compile(regexPattern).matcher(email).matches();
    }
}
