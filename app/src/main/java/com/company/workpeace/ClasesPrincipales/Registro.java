package com.company.workpeace.ClasesPrincipales;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.company.workpeace.ClasesAuxiliares.Firebase.MarcasAux;
import com.company.workpeace.ClasesAuxiliares.Firebase.MedidasAux;
import com.company.workpeace.ClasesAuxiliares.Firebase.UsuariosAux;
import com.company.workpeace.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class Registro extends AppCompatActivity {
    // DECLARACION DE VARIABLES PARA EL REGISTRO DEL USUARIO
    TextInputLayout nUsuario;
    TextInputLayout nombre;
    TextInputLayout email;
    TextInputLayout clave;
    RadioButton radioGeneroF;
    RadioButton radioGeneroM, Acondicionamiento,Fortalecimiento, BajarPeso;
    TextInputLayout edad;
    TextInputLayout estatura;
    TextInputLayout peso;
    Button btnRegistrarse;
    Button btnLogin;
    FirebaseDatabase ruta;
    FirebaseDatabase rutaMarcas;
    DatabaseReference referenciaMarcas;
    DatabaseReference referencia;
    FirebaseAuth autenticacion;
    FirebaseDatabase rutaMedidas;
    DatabaseReference referenciaMedidas;


    DatabaseReference referenciaWorkout;
    FirebaseDatabase rutaWorkout;
    String nombreUsuario, claveUsuario,emailUsario,usarioUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // GUARDAR EN LAS VARIABLES LOS DATOS DEL USUARIO
        nUsuario = findViewById(R.id.usuarioRegistro);
        nombre = findViewById(R.id.nombreRegistro);
        email = findViewById(R.id.emailRegistro);
        clave = findViewById(R.id.claveRegistro);
        radioGeneroF = (RadioButton)findViewById(R.id.radioF);
        radioGeneroM = (RadioButton)findViewById(R.id.radioM);
        Acondicionamiento = findViewById(R.id.radioAcondicionar);
        Fortalecimiento = findViewById(R.id.radioFortalecer);
        BajarPeso = findViewById(R.id.radioBajarPeso);
        edad = findViewById(R.id.edad);
        estatura = findViewById(R.id.estatura);
        peso = findViewById(R.id.peso);
        btnRegistrarse = findViewById(R.id.btnRegistro);
        autenticacion = FirebaseAuth.getInstance();
        ruta = FirebaseDatabase.getInstance();
        rutaMarcas = FirebaseDatabase.getInstance();
        rutaMedidas = FirebaseDatabase.getInstance();
        //Apuntar a la ruta "Usuarios"
        referencia = ruta.getReference("Usuarios");
        referenciaMarcas = rutaMarcas.getReference("Marcas");
        referenciaMedidas = rutaMedidas.getReference("Medidas");

        //referenciaWorkout = rutaWorkout.getReference("Workouts");

        //final String pecho1 = "Fortalecimiento principiantes pecho";

        //DescripcionAux descripcionAux = new DescripcionAux("h","h","h","h","h","h");
        //referenciaWorkout.child(pecho1).setValue(descripcionAux);
        //referencia.child(pecho1).setValue(ejercicioAux);

        //Toast.makeText(Registro.this,":"+usarioUsuario,Toast.LENGTH_LONG).show();


        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // PASAR LAS VARIABLES A SU CORRESPONDIENTE TIPO DE DATOS
                String genero = "";
                String objetivo ="";
                final String user = nUsuario.getEditText().getText().toString();
                final String nombres =nombre.getEditText().getText().toString();
                final String emailIntent = email.getEditText().getText().toString();
                final String contraseniaIntent = clave.getEditText().getText().toString();
                  String mail =email.getEditText().getText().toString();
                 String contrasenia =clave.getEditText().getText().toString();
                final String age =edad.getEditText().getText().toString();

                //Pasar el dato a entero
                int finalAge=Integer.parseInt(age);
                String height =estatura.getEditText().getText().toString();
                //Pasar el dato a flotante
                float finalHeight = Float.parseFloat(height);
                final String kg =peso.getEditText().getText().toString();
                //Pasar el dato a flotante
                float finalPeso=Float.parseFloat(kg);

                if(radioGeneroF.isChecked()){
                    genero = "Femenino";
                }

                if(radioGeneroM.isChecked()){
                    genero = "Masculino";
                }
                if(Acondicionamiento.isChecked())
                {
                    objetivo = "Acondicionamiento";
                }
                if(Fortalecimiento.isChecked())
                {
                    objetivo = "Fortalecimiento";
                }
                if(BajarPeso.isChecked())
                {
                    objetivo = "Bajar de peso";
                }
                //Verificar que no esté vacio el usuario
                if(TextUtils.isEmpty(user)){
                    Toast.makeText(Registro.this,"Ingresa el  usuario",Toast.LENGTH_LONG).show();
                    return;
                }
                //Verificar que no esté vacio el nombre
                if(TextUtils.isEmpty(nombres)){
                    Toast.makeText(Registro.this,"Ingresa el Nombre Completo",Toast.LENGTH_LONG).show();
                    return;
                }
                //Verificar que no esté vacio la email
                if(TextUtils.isEmpty(mail)){
                    Toast.makeText(Registro.this,"Ingresa el email",Toast.LENGTH_LONG).show();
                    return;
                }
                // Verificar que no esté vacio la clave
                if(TextUtils.isEmpty(contrasenia)){
                    Toast.makeText(Registro.this,"Ingresa la clave",Toast.LENGTH_LONG).show();
                    return;
                }
                //Verificar que no esté vacio la edad
                if(TextUtils.isEmpty(age)){
                    Toast.makeText(Registro.this,"Ingresa la edad",Toast.LENGTH_LONG).show();
                    return;
                }
                //Verificar que no esté vacio la estatura
                if(TextUtils.isEmpty(height)){
                    Toast.makeText(Registro.this,"Ingresa la estatura en metros",Toast.LENGTH_LONG).show();
                    return;
                }
                //Verificar que no esté vacio el peso
                if(TextUtils.isEmpty(kg)){
                    Toast.makeText(Registro.this,"Ingresa el peso en kilogramos",Toast.LENGTH_LONG).show();
                    return;
                }
                // ALMACENAR DATOS ANTERIORMENTE GUARDADOS EN LA BASE DE DATOS, USANDO LA CLASE USUARIOSAUX
                //UsuariosAux aux = new UsuariosAux(user,nombres,mail,contrasenia,genero,finalAge, finalHeight,finalPeso);
                Map<String,Object> nuevoUsuario = new HashMap<>();
                nuevoUsuario.put("nombre",nombres);
                nuevoUsuario.put("genero",genero);
                nuevoUsuario.put("edad",finalAge);
                nuevoUsuario.put("estatura",finalHeight);
                nuevoUsuario.put("email",mail);
                nuevoUsuario.put("clave",contrasenia);
                nuevoUsuario.put("peso",finalPeso);
                nuevoUsuario.put("nEjercicios",0);
                nuevoUsuario.put("nYogas",0);
                nuevoUsuario.put("nMeditaciones",0);
                nuevoUsuario.put("usuario",user);
                nuevoUsuario.put("objetivo",objetivo);

                referencia.child(user).updateChildren(nuevoUsuario);
                Map<String,Object> zonasUsuario = new HashMap<>();
                zonasUsuario.put("nPecho",0);
                zonasUsuario.put("nBrazo",0);
                zonasUsuario.put("nPierna",0);
                zonasUsuario.put("nHombro",0);
                zonasUsuario.put("nAbdomen",0);
                referencia.child(user).child("nEjercicios").updateChildren(zonasUsuario);
                MedidasAux medidasAux = new MedidasAux("0","0",
                        "0","0","0","0","0","0",user);
                MarcasAux marcasAux = new MarcasAux("0","0","0","0",
                        "0","0","0","0","0","0",
                        "0","0","0","0","0","0",user);
                referenciaMarcas.child(user).setValue(marcasAux);
                referenciaMedidas.child(user).setValue(medidasAux);
                // DATOS QUEDAN GUARDADOS EN LA RUTA "Usuarios/usuario(nombre del usuario)"
                //referencia.child(user).setValue(aux);

                //AUTENTICACION DE USUARIOS NUEVOS
                autenticacion.createUserWithEmailAndPassword(mail, contrasenia)
                        .addOnCompleteListener(Registro.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(Registro.this,"Se ha registrado satisfactoriamente....",Toast.LENGTH_LONG).show();
                                    Intent i = new Intent(Registro.this,Init.class);
                                    i.putExtra("usuario",user);
                                    i.putExtra("nombre",nombres);
                                    i.putExtra("clave",contraseniaIntent);
                                    i.putExtra("email",emailIntent);
                                    i.putExtra("edad",age);
                                    i.putExtra("kg",kg);
                                    startActivity(i);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                        Toast.makeText(Registro.this,"Ese usuario ya existe",Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        Toast.makeText(Registro.this,"No se pudo autenticar el usuario",Toast.LENGTH_LONG).show();
                                    }

                                }

                                // ...
                            }
                        });
            }
        });
        // PARA DEVOLVERSE A LA PANTALLA LOGIN
        btnLogin = findViewById(R.id.btnPantallaLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(Registro.this,Login.class);
                startActivity(next);
            }
        });
    }
}

