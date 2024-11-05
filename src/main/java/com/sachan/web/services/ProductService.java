package com.sachan.web.services;

import com.sachan.web.entities.Product;
import com.sachan.web.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product updateProductStock(Product newProduct) {
        return productRepository.findById(newProduct.getProductId())
                .map(currProduct -> {
                    currProduct.setStockQuantity(currProduct.getStockQuantity() + newProduct.getStockQuantity());
                    return productRepository.save(currProduct);
                })
                .orElseGet(() -> productRepository.save(newProduct));
    }

    public Integer getStockQuantity(String productId) {
        return productRepository.findById(productId)
                .map(Product::getStockQuantity)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));
    }
}
