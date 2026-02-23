
package com.cartify.model.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Customer customer;

    private String description;
    private int rating;
    private LocalDateTime dateTime;
}
