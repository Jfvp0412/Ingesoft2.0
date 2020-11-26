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

public class RelojMarcasPersonales extends AppCompatActivity {
    private static long START_TIME_IN_MILLIS = 60000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    ImageView imgTimer;

    TextView nombreEjerMarcas, tiempoEjerMarcas;
    View divpage, bgprogress;
    View empezar;
    TextView intropage, subintropage, fitonetitle, fitonedesc, timerValue, btnexercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reloj_marcas_personales);

        final String usuarios,correos,claves,nombres;

        Intent in = getIntent();
        usuarios = in.getStringExtra("usuario");
        correos = in.getStringExtra("email");
        claves = in.getStringExtra("clave");
        nombres = in.getStringExtra("nombre");

        Intent llega = getIntent();
        final String marca1,marca2,marca3,marca4,marca5,marca6,marca7,marca8,usuario;
        int marca10,marca11,marca12,marca13,marca14,marca15,marca16,marca17;
        marca1 = llega.getStringExtra("marca1");
        marca2 = llega.getStringExtra("marca2");
        marca3 = llega.getStringExtra("marca3");
        marca4 = llega.getStringExtra("marca4");
        marca5 = llega.getStringExtra("marca5");
        marca6 = llega.getStringExtra("marca6");
        marca7 = llega.getStringExtra("marca7");
        marca8 = llega.getStringExtra("marca8");

        marca10 = llega.getIntExtra("marca10",0);
        marca11 = llega.getIntExtra("marca11",0);
        marca12 = llega.getIntExtra("marca12",0);
        marca13 = llega.getIntExtra("marca13",0);
        marca14 = llega.getIntExtra("marca14",0);
        marca15 = llega.getIntExtra("marca15",0);
        marca16 = llega.getIntExtra("marca16",0);
        marca17 = llega.getIntExtra("marca17",0);
        usuario = llega.getStringExtra("usuario");



        nombreEjerMarcas =findViewById(R.id.nombreEjerMarcas);
        intropage = (TextView) findViewById(R.id.descEjerMarcas);
        subintropage = (TextView) findViewById(R.id.subDescEjerMarcas);
        //fitonetitle = (TextView) findViewById(R.id.nombreEjerYoga);
        //fitonedesc = (TextView) findViewById(R.id.seriesEjerYoga);
        timerValue = (TextView) findViewById(R.id.timerMarcas);
        btnexercise = (TextView) findViewById(R.id.btnContinuarMarcas);
        empezar = findViewById(R.id.btnEmpezarReloj);

        divpage = (View) findViewById(R.id.divpage);
        bgprogress = (View) findViewById(R.id.bgprogress);

        //fitone = (LinearLayout) findViewById(R.id.linearLayoutYoga);

        imgTimer = (ImageView) findViewById(R.id.imgtiempo);

        if(marca10==1){
            nombreEjerMarcas.setText(marca1);
        }
        else if(marca11==2){
            nombreEjerMarcas.setText(marca2);

        }
        else if(marca12==3){
            nombreEjerMarcas.setText(marca3);

        }
        else if(marca13==4){
            nombreEjerMarcas.setText(marca4);

        }
        else if(marca14==5){
            nombreEjerMarcas.setText(marca5);

        }
        else if(marca15==6){
            nombreEjerMarcas.setText(marca6);

        }
        else if(marca16==7){
            nombreEjerMarcas.setText(marca7);

        }
        else if(marca17==8){
            nombreEjerMarcas.setText(marca8);

        }

        empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();

            }
        });



        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volverRutina = new Intent(RelojMarcasPersonales.this, MarcasPersonales.class);
                volverRutina.putExtra("usuario",usuario);
                volverRutina.putExtra("email",correos);
                volverRutina.putExtra("nombre",nombres);
                volverRutina.putExtra("clave",claves);
                startActivity(volverRutina);
            }
        });
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
