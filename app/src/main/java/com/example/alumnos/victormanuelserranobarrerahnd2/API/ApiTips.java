package com.example.alumnos.victormanuelserranobarrerahnd2.API;


import com.example.alumnos.victormanuelserranobarrerahnd2.bein.ResponseTip;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.ResponseTips;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.TipsBean;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiTips {

    private final String URL = "http://victorcev.hol.es/APIandroid/tips/";
    private OkHttpClient client;

    public ApiTips() {

        client = new OkHttpClient();

    }

    public ArrayList<TipsBean> getTips(){

        try {

            Request request = new Request.Builder()
                    .url(URL)
                    .build();

            Response response = client.newCall(request).execute();
            String json = response.body().string();
            ResponseTips responseTips = ResponseTips.fromJson(json);

            return responseTips.getTips();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public TipsBean getTip(int id){
        try {

            Request request = new Request.Builder()
                    .url(URL + id)
                    .build();

            Response response = client.newCall(request).execute();
            String json = response.body().string();
            ResponseTip responseTip = ResponseTip.fromJson(json);

            return responseTip.getTip();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}