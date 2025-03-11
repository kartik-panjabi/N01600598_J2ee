package com.humber.n01600598.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private double salary;
}
