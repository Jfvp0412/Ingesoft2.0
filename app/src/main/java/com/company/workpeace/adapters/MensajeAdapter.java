package com.company.workpeace.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.company.workpeace.R;
import com.company.workpeace.models.Mensaje;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MensajeAdapter extends RecyclerView.Adapter <MensajeAdapter.ViewHolder>{
    int resource ;
    private ArrayList<Mensaje> mensajesList;
    public MensajeAdapter(ArrayList<Mensaje> mensajesList,int resource)
    {
        this.mensajesList = mensajesList;
        this.resource = resource;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //retorna la vista
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mensaje mensaje = mensajesList.get(position);
        holder.textViewMensaje.setText(mensaje.getNombreRutina());
        holder.textDuracion.setText(mensaje.getDuracion());
        holder.textFecha.setText(mensaje.getFecha());
    }

    @Override
    public int getItemCount() {
        return mensajesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textViewMensaje;
        private TextView textDuracion;
        private TextView textFecha;
        public View view;
        public ViewHolder(View view)
        {
            super(view);
            this.view= view;
            this.textViewMensaje = (TextView) view.findViewById(R.id.textViewMensaje);
            this.textDuracion = (TextView) view.findViewById(R.id.textDuracion);
            this.textFecha = (TextView) view.findViewById(R.id.textFecha);
        }
    }
}
