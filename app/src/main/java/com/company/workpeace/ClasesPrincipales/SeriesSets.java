package com.company.workpeace.ClasesPrincipales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.workpeace.R;

public class SeriesSets extends AppCompatActivity {
    TextView nombreEjer,cantEjer,descEjer,continuarRutina,superDesc;

    ImageView fotoEjer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_sets);

        nombreEjer = findViewById(R.id.nombreEjerSets);
        cantEjer = findViewById(R.id.subDescEjerSets);
        descEjer = findViewById(R.id.nombreEjerSets);
        superDesc = findViewById(R.id.timerMarcas);
        continuarRutina = findViewById(R.id.btnContinuarRutina);
        fotoEjer = findViewById(R.id.imgWorkout);

        final String usuarios,correos,claves,nombres;

        Intent intent = getIntent();
        usuarios = intent.getStringExtra("usuario");
        correos = intent.getStringExtra("email");
        claves = intent.getStringExtra("clave");
        nombres = intent.getStringExtra("nombre");
        Intent recibir = getIntent();

        final String ejer1,ejer2,ejer3,ejer4,ejer5,ejer6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                ,tiempo5,tiempo6;
        final int tipoEjer;
        tipoEjer = recibir.getIntExtra("tipoEjer",0);
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
        if(bundle!=null) {
            final int imgEjer = bundle.getInt("imgWorkout1");
            final int imgEjer2 = bundle.getInt("imgWorkout2");
            final int imgEjer3 = bundle.getInt("imgWorkout3");
            final int imgEjer4 = bundle.getInt("imgWorkout4");
            final int imgEjer5 = bundle.getInt("imgWorkout5");
            final int imgEjer6 = bundle.getInt("imgWorkout6");


            if(tipoEjer == 1){
                fotoEjer.setImageResource(imgEjer);
                nombreEjer.setText(ejer1);
                cantEjer.setText(tiempo1);
                superDesc.setText(desc1);
            }
            else if(tipoEjer == 2){
                fotoEjer.setImageResource(imgEjer2);
                nombreEjer.setText(ejer2);
                cantEjer.setText(tiempo2);
                superDesc.setText(desc2);
            }

            else if(tipoEjer == 3){
                fotoEjer.setImageResource(imgEjer3);
                nombreEjer.setText(ejer3);
                cantEjer.setText(tiempo3);
                superDesc.setText(desc3);
            }

            else if(tipoEjer == 4){
                fotoEjer.setImageResource(imgEjer4);
                nombreEjer.setText(ejer4);
                cantEjer.setText(tiempo4);
                superDesc.setText(desc4);
            }

            else if(tipoEjer == 5){
                fotoEjer.setImageResource(imgEjer5);
                nombreEjer.setText(ejer5);
                cantEjer.setText(tiempo5);
                superDesc.setText(desc5);
            }

            else if(tipoEjer == 6){
                fotoEjer.setImageResource(imgEjer6);
                nombreEjer.setText(ejer6);
                cantEjer.setText(tiempo6);
                superDesc.setText(desc6);
            }


            //introPgage.setText(rutNombre);

            continuarRutina.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent reloj = new Intent(SeriesSets.this,Exercise.class);
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

                    reloj.putExtra("tipoEjer",tipoEjer);

                    reloj.putExtra("rut1",tipoRutina);
                    reloj.putExtra("rutNombre",rutNombre);
                    reloj.putExtra("imgWorkout1",imgEjer);
                    reloj.putExtra("imgWorkout2",imgEjer2);
                    reloj.putExtra("imgWorkout3",imgEjer3);
                    reloj.putExtra("imgWorkout4",imgEjer4);
                    reloj.putExtra("imgWorkout5",imgEjer5);
                    reloj.putExtra("imgWorkout6",imgEjer6);

                    reloj.putExtra("usuario",usuarios);
                    reloj.putExtra("email",correos);
                    reloj.putExtra("clave",claves);
                    reloj.putExtra("nombre",nombres);
                    startActivity(reloj);
                }
            });

        }

    }
}