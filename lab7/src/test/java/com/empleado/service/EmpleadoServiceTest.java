package com.empleado.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lab7.empleado.dto.request.EmpleadoRequest;
import com.lab7.empleado.dto.response.EmpleadoResponse;
import com.lab7.empleado.entity.Especialidad;
import com.lab7.empleado.entity.Estado;
import com.lab7.empleado.service.EmpleadoService;

@ExtendWith(MockitoExtension.class)
public class EmpleadoServiceTest {
    @Mock 
    private EmpleadoService empleadoService;
    

    @Test 
    void WhenEmpleadoCreated_ThenReturnEmpleado() {
        EmpleadoRequest empleadoRequest = new EmpleadoRequest("Juan", "Perez", "juan.perez@universidad.edu",Especialidad.VENTAS, Estado.ACTIVO);
        EmpleadoResponse empleadoResponse = new EmpleadoResponse(3L, "Juan", "Perez", "juan.perez@universidad.edu", Especialidad.VENTAS, Estado.ACTIVO);
        when(empleadoService.crearEmpleado(empleadoRequest)).thenReturn(empleadoResponse);
        EmpleadoResponse result = empleadoService.crearEmpleado(empleadoRequest);
        assertEquals(3L, result.getId());
        verify(empleadoService).crearEmpleado(empleadoRequest);
    }

    @Test 
    void WhenGetEmpleadoFound_ThenReturnEmpleado() {
        EmpleadoResponse empleadoResponse = new EmpleadoResponse(1L, "Francisco", "Alonzo", "francisco.alonzo@universidad.edu", Especialidad.VENTAS, Estado.ACTIVO);
        when(empleadoService.getEmpleadoById(1L)).thenReturn(empleadoResponse);
        EmpleadoResponse result = empleadoService.getEmpleadoById(1L);
        assertEquals(1L, result.getId());
        verify(empleadoService).getEmpleadoById(1L);
    }

    @Test 
    void WhenEmpleadoNotFound_ThenReturnNull() {
        when(empleadoService.getEmpleadoById(99L)).thenReturn(null);
        EmpleadoResponse result = empleadoService.getEmpleadoById(99L);
        assertEquals(null, result);
        verify(empleadoService).getEmpleadoById(99L);
    }
    
}
