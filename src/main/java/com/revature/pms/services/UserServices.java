package com.revature.pms.services;

import com.revature.pms.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServices {

    public boolean registerUser(User user);
    public boolean deleteUser(int userId);
    public boolean updateUser(User user);
    public User getUser(int userId);
    public boolean isUserExists(int userId);

    public List<User> getUsers();

    public User login(String userEmail, String userPassword);

    public void logout();
}
