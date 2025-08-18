package com.example.platzi_market.domain.repository;

import com.example.platzi_market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepositoryDomain {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}