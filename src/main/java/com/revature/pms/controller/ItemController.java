package com.revature.pms.controller;

import com.revature.pms.model.Item;
import com.revature.pms.model.User;
import com.revature.pms.services.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item") //localhost:8080/item
public class ItemController {

    @PostMapping("/addItemToDB")
    public ResponseEntity<String> addItem(@RequestBody Item item) {
        ResponseEntity responseEntity = null;
        responseEntity = new ResponseEntity<String>("Successfully Saved your item:"
                + item.getItemId(), HttpStatus.OK);
        return responseEntity;
    }
}
