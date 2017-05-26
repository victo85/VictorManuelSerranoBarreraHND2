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
import android.widget.TextView;
import android.widget.Toast;


import com.example.alumnos.victormanuelserranobarrerahnd2.API.ApiTips;
import com.example.alumnos.victormanuelserranobarrerahnd2.Adapter.ObjetosAdapter;
import com.example.alumnos.victormanuelserranobarrerahnd2.Adapter.TipsAdapter;
import com.example.alumnos.victormanuelserranobarrerahnd2.Modelo2;
import com.example.alumnos.victormanuelserranobarrerahnd2.Modelo3;
import com.example.alumnos.victormanuelserranobarrerahnd2.R;
import com.example.alumnos.victormanuelserranobarrerahnd2.TipsActivity;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.ObjetosBean;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.TipsBean;

import java.util.ArrayList;


    public class TipsFragment extends Fragment implements AdapterView.OnItemClickListener {
        private ListView listTips;
        private ArrayList<TipsBean> tips;
        private static final String TIPS_KEY = "TIPS_KEY";


        public TipsFragment() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_tips, container, false);
            listTips = (ListView) view.findViewById(R.id.item_tips);
            tips = Modelo3.getTips();
            TipsAdapter adapter = new TipsAdapter(getActivity(), R.layout.item_tips, tips);
            listTips.setAdapter(adapter);
            listTips.setOnItemClickListener(this);

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

        public static com.example.alumnos.victormanuelserranobarrerahnd2.Fragments.TipsFragment newInstance() {
            return new com.example.alumnos.victormanuelserranobarrerahnd2.Fragments.TipsFragment();

        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            TipsBean tipsBean = tips.get(i);
            Intent intent = new Intent(getActivity(), TipsActivity.class);
            intent.putExtra(TIPS_KEY, tipsBean);
            startActivity(intent);
        }
        private class Hilo extends AsyncTask<Void, Void, ArrayList<TipsBean>> {

            @Override
            protected ArrayList<TipsBean> doInBackground(Void... voids) {
                ApiTips apiTips = new ApiTips();
                return apiTips.getTips();
            }

            @Override
            protected void onPostExecute(ArrayList<TipsBean> tipsBeen) {
                super.onPostExecute(tipsBeen);

                if(tipsBeen != null) {
                    tips.clear();
                    tips.addAll(tipsBeen);

                    TipsAdapter adapter = (TipsAdapter) listTips.getAdapter();
                    adapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(getActivity(),
                            "No se ha realizado la petición",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
    }
