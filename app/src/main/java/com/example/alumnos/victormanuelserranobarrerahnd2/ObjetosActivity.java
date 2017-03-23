package com.example.alumnos.victormanuelserranobarrerahnd2;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumnos.victormanuelserranobarrerahnd2.bein.ObjetosBean;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.PersonajesBean;

public class ObjetosActivity extends AppCompatActivity implements View.OnClickListener {

        private ImageView img;
        private TextView nombre, descripcion;
        private Button boton;

    private String textoCompartir;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_objetos);
            img = (ImageView) findViewById(R.id.img);
            nombre = (TextView) findViewById(R.id.nombre);
            descripcion = (TextView) findViewById(R.id.descripcion);
            boton = (Button) findViewById(R.id.compartir);
            Intent intent= getIntent();
            ObjetosBean objetosBean= (ObjetosBean) intent.getSerializableExtra("OBJETOS_KEY");
            nombre.setText(objetosBean.getNombre());
            descripcion.setText(objetosBean.getDescripcion());
            boton.setOnClickListener(this);
            img.setImageDrawable(ContextCompat.getDrawable(this,objetosBean.getImage()));

            textoCompartir=objetosBean.getDescripcion();
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
}
