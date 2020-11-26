package com.company.workpeace.ClasesPrincipales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.company.workpeace.ClasesAuxiliares.Firebase.Rutinas;
import com.company.workpeace.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class RutinasYoga extends AppCompatActivity {
    TextView ejercicio,ejercicio2,ejercicio3,ejercicio4,ejercicio5,ejercicio6,ejercicio7,ejercicio8, nombreRutina;
    FirebaseDatabase rutaMarcas;
    DatabaseReference referenciaMarcas;

    ImageView volver;

    TextView pose1,pose2,pose3,pose4,pose5,pose6,pose7,pose8;

    ImageView image1,image2,image3,image4,image5,image6,image7,image8;

    DatabaseReference referencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutinas_yoga);
        ejercicio = findViewById(R.id.pose1);
        ejercicio2 = findViewById(R.id.pose2);
        ejercicio3 = findViewById(R.id.pose3);
        ejercicio4 = findViewById(R.id.pose4);
        ejercicio5 = findViewById(R.id.pose5);
        ejercicio6 = findViewById(R.id.pose6);
        ejercicio7 = findViewById(R.id.pose7);
        ejercicio8 = findViewById(R.id.pose8);

        volver = findViewById(R.id.volverYoga);

        pose1 = findViewById(R.id.pose1Desc);
        pose2 = findViewById(R.id.pose2Desc);
        pose3 = findViewById(R.id.pose3Desc);
        pose4 = findViewById(R.id.pose4Desc);
        pose5 = findViewById(R.id.pose5Desc);
        pose6 = findViewById(R.id.pose6Desc);
        pose7 = findViewById(R.id.pose7Desc);
        pose8 = findViewById(R.id.pose8Desc);

        image1 = findViewById(R.id.imgYoga1);
        image2 = findViewById(R.id.imgYoga2);
        image3 = findViewById(R.id.imgYoga3);
        image4 = findViewById(R.id.imgYoga4);
        image5 = findViewById(R.id.imgYoga5);
        image6 = findViewById(R.id.imgYoga6);
        image7 = findViewById(R.id.imgYoga7);
        image8 = findViewById(R.id.imgYoga8);
        nombreRutina = findViewById(R.id.intropage);
        referencia = FirebaseDatabase.getInstance().getReference("Yoga");


        final String usuarios,correos,claves,nombres;

        Intent intent = getIntent();
        usuarios = intent.getStringExtra("usuario");
        correos = intent.getStringExtra("email");
        claves = intent.getStringExtra("clave");
        nombres = intent.getStringExtra("nombre");

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver = new Intent(RutinasYoga.this,Yoga.class);
                volver.putExtra("usuario",usuarios);
                volver.putExtra("email",correos);
                volver.putExtra("clave",claves);
                volver.putExtra("nombre",nombres);
                startActivity(volver);
            }
        });

        Intent recibir = getIntent();
        final String ejer1,ejer2,ejer3,ejer4,ejer5,ejer6,ejer7,ejer8,ejer9,nombre,tiempoTotal,tiempoPose;
        final String descYoga1,descYoga2,descYoga3,descYoga4,descYoga5,descYoga6,descYoga7,descYoga8;
        ejer1 = recibir.getStringExtra("yoga1");
        ejer2 = recibir.getStringExtra("yoga2");
        ejer3 = recibir.getStringExtra("yoga3");
        ejer4 = recibir.getStringExtra("yoga4");
        ejer5 = recibir.getStringExtra("yoga5");
        ejer6 = recibir.getStringExtra("yoga6");
        ejer7 = recibir.getStringExtra("yoga7");
        ejer8 = recibir.getStringExtra("yoga8");
        ejer9 = recibir.getStringExtra("yoga10");

        descYoga1 = recibir.getStringExtra("descYoga1");
        descYoga2 = recibir.getStringExtra("descYoga2");
        descYoga3 = recibir.getStringExtra("descYoga3");
        descYoga4 = recibir.getStringExtra("descYoga4");
        descYoga5 = recibir.getStringExtra("descYoga5");
        descYoga6 = recibir.getStringExtra("descYoga6");
        descYoga7 = recibir.getStringExtra("descYoga7");
        descYoga8 = recibir.getStringExtra("descYoga8");

        tiempoTotal = recibir.getStringExtra("tiempoTotal");
        tiempoPose = recibir.getStringExtra("tiempoPose");
        nombre = recibir.getStringExtra("tipoYoga1");
        final int tipoRutina = recibir.getIntExtra("yoga9",0);


        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            final int foto = bundle.getInt("imgYoga1");
            final int foto2 = bundle.getInt("imgYoga2");
            final int foto3 = bundle.getInt("imgYoga3");
            final int foto4 = bundle.getInt("imgYoga4");
            final int foto5 = bundle.getInt("imgYoga5");
            final int foto6 = bundle.getInt("imgYoga6");
            final int foto7 = bundle.getInt("imgYoga7");
            final int foto8 = bundle.getInt("imgYoga8");
            image1.setImageResource(foto);
            image2.setImageResource(foto2);
            image3.setImageResource(foto3);
            image4.setImageResource(foto4);
            image5.setImageResource(foto5);
            image6.setImageResource(foto6);
            image7.setImageResource(foto7);
            image8.setImageResource(foto8);

            pose1.setText(tiempoPose);
            pose2.setText(tiempoPose);
            pose3.setText(tiempoPose);
            pose4.setText(tiempoPose);
            pose5.setText(tiempoPose);
            pose6.setText(tiempoPose);
            pose7.setText(tiempoPose);
            pose8.setText(tiempoPose);

            ejercicio.setText(ejer1);
            ejercicio2.setText(ejer2);
            ejercicio3.setText(ejer3);
            ejercicio4.setText(ejer4);
            ejercicio5.setText(ejer5);
            ejercicio6.setText(ejer6);
            ejercicio7.setText(ejer7);
            ejercicio8.setText(ejer8);
            nombreRutina.setText(ejer9);



            ejercicio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent reloj = new Intent(RutinasYoga.this,EjercicioYoga.class);
                    reloj.putExtra("yoga9",tipoRutina);
                    reloj.putExtra("yoga1",ejer1);
                    reloj.putExtra("yoga2",ejer2);
                    reloj.putExtra("yoga3",ejer3);
                    reloj.putExtra("yoga4",ejer4);
                    reloj.putExtra("yoga5",ejer5);
                    reloj.putExtra("yoga6",ejer6);
                    reloj.putExtra("yoga7",ejer7);
                    reloj.putExtra("yoga8",ejer8);
                    reloj.putExtra("yoga10",ejer9);

                    reloj.putExtra("usuario",usuarios);
                    reloj.putExtra("email",correos);
                    reloj.putExtra("clave",claves);
                    reloj.putExtra("nombre",nombres);

                    reloj.putExtra("imgYoga1",foto);
                    reloj.putExtra("imgYoga2",foto2);
                    reloj.putExtra("imgYoga3",foto3);
                    reloj.putExtra("imgYoga4",foto4);
                    reloj.putExtra("imgYoga5",foto5);
                    reloj.putExtra("imgYoga6",foto6);
                    reloj.putExtra("imgYoga7",foto7);
                    reloj.putExtra("imgYoga8",foto8);

                    reloj.putExtra("descYoga1",descYoga1);
                    reloj.putExtra("descYoga2",descYoga2);
                    reloj.putExtra("descYoga3",descYoga3);
                    reloj.putExtra("descYoga4",descYoga4);
                    reloj.putExtra("descYoga5",descYoga5);
                    reloj.putExtra("descYoga6",descYoga6);
                    reloj.putExtra("descYoga7",descYoga7);
                    reloj.putExtra("descYoga8",descYoga8);

                    reloj.putExtra("thothYoga",1);

                    reloj.putExtra("tiempoPose",tiempoPose);
                    reloj.putExtra("tiempoTotal",tiempoTotal);
                    //reloj.putExtra("imgYoga1",foto);
                    startActivity(reloj);
                }
            });

            ejercicio2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent reloj2 = new Intent(RutinasYoga.this,EjercicioYoga.class);
                    reloj2.putExtra("yoga9",tipoRutina);
                    reloj2.putExtra("yoga1",ejer1);
                    reloj2.putExtra("yoga2",ejer2);
                    reloj2.putExtra("yoga3",ejer3);
                    reloj2.putExtra("yoga4",ejer4);
                    reloj2.putExtra("yoga5",ejer5);
                    reloj2.putExtra("yoga6",ejer6);
                    reloj2.putExtra("yoga7",ejer7);
                    reloj2.putExtra("yoga8",ejer8);
                    reloj2.putExtra("yoga10",ejer9);
                    reloj2.putExtra("imgYoga1",foto);
                    reloj2.putExtra("imgYoga2",foto2);
                    reloj2.putExtra("imgYoga3",foto3);
                    reloj2.putExtra("imgYoga4",foto4);
                    reloj2.putExtra("imgYoga5",foto5);
                    reloj2.putExtra("imgYoga6",foto6);
                    reloj2.putExtra("imgYoga7",foto7);
                    reloj2.putExtra("imgYoga8",foto8);

                    reloj2.putExtra("descYoga1",descYoga1);
                    reloj2.putExtra("descYoga2",descYoga2);
                    reloj2.putExtra("descYoga3",descYoga3);
                    reloj2.putExtra("descYoga4",descYoga4);
                    reloj2.putExtra("descYoga5",descYoga5);
                    reloj2.putExtra("descYoga6",descYoga6);
                    reloj2.putExtra("descYoga7",descYoga7);
                    reloj2.putExtra("descYoga8",descYoga8);

                    reloj2.putExtra("usuario",usuarios);
                    reloj2.putExtra("email",correos);
                    reloj2.putExtra("clave",claves);
                    reloj2.putExtra("nombre",nombres);
                    reloj2.putExtra("thothYoga",2);

                    startActivity(reloj2);
                }
            });

            ejercicio3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent reloj3 = new Intent(RutinasYoga.this,EjercicioYoga.class);
                    reloj3.putExtra("yoga9",tipoRutina);
                    reloj3.putExtra("yoga1",ejer1);
                    reloj3.putExtra("yoga2",ejer2);
                    reloj3.putExtra("yoga3",ejer3);
                    reloj3.putExtra("yoga4",ejer4);
                    reloj3.putExtra("yoga5",ejer5);
                    reloj3.putExtra("yoga6",ejer6);
                    reloj3.putExtra("yoga7",ejer7);
                    reloj3.putExtra("yoga8",ejer8);
                    reloj3.putExtra("yoga10",ejer9);
                    reloj3.putExtra("imgYoga1",foto);
                    reloj3.putExtra("imgYoga2",foto2);
                    reloj3.putExtra("imgYoga3",foto3);
                    reloj3.putExtra("imgYoga4",foto4);
                    reloj3.putExtra("imgYoga5",foto5);
                    reloj3.putExtra("imgYoga6",foto6);
                    reloj3.putExtra("imgYoga7",foto7);
                    reloj3.putExtra("imgYoga8",foto8);

                    reloj3.putExtra("usuario",usuarios);
                    reloj3.putExtra("email",correos);
                    reloj3.putExtra("clave",claves);
                    reloj3.putExtra("nombre",nombres);

                    reloj3.putExtra("descYoga1",descYoga1);
                    reloj3.putExtra("descYoga2",descYoga2);
                    reloj3.putExtra("descYoga3",descYoga3);
                    reloj3.putExtra("descYoga4",descYoga4);
                    reloj3.putExtra("descYoga5",descYoga5);
                    reloj3.putExtra("descYoga6",descYoga6);
                    reloj3.putExtra("descYoga7",descYoga7);
                    reloj3.putExtra("descYoga8",descYoga8);
                    reloj3.putExtra("thothYoga",3);
                    startActivity(reloj3);
                }
            });

            ejercicio4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent reloj4 = new Intent(RutinasYoga.this,EjercicioYoga.class);
                    reloj4.putExtra("yoga9",tipoRutina);
                    reloj4.putExtra("yoga1",ejer1);
                    reloj4.putExtra("yoga2",ejer2);
                    reloj4.putExtra("yoga3",ejer3);
                    reloj4.putExtra("yoga4",ejer4);
                    reloj4.putExtra("yoga5",ejer5);
                    reloj4.putExtra("yoga6",ejer6);
                    reloj4.putExtra("yoga7",ejer7);
                    reloj4.putExtra("yoga8",ejer8);
                    reloj4.putExtra("yoga10",ejer9);
                    reloj4.putExtra("imgYoga1",foto);
                    reloj4.putExtra("imgYoga2",foto2);
                    reloj4.putExtra("imgYoga3",foto3);
                    reloj4.putExtra("imgYoga4",foto4);
                    reloj4.putExtra("imgYoga5",foto5);
                    reloj4.putExtra("imgYoga6",foto6);
                    reloj4.putExtra("imgYoga7",foto7);
                    reloj4.putExtra("imgYoga8",foto8);

                    reloj4.putExtra("usuario",usuarios);
                    reloj4.putExtra("email",correos);
                    reloj4.putExtra("clave",claves);
                    reloj4.putExtra("nombre",nombres);
                    reloj4.putExtra("thothYoga",4);

                    reloj4.putExtra("descYoga1",descYoga1);
                    reloj4.putExtra("descYoga2",descYoga2);
                    reloj4.putExtra("descYoga3",descYoga3);
                    reloj4.putExtra("descYoga4",descYoga4);
                    reloj4.putExtra("descYoga5",descYoga5);
                    reloj4.putExtra("descYoga6",descYoga6);
                    reloj4.putExtra("descYoga7",descYoga7);
                    reloj4.putExtra("descYoga8",descYoga8);
                    startActivity(reloj4);
                }
            });

            ejercicio5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent reloj5 = new Intent(RutinasYoga.this,EjercicioYoga.class);
                    reloj5.putExtra("yoga9",tipoRutina);
                    reloj5.putExtra("yoga1",ejer1);
                    reloj5.putExtra("yoga2",ejer2);
                    reloj5.putExtra("yoga3",ejer3);
                    reloj5.putExtra("yoga4",ejer4);
                    reloj5.putExtra("yoga5",ejer5);
                    reloj5.putExtra("yoga6",ejer6);
                    reloj5.putExtra("yoga7",ejer7);
                    reloj5.putExtra("yoga8",ejer8);
                    reloj5.putExtra("yoga10",ejer9);
                    reloj5.putExtra("imgYoga1",foto);
                    reloj5.putExtra("imgYoga2",foto2);
                    reloj5.putExtra("imgYoga3",foto3);
                    reloj5.putExtra("imgYoga4",foto4);
                    reloj5.putExtra("imgYoga5",foto5);
                    reloj5.putExtra("imgYoga6",foto6);
                    reloj5.putExtra("imgYoga7",foto7);
                    reloj5.putExtra("imgYoga8",foto8);

                    reloj5.putExtra("thothYoga",5);

                    reloj5.putExtra("descYoga1",descYoga1);
                    reloj5.putExtra("descYoga2",descYoga2);
                    reloj5.putExtra("descYoga3",descYoga3);
                    reloj5.putExtra("descYoga4",descYoga4);
                    reloj5.putExtra("descYoga5",descYoga5);
                    reloj5.putExtra("descYoga6",descYoga6);
                    reloj5.putExtra("descYoga7",descYoga7);
                    reloj5.putExtra("descYoga8",descYoga8);

                    reloj5.putExtra("usuario",usuarios);
                    reloj5.putExtra("email",correos);
                    reloj5.putExtra("clave",claves);
                    reloj5.putExtra("nombre",nombres);
                    startActivity(reloj5);
                }
            });

            ejercicio6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent reloj6 = new Intent(RutinasYoga.this,EjercicioYoga.class);
                    reloj6.putExtra("yoga9",tipoRutina);
                    reloj6.putExtra("yoga1",ejer1);
                    reloj6.putExtra("yoga2",ejer2);
                    reloj6.putExtra("yoga3",ejer3);
                    reloj6.putExtra("yoga4",ejer4);
                    reloj6.putExtra("yoga5",ejer5);
                    reloj6.putExtra("yoga6",ejer6);
                    reloj6.putExtra("yoga7",ejer7);
                    reloj6.putExtra("yoga8",ejer8);
                    reloj6.putExtra("yoga10",ejer9);
                    reloj6.putExtra("imgYoga1",foto);
                    reloj6.putExtra("imgYoga2",foto2);
                    reloj6.putExtra("imgYoga3",foto3);
                    reloj6.putExtra("imgYoga4",foto4);
                    reloj6.putExtra("imgYoga5",foto5);
                    reloj6.putExtra("imgYoga6",foto6);
                    reloj6.putExtra("imgYoga7",foto7);
                    reloj6.putExtra("imgYoga8",foto8);

                    reloj6.putExtra("descYoga1",descYoga1);
                    reloj6.putExtra("descYoga2",descYoga2);
                    reloj6.putExtra("descYoga3",descYoga3);
                    reloj6.putExtra("descYoga4",descYoga4);
                    reloj6.putExtra("descYoga5",descYoga5);
                    reloj6.putExtra("descYoga6",descYoga6);
                    reloj6.putExtra("descYoga7",descYoga7);
                    reloj6.putExtra("descYoga8",descYoga8);

                    reloj6.putExtra("usuario",usuarios);
                    reloj6.putExtra("email",correos);
                    reloj6.putExtra("clave",claves);
                    reloj6.putExtra("nombre",nombres);

                    reloj6.putExtra("thothYoga",6);
                    startActivity(reloj6);
                }
            });

            ejercicio7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent reloj7 = new Intent(RutinasYoga.this,EjercicioYoga.class);
                    reloj7.putExtra("yoga9",tipoRutina);
                    reloj7.putExtra("yoga1",ejer1);
                    reloj7.putExtra("yoga2",ejer2);
                    reloj7.putExtra("yoga3",ejer3);
                    reloj7.putExtra("yoga4",ejer4);
                    reloj7.putExtra("yoga5",ejer5);
                    reloj7.putExtra("yoga6",ejer6);
                    reloj7.putExtra("yoga7",ejer7);
                    reloj7.putExtra("yoga8",ejer8);
                    reloj7.putExtra("yoga10",ejer9);
                    reloj7.putExtra("imgYoga1",foto);
                    reloj7.putExtra("imgYoga2",foto2);
                    reloj7.putExtra("imgYoga3",foto3);
                    reloj7.putExtra("imgYoga4",foto4);
                    reloj7.putExtra("imgYoga5",foto5);
                    reloj7.putExtra("imgYoga6",foto6);
                    reloj7.putExtra("imgYoga7",foto7);
                    reloj7.putExtra("imgYoga8",foto8);

                    reloj7.putExtra("descYoga1",descYoga1);
                    reloj7.putExtra("descYoga2",descYoga2);
                    reloj7.putExtra("descYoga3",descYoga3);
                    reloj7.putExtra("descYoga4",descYoga4);
                    reloj7.putExtra("descYoga5",descYoga5);
                    reloj7.putExtra("descYoga6",descYoga6);
                    reloj7.putExtra("descYoga7",descYoga7);
                    reloj7.putExtra("descYoga8",descYoga8);

                    reloj7.putExtra("usuario",usuarios);
                    reloj7.putExtra("email",correos);
                    reloj7.putExtra("clave",claves);
                    reloj7.putExtra("nombre",nombres);

                    reloj7.putExtra("thothYoga",7);
                    startActivity(reloj7);
                }
            });

            ejercicio8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent reloj8 = new Intent(RutinasYoga.this,EjercicioYoga.class);
                    reloj8.putExtra("yoga9",tipoRutina);
                    reloj8.putExtra("yoga1",ejer1);
                    reloj8.putExtra("yoga2",ejer2);
                    reloj8.putExtra("yoga3",ejer3);
                    reloj8.putExtra("yoga4",ejer4);
                    reloj8.putExtra("yoga5",ejer5);
                    reloj8.putExtra("yoga6",ejer6);
                    reloj8.putExtra("yoga7",ejer7);
                    reloj8.putExtra("yoga8",ejer8);
                    reloj8.putExtra("yoga10",ejer9);
                    reloj8.putExtra("imgYoga1",foto);
                    reloj8.putExtra("imgYoga2",foto2);
                    reloj8.putExtra("imgYoga3",foto3);
                    reloj8.putExtra("imgYoga4",foto4);
                    reloj8.putExtra("imgYoga5",foto5);
                    reloj8.putExtra("imgYoga6",foto6);
                    reloj8.putExtra("imgYoga7",foto7);
                    reloj8.putExtra("imgYoga8",foto8);

                    reloj8.putExtra("descYoga1",descYoga1);
                    reloj8.putExtra("descYoga2",descYoga2);
                    reloj8.putExtra("descYoga3",descYoga3);
                    reloj8.putExtra("descYoga4",descYoga4);
                    reloj8.putExtra("descYoga5",descYoga5);
                    reloj8.putExtra("descYoga6",descYoga6);
                    reloj8.putExtra("descYoga7",descYoga7);
                    reloj8.putExtra("descYoga8",descYoga8);

                    reloj8.putExtra("usuario",usuarios);
                    reloj8.putExtra("email",correos);
                    reloj8.putExtra("clave",claves);
                    reloj8.putExtra("nombre",nombres);

                    reloj8.putExtra("thothYoga",8);
                    startActivity(reloj8);
                }
            });
        }







    }




}