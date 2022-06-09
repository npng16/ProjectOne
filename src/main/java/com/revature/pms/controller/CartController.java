package com.revature.pms.controller;

import com.revature.pms.dao.CartDAO;
import com.revature.pms.model.Cart;
import com.revature.pms.model.Item;
import com.revature.pms.services.CartService;
import com.revature.pms.services.CartServiceImpl;
import com.revature.pms.services.ItemServices;
import com.revature.pms.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cart") //localhost:8080/cart
public class CartController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);
    @Autowired(required = false)
    CartService cartService;

    @Autowired
    ItemServices itemService;
//    @PostMapping
//    public ResponseEntity<String> insertToCart(@RequestBody Item item) {
//        ResponseEntity responseEntity = null;
//        responseEntity = new ResponseEntity<String>("Successfully add item: " + item.getItemId() + " to  your cart:", HttpStatus.OK);
//        return responseEntity;
//    }


//    @GetMapping("/addItemToCart/{mitemId}")
//    public ResponseEntity<String> addItemToCart(@PathVariable("mitemId") int mItemId) {
//
////        cartService.addItemToCart(mItemId);
////            return "added item by item Id: " + mItemId + " to cart..";
//        ResponseEntity<String> responseEntity;
//
//            if (cartService.addItemToCart(mItemId)) {
//                responseEntity = new ResponseEntity<String>
//                        ("Item added to cart successfully", HttpStatus.OK);
//                LOGGER.info("Item added to cart successfully");
//            }
//            else {
//                responseEntity = new ResponseEntity<String>
//                        ("Cannot add item id " + mItemId, HttpStatus.NOT_ACCEPTABLE);
//                LOGGER.error("Cannot add user item id");
//            }
//        return responseEntity;
//    }


    @GetMapping("/displayAllCartItems")
    public ResponseEntity<String> getItems() {
        ResponseEntity responseEntity = null;
        List<Item> items = new ArrayList<>();
        items = cartService.getItems();
        return new ResponseEntity<String>(items.toString(), HttpStatus.OK);
    }
}
