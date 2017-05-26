package com.example.alumnos.victormanuelserranobarrerahnd2.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alumnos.victormanuelserranobarrerahnd2.API.ApiObjetos;
import com.example.alumnos.victormanuelserranobarrerahnd2.API.ApiPersonajes;
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

        public static ObjetosFragment newInstance() {//New instance: lo que nos permite inicializar y configurar una nuevo Fragment sin tener que llamar a su constructor y métodos setter adicionales.
            return new ObjetosFragment();

        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            ObjetosBean objetosBean = objetos.get(i);
            Intent intent = new Intent(getActivity(), ObjetosActivity.class);//Un Intent es un objeto que proporciona enlace de tiempo de ejecución entre componentes separados (como dos actividades).
            intent.putExtra(OBJETOS_KEY, objetosBean);
            startActivity(intent);
        }
        private class Hilo extends AsyncTask<Void, Void, ArrayList<ObjetosBean>> {

            @Override
            protected ArrayList<ObjetosBean> doInBackground(Void... voids) {
                ApiObjetos apiObjetos = new ApiObjetos();
                return apiObjetos.getObjetos();
            }

            @Override
            protected void onPostExecute(ArrayList<ObjetosBean> objetosBeen) {
                super.onPostExecute(objetosBeen);

                if(objetosBeen != null) {
                    objetos.clear();
                    objetos.addAll(objetosBeen);

                    ObjetosAdapter adapter = (ObjetosAdapter) listobjetos.getAdapter();
                    adapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(getActivity(),
                            "No se ha realizado la petición",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
    }



