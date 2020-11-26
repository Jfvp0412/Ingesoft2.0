package com.company.workpeace.ClasesPrincipales;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.company.workpeace.ClasesAuxiliares.Firebase.BottomSheet;
import com.company.workpeace.R;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MisRutinas extends AppCompatActivity {

    TextView miRutina, miRutina2,miRutina3,miRutina4,miRutina5,miRutina6,miRutina7,miRutina8,miRutina9,miRutina10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_rutinas);
        miRutina = findViewById(R.id.TitulosMisRutinas);
        miRutina2 = findViewById(R.id.TitulosMisRutinas2);
        miRutina3 = findViewById(R.id.TitulosMisRutinas3);
        miRutina4 = findViewById(R.id.TitulosMisRutinas4);
        miRutina5 = findViewById(R.id.TitulosMisRutinas5);
        miRutina6 = findViewById(R.id.TitulosMisRutinas6);
        miRutina7 = findViewById(R.id.TitulosMisRutinas7);
        miRutina8 = findViewById(R.id.TitulosMisRutinas8);
        miRutina9 = findViewById(R.id.TitulosMisRutinas9);
        miRutina10 = findViewById(R.id.TitulosMisRutinas10);
        String personalizada;
        String verificar;

        int hola = 0;
        if(hola !=1){

            Toast.makeText(MisRutinas.this,":1111",Toast.LENGTH_LONG).show();
        }
        Toast.makeText(MisRutinas.this,":"+miRutina2.getText().toString(),Toast.LENGTH_LONG).show();


        Intent llega = getIntent();
        personalizada = llega.getStringExtra("personalizada");
        FloatingActionButton agregarRutina, editarRutina, eliminarRutina;

        agregarRutina = findViewById(R.id.agregarRutina);
        editarRutina = findViewById(R.id.editarRutina);
        eliminarRutina = findViewById(R.id.eliminarRutina);

        agregarRutina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(),"TAG");
            }
        });

        //Toast.makeText(MisRutinas.this,":"+miRutina2.getText().toString(),Toast.LENGTH_LONG).show();
        if(TextUtils.isEmpty(miRutina.getText().toString())){
            miRutina.setText(personalizada);

        }


        else if(miRutina2.getText().toString().equals("")){
            miRutina2.setText(personalizada);
            String sera;
            sera = miRutina2.getText().toString();
            hola = 1;


        }
        else if(TextUtils.isEmpty(miRutina3.getText().toString())){
            miRutina3.setText(personalizada);
        }
        else if(TextUtils.isEmpty(miRutina4.getText().toString())){
            miRutina4.setText(personalizada);
        }
        else if(TextUtils.isEmpty(miRutina5.getText().toString())){
            miRutina5.setText(personalizada);
        }
        else if(TextUtils.isEmpty(miRutina6.getText().toString())){
            miRutina6.setText(personalizada);
        }
        else if(TextUtils.isEmpty(miRutina7.getText().toString())){
            miRutina7.setText(personalizada);
        }
        else if(TextUtils.isEmpty(miRutina8.getText().toString())){
            miRutina8.setText(personalizada);
        }
        else if(TextUtils.isEmpty(miRutina9.getText().toString())){
            miRutina9.setText(personalizada);
        }
        else if(TextUtils.isEmpty(miRutina10.getText().toString())){
            miRutina10.setText(personalizada);
        }









    }
}