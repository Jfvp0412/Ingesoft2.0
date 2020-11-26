package com.company.workpeace.ClasesPrincipales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.company.workpeace.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class  Perfil extends AppCompatActivity {
    TextInputLayout fullName, email,password,username,edad;
    TextView fullNameLabel, usernameLabel, txtObjetivo;
    Button btnAct;

    RadioButton Fortalecer,bajarPeso, acondicionamiento;

    ImageView btn;

    ImageView volver;

    String _USERNAME, _NAME, _EMAIL,_PASSWORD, _EDAD,_OBJETIVO;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        reference = FirebaseDatabase.getInstance().getReference("Usuarios");

        volver = findViewById(R.id.volverPerfil);

        fullName = findViewById(R.id.full_name_profile);
        email = findViewById(R.id.email_profile);
        password = findViewById(R.id.password_profile);
        edad = findViewById(R.id.edad);
        fullNameLabel = findViewById(R.id.fullname_field);
        usernameLabel = findViewById(R.id.username_field);
        txtObjetivo = findViewById(R.id.textObjetivo);
        Fortalecer = findViewById(R.id.radioFort);
        bajarPeso = findViewById(R.id.radioBajar);
        acondicionamiento = findViewById(R.id.radioAcondicionamiento);
        btnAct = findViewById(R.id.btnActualizar);

        Intent intent = getIntent();
        final String usuarioss, claves, mails,nombres;
        usuarioss = intent.getStringExtra("usuario");
        nombres = intent.getStringExtra("nombre");
        mails = intent.getStringExtra("email");
        claves = intent.getStringExtra("clave");

        showAllUserData();



        btnAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.child(_USERNAME).child("nombre").setValue(fullName.getEditText().getText().toString());
                _NAME = fullName.getEditText().getText().toString();
                reference.child(_USERNAME).child("clave").setValue(password.getEditText().getText().toString());
                _PASSWORD = password.getEditText().getText().toString();
                reference.child(_USERNAME).child("edad").setValue(edad.getEditText().getText().toString());
                _EDAD = edad.getEditText().getText().toString();
                reference.child(_USERNAME).child("email").setValue(email.getEditText().getText().toString());
                _EMAIL = email.getEditText().getText().toString();
                isObjetivoChanged();
                Toast.makeText(Perfil.this,"Los datos se han actualizado satisfactoriamente",Toast.LENGTH_LONG).show();
            }
        });


        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver = new Intent(Perfil.this,Yoga.class);
                volver.putExtra("usuario",usuarioss);
                volver.putExtra("nombre",nombres);
                volver.putExtra("email",mails);
                volver.putExtra("clave",claves);
                startActivity(volver);
            }
        });

    }

    private void showAllUserData() {

        Intent intent = getIntent();
        _USERNAME = intent.getStringExtra("usuario");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                _EDAD = snapshot.child(_USERNAME).child("edad").getValue().toString();
                _NAME = snapshot.child(_USERNAME).child("nombre").getValue().toString();
                _EMAIL = snapshot.child(_USERNAME).child("email").getValue().toString();
                _PASSWORD = snapshot.child(_USERNAME).child("clave").getValue().toString();
                _OBJETIVO = snapshot.child(_USERNAME).child("objetivo").getValue().toString();
                fullName.getEditText().setText(_NAME);
                email.getEditText().setText(_EMAIL);
                password.getEditText().setText(_PASSWORD);
                edad.getEditText().setText(_EDAD);
                txtObjetivo.setText(_OBJETIVO);
                fullNameLabel.setText(_NAME);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        usernameLabel.setText(_USERNAME);
        fullName.getEditText().setText(_NAME);

        email.getEditText().setText(_EMAIL);
        password.getEditText().setText(_PASSWORD);
    }


    private boolean isObjetivoChanged() {
        String obj = "";
        if(Fortalecer.isChecked())
            obj = "Fortalecimiento";
        if(bajarPeso.isChecked())
            obj = "Bajar de peso";
        if(acondicionamiento.isChecked())
            obj = "Acondicionamiento";
        if(obj == "")
            return false;
        if (!_OBJETIVO.equals(obj)) {
            reference.child(_USERNAME).child("objetivo").setValue(obj);
            _OBJETIVO = obj;
            return true;
        } else {
            return false;
        }
    }
}