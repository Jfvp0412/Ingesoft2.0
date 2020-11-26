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

public class Init extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView menuIcon;
    TextView rutina1, rutina2, rutina3, rutina4, rutina5, rutina6, rutina7, rutina8, rutina9;
    TextView forta,acon,bajarPeso;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_init);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        rutina1 = findViewById(R.id.fitUnoTitulo);
        rutina2 = findViewById(R.id.fitDosTitulo);
        rutina3 = findViewById(R.id.fitTresTitulo);
        rutina4 = findViewById(R.id.fitCuatroTitulo);
        rutina5 = findViewById(R.id.fitCincoTitulo);
        rutina6 = findViewById(R.id.fitSeisTitulo);
        rutina7 = findViewById(R.id.fitSieteTitulo);
        rutina8 = findViewById(R.id.fitOchoTitulo);
        rutina9 = findViewById(R.id.fitNueveTitulo);
        forta = findViewById(R.id.fortalecimiento);
        acon = findViewById(R.id.acondicionamiento);
        bajarPeso = findViewById(R.id.bajarPeso);
        menuIcon = findViewById(R.id.menu_icon);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        navigationDrawer();

        final String usuarios,correos,claves,nombres;

        Intent intent = getIntent();
        usuarios = intent.getStringExtra("usuario");
        correos = intent.getStringExtra("email");
        claves = intent.getStringExtra("clave");
        nombres = intent.getStringExtra("nombre");


        rutina1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                Intent Rutina1 = new Intent(Init.this,RutinasEjercicio.class);
                Rutina1.putExtra("rut1",1);
                Rutina1.putExtra("rutNombre","FORTALECIMIENTO");
                Rutina1.putExtra("usuario",usuarios);
                Rutina1.putExtra("email",correos);
                Rutina1.putExtra("clave",claves);
                Rutina1.putExtra("nombre",nombres);
                startActivity(Rutina1);
            }
        });


        rutina2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                Intent Rutina2 = new Intent(Init.this,RutinasEjercicio.class);
                Rutina2.putExtra("rut1",2);
                Rutina2.putExtra("rutNombre","FORTALECIMIENTO");
                Rutina2.putExtra("usuario",usuarios);
                Rutina2.putExtra("email",correos);
                Rutina2.putExtra("clave",claves);
                Rutina2.putExtra("nombre",nombres);


                startActivity(Rutina2);
            }
        });

        rutina3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                Intent Rutina3 = new Intent(Init.this,RutinasEjercicio.class);
                Rutina3.putExtra("rut1",3);
                Rutina3.putExtra("rutNombre","FORTALECIMIENTO");
                Rutina3.putExtra("usuario",usuarios);
                Rutina3.putExtra("email",correos);
                Rutina3.putExtra("clave",claves);
                Rutina3.putExtra("nombre",nombres);


                startActivity(Rutina3);
            }
        });

        rutina4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                Intent Rutina4 = new Intent(Init.this,RutinasEjercicio.class);
                Rutina4.putExtra("rut1",4);
                Rutina4.putExtra("rutNombre","ACONDICIONAMIENTO");
                Rutina4.putExtra("usuario",usuarios);
                Rutina4.putExtra("email",correos);
                Rutina4.putExtra("clave",claves);
                Rutina4.putExtra("nombre",nombres);


                startActivity(Rutina4);
            }
        });

        rutina5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                Intent Rutina5 = new Intent(Init.this,RutinasEjercicio.class);
                Rutina5.putExtra("rut1",5);
                Rutina5.putExtra("rutNombre","ACONDICIONAMIENTO");
                Rutina5.putExtra("usuario",usuarios);
                Rutina5.putExtra("email",correos);
                Rutina5.putExtra("clave",claves);
                Rutina5.putExtra("nombre",nombres);


                startActivity(Rutina5);
            }
        });

        rutina6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                Intent Rutina6 = new Intent(Init.this,RutinasEjercicio.class);
                Rutina6.putExtra("rut1",6);
                Rutina6.putExtra("rutNombre","ACONDICIONAMIENTO");
                Rutina6.putExtra("usuario",usuarios);
                Rutina6.putExtra("email",correos);
                Rutina6.putExtra("clave",claves);
                Rutina6.putExtra("nombre",nombres);


                startActivity(Rutina6);
            }
        });

        rutina7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                Intent Rutina7 = new Intent(Init.this,RutinasEjercicio.class);
                Rutina7.putExtra("rut1",7);
                Rutina7.putExtra("rutNombre","BAJAR DE PESO");
                Rutina7.putExtra("usuario",usuarios);
                Rutina7.putExtra("email",correos);
                Rutina7.putExtra("clave",claves);
                Rutina7.putExtra("nombre",nombres);


                startActivity(Rutina7);
            }
        });

        rutina8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                Intent Rutina8 = new Intent(Init.this,RutinasEjercicio.class);
                Rutina8.putExtra("rut1",8);
                Rutina8.putExtra("rutNombre","BAJAR DE PESO");
                Rutina8.putExtra("usuario",usuarios);
                Rutina8.putExtra("email",correos);
                Rutina8.putExtra("clave",claves);
                Rutina8.putExtra("nombre",nombres);


                startActivity(Rutina8);
            }
        });

        rutina9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                Intent Rutina9 = new Intent(Init.this,RutinasEjercicio.class);
                Rutina9.putExtra("rut1",9);
                Rutina9.putExtra("rutNombre","BAJAR DE PESO");
                Rutina9.putExtra("usuario",usuarios);
                Rutina9.putExtra("email",correos);
                Rutina9.putExtra("clave",claves);
                Rutina9.putExtra("nombre",nombres);


                startActivity(Rutina9);
            }
        });

        progressBar.setVisibility(View.GONE);
    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
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
                Intent perfil = new Intent(Init.this,Perfil.class);
                perfil.putExtra("usuario",usuario);
                perfil.putExtra("nombre",nombre);
                perfil.putExtra("clave",clave);
                perfil.putExtra("email",correo);

                startActivity(perfil);
                break;
            case R.id.nav_yoga:
                Intent yoga = new Intent(Init.this,Yoga.class);
                yoga.putExtra("usuario",usuario);
                yoga.putExtra("nombre",nombre);
                yoga.putExtra("clave",clave);
                yoga.putExtra("email",correo);
                startActivity(yoga);
                break;
            case R.id.nav_meditacion:
                Intent meditacion = new Intent(Init.this,PantallaMeditacion.class);
                meditacion.putExtra("usuario",usuario);
                meditacion.putExtra("nombre",nombre);
                meditacion.putExtra("clave",clave);
                meditacion.putExtra("email",correo);
                startActivity(meditacion);
                break;

            case R.id.nav_marcas_personales:
                Intent marcas = new Intent(Init.this,MarcasPersonales.class);
                marcas.putExtra("usuario",usuario);
                marcas.putExtra("nombre",nombre);
                marcas.putExtra("clave",clave);
                marcas.putExtra("email",correo);
                startActivity(marcas);
                break;

            case R.id.nav_dias_meditacion:
                Intent dias = new Intent(Init.this,HistorialMeditacionActivity.class);
                dias.putExtra("usuario",usuario);
                dias.putExtra("nombre",nombre);
                dias.putExtra("clave",clave);
                dias.putExtra("email",correo);
                startActivity(dias);
                break;
            case R.id.nav_dias_ejercicio:
                Intent diasEjer = new Intent(Init.this,HistorialEjercicioActivity.class);
                diasEjer.putExtra("usuario",usuario);
                diasEjer.putExtra("nombre",nombre);
                diasEjer.putExtra("clave",clave);
                diasEjer.putExtra("email",correo);
                startActivity(diasEjer);
                break;
            case R.id.nav_dias_yoga:
                Intent diasYog = new Intent(Init.this,HistorialYogaActivity.class);
                diasYog.putExtra("usuario",usuario);
                diasYog.putExtra("nombre",nombre);
                diasYog.putExtra("clave",clave);
                diasYog.putExtra("email",correo);
                startActivity(diasYog);
                break;
            case R.id.nav_recordatorio:
                Intent recordatorio = new Intent(Init.this,MyDoes.class);
                recordatorio.putExtra("usuario",usuario);
                recordatorio.putExtra("nombre",nombre);
                recordatorio.putExtra("clave",clave);
                recordatorio.putExtra("email",correo);
                startActivity(recordatorio);
                break;
            case R.id.nav_mis_rutinas:
                Intent misRutinas = new Intent(Init.this,Rutinas.class);
                misRutinas.putExtra("usuario",usuario);
                misRutinas.putExtra("nombre",nombre);
                misRutinas.putExtra("clave",clave);
                misRutinas.putExtra("email",correo);
                startActivity(misRutinas);
                break;
            case R.id.nav_peso_y_medidas:
                Intent misMedidas = new Intent(Init.this,Probando.class);
                misMedidas.putExtra("usuario",usuario);
                misMedidas.putExtra("nombre",nombre);
                misMedidas.putExtra("clave",clave);
                misMedidas.putExtra("email",correo);
                startActivity(misMedidas);
                break;
            case R.id.nav_logout:
                Intent logout = new Intent(Init.this, Login.class);
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