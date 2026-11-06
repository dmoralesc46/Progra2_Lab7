package com.lab7.proveedor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lab7.proveedor.dto.request.ProveedorRequest;
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

    public ProveedorResponse getProveedorById(Long id){
        return proveedores.stream().filter(proveedor -> proveedor.getId().equals(id)).findFirst().orElse(null);
    }

    public List<ProveedorResponse> obtenerProveedorPorCategoria(Categoria categoria){
        return proveedores.stream().filter(prov -> prov.getCategoria().equals(categoria)).collect(Collectors.toList());
    }

    public ProveedorResponse crearProveedor(ProveedorRequest proveedorbody){
        if(proveedorbody.nombre()==null || proveedorbody.apellido()==null
            ||proveedorbody.correo()==null || proveedorbody.nombre().isBlank()
            ||proveedorbody.apellido().isBlank() || proveedorbody.correo().isBlank()
            || proveedorbody.categoria()==null || proveedorbody.estado()==null){
                return null;
        }

        ProveedorResponse nuevo_proveedor = new ProveedorResponse(
            (long)(proveedores.size()+1), 
            proveedorbody.nombre(), 
            proveedorbody.apellido(), 
            proveedorbody.correo(), 
            proveedorbody.categoria(), 
            proveedorbody.estado());
        proveedores.add(nuevo_proveedor);
        return nuevo_proveedor;
    }
}