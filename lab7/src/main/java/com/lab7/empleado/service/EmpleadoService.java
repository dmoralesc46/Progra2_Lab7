package com.lab7.empleado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lab7.empleado.dto.request.EmpleadoRequest;
import com.lab7.empleado.dto.response.EmpleadoResponse;
import com.lab7.empleado.entity.Especialidad;
import com.lab7.empleado.entity.Estado;

@Service 
public class EmpleadoService {
    private List<EmpleadoResponse> empleados = new ArrayList<>(
        List.of(
            new EmpleadoResponse(1L, "Camila", "Murillo", "camila.murillo@example.com", Especialidad.ADMINISTRACION, Estado.ACTIVO),
            new EmpleadoResponse(2L, "Tulio", "Martinez", "tulio.martinez@example.com", Especialidad.SERVICIO_AL_CLIENTE, Estado.ACTIVO),
            new EmpleadoResponse(3L, "Marcos", "Carbajal", "marcos.carbajal@example.com", Especialidad.CONTABILIDAD, Estado.VACACIONES)
        )
    );

    public List<EmpleadoResponse> getAll(){
        return empleados;
    }

    public EmpleadoResponse getEmpleadoById(Long id){
        return empleados.stream().filter(emp -> emp.getId().equals(id)).findFirst().orElse(null);
    }

    public List<EmpleadoResponse> filterByEspecialidad(Especialidad especialidad){
        return empleados.stream().filter(emp -> emp.getEspecialidad().equals(especialidad)).collect(Collectors.toList());
    }

    public EmpleadoResponse crearEmpleado(EmpleadoRequest empleadobody){
        if(empleadobody.nombre()==null || empleadobody.apellido()==null || empleadobody.correo()==null
            || empleadobody.nombre().isBlank() || empleadobody.apellido().isBlank()
            || empleadobody.correo().isBlank() || empleadobody.especialidad()==null || empleadobody.estado()==null){
                return null;
        }

        EmpleadoResponse new_empleado = new EmpleadoResponse(
            (long) (empleados.size()+1),
            empleadobody.nombre(),
            empleadobody.apellido(),
            empleadobody.correo(),
            empleadobody.especialidad(),
            empleadobody.estado()
        );

        empleados.add(new_empleado);
        return new_empleado;
    }

}
