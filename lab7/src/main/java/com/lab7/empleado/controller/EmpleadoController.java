package com.lab7.empleado.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab7.empleado.dto.request.EmpleadoRequest;
import com.lab7.empleado.dto.response.EmpleadoResponse;
import com.lab7.empleado.entity.Especialidad;
import com.lab7.empleado.service.EmpleadoService;

@RestController 
@RequestMapping("/api/empleados")
public class EmpleadoController {
    EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(empleadoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        EmpleadoResponse result = empleadoService.getEmpleadoById(id);
        if(result == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                    "mensaje","El empleado con id "+id+" no existe",
                    "codigo", 404
                )
            );
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/especialidad/{especialidad}")
    public ResponseEntity<?> filterByEspecialidad(@PathVariable Especialidad especialidad){
        List<EmpleadoResponse> filtered_Empleados = empleadoService.filterByEspecialidad(especialidad);

        return ResponseEntity.ok(filtered_Empleados);        
    }

    @PostMapping
    public ResponseEntity<?> crearEmpleado(@RequestBody EmpleadoRequest empladobody){
        EmpleadoResponse nuevo_emp = empleadoService.crearEmpleado(empladobody);
        if(nuevo_emp==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                Map.of( 
                    "mensaje","Por favor ingresar todos los campos necesarios",
                    "codigo",409
                )
            );
        }
        return ResponseEntity.ok(nuevo_emp);
    }
}
