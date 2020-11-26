package com.company.workpeace.ClasesPrincipales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.company.workpeace.R;
import com.company.workpeace.adapters.MensajeAdapter;
import com.company.workpeace.models.Mensaje;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.widget.TextView;

import java.util.ArrayList;

public class HistorialEjercicioActivity extends AppCompatActivity {
    TextView txtPecho,txtAbdomen,txtPierna,txtBrazo,txtEspalda,txtTotal;
    DatabaseReference baseDatos;
    String usuarios,correos,claves,nombres, pecho, abdomen,pierna, brazo, espalda, totalRut;
    int total;

    RecyclerView mRecyclerView;
    ArrayList <Mensaje> listaMensajes = new ArrayList<>();
    MensajeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        usuarios = intent.getStringExtra("usuario");
        correos = intent.getStringExtra("email");
        claves = intent.getStringExtra("clave");
        nombres = intent.getStringExtra("nombre");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_ejercicio);
        txtPecho = findViewById(R.id.textPecho);
        txtAbdomen = findViewById(R.id.textAbdomen);
        txtPierna = findViewById(R.id.textPierna);
        txtBrazo = findViewById(R.id.textBrazo);
        txtEspalda = findViewById(R.id.textEspalda);
        txtTotal = findViewById(R.id.textTotal);
        baseDatos = FirebaseDatabase.getInstance().getReference();
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerViewEjercicios);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                total = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                pecho = "Rutinas de pecho: "+ datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString();
                abdomen = "Rutinas de abdomen: " + datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString();
                pierna = "Rutinas de pierna: "+ datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString();
                brazo = "Rutinas de brazo: "+datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString();
                espalda = "Rutinas de espalda y hombro: "+datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString();
                totalRut = "Total de rutinas: "+ Integer.toString(total);
                txtPecho.setText(pecho);
                txtPierna.setText(pierna);
                txtAbdomen.setText(abdomen);
                txtBrazo.setText(brazo);
                txtEspalda.setText(espalda);
                txtTotal.setText(totalRut);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        getMensajesFromFirebase();
    }
    private void getMensajesFromFirebase()
    {
        baseDatos.child("HistorialWorkouts").child(usuarios).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    int cont = 0;
                    listaMensajes.clear();
                    for(int i = 1; i <= total; i++)
                    {
                        String nombreEjer = "Nombre de ejercicio: " + snapshot.child(String.valueOf(i)).child("Nombre ejercicio").getValue().toString();
                        String duracion = "Duración: " + snapshot.child(String.valueOf(i)).child("Duracion").getValue().toString();
                        String fecha = "Fecha: "+ snapshot.child(String.valueOf(i)).child("Fecha de realización").getValue().toString();
                        listaMensajes.add(new Mensaje(nombreEjer,fecha,duracion));
                    }
                    adapter = new MensajeAdapter(listaMensajes,R.layout.mensaje_ejercicios);
                    mRecyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}