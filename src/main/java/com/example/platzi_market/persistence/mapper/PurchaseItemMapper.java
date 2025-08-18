package com.example.platzi_market.persistence.mapper;

import com.example.platzi_market.domain.PurchaseItem;
import com.example.platzi_market.persistence.entities.CompraProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(CompraProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target= "compras", ignore = true),
            @Mapping(target= "productos",ignore = true),
            @Mapping(target="id.idCompra", ignore = true)
    })
    CompraProducto toCompraProducto(PurchaseItem item);
}
