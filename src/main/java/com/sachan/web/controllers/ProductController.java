package com.sachan.web.controllers;

import com.sachan.web.entities.Product;
import com.sachan.web.entities.Order;
import com.sachan.web.services.ProductService;
import com.sachan.web.dto.OrderSummaryDTO;
import com.sachan.web.dto.OrderDTO;
import com.sachan.web.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProductStock(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/product/{productId}/stockInHand")
    public ResponseEntity<Integer> getStockInHand(@PathVariable String productId) {
        return ResponseEntity.ok(productService.getStockQuantity(productId));
    }

    @PostMapping("/product/{productId}/buyer/{buyerId}/order")
    public ResponseEntity<Order> createOrder(
            @PathVariable String productId,
            @PathVariable String buyerId,
            @RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.createOrder(productId, buyerId, orderDTO.getQuantity()));
    }

    @PutMapping("/product/{orderId}/order/cancel")
    public ResponseEntity<Order> createOrder(
            @PathVariable Long orderId
    ) {
        return ResponseEntity.ok(orderService.cancelOrder(orderId));
    }

    @GetMapping("/product/order")
    public ResponseEntity<List<OrderSummaryDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}

