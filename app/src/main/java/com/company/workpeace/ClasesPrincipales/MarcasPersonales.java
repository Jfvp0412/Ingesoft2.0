package com.company.workpeace.ClasesPrincipales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.company.workpeace.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MarcasPersonales extends AppCompatActivity {

    TextInputLayout marca1,marca2,marca3,marca4,marca5,marca6,marca7,marca8;
    TextInputLayout marcaA1,marcaA2,marcaA3,marcaA4,marcaA5,marcaA6,marcaA7,marcaA8;

    TextView ir,ir2,ir3,ir4,ir5,ir6,ir7,ir8;
    Button btnActualizarMarcas, btnActualizarFlex, btnActualizarSquats, btnActualizarPica,btnActualizarCrunch, btnActualizarTriceps;
    Button btnActualizarSupina, btnActualizarPared;

    ImageView devolver;


    DatabaseReference reference;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcas_personales);
        Intent intent = getIntent();
        ir = findViewById(R.id.act1);
        ir2 = findViewById(R.id.act2);
        ir3 = findViewById(R.id.act3);
        ir4 = findViewById(R.id.act4);
        ir5 = findViewById(R.id.act5);
        ir6 = findViewById(R.id.act6);
        ir7 = findViewById(R.id.act7);
        ir8 = findViewById(R.id.act8);
        devolver = findViewById(R.id.menu_icon);

        final String usuarios,correos,claves,nombres;

        Intent in = getIntent();
        usuarios = in.getStringExtra("usuario");
        correos = in.getStringExtra("email");
        claves = in.getStringExtra("clave");
        nombres = in.getStringExtra("nombre");



        btnActualizarMarcas = findViewById(R.id.btnActualizarMarcas);
        btnActualizarCrunch = findViewById(R.id.btnActualizarCrunch);
        btnActualizarFlex = findViewById(R.id.btnActualizarFlexiones);
        btnActualizarPared = findViewById(R.id.btnActualizarPared);
        btnActualizarPica = findViewById(R.id.btnActualizarPica);
        btnActualizarSquats = findViewById(R.id.btnActualizarSquats);
        btnActualizarTriceps = findViewById(R.id.btnActualizarTriceps);
        btnActualizarSupina = findViewById(R.id.btnActualizarSupina);
        usuario = intent.getStringExtra("usuario");
        reference = FirebaseDatabase.getInstance().getReference("Marcas");
        final Query checkUsuario = reference.orderByChild("usuario").equalTo(usuario);

        checkUsuario.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    //Toast.makeText(MarcasPersonales.this, ":llegue", Toast.LENGTH_SHORT).show();

                    final String cant1,cant2,cant3,cant4,cant5,cant6,cant7,cant8;
                    final String cantA1,cantA2,cantA3,cantA4,cantA5,cantA6,cantA7,cantA8;
                    cant1 = dataSnapshot.child(usuario).child("nuevaMarca1").getValue(String.class);
                    cant2 = dataSnapshot.child(usuario).child("nuevaMarca2").getValue(String.class);
                    cant3 = dataSnapshot.child(usuario).child("nuevaMarca3").getValue(String.class);
                    cant4 = dataSnapshot.child(usuario).child("nuevaMarca4").getValue(String.class);
                    cant5 = dataSnapshot.child(usuario).child("nuevaMarca5").getValue(String.class);
                    cant6 = dataSnapshot.child(usuario).child("nuevaMarca6").getValue(String.class);
                    cant7 = dataSnapshot.child(usuario).child("nuevaMarca7").getValue(String.class);
                    cant8 = dataSnapshot.child(usuario).child("nuevaMarca8").getValue(String.class);

                    cantA1 = dataSnapshot.child(usuario).child("marcaAnterior1").getValue(String.class);
                    cantA2 = dataSnapshot.child(usuario).child("marcaAnterior2").getValue(String.class);
                    cantA3 = dataSnapshot.child(usuario).child("marcaAnterior3").getValue(String.class);
                    cantA4 = dataSnapshot.child(usuario).child("marcaAnterior4").getValue(String.class);
                    cantA5 = dataSnapshot.child(usuario).child("marcaAnterior5").getValue(String.class);
                    cantA6 = dataSnapshot.child(usuario).child("marcaAnterior6").getValue(String.class);
                    cantA7 = dataSnapshot.child(usuario).child("marcaAnterior7").getValue(String.class);
                    cantA8 = dataSnapshot.child(usuario).child("marcaAnterior8").getValue(String.class);


                    mostrarMarcas(cant1,cant2,cant3,cant4,cant5,cant6,cant7,cant8,cantA1,cantA2,cantA3,cantA4,cantA5,cantA6,cantA7,cantA8);

                    actualizarDatos(cant1,cant2,cant3,cant4,cant5,cant6,cant7,cant8);


                }

                else{
                    Toast.makeText(MarcasPersonales.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reloj = new Intent(MarcasPersonales.this,RelojMarcasPersonales.class);
                reloj.putExtra("marca1","Flexiones");
                reloj.putExtra("marca2","Squats");
                reloj.putExtra("marca3","Flexiones En Pica");
                reloj.putExtra("marca4","Flexiones En Pica");
                reloj.putExtra("marca5","Triceps en silla");
                reloj.putExtra("marca6","Flexión Supina");
                reloj.putExtra("marca7","Flexiones en Pared");
                reloj.putExtra("marca8","Burpees");
                reloj.putExtra("usuario",usuario);
                reloj.putExtra("email",correos);
                reloj.putExtra("nombre",nombres);
                reloj.putExtra("clave",claves);


                reloj.putExtra("marca10",1);
                reloj.putExtra("marca11",2);
                reloj.putExtra("marca12",3);
                reloj.putExtra("marca13",4);
                reloj.putExtra("marca14",5);
                reloj.putExtra("marca15",6);
                reloj.putExtra("marca16",7);
                reloj.putExtra("marca17",8);
                startActivity(reloj);

            }
        });

        ir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reloj = new Intent(MarcasPersonales.this,RelojMarcasPersonales.class);
                reloj.putExtra("marca1","Flexiones");
                reloj.putExtra("marca2","Squats");
                reloj.putExtra("marca3","Flexiones En Pica");
                reloj.putExtra("marca4","Flexiones En Pica");
                reloj.putExtra("marca5","Triceps en silla");
                reloj.putExtra("marca6","Flexión Supina");
                reloj.putExtra("marca7","Flexiones en Pared");
                reloj.putExtra("marca8","Burpees");
                reloj.putExtra("usuario",usuario);
                reloj.putExtra("email",correos);
                reloj.putExtra("nombre",nombres);
                reloj.putExtra("clave",claves);


                reloj.putExtra("marca10",1);
                reloj.putExtra("marca11",2);
                reloj.putExtra("marca12",3);
                reloj.putExtra("marca13",4);
                reloj.putExtra("marca14",5);
                reloj.putExtra("marca15",6);
                reloj.putExtra("marca16",7);
                reloj.putExtra("marca17",8);
                startActivity(reloj);

            }
        });

        ir3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reloj = new Intent(MarcasPersonales.this,RelojMarcasPersonales.class);
                reloj.putExtra("marca1","Flexiones");
                reloj.putExtra("marca2","Squats");
                reloj.putExtra("marca3","Flexiones En Pica");
                reloj.putExtra("marca4","Flexiones En Pica");
                reloj.putExtra("marca5","Triceps en silla");
                reloj.putExtra("marca6","Flexión Supina");
                reloj.putExtra("marca7","Flexiones en Pared");
                reloj.putExtra("marca8","Burpees");
                reloj.putExtra("usuario",usuario);
                reloj.putExtra("email",correos);
                reloj.putExtra("nombre",nombres);
                reloj.putExtra("clave",claves);


                reloj.putExtra("marca10",1);
                reloj.putExtra("marca11",2);
                reloj.putExtra("marca12",3);
                reloj.putExtra("marca13",4);
                reloj.putExtra("marca14",5);
                reloj.putExtra("marca15",6);
                reloj.putExtra("marca16",7);
                reloj.putExtra("marca17",8);
                startActivity(reloj);

            }
        });

        ir4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reloj = new Intent(MarcasPersonales.this,RelojMarcasPersonales.class);
                reloj.putExtra("marca1","Flexiones");
                reloj.putExtra("marca2","Squats");
                reloj.putExtra("marca3","Flexiones En Pica");
                reloj.putExtra("marca4","Flexiones En Pica");
                reloj.putExtra("marca5","Triceps en silla");
                reloj.putExtra("marca6","Flexión Supina");
                reloj.putExtra("marca7","Flexiones en Pared");
                reloj.putExtra("marca8","Burpees");
                reloj.putExtra("usuario",usuario);
                reloj.putExtra("email",correos);
                reloj.putExtra("nombre",nombres);
                reloj.putExtra("clave",claves);


                reloj.putExtra("marca10",1);
                reloj.putExtra("marca11",2);
                reloj.putExtra("marca12",3);
                reloj.putExtra("marca13",4);
                reloj.putExtra("marca14",5);
                reloj.putExtra("marca15",6);
                reloj.putExtra("marca16",7);
                reloj.putExtra("marca17",8);
                startActivity(reloj);

            }
        });

        ir5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reloj = new Intent(MarcasPersonales.this,RelojMarcasPersonales.class);
                reloj.putExtra("marca1","Flexiones");
                reloj.putExtra("marca2","Squats");
                reloj.putExtra("marca3","Flexiones En Pica");
                reloj.putExtra("marca4","Flexiones En Pica");
                reloj.putExtra("marca5","Triceps en silla");
                reloj.putExtra("marca6","Flexión Supina");
                reloj.putExtra("marca7","Flexiones en Pared");
                reloj.putExtra("marca8","Burpees");
                reloj.putExtra("usuario",usuario);
                reloj.putExtra("email",correos);
                reloj.putExtra("nombre",nombres);
                reloj.putExtra("clave",claves);


                reloj.putExtra("marca10",1);
                reloj.putExtra("marca11",2);
                reloj.putExtra("marca12",3);
                reloj.putExtra("marca13",4);
                reloj.putExtra("marca14",5);
                reloj.putExtra("marca15",6);
                reloj.putExtra("marca16",7);
                reloj.putExtra("marca17",8);
                reloj.putExtra("email",correos);
                reloj.putExtra("nombre",nombres);
                reloj.putExtra("clave",claves);
                startActivity(reloj);

            }
        });

        ir6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reloj = new Intent(MarcasPersonales.this,RelojMarcasPersonales.class);
                reloj.putExtra("marca1","Flexiones");
                reloj.putExtra("marca2","Squats");
                reloj.putExtra("marca3","Flexiones En Pica");
                reloj.putExtra("marca4","Flexiones En Pica");
                reloj.putExtra("marca5","Triceps en silla");
                reloj.putExtra("marca6","Flexión Supina");
                reloj.putExtra("marca7","Flexiones en Pared");
                reloj.putExtra("marca8","Burpees");
                reloj.putExtra("usuario",usuario);
                reloj.putExtra("email",correos);
                reloj.putExtra("nombre",nombres);
                reloj.putExtra("clave",claves);


                reloj.putExtra("marca10",1);
                reloj.putExtra("marca11",2);
                reloj.putExtra("marca12",3);
                reloj.putExtra("marca13",4);
                reloj.putExtra("marca14",5);
                reloj.putExtra("marca15",6);
                reloj.putExtra("marca16",7);
                reloj.putExtra("marca17",8);
                reloj.putExtra("email",correos);
                reloj.putExtra("nombre",nombres);
                reloj.putExtra("clave",claves);
                startActivity(reloj);

            }
        });

        ir7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reloj = new Intent(MarcasPersonales.this,RelojMarcasPersonales.class);
                reloj.putExtra("marca1","Flexiones");
                reloj.putExtra("marca2","Squats");
                reloj.putExtra("marca3","Flexiones En Pica");
                reloj.putExtra("marca4","Flexiones En Pica");
                reloj.putExtra("marca5","Triceps en silla");
                reloj.putExtra("marca6","Flexión Supina");
                reloj.putExtra("marca7","Flexiones en Pared");
                reloj.putExtra("marca8","Burpees");
                reloj.putExtra("usuario",usuario);
                reloj.putExtra("email",correos);
                reloj.putExtra("nombre",nombres);
                reloj.putExtra("clave",claves);


                reloj.putExtra("marca10",1);
                reloj.putExtra("marca11",2);
                reloj.putExtra("marca12",3);
                reloj.putExtra("marca13",4);
                reloj.putExtra("marca14",5);
                reloj.putExtra("marca15",6);
                reloj.putExtra("marca16",7);
                reloj.putExtra("marca17",8);
                reloj.putExtra("email",correos);
                reloj.putExtra("nombre",nombres);
                reloj.putExtra("clave",claves);
                startActivity(reloj);

            }
        });

        ir8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reloj = new Intent(MarcasPersonales.this,RelojMarcasPersonales.class);
                reloj.putExtra("marca1","Flexiones");
                reloj.putExtra("marca2","Squats");
                reloj.putExtra("marca3","Flexiones En Pica");
                reloj.putExtra("marca4","Flexiones En Pica");
                reloj.putExtra("marca5","Triceps en silla");
                reloj.putExtra("marca6","Flexión Supina");
                reloj.putExtra("marca7","Flexiones en Pared");
                reloj.putExtra("marca8","Burpees");
                reloj.putExtra("usuario",usuario);
                reloj.putExtra("email",correos);
                reloj.putExtra("nombre",nombres);
                reloj.putExtra("clave",claves);

                reloj.putExtra("marca10",1);
                reloj.putExtra("marca11",2);
                reloj.putExtra("marca12",3);
                reloj.putExtra("marca13",4);
                reloj.putExtra("marca14",5);
                reloj.putExtra("marca15",6);
                reloj.putExtra("marca16",7);
                reloj.putExtra("marca17",8);
                startActivity(reloj);


            }
        });

        devolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver = new Intent(MarcasPersonales.this,PantallaMeditacion.class);
                volver.putExtra("email",correos);
                volver.putExtra("nombre",nombres);
                volver.putExtra("clave",claves);
                volver.putExtra("usuario",usuarios);

                startActivity(volver);
            }
        });



    }

    private void actualizarDatos(final String cant1,final String cant2,final String cant3,final String cant4
            ,final String cant5,final String cant6,final String cant7,final String cant8) {
        final String personal2,personal3,personal4,personal5,personal6,personal7,personal8;
        btnActualizarFlex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MarcasPersonales.this,":hola"+personal,Toast.LENGTH_LONG).show();
                if(!cant1.equals(marca1.getEditText().getText().toString())){
                    reference.child(usuario).child("nuevaMarca1").setValue(marca1.getEditText().getText().toString());
                    reference.child(usuario).child("marcaAnterior1").setValue(cant1);

                    Toast.makeText(MarcasPersonales.this,"Datos actualizados....",Toast.LENGTH_LONG).show();
                }
                marcaA1.getEditText().setText(cant1);
            }
        });
        btnActualizarSquats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cant2.equals(marca2.getEditText().getText().toString())){
                    Toast.makeText(MarcasPersonales.this,":SI ENTRA",Toast.LENGTH_LONG).show();
                    reference.child(usuario).child("nuevaMarca2").setValue(marca2.getEditText().getText().toString());
                    reference.child(usuario).child("marcaAnterior2").setValue(cant2);

                    Toast.makeText(MarcasPersonales.this,"Datos actualizados....",Toast.LENGTH_LONG).show();

                }
                marcaA2.getEditText().setText(cant2);
            }
        });
        btnActualizarPica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cant3.equals(marca3.getEditText().getText().toString())){
                    reference.child(usuario).child("nuevaMarca3").setValue(marca3.getEditText().getText().toString());
                    reference.child(usuario).child("marcaAnterior3").setValue(cant3);

                    Toast.makeText(MarcasPersonales.this,"Datos actualizados....",Toast.LENGTH_LONG).show();
                }
                marcaA3.getEditText().setText(cant3);
            }
        });
        btnActualizarCrunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cant4.equals(marca3.getEditText().getText().toString())){
                    reference.child(usuario).child("nuevaMarca4").setValue(marca4.getEditText().getText().toString());
                    reference.child(usuario).child("marcaAnterior4").setValue(cant4);

                    Toast.makeText(MarcasPersonales.this,"Datos actualizados....",Toast.LENGTH_LONG).show();

                }
                marcaA4.getEditText().setText(cant4);
            }
        });
        btnActualizarTriceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cant5.equals(marca2.getEditText().getText().toString())){
                    reference.child(usuario).child("nuevaMarca5").setValue(marca5.getEditText().getText().toString());
                    reference.child(usuario).child("marcaAnterior5").setValue(cant5);

                    Toast.makeText(MarcasPersonales.this,"Datos actualizados....",Toast.LENGTH_LONG).show();

                }
                marcaA5.getEditText().setText(cant5);
            }
        });
        btnActualizarSupina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cant6.equals(marca6.getEditText().getText().toString())){
                    reference.child(usuario).child("nuevaMarca6").setValue(marca6.getEditText().getText().toString());
                    reference.child(usuario).child("marcaAnterior6").setValue(cant6);

                    Toast.makeText(MarcasPersonales.this,"Datos actualizados....",Toast.LENGTH_LONG).show();
                }
                marcaA6.getEditText().setText(cant6);
            }
        });
        btnActualizarPared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cant7.equals(marca7.getEditText().getText().toString())){
                    reference.child(usuario).child("nuevaMarca7").setValue(marca7.getEditText().getText().toString());
                    reference.child(usuario).child("marcaAnterior7").setValue(cant7);

                    Toast.makeText(MarcasPersonales.this,"Datos actualizados....",Toast.LENGTH_LONG).show();
                }
                marcaA7.getEditText().setText(cant7);
            }
        });
        btnActualizarMarcas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cant8.equals(marca8.getEditText().getText().toString())){
                    reference.child(usuario).child("nuevaMarca8").setValue(marca8.getEditText().getText().toString());
                    reference.child(usuario).child("marcaAnterior8").setValue(cant8);

                    Toast.makeText(MarcasPersonales.this,"Datos actualizados....",Toast.LENGTH_LONG).show();
                }
                marcaA8.getEditText().setText(cant8);
            }
        });
    }


    private void mostrarMarcas(String cant1,String cant2, String cant3, String cant4, String cant5, String cant6 , String cant7, String cant8,
                               String cantA1,String cantA2, String cantA3, String cantA4, String cantA5, String cantA6 , String cantA7, String cantA8){
        marca1 = findViewById(R.id.marcad1);
        marca2 = findViewById(R.id.marcad2);
        marca3 = findViewById(R.id.marcad3);
        marca4 = findViewById(R.id.marcad4);
        marca5 = findViewById(R.id.marcad5);
        marca6 = findViewById(R.id.marcad6);
        marca7 = findViewById(R.id.marcad7);
        marca8 = findViewById(R.id.marcaD8);

        marcaA1 = findViewById(R.id.marca1);
        marcaA2 = findViewById(R.id.marca2);
        marcaA3 = findViewById(R.id.marca3);
        marcaA4 = findViewById(R.id.marca4);
        marcaA5 = findViewById(R.id.marca5);
        marcaA6 = findViewById(R.id.marca6);
        marcaA7 = findViewById(R.id.marca7);
        marcaA8 = findViewById(R.id.marca8);

        marca1.getEditText().setText(cant1);
        marca2.getEditText().setText(cant2);
        marca3.getEditText().setText(cant3);
        marca4.getEditText().setText(cant4);
        marca5.getEditText().setText(cant5);
        marca6.getEditText().setText(cant6);
        marca7.getEditText().setText(cant7);
        marca8.getEditText().setText(cant8);


        marcaA1.getEditText().setText(cantA1);
        marcaA2.getEditText().setText(cantA2);
        marcaA3.getEditText().setText(cantA3);
        marcaA4.getEditText().setText(cantA4);
        marcaA5.getEditText().setText(cantA5);
        marcaA6.getEditText().setText(cantA6);
        marcaA7.getEditText().setText(cantA7);
        marcaA8.getEditText().setText(cantA8);






    }






}