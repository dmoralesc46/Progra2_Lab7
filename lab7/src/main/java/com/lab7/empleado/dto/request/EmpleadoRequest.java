package com.lab7.empleado.dto.request;

import com.lab7.empleado.entity.Especialidad;
import com.lab7.empleado.entity.Estado;

public record EmpleadoRequest(
    String nombre,
    String apellido, 
    String correo,
    Especialidad especialidad,
    Estado estado
) {
    
}
