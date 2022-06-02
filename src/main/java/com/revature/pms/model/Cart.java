package com.revature.pms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "cart", schema = "one")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cartId")
    private int cartId;

    //************ a user has one and only one cart and a cart belongs to only one user
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

//    a cart may have many items
//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(
//            name = "item",
//            joinColumns = {@JoinColumn(name = "cartId")},
//            inverseJoinColumns = {@JoinColumn(name = "cartList")}
//    )
//    private List<Item> itemIdInCart;

}
