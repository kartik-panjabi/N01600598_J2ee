package com.humber.n01600598.controller;

import com.humber.n01600598.repository.ProductRepository;
import com.humber.n01600598.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.humber.n01600598.service.ProductService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;



    @GetMapping("/")
    public String getProducts(Model model) {
        return "products";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        return "product-add";
    }

    @PostMapping("/save")
    public void saveProduct(Product product, RedirectAttributes redirectAttributes) {

        productService.insertProduct(product);

        redirectAttributes.addFlashAttribute("message", "Product saved successfully");

    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id, RedirectAttributes redirectAttributes) {


    }




}
