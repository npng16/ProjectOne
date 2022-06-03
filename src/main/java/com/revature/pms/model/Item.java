package com.revature.pms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Component
@AllArgsConstructor
@Table(name = "item", schema = "one")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemId")
    private int itemId;
    @Column(name="name")
    private String itemName;
    @Column(name="price")
    private double itemPrice;

    // ********** an item can belong to only one order but there can be many items in a cart ***********
//    @ManyToOne
//    @JoinColumn(name = "orderId")
//    private Order order;

    public Item() {
        System.out.println("Item object has been created..");
    }

    public String displayMessage(){return "This is displayMessage() from Item class";}
}
