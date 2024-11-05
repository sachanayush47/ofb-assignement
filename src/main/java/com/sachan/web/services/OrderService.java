package com.sachan.web.services;

import com.sachan.web.dto.OrderSummaryDTO;
import com.sachan.web.entities.Buyer;
import com.sachan.web.entities.Order;
import com.sachan.web.entities.Product;
import com.sachan.web.repositories.BuyerRepository;
import com.sachan.web.repositories.OrderRepository;
import com.sachan.web.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    public Order createOrder(String productId, String buyerId, Integer quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        Buyer buyer = buyerRepository.findById(buyerId)
                .orElseThrow(() -> new EntityNotFoundException("Buyer not found"));

        if (product.getStockQuantity() < quantity) {
            throw new IllegalStateException("Insufficient stock");
        }

        product.setStockQuantity(product.getStockQuantity() - quantity);
        productRepository.save(product);

        Order order = new Order();
        order.setBuyer(buyer);
        order.setProduct(product);
        order.setQuantity(quantity);
        order.setStatus("created");

        return orderRepository.save(order);
    }

    // Cancel Order
    public Order cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("Order not found"));
        order.setStatus("cancelled");
        orderRepository.save(order);
        return order;
    }

    public List<OrderSummaryDTO> getAllOrders() {
        return orderRepository.findAllWithBuyerAndProduct()
                .stream()
                .map(order -> new OrderSummaryDTO(
                        order.getBuyer().getName(),
                        order.getProduct().getProductName(),
                        order.getQuantity(),
                        order.getOrderDate()
                ))
                .collect(Collectors.toList());
    }
}