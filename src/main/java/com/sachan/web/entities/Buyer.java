package com.sachan.web.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "buyers")
public class Buyer {
    @Id
    private String buyerId;
    private String name;

    public Buyer() {}

    public Buyer(String buyerId, String name) {
        this.buyerId = buyerId;
        this.name = name;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
