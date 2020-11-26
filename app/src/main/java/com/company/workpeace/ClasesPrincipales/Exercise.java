package com.company.workpeace.ClasesPrincipales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.company.workpeace.R;

public class Exercise extends AppCompatActivity {

    TextView ejercicio,ejercicio2,ejercicio3,ejercicio4,ejercicio5,ejercicio6,introPgage;
    ImageView img1,img2,img3,img4,img5,img6;

    ImageView volver;

    TextView descrp1,descrp2,descrp3,descrp4,descrp5,descrp6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        Intent recibir = getIntent();
        ejercicio = findViewById(R.id.ejer1);
        ejercicio2 = findViewById(R.id.ejer2);
        ejercicio3 = findViewById(R.id.ejer3);
        ejercicio4 = findViewById(R.id.ejer4);
        ejercicio5 = findViewById(R.id.ejer5);
        ejercicio6 = findViewById(R.id.ejer6);
        descrp1 = findViewById(R.id.fitonedesc);
        descrp2 = findViewById(R.id.fittwodesc);
        descrp3 = findViewById(R.id.fitthreedesc);
        descrp4 = findViewById(R.id.fitfourdesc);
        descrp5 = findViewById(R.id.fit5desc);
        descrp6 = findViewById(R.id.fit6desc);
        introPgage = findViewById(R.id.intropage);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);

        final String usuarios,correos,claves,nombres;

        Intent intent = getIntent();
        usuarios = intent.getStringExtra("usuario");
        correos = intent.getStringExtra("email");
        claves = intent.getStringExtra("clave");
        nombres = intent.getStringExtra("nombre");

        volver = findViewById(R.id.volverEjer);
        final String ejer1,ejer2,ejer3,ejer4,ejer5,ejer6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                ,tiempo5,tiempo6;
        ejer1 = recibir.getStringExtra("eje1");
        ejer2 = recibir.getStringExtra("eje2");
        ejer3 = recibir.getStringExtra("eje3");
        ejer4 = recibir.getStringExtra("eje4");
        ejer5 = recibir.getStringExtra("eje5");
        ejer6 = recibir.getStringExtra("eje6");

        desc1 = recibir.getStringExtra("desc1");
        desc2 = recibir.getStringExtra("desc2");
        desc3 = recibir.getStringExtra("desc3");
        desc4 = recibir.getStringExtra("desc4");
        desc5 = recibir.getStringExtra("desc5");
        desc6 = recibir.getStringExtra("desc6");

        tiempo1 = recibir.getStringExtra("cant1");
        tiempo2 = recibir.getStringExtra("cant2");
        tiempo3 = recibir.getStringExtra("cant3");
        tiempo4 = recibir.getStringExtra("cant4");
        tiempo5 = recibir.getStringExtra("cant5");
        tiempo6 = recibir.getStringExtra("cant6");
        final int tipoRutina = recibir.getIntExtra("rut1",0);
        final String rutNombre = recibir.getStringExtra("rutNombre");
        //Toast.makeText(Exercise.this, ":"+ejer1, Toast.LENGTH_SHORT).show();

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            final int imgEjer = bundle.getInt("imgWorkout1");
            final int imgEjer2 = bundle.getInt("imgWorkout2");
            final int imgEjer3 = bundle.getInt("imgWorkout3");
            final int imgEjer4 = bundle.getInt("imgWorkout4");
            final int imgEjer5 = bundle.getInt("imgWorkout5");
            final int imgEjer6 = bundle.getInt("imgWorkout6");

            img1.setImageResource(imgEjer);
            img2.setImageResource(imgEjer2);
            img3.setImageResource(imgEjer3);
            img4.setImageResource(imgEjer4);
            img5.setImageResource(imgEjer5);
            img6.setImageResource(imgEjer6);
            introPgage.setText(rutNombre);
            ejercicio.setText(ejer1);
            ejercicio2.setText(ejer2);
            ejercicio3.setText(ejer3);
            ejercicio4.setText(ejer4);
            ejercicio5.setText(ejer5);
            ejercicio6.setText(ejer6);

            descrp1.setText(tiempo1);
            descrp2.setText(tiempo2);
            descrp3.setText(tiempo3);
            descrp4.setText(tiempo4);
            descrp5.setText(tiempo5);
            descrp6.setText(tiempo6);

            ejercicio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent reloj = new Intent(Exercise.this,SeriesSets.class);
                    reloj.putExtra("eje1",ejer1);
                    reloj.putExtra("eje2",ejer2);
                    reloj.putExtra("eje3",ejer3);
                    reloj.putExtra("eje4",ejer4);
                    reloj.putExtra("eje5",ejer5);
                    reloj.putExtra("eje6",ejer6);
                    reloj.putExtra("usuario",usuarios);
                    reloj.putExtra("email",correos);
                    reloj.putExtra("clave",claves);
                    reloj.putExtra("nombre",nombres);

                    reloj.putExtra("desc1",desc1);
                    reloj.putExtra("desc2",desc2);
                    reloj.putExtra("desc3",desc3);
                    reloj.putExtra("desc4",desc4);
                    reloj.putExtra("desc5",desc5);
                    reloj.putExtra("desc6",desc6);

                    reloj.putExtra("cant1",tiempo1);
                    reloj.putExtra("cant2",tiempo2);
                    reloj.putExtra("cant3",tiempo3);
                    reloj.putExtra("cant4",tiempo4);
                    reloj.putExtra("cant5",tiempo5);
                    reloj.putExtra("cant6",tiempo6);

                    reloj.putExtra("tipoEjer",1);

                    reloj.putExtra("rut1",tipoRutina);
                    reloj.putExtra("rutNombre",rutNombre);
                    reloj.putExtra("imgWorkout1",imgEjer);
                    reloj.putExtra("imgWorkout2",imgEjer2);
                    reloj.putExtra("imgWorkout3",imgEjer3);
                    reloj.putExtra("imgWorkout4",imgEjer4);
                    reloj.putExtra("imgWorkout5",imgEjer5);
                    reloj.putExtra("imgWorkout6",imgEjer6);
                    startActivity(reloj);
                }
            });

            ejercicio2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent reloj = new Intent(Exercise.this,SeriesSets.class);
                    reloj.putExtra("eje1",ejer1);
                    reloj.putExtra("eje2",ejer2);
                    reloj.putExtra("eje3",ejer3);
                    reloj.putExtra("eje4",ejer4);
                    reloj.putExtra("eje5",ejer5);
                    reloj.putExtra("eje6",ejer6);

                    reloj.putExtra("desc1",desc1);
                    reloj.putExtra("desc2",desc2);
                    reloj.putExtra("desc3",desc3);
                    reloj.putExtra("desc4",desc4);
                    reloj.putExtra("desc5",desc5);
                    reloj.putExtra("desc6",desc6);

                    reloj.putExtra("cant1",tiempo1);
                    reloj.putExtra("cant2",tiempo2);
                    reloj.putExtra("cant3",tiempo3);
                    reloj.putExtra("cant4",tiempo4);
                    reloj.putExtra("cant5",tiempo5);
                    reloj.putExtra("cant6",tiempo6);

                    reloj.putExtra("usuario",usuarios);
                    reloj.putExtra("email",correos);
                    reloj.putExtra("clave",claves);
                    reloj.putExtra("nombre",nombres);

                    reloj.putExtra("tipoEjer",2);

                    reloj.putExtra("rut1",tipoRutina);
                    reloj.putExtra("rutNombre",rutNombre);
                    reloj.putExtra("imgWorkout1",imgEjer);
                    reloj.putExtra("imgWorkout2",imgEjer2);
                    reloj.putExtra("imgWorkout3",imgEjer3);
                    reloj.putExtra("imgWorkout4",imgEjer4);
                    reloj.putExtra("imgWorkout5",imgEjer5);
                    reloj.putExtra("imgWorkout6",imgEjer6);
                    startActivity(reloj);
                }
            });

            ejercicio3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent reloj = new Intent(Exercise.this,SeriesSets.class);
                    reloj.putExtra("eje1",ejer1);
                    reloj.putExtra("eje2",ejer2);
                    reloj.putExtra("eje3",ejer3);
                    reloj.putExtra("eje4",ejer4);
                    reloj.putExtra("eje5",ejer5);
                    reloj.putExtra("eje6",ejer6);

                    reloj.putExtra("desc1",desc1);
                    reloj.putExtra("desc2",desc2);
                    reloj.putExtra("desc3",desc3);
                    reloj.putExtra("desc4",desc4);
                    reloj.putExtra("desc5",desc5);
                    reloj.putExtra("desc6",desc6);

                    reloj.putExtra("cant1",tiempo1);
                    reloj.putExtra("cant2",tiempo2);
                    reloj.putExtra("cant3",tiempo3);
                    reloj.putExtra("cant4",tiempo4);
                    reloj.putExtra("cant5",tiempo5);
                    reloj.putExtra("cant6",tiempo6);

                    reloj.putExtra("usuario",usuarios);
                    reloj.putExtra("email",correos);
                    reloj.putExtra("clave",claves);
                    reloj.putExtra("nombre",nombres);

                    reloj.putExtra("tipoEjer",3);

                    reloj.putExtra("rut1",tipoRutina);
                    reloj.putExtra("rutNombre",rutNombre);
                    reloj.putExtra("imgWorkout1",imgEjer);
                    reloj.putExtra("imgWorkout2",imgEjer2);
                    reloj.putExtra("imgWorkout3",imgEjer3);
                    reloj.putExtra("imgWorkout4",imgEjer4);
                    reloj.putExtra("imgWorkout5",imgEjer5);
                    reloj.putExtra("imgWorkout6",imgEjer6);
                    startActivity(reloj);
                }
            });

            ejercicio4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent reloj = new Intent(Exercise.this,SeriesSets.class);
                    reloj.putExtra("eje1",ejer1);
                    reloj.putExtra("eje2",ejer2);
                    reloj.putExtra("eje3",ejer3);
                    reloj.putExtra("eje4",ejer4);
                    reloj.putExtra("eje5",ejer5);
                    reloj.putExtra("eje6",ejer6);

                    reloj.putExtra("desc1",desc1);
                    reloj.putExtra("desc2",desc2);
                    reloj.putExtra("desc3",desc3);
                    reloj.putExtra("desc4",desc4);
                    reloj.putExtra("desc5",desc5);
                    reloj.putExtra("desc6",desc6);

                    reloj.putExtra("cant1",tiempo1);
                    reloj.putExtra("cant2",tiempo2);
                    reloj.putExtra("cant3",tiempo3);
                    reloj.putExtra("cant4",tiempo4);
                    reloj.putExtra("cant5",tiempo5);
                    reloj.putExtra("cant6",tiempo6);

                    reloj.putExtra("usuario",usuarios);
                    reloj.putExtra("email",correos);
                    reloj.putExtra("clave",claves);
                    reloj.putExtra("nombre",nombres);

                    reloj.putExtra("tipoEjer",4);

                    reloj.putExtra("rut1",tipoRutina);
                    reloj.putExtra("rutNombre",rutNombre);
                    reloj.putExtra("imgWorkout1",imgEjer);
                    reloj.putExtra("imgWorkout2",imgEjer2);
                    reloj.putExtra("imgWorkout3",imgEjer3);
                    reloj.putExtra("imgWorkout4",imgEjer4);
                    reloj.putExtra("imgWorkout5",imgEjer5);
                    reloj.putExtra("imgWorkout6",imgEjer6);
                    startActivity(reloj);
                }
            });

            ejercicio5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent reloj = new Intent(Exercise.this,SeriesSets.class);
                    reloj.putExtra("eje1",ejer1);
                    reloj.putExtra("eje2",ejer2);
                    reloj.putExtra("eje3",ejer3);
                    reloj.putExtra("eje4",ejer4);
                    reloj.putExtra("eje5",ejer5);
                    reloj.putExtra("eje6",ejer6);

                    reloj.putExtra("desc1",desc1);
                    reloj.putExtra("desc2",desc2);
                    reloj.putExtra("desc3",desc3);
                    reloj.putExtra("desc4",desc4);
                    reloj.putExtra("desc5",desc5);
                    reloj.putExtra("desc6",desc6);

                    reloj.putExtra("usuario",usuarios);
                    reloj.putExtra("email",correos);
                    reloj.putExtra("clave",claves);
                    reloj.putExtra("nombre",nombres);

                    reloj.putExtra("cant1",tiempo1);
                    reloj.putExtra("cant2",tiempo2);
                    reloj.putExtra("cant3",tiempo3);
                    reloj.putExtra("cant4",tiempo4);
                    reloj.putExtra("cant5",tiempo5);
                    reloj.putExtra("cant6",tiempo6);

                    reloj.putExtra("tipoEjer",5);

                    reloj.putExtra("rut1",tipoRutina);
                    reloj.putExtra("rutNombre",rutNombre);
                    reloj.putExtra("imgWorkout1",imgEjer);
                    reloj.putExtra("imgWorkout2",imgEjer2);
                    reloj.putExtra("imgWorkout3",imgEjer3);
                    reloj.putExtra("imgWorkout4",imgEjer4);
                    reloj.putExtra("imgWorkout5",imgEjer5);
                    reloj.putExtra("imgWorkout6",imgEjer6);
                    startActivity(reloj);
                }
            });

            ejercicio6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent reloj = new Intent(Exercise.this,SeriesSets.class);
                    reloj.putExtra("eje1",ejer1);
                    reloj.putExtra("eje2",ejer2);
                    reloj.putExtra("eje3",ejer3);
                    reloj.putExtra("eje4",ejer4);
                    reloj.putExtra("eje5",ejer5);
                    reloj.putExtra("eje6",ejer6);

                    reloj.putExtra("desc1",desc1);
                    reloj.putExtra("desc2",desc2);
                    reloj.putExtra("desc3",desc3);
                    reloj.putExtra("desc4",desc4);
                    reloj.putExtra("desc5",desc5);
                    reloj.putExtra("desc6",desc6);

                    reloj.putExtra("usuario",usuarios);
                    reloj.putExtra("email",correos);
                    reloj.putExtra("clave",claves);
                    reloj.putExtra("nombre",nombres);

                    reloj.putExtra("cant1",tiempo1);
                    reloj.putExtra("cant2",tiempo2);
                    reloj.putExtra("cant3",tiempo3);
                    reloj.putExtra("cant4",tiempo4);
                    reloj.putExtra("cant5",tiempo5);
                    reloj.putExtra("cant6",tiempo6);

                    reloj.putExtra("tipoEjer",6);

                    reloj.putExtra("rut1",tipoRutina);
                    reloj.putExtra("rutNombre",rutNombre);
                    reloj.putExtra("imgWorkout1",imgEjer);
                    reloj.putExtra("imgWorkout2",imgEjer2);
                    reloj.putExtra("imgWorkout3",imgEjer3);
                    reloj.putExtra("imgWorkout4",imgEjer4);
                    reloj.putExtra("imgWorkout5",imgEjer5);
                    reloj.putExtra("imgWorkout6",imgEjer6);
                    startActivity(reloj);
                }
            });

            volver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent volver = new Intent(Exercise.this,RutinasEjercicio.class);

                    volver.putExtra("eje1",ejer1);
                    volver.putExtra("eje2",ejer1);
                    volver.putExtra("eje3",ejer1);
                    volver.putExtra("eje4",ejer1);
                    volver.putExtra("eje5",ejer1);
                    volver.putExtra("eje6",ejer1);

                    volver.putExtra("desc1",desc1);
                    volver.putExtra("desc2",desc2);
                    volver.putExtra("desc3",desc3);
                    volver.putExtra("desc4",desc4);
                    volver.putExtra("desc5",desc5);
                    volver.putExtra("desc6",desc6);



                    volver.putExtra("cant1",tiempo1);
                    volver.putExtra("cant2",tiempo2);
                    volver.putExtra("cant3",tiempo3);
                    volver.putExtra("cant4",tiempo4);
                    volver.putExtra("cant5",tiempo5);
                    volver.putExtra("cant6",tiempo6);

                    volver.putExtra("rut1",tipoRutina);
                    volver.putExtra("rutNombre",rutNombre);


                    volver.putExtra("imgWorkout1",imgEjer);
                    volver.putExtra("imgWorkout2",imgEjer2);
                    volver.putExtra("imgWorkout3",imgEjer3);
                    volver.putExtra("imgWorkout4",imgEjer4);
                    volver.putExtra("imgWorkout5",imgEjer5);
                    volver.putExtra("imgWorkout6",imgEjer6);


                    volver.putExtra("usuario",usuarios);
                    volver.putExtra("email",correos);
                    volver.putExtra("clave",claves);
                    volver.putExtra("nombre",nombres);

                    startActivity(volver);
                }
            });

        }








    }
}