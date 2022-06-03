package com.revature.pms.services;

import com.revature.pms.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    public void findCartIdByUserId(int id);
    public void addItemToCart(int itemId, int userId);
    public void addItemToOrders(Item item);
    public List<Item> getItems();
}
