package com.lab7.proveedor.dto.request;

import com.lab7.proveedor.entity.Categoria;
import com.lab7.proveedor.entity.Estado;

public record ProveedorRequest(
    String nombre, 
    String apellido, 
    String correo,
    Categoria categoria,
    Estado estado   
) {
    
}
