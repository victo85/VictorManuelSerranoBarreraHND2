package com.example.alumnos.victormanuelserranobarrerahnd2;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumnos.victormanuelserranobarrerahnd2.bein.PersonajesBean;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.UsuarioBean;

public class PersonajeActivity extends AppCompatActivity {
private ImageView img;
    private TextView nombre, descripcion, caracteristicas;
    private Button boton;
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
        caracteristicas.setText(personajesBean.getCaracteristicas());
        img.setImageDrawable(ContextCompat.getDrawable(this,personajesBean.getImage()));
    }
}
