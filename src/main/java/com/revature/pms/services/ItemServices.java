package com.revature.pms.services;

import com.revature.pms.model.Item;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public interface ItemServices {
     public boolean addItem(Item item);
     public boolean deleteItem(int itemId);
     public boolean updateItem(Item item);
     public Item getItem(int itemId);
     public boolean isItemExists(int itemId);
     ArrayList<Item> getItems();
}
