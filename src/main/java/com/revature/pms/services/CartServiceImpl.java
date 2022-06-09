package com.revature.pms.services;

import com.revature.pms.dao.CartDAO;
import com.revature.pms.dao.ItemDAO;
import com.revature.pms.dao.UserDAO;
import com.revature.pms.model.Cart;
import com.revature.pms.model.Item;
import com.revature.pms.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CartServiceImpl implements CartService{
    private static final Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);
    @Autowired
    ItemDAO itemDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    CartDAO cartDAO;

    @Autowired
    ItemServices itemService;

    @Autowired
    HttpServletRequest request;

    @Override
    public boolean addItemToCart(int itemId) {


        HttpSession session = request.getSession(false);
        User sessionUser = (User) session.getAttribute("currentUser");

        Cart mCart = sessionUser.getCart();
        List<Item> temporaryList = mCart.getItemList();
        temporaryList.add(itemService.getItem(itemId));
        mCart.setItemList(temporaryList);
        cartDAO.save(mCart);
        sessionUser.setCart(mCart);
        return true;

    }

    @Override
    public void addItemToOrders(Item item) {

    }

    @Override
    public List<Item> getItems() {
        return itemDAO.findAll();
    }
}
