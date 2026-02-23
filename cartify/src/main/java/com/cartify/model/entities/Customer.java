
package com.cartify.model.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Customer extends User {

    private String country;
    private String state;
    private String city;
    private String address1;
    private String address2;
    private String zipCode;
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Cart cart;
}
