package com.example.platzi_market.persistence.crud;

import com.example.platzi_market.persistence.entities.Compra;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<Compra,Integer> {
    //Query Method que retorna una lista de compras hechas por el cliente a buscar
    Optional<List<Compra>> findByIdCliente(String idCliente);
    /*@Query("SELECT DISTINCT c FROM Compra c LEFT JOIN FETCH c.productos") // 👈 JOIN FETCH evita LazyInit
    List<Compra> findAllWithProducts();*/
}
