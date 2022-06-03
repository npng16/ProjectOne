package com.revature.pms.controller;

import com.revature.pms.dao.CartDAO;
import com.revature.pms.model.Cart;
import com.revature.pms.model.Item;
import com.revature.pms.services.CartService;
import com.revature.pms.services.ItemServices;
import com.revature.pms.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cart") //localhost:8080/cart
public class CartController {

    @Autowired(required = false)
    CartService cartService;

    @Autowired
    UserServices userService;

    @Autowired
    Cart cart;

    @Autowired
    CartDAO cartDAO;

    @Autowired
    ItemServices itemService;
//    @PostMapping
//    public ResponseEntity<String> insertToCart(@RequestBody Item item) {
//        ResponseEntity responseEntity = null;
//        responseEntity = new ResponseEntity<String>("Successfully add item: " + item.getItemId() + " to  your cart:", HttpStatus.OK);
//        return responseEntity;
//    }

    // get cart by userId
    @GetMapping("/getCart/{Id}")
    public Cart setCartByUserId(@PathVariable("Id") int mUserId) {
        cartService.findCartIdByUserId(mUserId);
        cart.setCartId(mUserId);
        cartDAO.save(cart);
        return cart;
    }
    @GetMapping("/addItemToCart{id}")
    public String addItemToCart(@PathVariable("Id") int mItemId) {

        return "added item by item Id: " + mItemId + " to cart..";

    }

    @GetMapping("/displayAllCartItems")
    public ResponseEntity<String> getItems() {
        ResponseEntity responseEntity = null;
        List<Item> items = new ArrayList<>();
        items = cartService.getItems();
        return new ResponseEntity<String>(items.toString(), HttpStatus.OK);
    }
}
