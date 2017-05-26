package com.example.alumnos.victormanuelserranobarrerahnd2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alumnos.victormanuelserranobarrerahnd2.API.ApiPersonajes;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.PersonajesBean;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.UsuarioBean;

public class PersonajeActivity extends AppCompatActivity implements View.OnClickListener{
private ImageView img;
    private TextView nombre, descripcion, caracteristicas;
    private Button boton;
    private String textoCompartir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje);
        img = (ImageView) findViewById(R.id.img);
        nombre = (TextView) findViewById(R.id.nombre);
        descripcion = (TextView) findViewById(R.id.descripcion);
        caracteristicas = (TextView) findViewById(R.id.caracteristicas);
        boton = (Button) findViewById(R.id.compartir);
        Intent intent= getIntent();
        PersonajesBean personajesBean= (PersonajesBean) intent.getSerializableExtra("PERSONAJE_KEY");
        nombre.setText(personajesBean.getNombre());
        descripcion.setText(personajesBean.getDescripcion());
        boton.setOnClickListener(this);
        textoCompartir=personajesBean.getDescripcion();
        caracteristicas.setText(personajesBean.getCaracteristicas());
        img.setImageDrawable(ContextCompat.getDrawable(this,personajesBean.getImage()));
        Hilo hilo = new Hilo();
        hilo.execute();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.compartir:
                Intent intentCompartir = new Intent(Intent.ACTION_SEND);
                intentCompartir.setType("text/plain");
                intentCompartir.putExtra(Intent.EXTRA_TEXT,textoCompartir);
                startActivity(Intent.createChooser(intentCompartir, "Compartir en..."));
                break;

        }

    }
    private class Hilo extends AsyncTask<Integer, Void, PersonajesBean> {

        @Override
        protected PersonajesBean doInBackground(Integer... args) {

            int id = args[0];
            ApiPersonajes apiPersonajes = new ApiPersonajes();
            PersonajesBean personajesBean = apiPersonajes.getPersonaje(id);

            return personajesBean;
        }

        @Override
        protected void onPostExecute(PersonajesBean personajeBean) {
            super.onPostExecute(personajeBean);

            if(personajeBean == null){

                Toast.makeText(PersonajeActivity.this, "No se pudo realizar la petición", Toast.LENGTH_SHORT).show();

            }else{

                nombre.setText(personajeBean.getNombre());
                descripcion.setText(personajeBean.getDescripcion());
                caracteristicas.setText(personajeBean.getCaracteristicas());
                img.setImageDrawable(ContextCompat.getDrawable(PersonajeActivity.this,personajeBean.getImage()));

            }

        }
    }

}


