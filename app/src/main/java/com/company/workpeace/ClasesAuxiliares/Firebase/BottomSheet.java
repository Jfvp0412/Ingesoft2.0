package com.company.workpeace.ClasesAuxiliares.Firebase;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.company.workpeace.ClasesPrincipales.MisRutinas;
import com.company.workpeace.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheet extends BottomSheetDialogFragment {

    public BottomSheet(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.agregar_rutina,container,false);


        Button agregar = view.findViewById(R.id.submitRutina);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nombreRutina = view.findViewById(R.id.NombreRutina);
                if(!TextUtils.isEmpty(nombreRutina.getText().toString())){
                    final String nombre = nombreRutina.getText().toString();
                    Intent miRutina = new Intent(getContext(),MisRutinas.class);
                    miRutina.putExtra("personalizada",nombre);
                    startActivity(miRutina);

                }

            }
        });
        return view;

    }



}
