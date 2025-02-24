package com.humber.n01600598.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Generates a constructor with all arguments
@AllArgsConstructor // Generates a no-args constructor
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // Auto-generate IDs
    private Long id;
    private String name;
    private double price;
    private String description;
}
