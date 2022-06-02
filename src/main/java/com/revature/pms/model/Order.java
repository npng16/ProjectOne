package com.revature.pms.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private int orderId;

    // *** an order can have many items ************
    @OneToMany
    private Set<Item> itemsInOrder;
}
