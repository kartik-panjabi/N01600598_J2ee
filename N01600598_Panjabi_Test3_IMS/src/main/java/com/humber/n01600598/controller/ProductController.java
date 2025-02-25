package com.humber.n01600598.controller;

//import com.humber.n01600598.repository.ProductRepository;
import com.humber.n01600598.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    //final ProductRepository productRepository = new ProductRepository();

    @GetMapping("/")
    public String getProducts(Model model) {
        return "products";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        return "product-add";
    }

    @PostMapping("/save")
    public void saveProduct(Product product) {

    }
}
