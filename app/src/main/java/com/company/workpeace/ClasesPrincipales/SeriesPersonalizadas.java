package com.company.workpeace.ClasesPrincipales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.workpeace.R;

public class SeriesPersonalizadas extends AppCompatActivity {

    ImageView imgPersonalizada;
    TextView nombrePersonalizada,TextoSets,TextoDescrip;
    TextView CantidadSets, cantidadReps,TextoReps,btnRegresarMiRutina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_personalizadas);

        imgPersonalizada = findViewById(R.id.imgPersonalizada);
        nombrePersonalizada = findViewById(R.id.nombrePersonalizada);
        CantidadSets = findViewById(R.id.CantidadSets);
        cantidadReps = findViewById(R.id.cantidadReps);
        TextoSets = findViewById(R.id.TextoSets);
        TextoReps = findViewById(R.id.TextoReps);
        TextoDescrip = findViewById(R.id.TextoDescrip);
        btnRegresarMiRutina = findViewById(R.id.btnRegresarMiRutina);

        final int number = getIntent().getIntExtra("numeroEjerP",0);

        if(number == 1){
            imgPersonalizada.setImageResource(R.drawable.flexiones_con_inclinacion);
        }
        else if(number == 2){
            imgPersonalizada.setImageResource(R.drawable.flexiones_con_apoyo_de_rodillas);
        }
        else if(number == 3){
            imgPersonalizada.setImageResource(R.drawable.flexiones);
        }
        else if(number == 4){
            imgPersonalizada.setImageResource(R.drawable.flexiones_con_brazos_abiertos);
        }
        else if(number == 5){
            imgPersonalizada.setImageResource(R.drawable.flexiones_hindues);
        }
        else if(number == 6){
            imgPersonalizada.setImageResource(R.drawable.flexiones_escalonadas);
        }
        else if(number == 7){
            imgPersonalizada.setImageResource(R.drawable.flexion_y_rotacion);
        }
        else if(number == 8){
            imgPersonalizada.setImageResource(R.drawable.flexiones_en_caja);
        }
        else if(number == 9){
            imgPersonalizada.setImageResource(R.drawable.flexiones_en_diamante);
        }
        else if(number == 10){
            imgPersonalizada.setImageResource(R.drawable.triceps_en_silla);
        }


        else if(number == 11){
            imgPersonalizada.setImageResource(R.drawable.flexiones_en_diamante);
        }
        else if(number == 12){
            imgPersonalizada.setImageResource(R.drawable.punetazos);
        }
        else if(number == 13){
            imgPersonalizada.setImageResource(R.drawable.inchworms);
        }
        else if(number == 14){
            imgPersonalizada.setImageResource(R.drawable.flexiones);
        }
        else if(number == 15){
            imgPersonalizada.setImageResource(R.drawable.fondos_militares);
        }
        else if(number == 16){
            imgPersonalizada.setImageResource(R.drawable.triceps_en_suelo);
        }
        else if(number == 17){
            imgPersonalizada.setImageResource(R.drawable.flexion_y_rotacion);
        }
        else if(number == 18){
            imgPersonalizada.setImageResource(R.drawable.saltos_sin_cuerda);
        }
        else if(number == 19){
            imgPersonalizada.setImageResource(R.drawable.plancha_diagonal);
        }
        else if(number == 20){
            imgPersonalizada.setImageResource(R.drawable.sentadilla);
        }


        else if(number == 21){
            imgPersonalizada.setImageResource(R.drawable.estocada_hacia_atras);
        }
        else if(number == 22){
            imgPersonalizada.setImageResource(R.drawable.sentadilla_en_pared);
        }
        else if(number == 23){
            imgPersonalizada.setImageResource(R.drawable.donkey_isq);
        }
        else if(number == 24){
            imgPersonalizada.setImageResource(R.drawable.donkey_dere);
        }
        else if(number == 25){
            imgPersonalizada.setImageResource(R.drawable.fire);
        }
        else if(number == 26){
            imgPersonalizada.setImageResource(R.drawable.zancada_frontal);
        }
        else if(number == 27){
            imgPersonalizada.setImageResource(R.drawable.sentadilla_de_sumo);
        }
        else if(number == 28){
            imgPersonalizada.setImageResource(R.drawable.levantamiento_de_pantorrillas);
        }
        else if(number == 29){
            imgPersonalizada.setImageResource(R.drawable.abs_v);
        }

        else if(number == 30){
            imgPersonalizada.setImageResource(R.drawable.crunch_abdominales);
        }



        else if(number == 31){
            imgPersonalizada.setImageResource(R.drawable.elevaciones_de_piernas);
        }
        else if(number == 32){
            imgPersonalizada.setImageResource(R.drawable.plancha);
        }
        else if(number == 33){
            imgPersonalizada.setImageResource(R.drawable.twist_ruso);
        }
        else if(number == 34){
            imgPersonalizada.setImageResource(R.drawable.toque_al_talon);
        }
        else if(number == 35){
            imgPersonalizada.setImageResource(R.drawable.abdomen2);
        }
        else if(number == 36){
            imgPersonalizada.setImageResource(R.drawable.escalada_de_montana);
        }
        else if(number == 37){
            imgPersonalizada.setImageResource(R.drawable.burpees);
        }
        else if(number == 38){
            imgPersonalizada.setImageResource(R.drawable.flexion_en_la_pared);
        }
        else if(number == 39){
            imgPersonalizada.setImageResource(R.drawable.plancha_diagonal);
        }
        else if(number == 40){
            imgPersonalizada.setImageResource(R.drawable.pose_gato);
        }



        else if(number == 41){
            imgPersonalizada.setImageResource(R.drawable.flexiones_con_inclinacion);
        }

        else if(number == 42){
            imgPersonalizada.setImageResource(R.drawable.postura_bebe);
        }
        else if(number == 43){
            imgPersonalizada.setImageResource(R.drawable.pose_montania);
        }
        else if(number == 44){
            imgPersonalizada.setImageResource(R.drawable.flexiones_spiderman);
        }

        else if(number == 45){
            imgPersonalizada.setImageResource(R.drawable.superman);
        }
        else if(number == 46){
            imgPersonalizada.setImageResource(R.drawable.delfin);
        }


        nombrePersonalizada.setText(getIntent().getStringExtra("nombreEjercicioP"));
        CantidadSets.setText(getIntent().getStringExtra("cantidadSetsP"));
        cantidadReps.setText(getIntent().getStringExtra("cantidadRepsP"));
        TextoDescrip.setText(getIntent().getStringExtra("descripcionEjercicioP"));
        final String usuario = getIntent().getStringExtra("usuario");


        btnRegresarMiRutina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voy = new Intent(SeriesPersonalizadas.this,Rutinas.class);
                voy.putExtra("usuario",usuario);
                startActivity(voy);
            }
        });
    }
}