package com.revature.pms.services;

import com.revature.pms.dao.ItemDAO;
import com.revature.pms.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
    public ArrayList<Item> getItems() {
        ArrayList<Item> arrayListOfItems = new ArrayList<>();
        arrayListOfItems.addAll(itemDAO.findAll());
        return arrayListOfItems;
    }
}
