package com.francobbs.orderservice.controller;

import com.francobbs.orderservice.model.Order;
import com.francobbs.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return service.add(order);
    }
}