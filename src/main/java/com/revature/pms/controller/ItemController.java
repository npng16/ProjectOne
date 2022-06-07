package com.revature.pms.controller;

import com.revature.pms.model.Item;
import com.revature.pms.model.User;
import com.revature.pms.services.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("item") //localhost:8080/item
public class ItemController {
    @Autowired
    ItemServices itemService;

    @GetMapping()
    public ResponseEntity<List<Item>> getItems() {
        ResponseEntity responseEntity = null;
        List<Item> items = itemService.getItems();
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<String> addItem(@RequestBody Item item) {
        ResponseEntity responseEntity = null;
        itemService.addItem(item);
        responseEntity = new ResponseEntity<String>("Successfully Saved your item:"
                + item.getItemId(), HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("{pItemId}")
    public String deleteItem(@PathVariable("pItemId") int itemId) {
        itemService.deleteItem(itemId);
        return "Deleting details by item Id: " + itemId;
    }
}
