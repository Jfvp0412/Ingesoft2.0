package com.company.workpeace.ClasesPrincipales;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.company.workpeace.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class Login extends AppCompatActivity {
    TextInputLayout usuario;
    TextInputLayout psw;
    TextInputLayout correo;
    Button btnRegistro;
    Button btnIniciarSesion;
    DatabaseReference referencia;
    ProgressBar progressBar;
    Button btnOlvidarClave;
    FirebaseAuth fAuth;
    FirebaseAuth autenticacion;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        btnRegistro = findViewById(R.id.btnPantallaRegistro);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesionLogin);
        usuario = findViewById(R.id.usuarioLogin);
        psw = findViewById(R.id.claveLogin);
        correo = findViewById(R.id.correoLogin);
        btnOlvidarClave = findViewById(R.id.btnOlvidoClaveLogin);
        fAuth = FirebaseAuth.getInstance();
        autenticacion = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference("Usuarios");

        btnOlvidarClave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetMail = new EditText(v.getContext());
                final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Cambiar Contraseña ?");
                passwordResetDialog.setMessage("Ingresa tu Email para cambiar tu contraseña.");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mail = resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Login.this, "Se envió un mensaje a tu correo electrónico.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this, "Error ! El mensaje no se pudo enviar" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // close the dialog
                    }
                });

                passwordResetDialog.create().show();
            }
        });



        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);

                // PASAR LAS VARIABLES A SU CORRESPONDIENTE TIPO DE DATOS
                final String usuarioIngreso = usuario.getEditText().getText().toString().trim();
                final String claveIngreso = psw.getEditText().getText().toString().trim();
                final String mailIngreso = correo.getEditText().getText().toString().trim();


                //Verificar que no esté vacio el usuario
                if(TextUtils.isEmpty(usuarioIngreso)){
                    Toast.makeText(Login.this,"Ingresa el  usuario",Toast.LENGTH_LONG).show();
                    return;
                }

                //Verificar que no esté vacio la clave
                if(TextUtils.isEmpty(claveIngreso)){
                    Toast.makeText(Login.this,"Ingresa la clave",Toast.LENGTH_LONG).show();
                    return;
                }


                //Apunto a la ruta "Usuarios"
                autenticacion.signInWithEmailAndPassword(mailIngreso, claveIngreso)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(Login.this,"Bienvenido",Toast.LENGTH_LONG).show();

                                    referencia = FirebaseDatabase.getInstance().getReference("Usuarios");

// Quedar apuntando al hijo de la ruta "Usuarios"
                                    Query checkUsuario = referencia.orderByChild("usuario").equalTo(usuarioIngreso);
                                    checkUsuario.addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            // si el usuario existe

                                            if(dataSnapshot.exists()){
                                                //Toast.makeText(Login.this,"holaaaa",Toast.LENGTH_LONG).show();
                                                usuario.setError(null);
                                                usuario.setErrorEnabled(false);
                                                referencia.child(usuarioIngreso).child("clave").setValue(claveIngreso);

                                                //Si los datos que ingresó son los mismos que los de la base de datos, paso a la siguiente pantalla
                                                if(1==1){
                                                    usuario.setError(null);
                                                    usuario.setErrorEnabled(false);
                                                    String usuarioBD = dataSnapshot.child(usuarioIngreso).child("usuario").getValue(String.class);
                                                    String emailDB = dataSnapshot.child(usuarioIngreso).child("email").getValue(String.class);
                                                    String nombreDB = dataSnapshot.child(usuarioIngreso).child("nombre").getValue(String.class);
                                                    String edad = dataSnapshot.child(usuarioIngreso).child("edad").getValue().toString();
                                                    String estatura = dataSnapshot.child(usuarioIngreso).child("edad").getValue().toString();
                                                    String peso = dataSnapshot.child(usuarioIngreso).child("edad").getValue().toString();
                                                    String claveDB = dataSnapshot.child(usuarioIngreso).child("clave").getValue(String.class);

                                                    //Toast.makeText(Login.this,"Bienvenido de vuelta",Toast.LENGTH_SHORT).show();

                                                    Intent sig = new Intent(Login.this,Init.class);
                                                    //Guardar el usuario para mostrar los datos de ese usuario en otra pantalla y solo los de ese usuario
                                                    sig.putExtra("usuario",usuarioBD);
                                                    sig.putExtra("email",emailDB);
                                                    sig.putExtra("nombre",nombreDB);
                                                    sig.putExtra("clave",claveDB);
                                                    sig.putExtra("edad",edad);
                                                    sig.putExtra("estatura",estatura);
                                                    sig.putExtra("peso",peso);

                                                    //Pasar a la pantalla Pefil
                                                    startActivity(sig);

                                                }else{
                                                    // Si la clave que ingresó no es igual a la de la base datos
                                                    progressBar.setVisibility(View.GONE);
                                                    psw.setError("Contraseña incorrecta");
                                                    psw.requestFocus();
                                                }



                                            }else{
                                                // Si el usuario no existe
                                                progressBar.setVisibility(View.GONE);
                                                usuario.setError("Ese usuario no existe");
                                                usuario.requestFocus();
                                            }

                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                } else {
                                    // If sign in fails, display a message to the user.
                                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                        Toast.makeText(Login.this,"Este usuario ya existe",Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(Login.this,"No se pudo ingresar",Toast.LENGTH_LONG).show();

                                    }
                                }
                                // ...
                            }
                        });
            }
        });
        //CAMBIAR A PANTALLA REGISTRO
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(Login.this,Registro.class);
                startActivity(siguiente);
            }
        });
    }

}


