package com.francobbs.orderservice.model;

public class Order {
    private Long id;
    private String description;
    private Double total;

    public Order(Long id, String description, Double total) {
        this.id = id;
        this.description = description;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
