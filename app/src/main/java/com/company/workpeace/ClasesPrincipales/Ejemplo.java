package com.company.workpeace.ClasesPrincipales;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import com.company.workpeace.R;

import java.util.Locale;

public class Ejemplo extends AppCompatActivity {
    TextView intropage, subintropage, fitonetitle, fitonedesc, timerValue, btnexercise;
    View divpage, bgprogress, btnempezar;
    TextView nombreEjer;
    LinearLayout fitone;
    ImageView imgTimer;

    private static final long START_TIME_IN_MILLIS = 50000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo);

        nombreEjer = findViewById(R.id.nombreEjercicio1);

        intropage = (TextView) findViewById(R.id.descripcionEjercicio1);
        subintropage = (TextView) findViewById(R.id.subDescEjer1);
        fitonetitle = (TextView) findViewById(R.id.nombreEjercicio1);
        fitonedesc = (TextView) findViewById(R.id.seriesEjercicio1);
        timerValue = (TextView) findViewById(R.id.timerValue);
        btnexercise = (TextView) findViewById(R.id.btnSeguirRutina1);

        divpage = (View) findViewById(R.id.divpage);
        bgprogress = (View) findViewById(R.id.bgprogress);

        fitone = (LinearLayout) findViewById(R.id.ejerciciosPrincipiantes);

        imgTimer = (ImageView) findViewById(R.id.imgtimer);

        Intent llega = getIntent();
        final String ejer1,ejer2,ejer3,ejer4,ejer5,ejer6,rutNombre;
        ejer1 = llega.getStringExtra("eje1");
        ejer2 = llega.getStringExtra("eje2");
        ejer3 = llega.getStringExtra("eje3");
        ejer4 = llega.getStringExtra("eje4");
        ejer5 = llega.getStringExtra("eje5");
        ejer6 = llega.getStringExtra("eje6");
        rutNombre = llega.getStringExtra("rutNombre");
        final int tipoRutina = llega.getIntExtra("rut1",0);
        Toast.makeText(Ejemplo.this,":"+ejer1,Toast.LENGTH_LONG).show();

        nombreEjer.setText(rutNombre);



        startTimer();

        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volverRutina = new Intent(Ejemplo.this, Exercise.class);
                volverRutina.putExtra("eje1",ejer1);
                volverRutina.putExtra("eje2",ejer2);
                volverRutina.putExtra("eje3",ejer3);
                volverRutina.putExtra("eje4",ejer4);
                volverRutina.putExtra("eje5",ejer5);
                volverRutina.putExtra("eje6",ejer6);
                volverRutina.putExtra("eje7",rutNombre);
                volverRutina.putExtra("rut1",tipoRutina);
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
                Toast.makeText(getApplicationContext(),"Done!", Toast.LENGTH_SHORT).show();
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


