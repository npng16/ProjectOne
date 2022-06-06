package com.revature.pms.controller;

import com.revature.pms.model.Item;
import com.revature.pms.model.User;
import com.revature.pms.services.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("item") //localhost:8080/item
public class ItemController {
    @Autowired
    ItemServices itemService;

    @GetMapping()
    public ResponseEntity<String> getItems() {
        ResponseEntity responseEntity = null;
        List<Item> items = new ArrayList<>();
        items = itemService.getItems();
        return new ResponseEntity<String>(items.toString(), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<String> addItem(@RequestBody Item item) {
        ResponseEntity responseEntity = null;
        itemService.addItem(item);
        responseEntity = new ResponseEntity<String>("Successfully Saved your item:"
                + item.getItemId(), HttpStatus.OK);
        return responseEntity;
    }
}
