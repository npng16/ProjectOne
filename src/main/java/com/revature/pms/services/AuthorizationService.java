package com.revature.pms.services;

import com.revature.pms.exceptions.NotAuthorizedException;
import com.revature.pms.exceptions.NotLoggedInException;
import com.revature.pms.model.Role;
import com.revature.pms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class AuthorizationService {
    @Autowired
    private HttpServletRequest request;

    public void guardByUserId(int userId) {
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("currentUser") == null) {
            throw new NotLoggedInException("You must be logged in to perform this action.");
        }

        User currentUser = (User) session.getAttribute("currentUser");

        if(userId != currentUser.getUserId()) {
            if(currentUser.getRole() != Role.ADMIN) {
                throw new NotAuthorizedException("You are not authorized to perform this action on this resource.");
            }
        }
    }
}
