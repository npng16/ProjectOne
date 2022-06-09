package com.revature.pms.services;

import com.revature.pms.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    public boolean addItemToCart(int itemId);
    public void addItemToOrders(Item item);
    public List<Item> getItems();
}
