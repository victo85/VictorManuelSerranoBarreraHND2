package com.example.alumnos.victormanuelserranobarrerahnd2.API;




import com.example.alumnos.victormanuelserranobarrerahnd2.bein.PersonajesBean;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.ResponsePersonaje;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.ResponsePersonajes;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiPersonajes {
    private final String URL = "\thttp://victorcev.hol.es/APIandroid/personajes/";
    private OkHttpClient client;

    public ApiPersonajes() {

        client = new OkHttpClient();

    }

    public ArrayList<PersonajesBean> getPersonajes(){

        try {

            Request request = new Request.Builder()
                    .url(URL)
                    .build();

            Response response = client.newCall(request).execute();
            String json = response.body().string();
            ResponsePersonajes responsePersonajes = ResponsePersonajes.fromJson(json);

            return responsePersonajes.getPersonajes();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public PersonajesBean getPersonaje(int id){
        try {

            Request request = new Request.Builder()
                    .url(URL + id)
                    .build();

            Response response = client.newCall(request).execute();
            String json = response.body().string();
            ResponsePersonaje responsePersonaje = ResponsePersonaje.fromJson(json);

            return responsePersonaje.getPersonaje();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}

