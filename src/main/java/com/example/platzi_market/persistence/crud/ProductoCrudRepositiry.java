package com.example.platzi_market.persistence.crud;

import com.example.platzi_market.persistence.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepositiry extends CrudRepository<Producto,Integer> {
}
