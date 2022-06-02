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
@NoArgsConstructor
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

    //reference for one-to-one relationship  **** a cart belongs to one user and a user has only one cart
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user", fetch=FetchType.LAZY, targetEntity = Cart.class)
    private Cart cart;

    //reference for many-to-many
    @ManyToMany
    @ElementCollection
    @CollectionTable(name = "userCartList", joinColumns = @JoinColumn(name = "userId"))
    @Column(name = "itemsInCart")
    private List<Item> cartList = new ArrayList<>();



    public String displayMessage() {
        return "Hi this is from User class";
    }

}
