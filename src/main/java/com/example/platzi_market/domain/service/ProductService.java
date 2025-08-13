package com.example.platzi_market.domain.service;

import com.example.platzi_market.domain.Product;
import com.example.platzi_market.domain.repository.ProductRepositoryDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepositoryDomain productRepositoryDomain;

    //metodos a realizar
    public List<Product> getAll(){
        return productRepositoryDomain.getAll();
    }
    public Optional<Product> getProduct(int productId){
        return productRepositoryDomain.getProduct(productId);
    }
    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepositoryDomain.getByCategory(categoryId);
    }

    public Product save(Product product){

        return productRepositoryDomain.save(product);
    }

    public boolean delete(int productId){
        /*
        * getProduct -> valida que el objeto exista
        * .map -> elemento del Optional que nos permite convertir un optional en otro, para validar un valor nulo
        * si este existe se realiza la eliminación del objeto por su ID
        * orElse() -> retorna un valor falso si no existe el objeto
        * */
        return getProduct(productId).map(product ->{
            productRepositoryDomain.delete(productId);
            return true;
        }).orElse(false);
    }
}
