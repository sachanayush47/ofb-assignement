package com.sachan.web.repositories;

import com.sachan.web.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o JOIN FETCH o.buyer JOIN FETCH o.product")
    List<Order> findAllWithBuyerAndProduct();
}

