package com.revature.pms.dao;

import com.revature.pms.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    public Optional<User> findByEmailAndPassword(String email, String userPassword);
    public boolean existsByEmail(String userEmail);

}
