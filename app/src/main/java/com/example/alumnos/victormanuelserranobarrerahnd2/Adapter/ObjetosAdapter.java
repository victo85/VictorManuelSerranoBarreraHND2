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
import com.example.alumnos.victormanuelserranobarrerahnd2.bein.PersonajesBean;

import java.util.List;

public class ObjetosAdapter extends ArrayAdapter<ObjetosBean>{
    private Context context;
    private int resource;
    private List<ObjetosBean> objects;

    public ObjetosAdapter(Context context, int resource, List<ObjetosBean> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource = resource;
        this.objects=objects;
    }

    class ViewHolder{
        TextView txtNombre;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if(view==null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(resource,null);
            viewHolder.txtNombre = (TextView) view.findViewById(R.id.txtNombre);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        ObjetosBean objetosBean = objects.get(position);

        viewHolder.txtNombre.setText(objetosBean.getNombre());
        return view;
    }
}
