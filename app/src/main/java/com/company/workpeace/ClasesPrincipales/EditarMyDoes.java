package com.company.workpeace.ClasesPrincipales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
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
import com.company.workpeace.Reciclador.DoesAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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

public class EditarMyDoes extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    EditText titulo, desc, fecha, editarHora;
    TextView editarFecha;
    Button btnEditarTask, btnEliminar, btnEditarCalendario, btnAbrirReloj;
    DatabaseReference reference;

    int t1Hour, t1Minute,t2Hour, t2Minute;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_my_does);
        Intent intent = getIntent();

        titulo = findViewById(R.id.editarTitulo);
        desc = findViewById(R.id.editarDesc);
        fecha = findViewById(R.id.editarFecha);
        editarHora = findViewById(R.id.editarHoras);
        editarFecha = findViewById(R.id.adddate);

        btnEditarTask = findViewById(R.id.btnSaveUpdate);
        btnEliminar = findViewById(R.id.btnDelete);
        btnEditarCalendario = findViewById(R.id.btneditarCalendario);
        btnAbrirReloj = findViewById(R.id.btneditarHora);

        btnAbrirReloj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(EditarMyDoes.this, android.R.style.Theme_Holo_Dialog_MinWidth, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        t2Hour = hourOfDay;
                        t2Minute = minute;

                        String time = t2Hour + ":" + t2Minute;

                        SimpleDateFormat f24Hours = new SimpleDateFormat("HH:mm");

                        try {
                            Date date = f24Hours.parse(time);

                            SimpleDateFormat f12Hours = new SimpleDateFormat("hh:mm aa");
                            editarHora.setText(f12Hours.format(date));


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

        btnEditarCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });



        titulo.setText(getIntent().getStringExtra("titledoes"));
        desc.setText(getIntent().getStringExtra("descdoes"));
        fecha.setText(getIntent().getStringExtra("datedoes"));
        editarHora.setText(getIntent().getStringExtra("getHora"));
        final String keykeydoes = getIntent().getStringExtra("keydoes");
        final String usuario = getIntent().getStringExtra("username");


        //Toast.makeText(EditarMyDoes.this,":"+usuario,Toast.LENGTH_LONG).show();

        btnEditarTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference = FirebaseDatabase.getInstance().getReference().child("DoesApp").child(usuario);
                //Toast.makeText(EditarMyDoes.this,":"+usuario,Toast.LENGTH_SHORT).show();
                reference.child("Does" + keykeydoes).child("titulo").setValue(titulo.getText().toString());
                reference.child("Does" + keykeydoes).child("descripcion").setValue(desc.getText().toString());
                reference.child("Does" + keykeydoes).child("fecha").setValue(fecha.getText().toString());
                reference.child("Does" + keykeydoes).child("hora").setValue(editarHora.getText().toString());
                reference.child("Does" + keykeydoes).child("keydoes").setValue(keykeydoes);
                reference.child("Does" + keykeydoes).child("usuario").setValue(usuario);

                Intent a = new Intent(EditarMyDoes.this,MyDoes.class);
                a.putExtra("usuario",usuario);
                Toast.makeText(EditarMyDoes.this,"Cambios guardados...",Toast.LENGTH_LONG).show();
                startActivity(a);


            }
        });


        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference = FirebaseDatabase.getInstance().getReference().child("DoesApp").child(usuario).child("Does" + keykeydoes);
                reference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Intent a = new Intent(EditarMyDoes.this,MyDoes.class);
                            a.putExtra("usuario",usuario);
                            Toast.makeText(EditarMyDoes.this,"Recordatorio eliminado...",Toast.LENGTH_LONG).show();
                            startActivity(a);

                        }
                        else{
                            Toast.makeText(EditarMyDoes.this,"No se pudo eliminar...",Toast.LENGTH_LONG).show();
                        }
                    }
                });


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
        fecha.setText(currentDateString);
    }
}