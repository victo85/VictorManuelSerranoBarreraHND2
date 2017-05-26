package com.example.alumnos.victormanuelserranobarrerahnd2.bein;

import java.io.Serializable;


public class ObjetosBean implements Serializable{

    private int imagenObjetos;
    private String nombre, descripcion;

    public ObjetosBean() {

    }

    public ObjetosBean(int imagenObjeto, String nombre, String descripcion) {
        this.imagenObjetos = imagenObjeto;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getImagenObjetos() {
        return imagenObjetos;
    }

    public void setImagenObjetos(int imagenObjeto) {
        this.imagenObjetos = imagenObjeto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}