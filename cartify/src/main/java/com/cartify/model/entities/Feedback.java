
package com.cartify.model.entities;

import com.cartify.model.entities.base.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedbacks")
public class Feedback  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Customer customer;

    private String description;
    private Integer rating;
    private LocalDateTime createdAt;

    public Feedback() {
    }

    public Feedback(Long id, Order order, Customer customer, String description, Integer rating, LocalDateTime createdAt) {
        this.id = id;
        this.order = order;
        this.customer = customer;
        this.description = description;
        this.rating = rating;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDateTime getDateTime() {
        return createdAt;
    }

    public void setDateTime(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
