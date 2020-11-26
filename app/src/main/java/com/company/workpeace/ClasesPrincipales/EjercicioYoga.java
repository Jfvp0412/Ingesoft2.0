package com.company.workpeace.ClasesPrincipales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.company.workpeace.R;

import java.util.Locale;

public class EjercicioYoga extends AppCompatActivity {
    TextView intropage, subintropage, fitonetitle, fitonedesc, timerValue, btnexercise;
    TextView nombreEjerYoga, tiempoEjerYoga;
    View divpage, bgprogress,btnEmpezarRutina;
    LinearLayout fitone;
    ImageView imgTimer;

    ImageView imgYoga;

    TextView subdescYoga;
    private static long START_TIME_IN_MILLIS = 50000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_yoga);

        nombreEjerYoga =findViewById(R.id.nombreEjerYoga);
        imgYoga = findViewById(R.id.imgPoseYoga);
        intropage = (TextView) findViewById(R.id.descEjerYoga);
        subdescYoga = (TextView) findViewById(R.id.subDescEjerYoga);
        //fitonetitle = (TextView) findViewById(R.id.nombreEjerYoga);
        //fitonedesc = (TextView) findViewById(R.id.seriesEjerYoga);
        timerValue = (TextView) findViewById(R.id.timerYoga);
        btnexercise = (TextView) findViewById(R.id.btnSeguiRutinaYoga);
        btnEmpezarRutina = findViewById(R.id.btnEmpezar);

        divpage = (View) findViewById(R.id.divpage);
        bgprogress = (View) findViewById(R.id.bgprogress);

        fitone = (LinearLayout) findViewById(R.id.linearLayoutYoga);

        imgTimer = (ImageView) findViewById(R.id.imgtimer);

        final String usuarios,correos,claves,nombres;

        Intent intent = getIntent();
        usuarios = intent.getStringExtra("usuario");
        correos = intent.getStringExtra("email");
        claves = intent.getStringExtra("clave");
        nombres = intent.getStringExtra("nombre");

        Intent llega = getIntent();
        final String ejer1,ejer2,ejer3,ejer4,ejer5,ejer6,ejer7,ejer8,ejer9,tiempoTotal,tiempoPose;
        final String descYoga1,descYoga2,descYoga3,descYoga4,descYoga5,descYoga6,descYoga7,descYoga8;

        final int thoth;

        thoth = llega.getIntExtra("thothYoga",0);

        Toast.makeText(EjercicioYoga.this,":"+thoth,Toast.LENGTH_LONG).show();
        ejer1 = llega.getStringExtra("yoga1");
        ejer2 = llega.getStringExtra("yoga2");
        ejer3 = llega.getStringExtra("yoga3");
        ejer4 = llega.getStringExtra("yoga4");
        ejer5 = llega.getStringExtra("yoga5");
        ejer6 = llega.getStringExtra("yoga6");
        ejer7 = llega.getStringExtra("yoga7");
        ejer8 = llega.getStringExtra("yoga8");
        ejer9 = llega.getStringExtra("yoga10");



        descYoga1 = llega.getStringExtra("descYoga1");
        descYoga2 = llega.getStringExtra("descYoga2");
        descYoga3 = llega.getStringExtra("descYoga3");
        descYoga4 = llega.getStringExtra("descYoga4");
        descYoga5 = llega.getStringExtra("descYoga5");
        descYoga6 = llega.getStringExtra("descYoga6");
        descYoga7 = llega.getStringExtra("descYoga7");
        descYoga8 = llega.getStringExtra("descYoga8");

        tiempoTotal = llega.getStringExtra("tiempoTotal");
        tiempoPose = llega.getStringExtra("tiempoPose");


        final int tipoRutina = llega.getIntExtra("yoga9",0);
        if(tipoRutina == 1){
            START_TIME_IN_MILLIS = 20000;
            mTimeLeftInMillis = START_TIME_IN_MILLIS;
        }
        else if(tipoRutina == 2){
            START_TIME_IN_MILLIS = 40000;
            mTimeLeftInMillis = START_TIME_IN_MILLIS;
        }
        else{
            START_TIME_IN_MILLIS = 60000;
            mTimeLeftInMillis = START_TIME_IN_MILLIS;
        }


        btnEmpezarRutina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();

            }
        });


        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            final int foto = bundle.getInt("imgYoga1");
            final int foto2 = bundle.getInt("imgYoga2");
            final int foto3 = bundle.getInt("imgYoga3");
            final int foto4 = bundle.getInt("imgYoga4");
            final int foto5 = bundle.getInt("imgYoga5");
            final int foto6 = bundle.getInt("imgYoga6");
            final int foto7 = bundle.getInt("imgYoga7");
            final int foto8 = bundle.getInt("imgYoga8");

            if(thoth ==1){


                nombreEjerYoga.setText(ejer1);

                subdescYoga.setText(descYoga1);
                imgYoga.setImageResource(foto);

            }

            else if(thoth ==2){


                nombreEjerYoga.setText(ejer2);

                subdescYoga.setText(descYoga2);

                imgYoga.setImageResource(foto2);

            }

            else if(thoth ==3){


                nombreEjerYoga.setText(ejer3);

                subdescYoga.setText(descYoga3);
                imgYoga.setImageResource(foto3);

            }

            else if(thoth ==4){

                nombreEjerYoga.setText(ejer4);

                subdescYoga.setText(descYoga4);
                imgYoga.setImageResource(foto4);

            }

            else if(thoth ==5){

                nombreEjerYoga.setText(ejer5);

                subdescYoga.setText(descYoga5);
                imgYoga.setImageResource(foto5);

            }

            else if(thoth ==6){


                nombreEjerYoga.setText(ejer6);

                subdescYoga.setText(descYoga6);
                imgYoga.setImageResource(foto5);

            }

            else if(thoth ==7){


                nombreEjerYoga.setText(ejer7);

                subdescYoga.setText(descYoga7);

                imgYoga.setImageResource(foto7);

            }

            else if(thoth ==8){

                nombreEjerYoga.setText(ejer8);

                subdescYoga.setText(descYoga8);

                imgYoga.setImageResource(foto8);

            }

            btnexercise.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent volverRutina = new Intent(EjercicioYoga.this, RutinasYoga.class);
                    volverRutina.putExtra("yoga1",ejer1);
                    volverRutina.putExtra("yoga2",ejer2);
                    volverRutina.putExtra("yoga3",ejer3);
                    volverRutina.putExtra("yoga4",ejer4);
                    volverRutina.putExtra("yoga5",ejer5);
                    volverRutina.putExtra("yoga6",ejer6);
                    volverRutina.putExtra("yoga7",ejer7);
                    volverRutina.putExtra("yoga8",ejer8);

                    volverRutina.putExtra("descYoga1",descYoga1);
                    volverRutina.putExtra("descYoga2",descYoga2);
                    volverRutina.putExtra("descYoga3",descYoga3);
                    volverRutina.putExtra("descYoga4",descYoga4);
                    volverRutina.putExtra("descYoga5",descYoga5);
                    volverRutina.putExtra("descYoga6",descYoga6);
                    volverRutina.putExtra("descYoga7",descYoga7);
                    volverRutina.putExtra("descYoga8",descYoga8);


                    volverRutina.putExtra("yoga9",tipoRutina);
                    volverRutina.putExtra("yoga10",ejer9);


                    volverRutina.putExtra("imgYoga1",foto);
                    volverRutina.putExtra("imgYoga2",foto2);
                    volverRutina.putExtra("imgYoga3",foto3);
                    volverRutina.putExtra("imgYoga4",foto4);
                    volverRutina.putExtra("imgYoga5",foto5);
                    volverRutina.putExtra("imgYoga6",foto6);
                    volverRutina.putExtra("imgYoga7",foto7);
                    volverRutina.putExtra("imgYoga8",foto8);


                    volverRutina.putExtra("tiempoTotal",tiempoTotal);
                    volverRutina.putExtra("tiempoPose",tiempoPose);

                    volverRutina.putExtra("usuario",usuarios);
                    volverRutina.putExtra("email",correos);
                    volverRutina.putExtra("clave",claves);
                    volverRutina.putExtra("nombre",nombres);

                    volverRutina.putExtra("thothYoga",thoth);

                    startActivity(volverRutina);
                }
            });

        }




    }


    private void startTimer() {

        countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                //Toast.makeText(getApplicationContext(),"Terminado!", Toast.LENGTH_SHORT).show();
            }
        }.start();
        mTimerRunning = true;
    }

    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeft = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds) ;
        timerValue.setText(timeLeft);
    }
}