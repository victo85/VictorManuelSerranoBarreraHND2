package com.example.alumnos.victormanuelserranobarrerahnd2.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alumnos.victormanuelserranobarrerahnd2.R;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.Preferencias;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.UsuarioBean;


public class PerfilFragment extends Fragment {

 private TextView nombre, apellidos, email;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_perfil, container, false);
        nombre= (TextView) view.findViewById(R.id.nombre);
        apellidos= (TextView) view.findViewById(R.id.apellidos);
        email= (TextView) view.findViewById(R.id.email);

        Preferencias preferencias = new Preferencias(getActivity());
        UsuarioBean usuarioBean= preferencias.getUsuario();
        nombre.setText("Nombre:"+usuarioBean.getNombre());
        apellidos.setText("Apellidos:"+usuarioBean.getApellidos());
        email.setText("E-mail:"+usuarioBean.getEmail());
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

    public static PerfilFragment newInstance() {
        return new PerfilFragment();
    }
}
