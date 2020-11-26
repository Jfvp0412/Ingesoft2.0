package com.company.workpeace.ClasesPrincipales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.company.workpeace.ClasesAuxiliares.Firebase.MiRutinaAux;
import com.company.workpeace.ClasesAuxiliares.Firebase.MyDoesAux;
import com.company.workpeace.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class CrearMiRutina extends AppCompatActivity {

    TextView titlepageRutina, addtitleMiRutina, addHoraRutina, adddateMiRutina;

    int t1Hour, t1Minute,t2Hour, t2Minute;
    EditText titledoesMiRutina, datedoesMiRutina, datedoes, dateHoraMiRutina;
    Button btnSaveTaskRutina, btnCancelRutina;
    DatabaseReference reference;

    ImageView imgPersonalizada;
    Integer doesNum;
    String usuario;
    String nombre, descrip, series,sets,key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_mi_rutina);

        Intent intent = getIntent();


        nombre = intent.getStringExtra("elNombre");
        descrip = intent.getStringExtra("laDescrip");
        key = intent.getStringExtra("elKey");
        series = intent.getStringExtra("lasSeries");
        usuario = intent.getStringExtra("usuario");
        final int number = intent.getIntExtra("ElNumero",0);
        //doesNum = intent.getStringExtra("doesNum");
        imgPersonalizada = findViewById(R.id.addImagenRutinaP);

        titlepageRutina = findViewById(R.id.titlepageRutina);

        addtitleMiRutina = findViewById(R.id.addtitleMiRutina);
        addHoraRutina = findViewById(R.id.addHoraRutina);
        adddateMiRutina = findViewById(R.id.adddateMiRutina);

        titledoesMiRutina = findViewById(R.id.titledoesMiRutina);
        datedoesMiRutina = findViewById(R.id.datedoesMiRutina);

        dateHoraMiRutina = findViewById(R.id.dateHoraMiRutina);

        btnSaveTaskRutina = findViewById(R.id.btnSaveTaskRutina);
        btnCancelRutina = findViewById(R.id.btnCancelRutina);

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
            imgPersonalizada.setImageResource(R.drawable.abdomen1);
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

        titledoesMiRutina.setText(nombre);



        btnSaveTaskRutina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // insert data to database
                reference = FirebaseDatabase.getInstance().getReference().child("MiRutina").child(usuario);
                String laSerie = datedoesMiRutina.getText().toString();
                String lasReps = dateHoraMiRutina.getText().toString();
                String username = usuario;
                MiRutinaAux miRutinaAux = new MiRutinaAux(nombre,laSerie,lasReps,descrip,username,key,number);

                reference.child("Does" + key).setValue(miRutinaAux);

                Intent ir = new Intent(CrearMiRutina.this,Rutinas.class);
                ir.putExtra("usuario",usuario);
                Toast.makeText(CrearMiRutina.this,"Ejercicio creado",Toast.LENGTH_SHORT).show();
                startActivity(ir);


            }
        });

        btnCancelRutina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(CrearMiRutina.this,Rutinas.class);
                a.putExtra("usuario",usuario);
                startActivity(a);
            }
        });

    }
}