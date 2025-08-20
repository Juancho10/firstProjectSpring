package com.example.platzi_market.web.controller;

import com.example.platzi_market.domain.Product;
import com.example.platzi_market.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@Tag(name = "Productos", description = "Operaciones con productos")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    @Operation(summary = "Obtener todos los productos")
    @ApiResponse(responseCode = "200", description = "Productos encontrados")
    public ResponseEntity<List<Product>> getAll() {
        /*
        * Se crea una instancia de ResponseEntity
        * Se le pasan dos parametros el metodo a retornar de la entidad y la respuesta http*/
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    @Operation(summary = "Buscar producto por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Producto encontrado"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public ResponseEntity<Product> getProduct(
            @Parameter(description = "Id del producto", example = "1")
            @PathVariable int productId) {
        /*
        * Como el metodo getProduct trabaja con un Optionar, se usa un map para trabajar con lo que hay dentro
        * Se devuelve un OK si el producto existe
        * Se devuelve un NOT_FOUND si no existe junto con su mensaje de error http*/

        return productService.getProduct(productId)
                .map(products -> new ResponseEntity<>(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Obtener productos por categoria")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Producto encontrado"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public ResponseEntity<List<Product>> getByCategory(
            @Parameter(description = "id de categoria", example = "1")
            @PathVariable int categoryId) {
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @Operation(summary = "Guardar un nuevo producto")
    @ApiResponse(responseCode = "200", description = "Producto creado exitosamente")
    public ResponseEntity<Product> save(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "datos del producto")
            @RequestBody Product product) {
        /*
        * Se Realiza la instancia de ResponseEntity y se devuelve una respuesta http CREATED que indica que se creo*/
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{productId}")
    @Operation(summary = "Eliminar un producto")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Producto eliminado"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public ResponseEntity delete(
            @Parameter(description = "ID del producto a eliminar", example = "1")
            @PathVariable int productId) {
        if(productService.delete(productId))
            return new  ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
