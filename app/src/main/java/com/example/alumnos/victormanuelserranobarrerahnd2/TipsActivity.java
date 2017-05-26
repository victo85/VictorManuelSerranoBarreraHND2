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

import com.example.alumnos.victormanuelserranobarrerahnd2.API.ApiTips;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.ObjetosBean;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.TipsBean;

public class TipsActivity extends AppCompatActivity  implements View.OnClickListener {

        private TextView nombre, descripcion;
        private Button boton;
        private String textoCompartir;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tips);
            nombre = (TextView) findViewById(R.id.nombre);
            descripcion = (TextView) findViewById(R.id.descripcion);
            boton = (Button) findViewById(R.id.compartir);
            Intent intent= getIntent();
            TipsBean tipsBean= (TipsBean) intent.getSerializableExtra("TIPS_KEY");
            boton.setOnClickListener(this);
            textoCompartir=tipsBean.getDescripcion();
            nombre.setText(tipsBean.getNombre());
            descripcion.setText(tipsBean.getDescripcion());
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
    private class Hilo extends AsyncTask<Integer, Void, TipsBean> {

        @Override
        protected TipsBean doInBackground(Integer... args) {

            int id = args[0];
            ApiTips apiTips = new ApiTips();
            TipsBean tipsBean = apiTips.getTip(id);

            return tipsBean;
        }

        @Override
        protected void onPostExecute(TipsBean tipsBean) {
            super.onPostExecute(tipsBean);

            if(tipsBean == null){

                Toast.makeText(TipsActivity.this, "No se pudo realizar la petición", Toast.LENGTH_SHORT).show();

            }else{

                nombre.setText(tipsBean.getNombre());
                descripcion.setText(tipsBean.getDescripcion());

            }
        }
    }
}

