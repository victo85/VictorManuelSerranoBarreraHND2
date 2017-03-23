package com.example.alumnos.victormanuelserranobarrerahnd2.bein;

import com.google.gson.Gson;



public class UsuarioBean {
    private String apellidos, contraseña, email, nombre;


    public UsuarioBean(String apellidos, String contraseña, String email, String nombre) {
        this.apellidos = apellidos;
        this.contraseña = contraseña;
        this.email = email;
        this.nombre = nombre;
    }

    public UsuarioBean() {
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static UsuarioBean fromJson(String json){
        if(json!=null && !json.isEmpty()) {
            Gson gson = new Gson();
            return gson.fromJson(json, UsuarioBean.class);
        }else{
            return new UsuarioBean();
        }
    }
}