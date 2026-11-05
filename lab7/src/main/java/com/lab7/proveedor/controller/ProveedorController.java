package com.lab7.proveedor.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab7.proveedor.dto.request.ProveedorRequest;
import com.lab7.proveedor.dto.response.ProveedorResponse;
import com.lab7.proveedor.entity.Categoria;
import com.lab7.proveedor.service.ProveedorService;

@RestController 
@RequestMapping("/api/proveedores")
public class ProveedorController {
    ProveedorService proveedorService;
    public ProveedorController(ProveedorService proveedorService){
        this.proveedorService = proveedorService;
    }

    @GetMapping 
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(proveedorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        ProveedorResponse proveedor = proveedorService.getProveedorById(id);
        if(proveedor == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                    "mensaje","El proveedor con id "+id +" no existe.",
                    "codigo", 404
                )
            );
        }
        return ResponseEntity.ok(proveedor);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<?> obtenerProveedorPorCategoria(@PathVariable Categoria categoria){
        List<ProveedorResponse> proveedor_filteredList = proveedorService.obtenerProveedorPorCategoria(categoria);
        if(proveedor_filteredList.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                Map.of(
                    "mensaje","No existe ningun profesor con la especialidad '"+ categoria.name() +"'.",
                    "codigo", 409
                )
            );
        }
        return ResponseEntity.ok(proveedor_filteredList);
    }

    @PostMapping
    public ResponseEntity<?> crearProveedor(@RequestBody ProveedorRequest proveedorbody){
        ProveedorResponse nuevo_proveedor = proveedorService.crearProveedor(proveedorbody);
        if(nuevo_proveedor==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                Map.of(
                    "mensaje","Ingrese todos los datos, no deje ninguno vacio",
                    "codigo",409
                )
            );
        }

        return ResponseEntity.ok(nuevo_proveedor);
    } 
}
