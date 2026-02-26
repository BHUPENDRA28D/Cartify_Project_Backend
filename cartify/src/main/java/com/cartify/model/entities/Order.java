
package com.cartify.model.entities;

import com.cartify.model.entities.base.BaseEntity;
import com.cartify.model.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true, nullable = false)
        private String orderId;

        @ManyToOne(optional = false)
        @JoinColumn(name = "customer_id")
        private Customer customer;

        @Column(nullable = false)
        private Double totalAmount;

        @Enumerated(EnumType.STRING)
        private com.cartify.model.enums.OrderStatus status;

        @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
        private java.util.List<OrderItem> items = new java.util.ArrayList<>();

        @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
        private Payment payment;

        private java.time.LocalDateTime orderDate;
        private java.time.LocalDateTime arrivingDate;

        @Column(nullable = false)
        private String shippingAddress;

        private java.time.LocalDateTime cancelledDate;



        // getters & setters


    public Order() {
    }

    public Order(Long id, String orderId, Customer customer, Double totalAmount, OrderStatus status, List<OrderItem> items, Payment payment, LocalDateTime orderDate, LocalDateTime arrivingDate, String shippingAddress, LocalDateTime cancelledDate) {
        this.id = id;
        this.orderId = orderId;
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.status = status;
        this.items = items;
        this.payment = payment;
        this.orderDate = orderDate;
        this.arrivingDate = arrivingDate;
        this.shippingAddress = shippingAddress;
        this.cancelledDate = cancelledDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getArrivingDate() {
        return arrivingDate;
    }

    public void setArrivingDate(LocalDateTime arrivingDate) {
        this.arrivingDate = arrivingDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public LocalDateTime getCancelledDate() {
        return cancelledDate;
    }

    public void setCancelledDate(LocalDateTime cancelledDate) {
        this.cancelledDate = cancelledDate;
    }
}




