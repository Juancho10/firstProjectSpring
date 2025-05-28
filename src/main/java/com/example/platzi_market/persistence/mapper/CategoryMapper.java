package com.example.platzi_market.persistence.mapper;

import com.example.platzi_market.domain.Category;
import com.example.platzi_market.persistence.entities.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source="idCategoria", target="categoryId"),
            @Mapping(source = "descripcion", target="description"),
            @Mapping(source="estado", target="state")
    })
    Category toCategory(Categoria categoria);

    //conversión inversa
    @InheritInverseConfiguration
    @Mapping(target="productos", ignore = true)
    Categoria toCategory(Category category);

}
