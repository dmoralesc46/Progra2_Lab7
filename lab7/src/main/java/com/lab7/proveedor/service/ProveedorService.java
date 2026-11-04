package com.lab7.proveedor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lab7.proveedor.dto.response.ProveedorResponse;
import com.lab7.proveedor.entity.Categoria;
import com.lab7.proveedor.entity.Estado;

@Service 
public class ProveedorService{
    List<ProveedorResponse> proveedores = new ArrayList<>(
        List.of(
            new ProveedorResponse(1L, "Rolando", "Carson","rolando.carson@example.com",  Categoria.FABRICANTE, Estado.ACTIVO), 
            new ProveedorResponse(2L, "Gregorio", "Trin","gregorio.trin@example.com",  Categoria.IMPORTADOR, Estado.ACTIVO)
        )
    );

    public List<ProveedorResponse> getAll(){
        return proveedores;
    }

    public ProveedorResponse getById(Long id){
        return proveedores.stream().filter(prov -> prov.getId().equals(id)).collect(Collectors.toList()).get(0);
    }

    public List<ProveedorResponse> obtenerProveedorPorCategoria(Categoria categoria){
        return proveedores.stream().filter(prov -> prov.getCategoria().equals(categoria)).collect(Collectors.toList());
    }
}