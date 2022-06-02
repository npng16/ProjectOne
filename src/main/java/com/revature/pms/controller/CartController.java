package com.revature.pms.controller;

import com.revature.pms.model.Item;
import com.revature.pms.services.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart") //localhost:8080/cart
public class CartController {

    @Autowired
    ItemServices itemServices;
    @PostMapping
    public ResponseEntity<String> insertToCart(@RequestBody Item item) {
        ResponseEntity responseEntity = null;
        responseEntity = new ResponseEntity<String>("Successfully add item: " + item.getItemId() + " to  your cart:", HttpStatus.OK);
        return responseEntity;
    }
}
