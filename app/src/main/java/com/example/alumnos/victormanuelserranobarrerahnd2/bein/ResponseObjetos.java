package com.example.alumnos.victormanuelserranobarrerahnd2.bein;

        import com.google.gson.Gson;

        import java.io.Serializable;
        import java.util.ArrayList;

/**
 * Created by ALUMNOS on 16/05/2017.
 */

public class ResponseObjetos implements Serializable{

    private int resultado;
    private ArrayList<ObjetosBean> objetos;

    public ResponseObjetos() {
    }

    public ResponseObjetos(int resultado, ArrayList<ObjetosBean> objetos) {
        this.resultado = resultado;
        this.objetos = objetos;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public ArrayList<ObjetosBean> getObjetos() {
        return objetos;
    }

    public void setObjetos(ArrayList<ObjetosBean> objetos) {
        this.objetos = objetos;
    }

    public static ResponseObjetos fromJson(String json){

        if(json != null && !json.isEmpty()){

            Gson gson = new Gson();
            return gson.fromJson(json, ResponseObjetos.class);

        }else{

            return new ResponseObjetos();

        }
    }

    public String toJson(){

        Gson gson = new Gson();
        return gson.toJson(this);

    }
}