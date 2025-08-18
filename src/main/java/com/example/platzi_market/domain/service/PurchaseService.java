package com.example.platzi_market.domain.service;

import com.example.platzi_market.domain.Purchase;
import com.example.platzi_market.domain.repository.PurchaseRepositoryDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepositoryDomain purchaseRepositoryDomain;

    @Transactional(readOnly = true)
    public List<Purchase> getAll(){
        return purchaseRepositoryDomain.getAll();
    };
    @Transactional(readOnly = true)
    public Optional<List<Purchase>> getByClient(String clientId){
        return purchaseRepositoryDomain.getByClient(clientId);
    };
    @Transactional
    public Purchase save(Purchase purchase){
        return purchaseRepositoryDomain.save(purchase);
    };

}
