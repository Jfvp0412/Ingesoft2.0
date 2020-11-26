package com.company.workpeace.Reciclador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.company.workpeace.ClasesAuxiliares.Firebase.MiRutinaAux;
import com.company.workpeace.ClasesAuxiliares.Firebase.MyDoesAux;
import com.company.workpeace.ClasesPrincipales.EditarMyDoes;
import com.company.workpeace.ClasesPrincipales.EditarMyDoesRutina;
import com.company.workpeace.ClasesPrincipales.Rutinas;
import com.company.workpeace.R;

import java.util.ArrayList;

public class DoesAdapterRutinas extends RecyclerView.Adapter<DoesAdapterRutinas.MyViewHolder>{

    Context context;
    ArrayList<MiRutinaAux> myDoesRutina;



    public DoesAdapterRutinas(Context c, ArrayList<MiRutinaAux> p) {
        context = c;
        myDoesRutina = p;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_does_rutina,viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.titledoesRutina.setText(myDoesRutina.get(i).getNombre());
        //myViewHolder.descdoesRutina.setText(myDoesRutina.get(i).getDescripcion());
        myViewHolder.datedoesRutina.setText(myDoesRutina.get(i).getSeries());
        myViewHolder.dateHoraRutina.setText(myDoesRutina.get(i).getRepeticiones());

        final String getTitleDoesRutina = myDoesRutina.get(i).getNombre();
        final String getDescDoesRutina = myDoesRutina.get(i).getDescripcion();
        final String getSeriesRutina = myDoesRutina.get(i).getSeries();
        final String getRepsRutina = myDoesRutina.get(i).getRepeticiones();
        final String getKeyDoesRutina = myDoesRutina.get(i).getKeydoes();
        final String getUsuarioRutina = myDoesRutina.get(i).getUsuario();
        final int getNumero = myDoesRutina.get(i).getNumero();
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent aa = new Intent(context, EditarMyDoesRutina.class);

                aa.putExtra("titledoesRutina", getTitleDoesRutina);
                aa.putExtra("descdoesRutina", getDescDoesRutina);
                aa.putExtra("seriesRutina", getSeriesRutina);
                aa.putExtra("keydoesRutina", getKeyDoesRutina);
                aa.putExtra("usernameRutina", getUsuarioRutina);
                aa.putExtra("getRepsRutina", getRepsRutina);
                aa.putExtra("getNumero", getNumero);
                context.startActivity(aa);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myDoesRutina.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titledoesRutina, descdoesRutina, datedoesRutina, keydoes, usuario, dateHoraRutina, numero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titledoesRutina = (TextView) itemView.findViewById(R.id.titledoesRutina);
            //descdoesRutina = (TextView) itemView.findViewById(R.id.descdoesRutina);
            datedoesRutina = (TextView) itemView.findViewById(R.id.datedoesRutina);
            dateHoraRutina = (TextView) itemView.findViewById(R.id.dateLasHorasRutina);
        }
    }

}