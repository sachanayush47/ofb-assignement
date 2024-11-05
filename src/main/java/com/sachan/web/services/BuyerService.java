package com.sachan.web.services;


import com.sachan.web.entities.Buyer;
import com.sachan.web.repositories.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    public Buyer createBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }
}