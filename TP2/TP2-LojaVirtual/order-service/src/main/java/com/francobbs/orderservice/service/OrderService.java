package com.francobbs.orderservice.service;

import com.francobbs.orderservice.model.Order;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    private Map<Long, Order> orders = new HashMap<>();

    public OrderService() {
        orders.put(1L, new Order(1L, "Compra PlayStation 5", 5000.0));
        orders.put(2L, new Order(2L, "Compra Xbox Series X", 4500.0));
    }

    public List<Order> getAll() {
        return new ArrayList<>(orders.values());
    }

    public Order getById(Long id) {
        return orders.get(id);
    }

    public Order add(Order order) {
        orders.put(order.getId(), order);
        return order;
    }
}