package com.company.workpeace.ClasesPrincipales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.company.workpeace.ClasesAuxiliares.Firebase.MyDoesAux;
import com.company.workpeace.R;
import com.company.workpeace.Reciclador.DoesAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyDoes extends AppCompatActivity {

    TextView titlepage, subtitlepage, endpage;
    Button btnAddNew;

    DatabaseReference reference;
    RecyclerView ourdoes;
    ArrayList<MyDoesAux> list;
    DoesAdapter doesAdapter;
    String usuario, nombre, clave, correo;
    DatabaseReference baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_does);
        String usuarios;
        Intent intent = getIntent();

        Intent in = getIntent();
        usuarios = in.getStringExtra("usuario");

        usuario = intent.getStringExtra("usuario");

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);
        endpage = findViewById(R.id.endpage);

        btnAddNew = findViewById(R.id.btnAddNew);
        baseDatos = FirebaseDatabase.getInstance().getReference();


        btnAddNew.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MyDoes.this, NewTaskAct.class);
                a.putExtra("usuario",usuario);
                startActivity(a);
            }
        });

        ourdoes = findViewById(R.id.ourdoes);
        ourdoes.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<MyDoesAux>();

        // get data from firebase
        reference = FirebaseDatabase.getInstance().getReference().child("DoesApp").child(usuario);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // set code to retrive data and replace layout
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    MyDoesAux p = dataSnapshot1.getValue(MyDoesAux.class);
                    list.add(p);
                }
                doesAdapter = new DoesAdapter(MyDoes.this, list);
                ourdoes.setAdapter(doesAdapter);
                doesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
            }

        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        baseDatos.child("Usuarios").child(usuario).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Intent home = new Intent(MyDoes.this,Init.class);
                nombre = snapshot.child("nombre").getValue().toString();
                clave = snapshot.child("clave").getValue().toString();
                correo = snapshot.child("email").getValue().toString();
                home.putExtra("usuario", usuario);
                home.putExtra("nombre", nombre);
                home.putExtra("clave", clave);
                home.putExtra("email", correo);
                startActivity(home);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}