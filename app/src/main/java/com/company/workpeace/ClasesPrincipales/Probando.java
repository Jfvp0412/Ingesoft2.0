package com.company.workpeace.ClasesPrincipales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.company.workpeace.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Probando extends AppCompatActivity {

    TextInputEditText medida1,medida2,medida3,medida4,medida5,medida6,medida7,medida8;
    Button act1,act2,act3,act4,act5,act6,act7,act8;

    DatabaseReference reference;
    String usuario;
    ImageView devolver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probando);

        medida1 = findViewById(R.id.medida1);
        medida2 = findViewById(R.id.medida2);
        medida3 = findViewById(R.id.medida3);
        medida4 = findViewById(R.id.medida4);
        medida5 = findViewById(R.id.medida5);
        medida6 = findViewById(R.id.medida6);
        medida7 = findViewById(R.id.medida7);
        medida8 = findViewById(R.id.medida8);
        act1 = findViewById(R.id.btnActualizarPeso);
        act2 = findViewById(R.id.btnActualizarCuello);
        act3 = findViewById(R.id.btnActualizarCintura);
        act4 = findViewById(R.id.btnActualizarAntebrazo);
        act5 = findViewById(R.id.btnActualizarHombros);
        act6 = findViewById(R.id.btnActualizarMurslo);
        act7 = findViewById(R.id.btnActualizarPantorrilla);
        act8 = findViewById(R.id.btnActualizarPecho);



        Intent in = getIntent();
        usuario = in.getStringExtra("usuario");

        reference = FirebaseDatabase.getInstance().getReference("Medidas").child(usuario);


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String medidas1 = snapshot.child("nuevaMedida").getValue().toString();
                String medidas2 = snapshot.child("nuevaMedida2").getValue().toString();
                String medidas3 = snapshot.child("nuevaMedida3").getValue().toString();
                String medidas4 = snapshot.child("nuevaMedida4").getValue().toString();
                String medidas5 = snapshot.child("nuevaMedida5").getValue().toString();
                String medidas6 = snapshot.child("nuevaMedida6").getValue().toString();
                String medidas7 = snapshot.child("nuevaMedida7").getValue().toString();
                String medidas8 = snapshot.child("nuevaMedida8").getValue().toString();




                medida1.setText(medidas1);
                medida2.setText(medidas2);
                medida3.setText(medidas3);
                medida4.setText(medidas4);
                medida5.setText(medidas5);
                medida6.setText(medidas6);
                medida7.setText(medidas7);
                medida8.setText(medidas8);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        act1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reference = FirebaseDatabase.getInstance().getReference("Medidas").child(usuario);

                reference.child("nuevaMedida").setValue(medida1.getText().toString());

                Toast.makeText(Probando.this,"Medida actualizada...",Toast.LENGTH_SHORT).show();






            }


        });

        act2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reference = FirebaseDatabase.getInstance().getReference("Medidas").child(usuario);


                reference.child("nuevaMedida2").setValue(medida2.getText().toString());
                Toast.makeText(Probando.this,"Medida actualizada...",Toast.LENGTH_SHORT).show();





            }


        });

        act3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reference = FirebaseDatabase.getInstance().getReference("Medidas").child(usuario);


                reference.child("nuevaMedida3").setValue(medida3.getText().toString());
                Toast.makeText(Probando.this,"Medida actualizada...",Toast.LENGTH_SHORT).show();




                //reference.child("medidaAnterior3").setValue(medidaD3.getEditText().getText().toString());
            }


        });

        act4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reference = FirebaseDatabase.getInstance().getReference("Medidas").child(usuario);
                //reference.child("nuevaMedida").setValue(medida1.getEditText().getText().toString());
                //reference.child("nuevaMedida2").setValue(medida2.getEditText().getText().toString());
                reference.child("nuevaMedida4").setValue(medida4.getText().toString());
                Toast.makeText(Probando.this,"Medida actualizada...",Toast.LENGTH_SHORT).show();


                //reference.child("medidaAnterior4").setValue(medidaD3.getEditText().getText().toString());

            }


        });

        act5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reference = FirebaseDatabase.getInstance().getReference("Medidas").child(usuario);



                reference.child("nuevaMedida5").setValue(medida5.getText().toString());
                Toast.makeText(Probando.this,"Medida actualizada...",Toast.LENGTH_SHORT).show();






            }


        });

        act6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference = FirebaseDatabase.getInstance().getReference("Medidas").child(usuario);
                reference.child("nuevaMedida6").setValue(medida6.getText().toString());
                Toast.makeText(Probando.this,"Medida actualizada...",Toast.LENGTH_SHORT).show();




                //reference.child("medidaAnterior5").setValue(medidaD5.getText().toString());


            }


        });

        act7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reference = FirebaseDatabase.getInstance().getReference("Medidas").child(usuario);

                reference.child("nuevaMedida7").setValue(medida7.getText().toString());
                Toast.makeText(Probando.this,"Medida actualizada...",Toast.LENGTH_SHORT).show();




                //reference.child("medidaAnterior7").setValue(medidaD7.getEditText().getText().toString());

            }


        });

        act8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reference = FirebaseDatabase.getInstance().getReference("Medidas").child(usuario);

                reference.child("nuevaMedida8").setValue(medida8.getText().toString());
                Toast.makeText(Probando.this,"Medida actualizada...",Toast.LENGTH_SHORT).show();

                //reference.child("medidaAnterior8").setValue(medidaD8.getEditText().getText().toString());
            }


        });
    }
    @Override
    protected void onStart() {
        super.onStart();

    }
}