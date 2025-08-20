package com.example.platzi_market.web.controller;

import com.example.platzi_market.domain.Purchase;
import com.example.platzi_market.domain.service.PurchaseService;
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
@RequestMapping("/purchases")
@Tag(name = "Compras", description = "Operaciones con las compras")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    @Operation(summary = "Mostrar todas las compras")
    @ApiResponse(responseCode = "200", description = "Lista de compras encontrada")
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "compras realizadas por Id cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Compras encontradas"),
            @ApiResponse(responseCode = "404", description = "Compras no encontradas")
    })
    public ResponseEntity<List<Purchase>> getByClient(
            @Parameter(description = "id del cliente", example = "12345678")
            @PathVariable("clientId") String clientId){
        return purchaseService.getByClient(clientId)
                .map(purchases -> new ResponseEntity<>(purchases,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    @Operation(summary = "Guardar una nueva compra")
    @ApiResponse(responseCode = "200", description = "compra creada exitosamente")
    public ResponseEntity<Purchase> save(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos de la compra a crear")
            @RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.save(purchase),HttpStatus.CREATED);
    }
}
