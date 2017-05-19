package com.example.alumnos.victormanuelserranobarrerahnd2.API;


import com.example.alumnos.victormanuelserranobarrerahnd2.bein.ObjetosBean;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.ResponseObjeto;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.ResponseObjetos;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiObjetos {

    private final String URL = "\thttp://victorcev.hol.es/APIandroid/objetos/";
    private OkHttpClient client;

    public ApiObjetos() {

        client = new OkHttpClient();

    }

    public ArrayList<ObjetosBean> getObjetos(){

        try {

            Request request = new Request.Builder()
                    .url(URL)
                    .build();

            Response response = client.newCall(request).execute();
            String json = response.body().string();
            ResponseObjetos responseObjetos = ResponseObjetos.fromJson(json);

            return responseObjetos.getObjetos();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ObjetosBean getObjeto(int id){
        try {

            Request request = new Request.Builder()
                    .url(URL + id)
                    .build();

            Response response = client.newCall(request).execute();
            String json = response.body().string();
            ResponseObjeto responseObjeto = ResponseObjeto.fromJson(json);

            return responseObjeto.getObjeto();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}