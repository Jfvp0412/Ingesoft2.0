package com.company.workpeace.ClasesPrincipales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.company.workpeace.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PantallaMeditacion extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView menuIcon;
    TextView meditacion;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ProgressBar progressBar;

    TextView med1,med2,med3,med4,med5,med6,med7,med8,med9,med10,med11,med12;
    DatabaseReference baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pantalla_meditacion);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        med1 = findViewById(R.id.medTitulo);
        med2 = findViewById(R.id.medTitulo2);
        med3 = findViewById(R.id.medTitulo3);
        med4 = findViewById(R.id.medTitulo4);
        med5 = findViewById(R.id.medTitulo5);
        med6 = findViewById(R.id.medTitulo6);
        med7 = findViewById(R.id.medTitulo7);
        med8 = findViewById(R.id.medTitulo8);
        med9 = findViewById(R.id.medTitulo9);
        med10 = findViewById(R.id.medTitulo10);
        med11 = findViewById(R.id.medTitulo11);
        med12 = findViewById(R.id.medTitulo12);
        menuIcon = findViewById(R.id.menu_icon);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        navigationDrawer();
        baseDatos = FirebaseDatabase.getInstance().getReference();
        final String usuarios,correos,claves,nombres;

        Intent intent = getIntent();
        usuarios = intent.getStringExtra("usuario");
        correos = intent.getStringExtra("email");
        claves = intent.getStringExtra("clave");
        nombres = intent.getStringExtra("nombre");

        med1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Meditación para la ansiedad principiante");
                            rutina.put("Duracion", "6 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nMeditaciones").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nMeditaciones").setValue(consecutivo);
                            baseDatos.child("HistorialMeditaciones").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Intent meditation = new Intent(PantallaMeditacion.this,EjercicioMed.class);
                meditation.putExtra("med",1);
                meditation.putExtra("usuario",usuarios);
                meditation.putExtra("nombre",nombres);
                meditation.putExtra("clave",claves);
                meditation.putExtra("email",correos);
                startActivity(meditation);
            }
        });

        med2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Meditación para la ansiedad intermedio");
                            rutina.put("Duracion", "10 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nMeditaciones").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nMeditaciones").setValue(consecutivo);
                            baseDatos.child("HistorialMeditaciones").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Intent meditation2 = new Intent(PantallaMeditacion.this,EjercicioMed.class);
                meditation2.putExtra("med",2);
                meditation2.putExtra("usuario",usuarios);
                meditation2.putExtra("nombre",nombres);
                meditation2.putExtra("clave",claves);
                meditation2.putExtra("email",correos);

                startActivity(meditation2);
            }
        });

        med3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Meditación para la ansiedad avanzado");
                            rutina.put("Duracion", "20 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nMeditaciones").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nMeditaciones").setValue(consecutivo);
                            baseDatos.child("HistorialMeditaciones").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Intent meditation3 = new Intent(PantallaMeditacion.this,EjercicioMed.class);
                meditation3.putExtra("med",3);
                meditation3.putExtra("usuario",usuarios);
                meditation3.putExtra("nombre",nombres);
                meditation3.putExtra("clave",claves);
                meditation3.putExtra("email",correos);

                startActivity(meditation3);
            }
        });

        med4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Meditación mindfulness principiante");
                            rutina.put("Duracion", "6 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nMeditaciones").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nMeditaciones").setValue(consecutivo);
                            baseDatos.child("HistorialMeditaciones").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Intent meditation4 = new Intent(PantallaMeditacion.this,EjercicioMed.class);
                meditation4.putExtra("med",4);
                meditation4.putExtra("usuario",usuarios);
                meditation4.putExtra("nombre",nombres);
                meditation4.putExtra("clave",claves);
                meditation4.putExtra("email",correos);

                startActivity(meditation4);
            }
        });

        med5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Meditación mindfulness intermedio");
                            rutina.put("Duracion", "12 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nMeditaciones").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nMeditaciones").setValue(consecutivo);
                            baseDatos.child("HistorialMeditaciones").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Intent meditation5 = new Intent(PantallaMeditacion.this,EjercicioMed.class);
                meditation5.putExtra("med",5);
                meditation5.putExtra("usuario",usuarios);
                meditation5.putExtra("nombre",nombres);
                meditation5.putExtra("clave",claves);
                meditation5.putExtra("email",correos);

                startActivity(meditation5);
            }
        });

        med6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Meditación mindfulness avanzado");
                            rutina.put("Duracion", "15 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nMeditaciones").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nMeditaciones").setValue(consecutivo);
                            baseDatos.child("HistorialMeditaciones").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Intent meditation6 = new Intent(PantallaMeditacion.this,EjercicioMed.class);
                meditation6.putExtra("med",6);
                meditation6.putExtra("usuario",usuarios);
                meditation6.putExtra("nombre",nombres);
                meditation6.putExtra("clave",claves);
                meditation6.putExtra("email",correos);

                startActivity(meditation6);
            }
        });

        med7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Meditación sueño profundo principiante");
                            rutina.put("Duracion", "11 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nMeditaciones").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nMeditaciones").setValue(consecutivo);
                            baseDatos.child("HistorialMeditaciones").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Intent meditation7 = new Intent(PantallaMeditacion.this,EjercicioMed.class);
                meditation7.putExtra("med",7);
                meditation7.putExtra("usuario",usuarios);
                meditation7.putExtra("nombre",nombres);
                meditation7.putExtra("clave",claves);
                meditation7.putExtra("email",correos);

                startActivity(meditation7);
            }
        });

        med8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Meditación sueño profundo intermedio");
                            rutina.put("Duracion", "14 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nMeditaciones").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nMeditaciones").setValue(consecutivo);
                            baseDatos.child("HistorialMeditaciones").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Intent meditation8 = new Intent(PantallaMeditacion.this,EjercicioMed.class);
                meditation8.putExtra("med",8);
                meditation8.putExtra("usuario",usuarios);
                meditation8.putExtra("nombre",nombres);
                meditation8.putExtra("clave",claves);
                meditation8.putExtra("email",correos);

                startActivity(meditation8);
            }
        });

        med9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Meditación sueño profundo principiante");
                            rutina.put("Duracion", "15 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nMeditaciones").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nMeditaciones").setValue(consecutivo);
                            baseDatos.child("HistorialMeditaciones").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Intent meditation9 = new Intent(PantallaMeditacion.this,EjercicioMed.class);
                meditation9.putExtra("med",9);
                meditation9.putExtra("usuario",usuarios);
                meditation9.putExtra("nombre",nombres);
                meditation9.putExtra("clave",claves);
                meditation9.putExtra("email",correos);

                startActivity(meditation9);
            }
        });

        med10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Meditación para dolor físico o emocional principiante");
                            rutina.put("Duracion", "12 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nMeditaciones").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nMeditaciones").setValue(consecutivo);
                            baseDatos.child("HistorialMeditaciones").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Intent meditation10 = new Intent(PantallaMeditacion.this,EjercicioMed.class);
                meditation10.putExtra("med",10);
                meditation10.putExtra("usuario",usuarios);
                meditation10.putExtra("nombre",nombres);
                meditation10.putExtra("clave",claves);
                meditation10.putExtra("email",correos);

                startActivity(meditation10);
            }
        });

        med11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Meditación para dolor físico o emocional intermedio");
                            rutina.put("Duracion", "13 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nMeditaciones").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nMeditaciones").setValue(consecutivo);
                            baseDatos.child("HistorialMeditaciones").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Intent meditation11 = new Intent(PantallaMeditacion.this,EjercicioMed.class);
                meditation11.putExtra("med",11);
                meditation11.putExtra("usuario",usuarios);
                meditation11.putExtra("nombre",nombres);
                meditation11.putExtra("clave",claves);
                meditation11.putExtra("email",correos);
                startActivity(meditation11);
            }
        });

        med12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Meditación para dolor físico o emocional avanzado");
                            rutina.put("Duracion", "16 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nMeditaciones").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nMeditaciones").setValue(consecutivo);
                            baseDatos.child("HistorialMeditaciones").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Intent meditation12 = new Intent(PantallaMeditacion.this,EjercicioMed.class);
                meditation12.putExtra("med",12);
                meditation12.putExtra("usuario",usuarios);
                meditation12.putExtra("nombre",nombres);
                meditation12.putExtra("clave",claves);
                meditation12.putExtra("email",correos);

                startActivity(meditation12);
            }
        });



        progressBar.setVisibility(View.GONE);
    }

    private void navigationDrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_meditacion);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        String usuario,correo,clave,nombre;

        Intent intent = getIntent();
        usuario = intent.getStringExtra("usuario");
        correo = intent.getStringExtra("email");
        clave = intent.getStringExtra("clave");
        nombre = intent.getStringExtra("nombre");

        switch (menuItem.getItemId()){

            case R.id.nav_perfil:
                Intent si = new Intent(PantallaMeditacion.this,Perfil.class);
                si.putExtra("usuario",usuario);
                si.putExtra("nombre",nombre);
                si.putExtra("clave",clave);
                si.putExtra("email",correo);
                startActivity(si);
                break;
            case R.id.nav_home:
                Intent home = new Intent(PantallaMeditacion.this,Init.class);
                home.putExtra("usuario",usuario);
                home.putExtra("nombre",nombre);
                home.putExtra("clave",clave);
                home.putExtra("email",correo);
                startActivity(home);
                break;
            case R.id.nav_yoga:
                Intent yoga = new Intent(PantallaMeditacion.this,Yoga.class);
                yoga.putExtra("usuario",usuario);
                yoga.putExtra("nombre",nombre);
                yoga.putExtra("clave",clave);
                yoga.putExtra("email",correo);
                startActivity(yoga);
                break;

            case R.id.nav_marcas_personales:
                Intent marcas = new Intent(PantallaMeditacion.this,MarcasPersonales.class);
                marcas.putExtra("usuario",usuario);
                marcas.putExtra("nombre",nombre);
                marcas.putExtra("clave",clave);
                marcas.putExtra("email",correo);
                startActivity(marcas);
                break;

            case R.id.nav_dias_meditacion:
                Intent dias = new Intent(PantallaMeditacion.this,HistorialMeditacionActivity.class);
                dias.putExtra("usuario",usuario);
                dias.putExtra("nombre",nombre);
                dias.putExtra("clave",clave);
                dias.putExtra("email",correo);
                startActivity(dias);
                break;
            case R.id.nav_dias_ejercicio:
                Intent diasEjer = new Intent(PantallaMeditacion.this,HistorialEjercicioActivity.class);
                diasEjer.putExtra("usuario",usuario);
                diasEjer.putExtra("nombre",nombre);
                diasEjer.putExtra("clave",clave);
                diasEjer.putExtra("email",correo);
                startActivity(diasEjer);
                break;
            case R.id.nav_dias_yoga:
                Intent diasYog = new Intent(PantallaMeditacion.this,HistorialYogaActivity.class);
                diasYog.putExtra("usuario",usuario);
                diasYog.putExtra("nombre",nombre);
                diasYog.putExtra("clave",clave);
                diasYog.putExtra("email",correo);
                startActivity(diasYog);
                break;
            case R.id.nav_mis_rutinas:
                Intent misRutinas = new Intent(PantallaMeditacion.this,Rutinas.class);
                misRutinas.putExtra("usuario",usuario);
                misRutinas.putExtra("nombre",nombre);
                misRutinas.putExtra("clave",clave);
                misRutinas.putExtra("email",correo);
                startActivity(misRutinas);
                break;
            case R.id.nav_peso_y_medidas:
                Intent misMedidas = new Intent(PantallaMeditacion.this,Probando.class);
                misMedidas.putExtra("usuario",usuario);
                misMedidas.putExtra("nombre",nombre);
                misMedidas.putExtra("clave",clave);
                misMedidas.putExtra("email",correo);
                startActivity(misMedidas);
                break;
            case R.id.nav_recordatorio:
                Intent recordatorio = new Intent(PantallaMeditacion.this,MyDoes.class);
                recordatorio.putExtra("usuario",usuario);
                recordatorio.putExtra("nombre",nombre);
                recordatorio.putExtra("clave",clave);
                recordatorio.putExtra("email",correo);
                startActivity(recordatorio);
                break;

            case R.id.nav_logout:
                Intent logout = new Intent(PantallaMeditacion.this, Login.class);
                logout.putExtra("usuario",usuario);
                logout.putExtra("nombre",nombre);
                logout.putExtra("clave",clave);
                logout.putExtra("email",correo);
                startActivity(logout);
                break;
        }
        return true;

    }
}
