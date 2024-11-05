package com.sachan.web.controllers;

import com.sachan.web.entities.Buyer;
import com.sachan.web.services.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @PutMapping("/buyer")
    public ResponseEntity<Buyer> createBuyer(@RequestBody Buyer buyer) {
        return ResponseEntity.ok(buyerService.createBuyer(buyer));
    }
}
