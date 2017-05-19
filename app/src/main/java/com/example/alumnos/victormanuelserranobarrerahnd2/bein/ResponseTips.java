package com.example.alumnos.victormanuelserranobarrerahnd2.bein;

        import com.google.gson.Gson;

        import java.io.Serializable;
        import java.util.ArrayList;

/**
 * Created by ALUMNOS on 16/05/2017.
 */

public class ResponseTips implements Serializable{

    private int resultado;
    private ArrayList<TipsBean> tips;

    public ResponseTips() {
    }

    public ResponseTips(int resultado, ArrayList<TipsBean> tips) {
        this.resultado = resultado;
        this.tips = tips;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public ArrayList<TipsBean> getTips() {
        return tips;
    }

    public void setTips(ArrayList<TipsBean> tips) {
        this.tips = tips;
    }

    public static ResponseTips fromJson(String json){

        if(json != null && !json.isEmpty()){

            Gson gson = new Gson();
            return gson.fromJson(json, ResponseTips.class);

        }else{

            return new ResponseTips();

        }
    }

    public String toJson(){

        Gson gson = new Gson();
        return gson.toJson(this);

    }
}