package com.cartify.model.entities;

import com.cartify.model.entities.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(
        name = "customers",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_customer_customerId", columnNames = "customer_id"),
                @UniqueConstraint(name = "uk_customer_email", columnNames = "email")
        }
)
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Business ID (visible to user)
    @Column(name = "customer_id", nullable = false, length = 20)
    @NotBlank
    private String customerId;

    @Column(nullable = false, length = 50)
    @NotBlank
    private String name;

    @Email
    @Column(nullable = false, length = 120)
    @NotBlank
    private String email;

    @Column(nullable = false)
    @NotBlank
    private String password;

    // ROLE_CUSTOMER
    @Column(nullable = false, length = 20)
    private String role;

    @Column(nullable = false)
    private boolean enabled = true;

    // Address Information

    @Column(nullable = false, length = 64)
    private String country;

    @Column(nullable = false, length = 64)
    private String state;

    @Column(nullable = false, length = 64)
    private String city;

    @Column(nullable = false, length = 200)
    private String address1;

    @Column(length = 200)
    private String address2;

    @Column(nullable = false, length = 16)
    private String zipCode;

    @Column(nullable = false, length = 16)
    private String phoneNumber;



//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Order> orders;
//
//    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
//    private Cart cart;

    // -------------------------
    // Constructors
    // -------------------------

    public Customer() {
    }

    // -------------------------
    // Getters & Setters
    // -------------------------

    public Long getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }


    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }


    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}