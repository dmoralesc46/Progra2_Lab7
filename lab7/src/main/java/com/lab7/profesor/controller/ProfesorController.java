package com.lab7.profesor.controller;

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

import com.lab7.profesor.dto.request.ProfesorRequest;
import com.lab7.profesor.dto.response.ProfesorResponse;
import com.lab7.profesor.entity.Especialidad;
import com.lab7.profesor.service.ProfesorService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController 
@RequestMapping("/api/profesores")
public class ProfesorController {
    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService){
        this.profesorService = profesorService;
    }

    
    @GetMapping 
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(profesorService.getAll());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> getProfesorById(@PathVariable Long id){
        ProfesorResponse profesor = profesorService.getProfesorById(id);
        if(profesor==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                    "mensaje","No existe ningun profesor con el id '"+ id +"'.",
                    "codigo", 404
                )
            );
        }
        return ResponseEntity.ok(profesor);
    }

   
    @GetMapping("/especialidad/{especialidad}")
    public ResponseEntity<?> getProfesorsByEspecialidad(@PathVariable Especialidad especialidad){
        List<ProfesorResponse> profesor_filteredList = profesorService.getProfesorByEspecialidad(especialidad);
        if(profesor_filteredList.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                Map.of(
                    "mensaje","No existe ningun profesor con la especialidad '"+ especialidad.name() +"'.",
                    "codigo", 409
                )
            );
        }
        return ResponseEntity.ok(profesor_filteredList);
    }

    @ApiResponse(responseCode = "200", description = "Profesor creado exitosamente")
    @ApiResponse(responseCode = "400", description = "Solicitud inválida: falta información o formato incorrecto")
    @PostMapping
    public ResponseEntity<?> crearProfesor(@RequestBody ProfesorRequest profesorbody){
        ProfesorResponse nuevo = profesorService.crearProfesor(profesorbody);
        if(nuevo==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of(
                    "mensaje","Ingrese todos los datos, no deje ninguno vacio",
                    "codigo",400
                )
            );
        }
        return ResponseEntity.ok(nuevo);
    } 

    
}
