package com.example.platzi_market.domain.repository;

import com.example.platzi_market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryDomain {

    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarce(int quantity);
    Product save(Product product);
    Optional<Product> getProduct(int productId);
    void delete(int productId);
}
