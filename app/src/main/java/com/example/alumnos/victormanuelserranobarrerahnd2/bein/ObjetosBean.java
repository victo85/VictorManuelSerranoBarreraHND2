package com.example.alumnos.victormanuelserranobarrerahnd2.bein;

import java.io.Serializable;

/**
 * Created by ALUMNOS on 10/03/2017.
 */

public class ObjetosBean  implements Serializable{
    private int image;
    private String nombre, descripcion;

    public ObjetosBean(int image, String nombre, String descripcion) {
        this.image = image;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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
