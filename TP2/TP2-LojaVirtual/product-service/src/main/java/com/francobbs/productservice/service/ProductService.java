package com.francobbs.productservice.service;

import com.francobbs.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private Map<Long, Product> products = new HashMap<>();

    public ProductService() {
        products.put(1L, new Product(1L, "PlayStation 5", 5000.0));
        products.put(2L, new Product(2L, "Xbox Series X", 4500.0));
    }

    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

    public Product getById(Long id) {
        return products.get(id);
    }

    public Product add(Product product) {
        products.put(product.getId(), product);
        return product;
    }
}