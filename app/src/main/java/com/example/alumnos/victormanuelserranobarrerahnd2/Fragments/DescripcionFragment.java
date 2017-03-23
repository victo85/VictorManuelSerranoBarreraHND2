package com.example.alumnos.victormanuelserranobarrerahnd2.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.alumnos.victormanuelserranobarrerahnd2.R;



public class DescripcionFragment extends Fragment implements View.OnClickListener{
    private TextView txtdescripcion;
    private Button compartir;
    private String descripcion;

    public DescripcionFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_descripcion, container, false);

        txtdescripcion = (TextView) view.findViewById(R.id.descripcion);
        compartir= (Button) view.findViewById(R.id.compartir);
        descripcion = "Estamos ante el juego de naves mas revolucionario de los ultimos años, estamos ante un juego con grafica 4k para moviles de alto rendimiento cosa que no tiene ningun juego, no mas anuncios en los juegos nuestro parner sois vosotros disfrutar de este gran juego y ¡MAAAAAAATAAAAR MATAAAAAAR Y DESTRUIR!";
        txtdescripcion.setText("Descripcion: " + descripcion);

        compartir.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    public static DescripcionFragment newInstance() {
        return new DescripcionFragment();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.compartir:
                Intent intentCompartir = new Intent(Intent.ACTION_SEND);
                intentCompartir.setType("text/plain");
                intentCompartir.putExtra(Intent.EXTRA_TEXT, descripcion);
                startActivity(Intent.createChooser(intentCompartir, "Compartir en..."));
                break;

        }
    }
}

