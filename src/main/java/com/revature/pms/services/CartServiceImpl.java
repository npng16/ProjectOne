package com.revature.pms.services;

import com.revature.pms.dao.CartDAO;
import com.revature.pms.dao.ItemDAO;
import com.revature.pms.dao.UserDAO;
import com.revature.pms.model.Cart;
import com.revature.pms.model.Item;
import com.revature.pms.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartServiceImpl implements CartService{
    @Autowired
    ItemDAO itemDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    CartDAO cartDAO;

    @Autowired
    ItemServices itemService;


    @Override
    public void findCartIdByUserId(int id) {
        if(userDAO.existsById(id)){
            Cart newCart = new Cart();
            newCart.setCartId(id);
            cartDAO.save(newCart);
        }
    }

    @Override
    public void addItemToCart(int itemId, int userId) {
        User oUser = userDAO.getReferenceById(userId);
        if(itemService.isItemExists(itemId)) {
        }


    }

    @Override
    public void addItemToOrders(Item item) {

    }

    @Override
    public List<Item> getItems() {
        return itemDAO.findAll();
    }
}
