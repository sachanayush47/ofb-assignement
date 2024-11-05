package com.sachan.web.dto;

import java.time.LocalDateTime;

public class OrderSummaryDTO {
    private String buyerName;
    private String productName;
    private Integer quantity;
    private LocalDateTime orderDate;

    public OrderSummaryDTO(String buyerName, String productName, Integer quantity, LocalDateTime orderDate) {
        this.buyerName = buyerName;
        this.productName = productName;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}