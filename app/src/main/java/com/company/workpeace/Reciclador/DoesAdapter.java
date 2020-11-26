package com.company.workpeace.Reciclador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.company.workpeace.ClasesAuxiliares.Firebase.MyDoesAux;
import com.company.workpeace.ClasesPrincipales.EditarMyDoes;
import com.company.workpeace.ClasesPrincipales.MyDoes;
import com.company.workpeace.R;

import java.util.ArrayList;

public class DoesAdapter extends RecyclerView.Adapter<DoesAdapter.MyViewHolder>{

    Context context;
    ArrayList<MyDoesAux> myDoes;



    public DoesAdapter(Context c, ArrayList<MyDoesAux> p) {
        context = c;
        myDoes = p;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_does,viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.titledoes.setText(myDoes.get(i).getTitulo());
        myViewHolder.descdoes.setText(myDoes.get(i).getDescripcion());
        myViewHolder.datedoes.setText(myDoes.get(i).getFecha());
        myViewHolder.dateHora.setText(myDoes.get(i).getHora());

        final String getTitleDoes = myDoes.get(i).getTitulo();
        final String getDescDoes = myDoes.get(i).getDescripcion();
        final String getDateDoes = myDoes.get(i).getFecha();
        final String getHoraDoes = myDoes.get(i).getHora();
        final String getKeyDoes = myDoes.get(i).getKeydoes();
        final String getUsuario = myDoes.get(i).getUsuario();


        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent aa = new Intent(context, EditarMyDoes.class);

                aa.putExtra("titledoes", getTitleDoes);
                aa.putExtra("descdoes", getDescDoes);
                aa.putExtra("datedoes", getDateDoes);
                aa.putExtra("keydoes", getKeyDoes);
                aa.putExtra("username", getUsuario);
                aa.putExtra("getHora", getHoraDoes);
                context.startActivity(aa);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myDoes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titledoes, descdoes, datedoes, keydoes, usuario, dateHora;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titledoes = (TextView) itemView.findViewById(R.id.titledoes);
            descdoes = (TextView) itemView.findViewById(R.id.descdoes);
            datedoes = (TextView) itemView.findViewById(R.id.datedoes);
            dateHora = (TextView) itemView.findViewById(R.id.dateLasHoras);
        }
    }

}
