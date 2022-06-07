package com.revature.pms.advice;

import javax.servlet.http.HttpSession;

import com.revature.pms.annotations.Authorized;
import com.revature.pms.exceptions.NotAuthorizedException;
import com.revature.pms.exceptions.NotLoggedInException;
import com.revature.pms.model.Role;
import com.revature.pms.model.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class AuthAspect {

    @Autowired
    private HttpServletRequest request;

    @Around("@annotation(authorized)")
    public Object authenticate(ProceedingJoinPoint pjp, Authorized authorized) throws Throwable {
        HttpSession session = request.getSession(false);    //get session associated w/ THIS request

        if (session == null || session.getAttribute("currentUser") == null){
            throw new NotLoggedInException("You must be logged in to perform this action");
        }

        User currentUser = (User) session.getAttribute("currentUser");
        Role currentRole = currentUser.getRole();
        List<Role> allowedRoles = Arrays.asList(authorized.allowedRoles());

        if (!allowedRoles.contains(currentRole)) {
            throw new NotAuthorizedException("You are not authorized to perform this action.");
        }
        //user logged in an authorized
        return pjp.proceed(pjp.getArgs());
    }

}
