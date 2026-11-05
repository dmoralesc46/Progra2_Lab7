package com.lab7.empleado.dto.response;

import com.lab7.empleado.entity.Especialidad;
import com.lab7.empleado.entity.Estado;

public class EmpleadoResponse {
    private Long id;
    private String nombre, apellido, correo;
    private Especialidad especialidad;
    private Estado estado;

    public EmpleadoResponse(Long id, String nombre, String apellido, String correo, Especialidad especialidad, Estado estado){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public Especialidad getEspecialidad(){
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad){
        this.especialidad = especialidad;
    }

    public Estado getEstado(){
        return estado;
    }

    public void setEstado(Estado estado){
        this.estado = estado;
    }
}
