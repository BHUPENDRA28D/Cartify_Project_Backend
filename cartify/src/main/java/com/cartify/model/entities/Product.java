
package com.cartify.model.entities;

import com.cartify.model.entities.base.BaseEntity;
import com.cartify.model.enums.ProductStatus;
import jakarta.persistence.*;

@Entity
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private double price;
    private String category;
    private String description;
    private int quantity;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    private boolean isDeleted = false;
}
