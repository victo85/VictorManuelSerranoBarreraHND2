package com.example.alumnos.victormanuelserranobarrerahnd2.bein;



        import com.google.gson.Gson;

        import java.io.Serializable;

/**
 * Created by ALUMNOS on 16/05/2017.
 */

public class ResponseObjeto implements Serializable{

    private int resultado;
    private ObjetosBean objeto;

    public ResponseObjeto() {
    }

    public ResponseObjeto(int resultado, ObjetosBean objeto) {
        this.resultado = resultado;
        this.objeto = objeto;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public ObjetosBean getObjeto() {
        return objeto;
    }

    public void setObjeto(ObjetosBean objeto) {
        this.objeto = objeto;
    }

    public static ResponseObjeto fromJson(String json){

        if(json != null && !json.isEmpty()){

            Gson gson = new Gson();
            return gson.fromJson(json, ResponseObjeto.class);

        }else{

            return new ResponseObjeto();

        }
    }

    public String toJson(){

        Gson gson = new Gson();
        return gson.toJson(this);

    }
}