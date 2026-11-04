package com.lab7.proveedor.dto.response;

import com.lab7.proveedor.entity.Categoria;
import com.lab7.proveedor.entity.Estado;

public class ProveedorResponse {
    private Long id;
    private String nombre, apellido, correo;
    private Categoria categoria;
    private Estado estado;

    public ProveedorResponse(Long id, String nombre, String apellido, String correo, Categoria categoria, Estado estado){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.categoria = categoria;
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

    public Categoria getCategoria(){
        return categoria;
    }

    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    public Estado getEstado(){
        return estado;
    }

    public void setEstado(Estado estado){
        this.estado = estado;
    }
}
