package com.revature.pms.services;

import com.revature.pms.dao.CartDAO;
import com.revature.pms.model.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class CartServiceImpl implements CartService{
    @Autowired
    CartDAO  cartDAO;

    @Override
    public void addItemToCart(Item item) {
//        cartDAO.save(item);

    }

    @Override
    public void addItemToOrders(Item item) {

    }

    @Override
    public ArrayList<Item> getItems() {
        return null;
    }
}
