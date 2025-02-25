package com.humber.n01600598.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.humber.n01600598.entity.Product;
import com.humber.n01600598.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
//    Product getAllProduct(int) {
//
//    }
//
    public void insertProduct(Product product) {
        productRepository.save(product);
    }
}
