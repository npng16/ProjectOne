package com.revature.pms.services;

import com.revature.pms.dao.ItemDAO;
import com.revature.pms.exceptions.UserNotFoundException;
import com.revature.pms.model.User;
import com.revature.pms.dao.UserDAO;
import com.revature.pms.utilities.CheckEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    UserDAO userDAO;

    @Autowired
    CheckEmail checkEmail;

    @Autowired
    private HttpServletRequest request;
    @Override
    public boolean registerUser(User user) {
        System.out.println("Registering user in database...");
        if(checkEmail.checkEmail(user.getEmail())) {
            userDAO.save(user);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean deleteUser(int userId) {
        userDAO.deleteById(userId);
        return true;
    }

    @Override
    public boolean updateUser(User user, int id) {
        User oUser = userDAO.getReferenceById(id);
        if(isUserExists(oUser.getUserId())) {
//            oUser.setEmail(user.getEmail());
            oUser.setName(user.getName());
            oUser.setCart(user.getCart());
//            oUser.setOrders(user.getOrders());
            userDAO.save(oUser);
           return true;
        }
        else {
            System.out.println("Cannot update user because user does not exist");
            return false;
        }
    }

    @Override
    public User getUser(int userId) {
        User user = userDAO.getById(userId);
        return user;
    }


    @Override
    public User login(String userEmail, String userPassword) {
        User exists = userDAO.findByEmailAndPassword(userEmail, userPassword)
                .orElseThrow(() -> new UserNotFoundException(String.format("No User with email: ", userEmail)));
        HttpSession session = request.getSession();
        session.setAttribute("currentUser", exists);

        return exists;
    }

    @Override
    public void logout() {
        HttpSession session = request.getSession(false);
        if(session == null) {
            //nobody is logged on
            return;
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
