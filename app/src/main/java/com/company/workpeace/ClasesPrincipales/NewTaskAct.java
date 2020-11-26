package com.company.workpeace.ClasesPrincipales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.company.workpeace.ClasesAuxiliares.Firebase.DatePickerFragment;
import com.company.workpeace.ClasesAuxiliares.Firebase.MyDoesAux;
import com.company.workpeace.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class NewTaskAct extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView titlepage, addtitle, adddesc, adddate;

    int t1Hour, t1Minute,t2Hour, t2Minute;
    EditText titledoes, descdoes, datedoes, dateHora;
    Button btnSaveTask, btnCancel, btnCalendario, btnHora;
    DatabaseReference reference;
    Integer doesNum = new Random().nextInt();
    String keydoes = Integer.toString(doesNum);

    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        Intent intent = getIntent();

        usuario = intent.getStringExtra("usuario");

        titlepage = findViewById(R.id.titlepage);

        addtitle = findViewById(R.id.addtitle);
        adddesc = findViewById(R.id.adddesc);
        adddate = findViewById(R.id.adddate);

        titledoes = findViewById(R.id.titledoes);
        descdoes = findViewById(R.id.descdoes);
        datedoes = findViewById(R.id.datedoes);
        dateHora = findViewById(R.id.dateHora);

        btnSaveTask = findViewById(R.id.btnSaveTask);
        btnCancel = findViewById(R.id.btnCancel);
        btnCalendario = findViewById(R.id.btnCalendario);
        btnHora = findViewById(R.id.btnHora);

        btnHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(NewTaskAct.this, android.R.style.Theme_Holo_Dialog_MinWidth, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        t2Hour = hourOfDay;
                        t2Minute = minute;

                        String time = t2Hour + ":" + t2Minute;

                        SimpleDateFormat f24Hours = new SimpleDateFormat("HH:mm");

                        try {
                            Date date = f24Hours.parse(time);

                            SimpleDateFormat f12Hours = new SimpleDateFormat("hh:mm aa");
                            dateHora.setText(f12Hours.format(date));


                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                },12,0,false
                );

                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(t2Hour,t2Minute);
                timePickerDialog.show();
            }
        });

        btnCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });

        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // insert data to database
                reference = FirebaseDatabase.getInstance().getReference().child("DoesApp").child(usuario);
                String titulo = titledoes.getText().toString();
                String descrip = descdoes.getText().toString();
                String fechas = datedoes.getText().toString();
                String horas = dateHora.getText().toString();
                String key = keydoes;
                String username = usuario;
                MyDoesAux myDoesAux = new MyDoesAux(titulo,descrip,fechas,key,username,horas);

                reference.child("Does" + doesNum).setValue(myDoesAux);

                Intent ir = new Intent(NewTaskAct.this,MyDoes.class);
                ir.putExtra("usuario",usuario);
                Toast.makeText(NewTaskAct.this,"Recordatorio creado",Toast.LENGTH_SHORT).show();
                startActivity(ir);


            }
        });



        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(NewTaskAct.this,MyDoes.class);
                a.putExtra("usuario",usuario);
                startActivity(a);
            }
        });



    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());
        datedoes.setText(currentDateString);
    }
}