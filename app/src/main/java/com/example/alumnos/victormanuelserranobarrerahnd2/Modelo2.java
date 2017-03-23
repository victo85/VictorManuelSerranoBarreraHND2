package com.example.alumnos.victormanuelserranobarrerahnd2;

import com.example.alumnos.victormanuelserranobarrerahnd2.bein.ObjetosBean;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.PersonajesBean;

import java.util.ArrayList;



public class Modelo2 {

        public static ArrayList<ObjetosBean> getObjetos(){

            ArrayList<ObjetosBean> objetos = new ArrayList<>();

            objetos.add(new ObjetosBean( R.drawable.misil, "Misil Atomico","Gran misil de una potencia debastadora, nadie quedara en pie." ));
            objetos.add(new ObjetosBean( R.drawable.metralleta, "Metralleta Ultrapesada","Ametralladora ultrapesada con un gran calibre"));
            objetos.add(new ObjetosBean( R.drawable.laser, "Laser de la muerte","Laser desintegrador que es capaz de acabar con la nave mas protegida" ));


            return objetos;

        }
    }