package com.lab7.profesor.dto.request;

import com.lab7.profesor.entity.Especialidad;
import com.lab7.profesor.entity.Estado;

public record ProfesorRequest(String nombre, String apellido, String correo, Especialidad especialidad, Estado estado) {
    
}
