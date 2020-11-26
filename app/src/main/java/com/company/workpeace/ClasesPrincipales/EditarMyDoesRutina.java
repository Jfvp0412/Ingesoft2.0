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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.company.workpeace.ClasesAuxiliares.Firebase.DatePickerFragment;
import com.company.workpeace.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EditarMyDoesRutina extends AppCompatActivity {

    EditText titulo, desc, fecha, editarHora;
    TextView editarFecha;
    Button btnEditarTask, btnEliminar, btnIrEjercicio;
    DatabaseReference reference;
    ImageView imgPersonalizada;

    int t1Hour, t1Minute,t2Hour, t2Minute;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_my_does_rutina);
        Intent intent = getIntent();

        titulo = findViewById(R.id.editarTituloEjercicio);
        fecha = findViewById(R.id.editarFechaEjercicio);
        editarHora = findViewById(R.id.editarHorasEjercicio);
        editarFecha = findViewById(R.id.adddateEjercicio);

        btnEditarTask = findViewById(R.id.btnSaveUpdateEjercicio);
        btnEliminar = findViewById(R.id.btnDeleteEjercicio);

        imgPersonalizada = findViewById(R.id.addImagenEjercicioPersonal);
        int number = getIntent().getIntExtra("getNumero",0);

        btnIrEjercicio = findViewById(R.id.btnIrEjercicio);

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

        titulo.setText(getIntent().getStringExtra("titledoesRutina"));
        fecha.setText(getIntent().getStringExtra("seriesRutina"));
        editarHora.setText(getIntent().getStringExtra("getRepsRutina"));
        final String series =fecha.getText().toString();
        final String reps =editarHora.getText().toString();
        final String keykeydoes = getIntent().getStringExtra("keydoesRutina");
        final String descripcion = getIntent().getStringExtra("descdoesRutina");
        final String usuario = getIntent().getStringExtra("usernameRutina");
        final int elNumero = getIntent().getIntExtra("getNumero",0);


        //Toast.makeText(EditarMyDoes.this,":"+usuario,Toast.LENGTH_LONG).show();

        btnEditarTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference = FirebaseDatabase.getInstance().getReference().child("MiRutina").child(usuario);
                //Toast.makeText(EditarMyDoes.this,":"+usuario,Toast.LENGTH_SHORT).show();
                reference.child("Does" + keykeydoes).child("nombre").setValue(titulo.getText().toString());
                reference.child("Does" + keykeydoes).child("descripcion").setValue(descripcion);
                reference.child("Does" + keykeydoes).child("series").setValue(fecha.getText().toString());
                reference.child("Does" + keykeydoes).child("repeticiones").setValue(editarHora.getText().toString());
                reference.child("Does" + keykeydoes).child("keydoes").setValue(keykeydoes);
                reference.child("Does" + keykeydoes).child("usuario").setValue(usuario);
                reference.child("Does" + keykeydoes).child("numero").setValue(elNumero);

                Intent a = new Intent(EditarMyDoesRutina.this,Rutinas.class);
                a.putExtra("usuario",usuario);
                Toast.makeText(EditarMyDoesRutina.this,"Cambios guardados...",Toast.LENGTH_LONG).show();
                startActivity(a);


            }
        });


        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference = FirebaseDatabase.getInstance().getReference().child("MiRutina").child(usuario).child("Does" + keykeydoes);
                reference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Intent a = new Intent(EditarMyDoesRutina.this,Rutinas.class);
                            a.putExtra("usuario",usuario);
                            Toast.makeText(EditarMyDoesRutina.this,"Ejercicio eliminado...",Toast.LENGTH_LONG).show();
                            startActivity(a);

                        }
                        else{
                            Toast.makeText(EditarMyDoesRutina.this,"No se pudo eliminar...",Toast.LENGTH_LONG).show();
                        }
                    }
                });


            }
        });

        btnIrEjercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(EditarMyDoesRutina.this,SeriesPersonalizadas.class);
                String nombreEjercicio = titulo.getText().toString();
                String cantidadReps = editarHora.getText().toString();
                String cantidadSets = fecha.getText().toString();
                intent.putExtra("nombreEjercicioP",nombreEjercicio);
                intent.putExtra("descripcionEjercicioP",descripcion);
                intent.putExtra("cantidadRepsP",cantidadReps);
                intent.putExtra("cantidadSetsP",cantidadSets);
                intent.putExtra("numeroEjerP",cantidadSets);
                intent.putExtra("usuario",usuario);
                intent.putExtra("numeroEjerP",elNumero);

                startActivity(intent);

            }
        });




    }

}