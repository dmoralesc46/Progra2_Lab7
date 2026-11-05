package com.profesor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lab7.profesor.dto.request.ProfesorRequest;
import com.lab7.profesor.dto.response.ProfesorResponse;
import com.lab7.profesor.entity.Especialidad;
import com.lab7.profesor.entity.Estado;
import com.lab7.profesor.service.ProfesorService;


@ExtendWith(MockitoExtension.class)
class ProfesorServiceTest {


	@Mock 
	private ProfesorService profesorService;


	@Test 
	void WhenProfesorCreated_ThenReturnProfesor() {
		ProfesorRequest profesorRequest = new ProfesorRequest("Juan", "Perez", "juan.perez@universidad.edu",Especialidad.MATEMATICA, Estado.ACTIVO);
		ProfesorResponse profesorResponse = new ProfesorResponse(3L, "Juan", "Perez", "juan.perez@universidad.edu",Especialidad.MATEMATICA, Estado.ACTIVO);
		when(profesorService.crearProfesor(profesorRequest)).thenReturn(profesorResponse);
		ProfesorResponse result = profesorService.crearProfesor(profesorRequest);
		assertEquals(3L, result.getId());
		verify(profesorService).crearProfesor(profesorRequest);
	}

	@Test 
	void WhenGetProfesorFound_ThenReturnProfesor() {
		ProfesorResponse profesorResponse = new ProfesorResponse(1L, "Francisco", "Alonzo", "francisco.alonzo@universidad.edu",Especialidad.CIENCIAS_SOCIALES, Estado.ACTIVO);
		when(profesorService.getProfesorById(1L)).thenReturn(profesorResponse);
		ProfesorResponse result = profesorService.getProfesorById(1L);
		assertEquals(1L, result.getId());
		verify(profesorService).getProfesorById(1L);	
	}

	@Test 
	void WhenProfesorNotFound_ThenReturnNull() {
		when(profesorService.getProfesorById(99L)).thenReturn(null);
		ProfesorResponse result = profesorService.getProfesorById(99L);
		assertEquals(null, result);
		verify(profesorService).getProfesorById(99L);	
	}



}
