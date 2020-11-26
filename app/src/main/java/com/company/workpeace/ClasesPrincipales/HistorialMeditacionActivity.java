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
import android.widget.TextView;

import java.util.ArrayList;

public class HistorialMeditacionActivity extends AppCompatActivity {
    TextView txtTotalMed;
    DatabaseReference baseDatos;
    RecyclerView mRecyclerView;
    int total = 0;
    String usuarios;
    ArrayList<Mensaje> listaMensajes = new ArrayList<>();
    MensajeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_meditacion);
        Intent intent = getIntent();
        usuarios = intent.getStringExtra("usuario");
        txtTotalMed = findViewById(R.id.textTotalMed);
        baseDatos = FirebaseDatabase.getInstance().getReference();
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerViewMeditaciones);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        baseDatos.child("Usuarios").child(usuarios).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                total = Integer.parseInt(snapshot.child("nMeditaciones").getValue().toString());
                txtTotalMed.setText("TOTAL DE SESIONES: " + String.valueOf(total));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        getMensajesFromFirebase();
    }
    private void getMensajesFromFirebase()
    {
        baseDatos.child("HistorialMeditaciones").child(usuarios).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    int cont = 0;
                    listaMensajes.clear();
                    for(int i = 1; i <= total; i++)
                    {
                        String nombreEjer = "Nombre de meditacion: " + snapshot.child(String.valueOf(i)).child("Nombre yoga").getValue().toString();
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