package com.sachan.web.repositories;

import com.sachan.web.entities.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, String> {
}
