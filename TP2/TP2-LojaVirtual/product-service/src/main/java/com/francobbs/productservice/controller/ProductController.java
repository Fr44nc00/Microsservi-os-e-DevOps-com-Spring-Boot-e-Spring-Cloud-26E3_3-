package com.francobbs.productservice.controller;

import com.francobbs.productservice.model.Product;
import com.francobbs.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.add(product);
    }
}