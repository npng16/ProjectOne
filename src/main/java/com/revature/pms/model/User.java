package com.revature.pms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@Component  //creates the User bean
@Table(name = "user", schema = "one")
public class User {
    @Column(name = "userId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    // every time a user is created, a cart is created too

    //reference for one-to-one relationship  **** a cart belongs to one user and a user has only one cart ****************
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId")
    private Cart cart = new Cart();


    // reference for user - order relationship
    // a user may have many orders but an order belongs to only one user
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private List<Order> orders;
    public User() {
        System.out.println("Item object has been created..");
    }
    public String displayMessage() {
        return "Hi this is from User class";
    }

}
