package com.example.alumnos.victormanuelserranobarrerahnd2.bein;

import java.io.Serializable;

/**
 * Created by ALUMNOS on 10/03/2017.
 */

public class PersonajesBean implements Serializable{
    private int image;
    private String Nombre, descripcion, caracteristicas;

    public PersonajesBean(int image, String nombre, String descripcion, String caracteristicas) {
        this.image = image;
        Nombre = nombre;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
