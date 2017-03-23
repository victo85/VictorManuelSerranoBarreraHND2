package com.example.alumnos.victormanuelserranobarrerahnd2;

import com.example.alumnos.victormanuelserranobarrerahnd2.bein.PersonajesBean;


import java.util.ArrayList;


public class Modelo {

    public static ArrayList<PersonajesBean> getPersonajes(){

        ArrayList<PersonajesBean> personajes = new ArrayList<>();

        personajes.add(new PersonajesBean( R.drawable.ultra_sonic_994_960_720, "Enemigo Ultrasonico","Enemigo equipado con un avion Ultrasonico" , "Velocidad endiablada, Gran armamento y Altamente Camuflada"));
        personajes.add(new PersonajesBean( R.drawable.avion_mil, "Enemigo UltraGrande","Enemigo equipado con un avion militar Extragrande" , "Velocidad normal, Gran armamento y Altamente Protegigo"));
        personajes.add(new PersonajesBean( R.drawable.principal, "Personaje principal","Enemigo equipado con una nave avanzada a su epoca de origen alienigena" , "Velocidad endiablada, Gran armamento y Altamente cualificada para destrozar a cualquier enemigo"));


        return personajes;

    }
}
