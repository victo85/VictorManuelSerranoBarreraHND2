package com.example.alumnos.victormanuelserranobarrerahnd2.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.alumnos.victormanuelserranobarrerahnd2.Adapter.ObjetosAdapter;
import com.example.alumnos.victormanuelserranobarrerahnd2.Adapter.PersonajesAdapter;
import com.example.alumnos.victormanuelserranobarrerahnd2.Modelo;
import com.example.alumnos.victormanuelserranobarrerahnd2.Modelo2;
import com.example.alumnos.victormanuelserranobarrerahnd2.ObjetosActivity;
import com.example.alumnos.victormanuelserranobarrerahnd2.PersonajeActivity;
import com.example.alumnos.victormanuelserranobarrerahnd2.R;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.ObjetosBean;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.PersonajesBean;

import java.util.ArrayList;


    public class ObjetosFragment extends Fragment implements AdapterView.OnItemClickListener {
        private ListView listobjetos;
        private ArrayList<ObjetosBean> objetos;
        private static final String OBJETOS_KEY = "OBJETOS_KEY";


        public ObjetosFragment() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_objetos, container, false);
            listobjetos = (ListView) view.findViewById(R.id.listaObjetos);
            objetos = Modelo2.getObjetos();
            ObjetosAdapter adapter = new ObjetosAdapter(getActivity(), R.layout.item_objetos, objetos);
            listobjetos.setAdapter(adapter);
            listobjetos.setOnItemClickListener(this);

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

        public static com.example.alumnos.victormanuelserranobarrerahnd2.Fragments.ObjetosFragment newInstance() {
            return new com.example.alumnos.victormanuelserranobarrerahnd2.Fragments.ObjetosFragment();

        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            ObjetosBean objetosBean = objetos.get(i);
            Intent intent = new Intent(getActivity(), ObjetosActivity.class);
            intent.putExtra(OBJETOS_KEY, objetosBean);
            startActivity(intent);
        }
    }
