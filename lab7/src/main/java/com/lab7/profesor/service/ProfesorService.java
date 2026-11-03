package com.lab7.profesor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lab7.profesor.dto.response.ProfesorResponse;
import com.lab7.profesor.entity.Especialidad;
import com.lab7.profesor.entity.Estado;

@Service 
public class ProfesorService {
    private final List<ProfesorResponse> profesores = new ArrayList<>(
        List.of(
            new ProfesorResponse(1L, "Francisco", "Alonzo", "francisco.alonzo@example.com", Especialidad.CIENCIAS_SOCIALES, Estado.ACTIVO),
            new ProfesorResponse(2L, "Gabriela", "Quintana", "gabriela.quintana@example.com", Especialidad.MATEMATICA, Estado.ACTIVO)  
        )    
    );

    public List<ProfesorResponse> getAll(){
        return this.profesores;
    }

    public ProfesorResponse getProfesorById(Long id){
        for (int i = 0; i <profesores.size(); i++) {
            ProfesorResponse profesor = profesores.get(i);
            if(profesor.getId().equals(id)){
                return profesor;
            }
        }

        //aca se marca el error
        return null;
    }

    public List<ProfesorResponse> getProfesorByEspecialidad(Especialidad especialidad){
        return profesores.stream().filter(espe -> espe.getEspecialidad().equals(especialidad)).collect(Collectors.toList());
    }
}
