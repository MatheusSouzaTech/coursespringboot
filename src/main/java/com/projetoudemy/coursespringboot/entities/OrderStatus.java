package com.projetoudemy.coursespringboot.entities;

import java.io.Serializable;

public class OrderStatus implements Serializable {

    private Integer quantity;
    private Double price;

    public OrderStatus(){}

    public OrderStatus(Integer quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
