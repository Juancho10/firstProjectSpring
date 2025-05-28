package com.example.platzi_market.persistence.crud;

import com.example.platzi_market.persistence.entities.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepositiry extends CrudRepository<Producto,Integer> {
    //recuperar la lista a una categoria en especifico
    /*solamente con un Query
    @Query(value = "SELECT * FROM productos WHERE id_categria = ?",nativeQuery = true)
    List<Producto> getByIdCategoria(int idCategoria);
    */
    //implementando Query Methods
    List<Producto> findByIdCategoriaOrderByNombre(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessTanAndEstado(int cantidadStock, boolean estado);

}
