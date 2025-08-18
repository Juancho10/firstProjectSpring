package com.example.platzi_market.persistence;

import com.example.platzi_market.domain.Purchase;
import com.example.platzi_market.domain.repository.PurchaseRepositoryDomain;
import com.example.platzi_market.persistence.crud.PurchaseCrudRepository;
import com.example.platzi_market.persistence.entities.Compra;
import com.example.platzi_market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepositoryDomain implements PurchaseRepositoryDomain {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Purchase> getAll() {
        //List<Compra> compras = purchaseCrudRepository.findAllWithProducts();
        return purchaseMapper.toPurchases((List<Compra>) purchaseCrudRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseCrudRepository.findByIdCliente(clientId)
                .map(compras -> purchaseMapper.toPurchases(compras));
    }

    @Override
    @Transactional(readOnly = true)
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
        // indicamos la compra a que producto pertenece y asi mismo el producto a que compra esta asignado
        compra.getProductos().forEach(productos -> productos.setCompras(compra));
        return purchaseMapper.toPurchase(purchaseCrudRepository.save(compra));
    }
}
