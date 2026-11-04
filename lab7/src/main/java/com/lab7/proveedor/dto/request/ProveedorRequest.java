package com.lab7.proveedor.dto.request;

import com.lab7.profesor.entity.Estado;
import com.lab7.proveedor.entity.Categoria;

public record ProveedorRequest(
    String nombre, 
    String apellido, 
    String correo,
    Categoria categoria,
    Estado estado   
) {
    
}
