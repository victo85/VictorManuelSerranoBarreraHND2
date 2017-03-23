package com.example.alumnos.victormanuelserranobarrerahnd2;


import com.example.alumnos.victormanuelserranobarrerahnd2.bein.TipsBean;

import java.util.ArrayList;

/**
 * Created by ALUMNOS on 16/03/2017.
 */

public class Modelo3 {

    public static ArrayList<TipsBean> getTips(){

        ArrayList<TipsBean> tips = new ArrayList<>();

        tips.add(new TipsBean( "Nuevas Naves","Dentro de poco tendreis la nuevas naves revolucionarias de el juego con mas hype de Play Store y App Store" ));
        tips.add(new TipsBean(  "Proxima actualización 3.0","En la proxima actualizacion recebireis una gran sorpresa con la nueva gama de graficos 4k para los moviles mas top y 1080 p para los moviles de media y baja gama"));
        tips.add(new TipsBean(  "App Actual 2.3","La version actual tiene un buen comportamiento en todas las versiones de android e IOS" ));


        return tips;

    }
}

