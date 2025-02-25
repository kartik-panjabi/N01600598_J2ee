package com.humber.n01600598.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.humber.n01600598.entity.Product;
import org.springframework.stereotype.Repository;

// create jpa repository for database operation for product
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}