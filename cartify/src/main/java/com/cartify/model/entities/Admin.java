
package com.cartify.model.entities;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User {
    private String adminCode;
}
