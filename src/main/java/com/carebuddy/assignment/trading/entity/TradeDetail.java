package com.carebuddy.assignment.trading.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class TradeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime tradeDateTime;
    private String stockName;
    private double listingPrice;
    private int quantity;
    private String type;
    private double pricePerUnit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTradeDateTime() {
        return tradeDateTime;
    }

    public void setTradeDateTime(LocalDateTime tradeDateTime) {
        this.tradeDateTime = tradeDateTime;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getListingPrice() {
        return listingPrice;
    }

    public void setListingPrice(double listingPrice) {
        this.listingPrice = listingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public TradeDetail() {
    }

    public TradeDetail(Long id, LocalDateTime tradeDateTime, String stockName, double listingPrice, int quantity, String type, double pricePerUnit) {
        this.id = id;
        this.tradeDateTime = tradeDateTime;
        this.stockName = stockName;
        this.listingPrice = listingPrice;
        this.quantity = quantity;
        this.type = type;
        this.pricePerUnit = pricePerUnit;
    }
}
