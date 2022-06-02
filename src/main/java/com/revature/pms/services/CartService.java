package com.revature.pms.services;

import com.revature.pms.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface CartService {
    public void addItemToCart(Item item);
    public void addItemToOrders(Item item);
    public ArrayList<Item> getItems();
}
