package com.example.platzi_market.persistence.crud;

import com.example.platzi_market.persistence.entities.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {
    //recuperar la lista a una categoria en especifico
    /*solamente con un Query
    @Query(value = "SELECT * FROM productos WHERE id_categria = ?",nativeQuery = true)
    List<Producto> getByIdCategoria(int idCategoria);
    */
    //implementando Query Methods
    List<Producto> findByIdCategoriaOrderByNombre(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
