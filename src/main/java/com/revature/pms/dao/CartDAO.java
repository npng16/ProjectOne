package com.revature.pms.dao;

import com.revature.pms.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer> {
//    public void insertToOrders();
}
