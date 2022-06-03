package com.revature.pms.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders", schema = "one")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int userId;

//    @OneToMany
//    private Set<Item> itemsInOrder;

    public void setUserId(User user) {
        userId = user.getUserId();
    }
}
