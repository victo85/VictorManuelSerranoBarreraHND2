package com.example.alumnos.victormanuelserranobarrerahnd2.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alumnos.victormanuelserranobarrerahnd2.R;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.ObjetosBean;
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.TipsBean;

import java.util.List;


    public class TipsAdapter extends ArrayAdapter<TipsBean> {
        private Context context;
        private int resource;
        private List<TipsBean> tips;

        public TipsAdapter(Context context, int resource, List<TipsBean> tips) {
            super(context, resource, tips);
            this.context = context;
            this.resource = resource;
            this.tips = tips;
        }

        class ViewHolder {
            TextView txtNombre;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            com.example.alumnos.victormanuelserranobarrerahnd2.Adapter.TipsAdapter.ViewHolder viewHolder;

            if (view == null) {
                viewHolder = new ViewHolder();
                view = LayoutInflater.from(context).inflate(resource, null);
                viewHolder.txtNombre = (TextView) view.findViewById(R.id.txtNombre);

                view.setTag(viewHolder);
            } else {
                viewHolder = (com.example.alumnos.victormanuelserranobarrerahnd2.Adapter.TipsAdapter.ViewHolder) view.getTag();
            }

            TipsBean tipsBean = tips.get(position);

            viewHolder.txtNombre.setText(tipsBean.getNombre());
            return view;
        }
    }