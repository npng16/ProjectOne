package com.revature.pms.services;

import com.revature.pms.exceptions.NotLoggedInException;
import com.revature.pms.exceptions.UnsuccessfulLogInException;
import com.revature.pms.exceptions.UserNotFoundException;
import com.revature.pms.model.User;
import com.revature.pms.dao.UserDAO;
import com.revature.pms.utilities.CheckEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServicesImpl implements UserServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServicesImpl.class);
    @Autowired
    UserDAO userDAO;

    @Autowired
    CheckEmail checkEmail;

    @Autowired
    private HttpServletRequest request;
    @Override
    public boolean registerUser(User user) {
        LOGGER.info("Attempting to register user in database...");
        if(userDAO.existsByEmail(user.getEmail())){
            LOGGER.warn("User already exists");
        }
        if(!checkEmail.checkEmail(user.getEmail())) {    //check if email is not valid
            LOGGER.warn("Failed to save user in database because invalid email");
            return false;
        }
        else {
            userDAO.save(user);
            return true;
        }
    }


    @Override
    public boolean deleteUser(int userId) {
        if(userDAO.existsById(userId)) {
            userDAO.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user, int id) {
        User oUser = userDAO.getReferenceById(id);
        if(isUserExists(oUser.getUserId())) {
            oUser.setName(user.getName());
            oUser.setCart(user.getCart());
            userDAO.save(oUser);

            HttpSession session = request.getSession(false);    //must be logged in already
            User sessionUser = (User) session.getAttribute("currentUser");

            //If the user is updating themselves, we must update the information in the session
            if(sessionUser.getUserId() == user.getUserId()) {
                session.setAttribute("currentUser", user);
            }

           return true;
        }
        else {
            System.out.println("Cannot update user because user does not exist");
            return false;
        }


    }

    @Override
    public User findById(int userId) {
        return userDAO.findById(userId).orElseThrow(() -> new UserNotFoundException("No user with id = " + userId));
    }

    @Override
    public User getUser(int userId) {
        User user = userDAO.getById(userId);
        return user;
    }


    @Override
    public User login(String userEmail, String userPassword) {
        User exists = userDAO.findByEmailAndPassword(userEmail, userPassword)
                .orElseThrow(() -> new UnsuccessfulLogInException(String.format("Log in credentials are not valid..")));
        HttpSession session = request.getSession();
        session.setAttribute("currentUser", exists);

        return exists;
    }

    @Override
    public void logout() {
        HttpSession session = request.getSession(false);
        if(session == null) {
            //nobody is logged on
            throw new NotLoggedInException("You are not logged in..");
        }
        session.invalidate();
        System.out.println("You have been logged out successfully. ");
    }

    @Override
    public boolean isUserExists(int userId) {
        return userDAO.existsById(userId);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.findAll();
    }

}
