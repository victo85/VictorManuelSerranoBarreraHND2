package com.example.alumnos.victormanuelserranobarrerahnd2.bein;


import java.io.Serializable;


    public class TipsBean  implements Serializable {
        private String nombre, descripcion;

        public TipsBean( String nombre, String descripcion) {

            this.nombre = nombre;
            this.descripcion = descripcion;
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


