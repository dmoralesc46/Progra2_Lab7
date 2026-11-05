package com.proveedor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lab7.proveedor.dto.request.ProveedorRequest;
import com.lab7.proveedor.dto.response.ProveedorResponse;
import com.lab7.proveedor.entity.Categoria;
import com.lab7.proveedor.entity.Estado;
import com.lab7.proveedor.service.ProveedorService;

@ExtendWith (MockitoExtension.class)
public class ProveedorServiceTest {
    @Mock 
    private ProveedorService proveedorService;

    @Test 
    void WhenProveedorCreated_ThenReturnProveedor() {
        ProveedorRequest proveedorRequest = new ProveedorRequest("Juan", "Perez", "juan.perez@universidad.edu",Categoria.FABRICANTE,Estado.ACTIVO);
        ProveedorResponse proveedorResponse = new ProveedorResponse(3L, "Juan", "Perez", "juan.perez@universidad.edu",Categoria.FABRICANTE,Estado.ACTIVO);
        when(proveedorService.crearProveedor(proveedorRequest)).thenReturn(proveedorResponse);
        ProveedorResponse result = proveedorService.crearProveedor(proveedorRequest);
        assertEquals(3L, result.getId());
        verify(proveedorService).crearProveedor(proveedorRequest);
    }

    @Test 
    void WhenGetProveedorFound_ThenReturnProveedor() {
        ProveedorResponse proveedorResponse = new ProveedorResponse(1L, "Francisco", "Alonzo", "francisco.alonzo@universidad.edu", Categoria.FABRICANTE, Estado.ACTIVO);
        when(proveedorService.getProveedorById(1L)).thenReturn(proveedorResponse);
        ProveedorResponse result = proveedorService.getProveedorById(1L);
        assertEquals(1L, result.getId());
        verify(proveedorService).getProveedorById(1L);
    }

    @Test 
    void WhenProveedorNotFound_ThenReturnNull() {
        when(proveedorService.getProveedorById(99L)).thenReturn(null);
        ProveedorResponse result = proveedorService.getProveedorById(99L);
        assertEquals(null, result);
        verify(proveedorService).getProveedorById(99L);
    }
}
