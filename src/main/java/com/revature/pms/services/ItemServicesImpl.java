package com.revature.pms.services;

import com.revature.pms.dao.ItemDAO;
import com.revature.pms.model.Item;
import com.revature.pms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ItemServicesImpl implements ItemServices {
    @Autowired
    ItemDAO itemDAO;

    @Override
    public boolean addItem(Item item) {
        itemDAO.save(item);
        return true;
    }

    @Override
    public boolean deleteItem(int itemId) {
        itemDAO.deleteById(itemId);
        return true;
    }

    @Override
    public boolean updateItem(Item item) {
        itemDAO.save(item);
        return true;
    }

    @Override
    public Item getItem(int itemId) {
        Item item = itemDAO.getById(itemId);
        return item;
    }

    @Override
    public boolean isItemExists(int itemId) {
        return itemDAO.existsById(itemId);
    }

    @Override
    public List<Item> getItems() {
        return itemDAO.findAll();
    }
//        Set<Item> setOfItems = new HashSet<>();
//        setOfItems.addAll(itemDAO.findAll());
//        return setOfItems;
//    }
}
