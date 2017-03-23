package com.example.alumnos.victormanuelserranobarrerahnd2;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumnos.victormanuelserranobarrerahnd2.bein.ObjetosBean;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.TipsBean;

public class TipsActivity extends AppCompatActivity {

        private TextView nombre, descripcion;
        private Button boton;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tips);
            nombre = (TextView) findViewById(R.id.nombre);
            descripcion = (TextView) findViewById(R.id.descripcion);
            boton = (Button) findViewById(R.id.compartir);
            Intent intent= getIntent();
            TipsBean tipsBean= (TipsBean) intent.getSerializableExtra("TIPS_KEY");
            nombre.setText(tipsBean.getNombre());
            descripcion.setText(tipsBean.getDescripcion());

        }
    }
