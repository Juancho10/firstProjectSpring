package com.example.platzi_market.persistence;

import com.example.platzi_market.domain.Product;
import com.example.platzi_market.persistence.crud.ProductoCrudRepositiry;
import com.example.platzi_market.persistence.entities.Producto;
import com.example.platzi_market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements com.example.platzi_market.domain.repository.ProductRepositoryDomain {
    @Autowired
    private ProductoCrudRepositiry productoCrudRepositiry;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepositiry.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepositiry.findByIdCategoriaOrderByNombre(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }
    //retorna todos los productos de una categoria ordenados asc

    @Override
    public Optional<List<Product>> getScarce(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepositiry.findByCantidadStockLessTanAndEstado(quantity, true);
        return productos.map(prod -> mapper.toProducts(prod));// exprecion lambda
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepositiry.save(producto));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepositiry.findById(productId).map(product -> mapper.toProduct(product));
    }

    @Override
    public void delete(int productId){
        productoCrudRepositiry.deleteById(productId);
    }
}
