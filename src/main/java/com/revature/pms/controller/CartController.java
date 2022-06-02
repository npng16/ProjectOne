package com.revature.pms.controller;

import com.revature.pms.model.Cart;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart") //localhost:8080/cart
public class CartController {
    @PostMapping
    public ResponseEntity<String> addCart(@RequestBody Cart cart) {
        ResponseEntity responseEntity = null;
        responseEntity = new ResponseEntity<String>("Successfully Saved your cart:"
                + cart.getCartId(), HttpStatus.OK);
        return responseEntity;
    }
}
