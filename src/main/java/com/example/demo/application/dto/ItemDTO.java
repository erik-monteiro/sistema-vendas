package com.example.demo.application.dto;

public class ItemDTO {
    private Long productId;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

