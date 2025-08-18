package com.example.platzi_market.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {
    private Integer purchaseId;
    private int clientId;
    private LocalDateTime date;
    private String paymethodMethod;
    private String comment;
    private String state;
    private List<PurchaseItem> items;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<PurchaseItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseItem> items) {
        this.items = items;
    }

    public String getPaymethodMethod() {
        return paymethodMethod;
    }

    public void setPaymethodMethod(String paymethodMethod) {
        this.paymethodMethod = paymethodMethod;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
