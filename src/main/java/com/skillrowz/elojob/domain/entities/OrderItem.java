package com.skillrowz.elojob.domain.entities;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItem {
    private UUID id;
    private GameAccount gameAccount;
    private BigDecimal unitPrice;

    public OrderItem(UUID id, GameAccount gameAccount, BigDecimal unitPrice) {
        this.id = id;
        this.gameAccount = gameAccount;
        this.unitPrice = unitPrice;
    }

    public UUID getId() { return id; }
    public GameAccount gameAccount() { return gameAccount; }
    public BigDecimal getUnitPrice() { return unitPrice; }

    public BigDecimal getTotalPrice() {
        return unitPrice;
    }
}
