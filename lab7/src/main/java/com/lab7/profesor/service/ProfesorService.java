package com.lab7.profesor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lab7.profesor.dto.request.ProfesorRequest;
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
        return profesores.stream().filter(profesor -> profesor.getId().equals(id)).findFirst().orElse(null);
    }

    public List<ProfesorResponse> getProfesorByEspecialidad(Especialidad especialidad){
        return profesores.stream().filter(espe -> espe.getEspecialidad().equals(especialidad)).collect(Collectors.toList());
    }

    public ProfesorResponse crearProfesor(ProfesorRequest profesorbody){
        //se verifica que los campos no vengan vacios
        if(profesorbody.nombre()==null || profesorbody.apellido()==null || profesorbody.correo()==null
            || profesorbody.nombre().isBlank() || profesorbody.apellido().isBlank()){

                return null;
        }

        //se verifica que el correo venga en el formato correcto
        Pattern patron = Pattern.compile("/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$/");
        Matcher matcher = patron.matcher(profesorbody.correo());
        if(!matcher.find()){
            return null;
        }
        //se crea un nuevo profesor
        ProfesorResponse new_profesor = new ProfesorResponse(
            (long)(profesores.size()+1), 
            profesorbody.nombre(),
            profesorbody.apellido(),
            profesorbody.correo(),
            profesorbody.especialidad(),
            profesorbody.estado()
        );
        profesores.add(new_profesor);
        return new_profesor;
    }
}
