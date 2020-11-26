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
import android.widget.Toast;

import com.company.workpeace.ClasesAuxiliares.Firebase.MiRutinaAux;
import com.company.workpeace.ClasesAuxiliares.Firebase.MyDoesAux;
import com.company.workpeace.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class RutinasPersonalizadas extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView menuIcon;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ProgressBar progressBar;

    ImageView miAdd,miAdd2,miAdd3,miAdd4,miAdd5,miAdd6,miAdd7,miAdd8,miAd9,miAdd10;

    ImageView miAdd11,miAdd12,miAdd13,miAdd14,miAdd15,miAdd16,miAd17,miAdd18,miAd19,miAdd20;

    ImageView miAdd21,miAdd22,miAdd23,miAdd24,miAd25,miAdd26,miAd27,miAdd28,miAd29,miAdd30;

    ImageView miAdd31,miAdd32,miAdd33,miAdd34,miAd35,miAdd36,miAd37,miAdd38,miAd39,miAdd40;

    ImageView miAdd41,miAdd42,miAdd43,miAdd44,miAd45,miAdd46;

    TextView EjerPecho1,EjerPecho2,EjerPecho3,EjerPecho4,EjerPecho5,EjerPecho6,EjerPecho7,EjerPecho8,EjerPecho9;

    TextView brazo1,brazo2,brazo3,brazo4,brazo5,brazo6,brazo7,brazo8,brazo9,brazo10;

    TextView pierna1,pierna2,pierna3,pierna4,pierna5,pierna6,pierna7,pierna8,pierna9;

    TextView abs1,abs2,abs3,abs4,abs5,abs6,abs7,abs8,abs9;

    TextView hombro1,hombro2,hombro3,hombro4,hombro5,hombro6,hombro7,hombro8,hombro9;

    DatabaseReference baseDatos;
    String usuario, nombre, clave, correo;

    Integer doesNum = new Random().nextInt();
    String keydoes = Integer.toString(doesNum);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_rutinas_personalizadas);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        menuIcon = findViewById(R.id.menu_icon);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        baseDatos = FirebaseDatabase.getInstance().getReference();

        Intent intent = getIntent();

        usuario = intent.getStringExtra("usuario");

        miAdd = findViewById(R.id.miAdd);
        miAdd2 = findViewById(R.id.miAdd2);
        miAdd3 = findViewById(R.id.miAdd3);
        miAdd4 = findViewById(R.id.miAdd4);
        miAdd5 = findViewById(R.id.miAdd5);
        miAdd6 = findViewById(R.id.miAdd6);
        miAdd7 = findViewById(R.id.miAdd7);
        miAdd8 = findViewById(R.id.miAdd8);
        miAd9 = findViewById(R.id.miAdd9);
        miAdd10 = findViewById(R.id.miAdd10);
        miAdd11 = findViewById(R.id.miAdd11);
        miAdd12 = findViewById(R.id.miAdd12);
        miAdd13 = findViewById(R.id.miAdd13);
        miAdd14 = findViewById(R.id.miAdd14);
        miAdd15 = findViewById(R.id.miAdd15);
        miAdd16 = findViewById(R.id.miAdd16);
        miAd17 = findViewById(R.id.miAdd17);
        miAdd18 = findViewById(R.id.miAdd18);
        miAd19 = findViewById(R.id.miAdd19);
        miAdd20 = findViewById(R.id.miAdd20);

        miAdd21 = findViewById(R.id.miAdd21);
        miAdd22 = findViewById(R.id.miAdd22);
        miAdd23 = findViewById(R.id.miAdd23);
        miAdd24 = findViewById(R.id.miAdd24);
        miAd25 = findViewById(R.id.miAdd25);
        miAdd26 = findViewById(R.id.miAdd26);
        miAd27 = findViewById(R.id.miAdd27);
        miAdd28 = findViewById(R.id.miAdd28);
        miAd29 = findViewById(R.id.miAdd29);
        miAdd30 = findViewById(R.id.miAdd30);
        miAdd31 = findViewById(R.id.miAdd31);
        miAdd32 = findViewById(R.id.miAdd32);
        miAdd33 = findViewById(R.id.miAdd33);
        miAdd34 = findViewById(R.id.miAdd34);
        miAd35 = findViewById(R.id.miAdd35);
        miAdd36 = findViewById(R.id.miAdd36);
        miAd37 = findViewById(R.id.miAdd37);
        miAdd38 = findViewById(R.id.miAdd38);
        miAd39 = findViewById(R.id.miAdd39);
        miAdd40 = findViewById(R.id.miAdd40);

        miAdd41 = findViewById(R.id.miAdd41);
        miAdd42 = findViewById(R.id.miAdd42);
        miAdd43 = findViewById(R.id.miAdd43);
        miAdd44 = findViewById(R.id.miAdd44);
        miAd45 = findViewById(R.id.miAdd45);
        miAdd46 = findViewById(R.id.miAdd46);

        EjerPecho1 = findViewById(R.id.EjerPecho1);
        EjerPecho2 = findViewById(R.id.EjerPecho2);
        EjerPecho3 = findViewById(R.id.EjerPecho3);
        EjerPecho4 = findViewById(R.id.EjerPecho4);
        EjerPecho5 = findViewById(R.id.EjerPecho5);
        EjerPecho6 = findViewById(R.id.EjerPecho6);
        EjerPecho7 = findViewById(R.id.EjerPecho7);
        EjerPecho8 = findViewById(R.id.EjerPecho8);
        EjerPecho9 = findViewById(R.id.EjerPecho9);

        brazo1 = findViewById(R.id.brazo1);
        brazo2 = findViewById(R.id.brazo2);
        brazo3 = findViewById(R.id.brazo3);
        brazo4 = findViewById(R.id.brazo4);
        brazo5 = findViewById(R.id.brazo5);
        brazo6 = findViewById(R.id.brazo6);
        brazo7 = findViewById(R.id.brazo7);
        brazo8 = findViewById(R.id.brazo8);
        brazo9 = findViewById(R.id.brazo9);
        brazo10 = findViewById(R.id.brazo10);

        pierna1 = findViewById(R.id.Pierna1);
        pierna2 = findViewById(R.id.Pierna2);
        pierna3 = findViewById(R.id.Pierna3);
        pierna4 = findViewById(R.id.Pierna4);
        pierna5 = findViewById(R.id.Pierna5);
        pierna6 = findViewById(R.id.Pierna6);
        pierna7 = findViewById(R.id.Pierna7);
        pierna8 = findViewById(R.id.Pierna8);
        pierna9 = findViewById(R.id.Pierna9);

        abs1 = findViewById(R.id.abs1);
        abs2 = findViewById(R.id.ab2);
        abs3 = findViewById(R.id.abs3);
        abs4 = findViewById(R.id.abs4);
        abs5 = findViewById(R.id.abs5);
        abs6 = findViewById(R.id.abs6);
        abs7 = findViewById(R.id.abs7);
        abs8 = findViewById(R.id.abs8);
        abs9 = findViewById(R.id.abs9);

        hombro1 = findViewById(R.id.hombro1);
        hombro2 = findViewById(R.id.hombro2);
        hombro3 = findViewById(R.id.hombro3);
        hombro4 = findViewById(R.id.hombro4);
        hombro5 = findViewById(R.id.hombro5);
        hombro6 = findViewById(R.id.hombro6);
        hombro7 = findViewById(R.id.hombro7);
        hombro8 = findViewById(R.id.hombro8);
        hombro9 = findViewById(R.id.hombro9);



        navigationDrawer();
        progressBar.setVisibility(View.GONE);


        miAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = EjerPecho1.getText().toString();
                String descrip = "Sobre una superficie elevada colocar la palma de las manos a la anchura de los hombros, con los codos extendidos y el cuerpo recto. A continuación, se baja el pecho hasta que quede muy cerca de la superficie y se extiende los brazos para volver a la posición inicial";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 1;
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                intent.putExtra("ElNumero",number);
                startActivity(intent);

            }
        });

        miAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = EjerPecho2.getText().toString();
                String descrip = "Apoyar las rodillas sobre el suelo y levantar ligeramente los pies, colocar la palma de las manos separadas y los brazos completamente estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 2;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                startActivity(intent);

            }
        });

        miAdd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = EjerPecho3.getText().toString();
                String descrip = "Apoyar sobre el suelo la palma de las manos a la anchura de los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 3;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = EjerPecho4.getText().toString();
                String descrip = "Apoyar sobre el suelo la palma de las manos con una anchura superior que los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 4;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = EjerPecho5.getText().toString();
                String descrip = "Apoyar sobre el suelo la palma de las manos a la anchura de los hombros, con la espalda recta y la cadera elevada. A continuación, se baja el pecho hasta que el cuerpo quede recto y se extiende los brazos y sube la cadera para volver a la posición inicial";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 5;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = EjerPecho6.getText().toString();
                String descrip = "Apoyar sobre el suelo la palma de las manos con una anchura superior que los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 6;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = EjerPecho7.getText().toString();
                String descrip = "Apoyar sobre el suelo la palma de las manos a la anchura de los hombros con el cuerpo recto. A continuación, se baja el pecho hasta quedar cerca del suelo y se extiende los brazos para volver a la posición inicial. Ahora se gira el tronco y se extiende hacia arriba una mano";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 7;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = EjerPecho8.getText().toString();
                String descrip = "Apoyar las rodillas y pies sobre el suelo, colocar la palma de las manos separadas y los brazos completamente estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 8;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = EjerPecho9.getText().toString();
                String descrip = "Apoyar sobre el suelo ambas manos juntas, con el cuerpo recto y a la altura de los hombros. A continuación, se baja el pecho hasta que quede muy cerca de suelo y se extiende los brazos para volver a la posición inicial";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 9;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = brazo1.getText().toString();
                String descrip = "Sentados en una silla colocando las manos al lado del cuerpo con los dedos mirando hacia delante, luego nos sostenemos sobre los brazos bajando los glúteos hasta que tus codos queden lo más cerca de un ángulo de 90 grados. Empujamos ejerciendo fuerza con los tríceps para volver a la posición inicial de manera que los brazos queden estirados";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 10;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = brazo2.getText().toString();
                String descrip = "Colócate en la misma posición que para las flexiones clásicas. Coloca las manos formando un triángulo. Inspira, contrae los brazos al bajar y mantén los pies juntos. Expira profundamente al acabar el movimiento, metiendo el abdomen para trabajar los abdominales interiores";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 11;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = brazo3.getText().toString();
                String descrip = "Colócate en posición de lucha, con los puños hacia arriba y las palmas enfrentadas. Rota las caderas a la izquierda y extiende el brazo derecho girando el antebrazo, de modo que las uñas apunten al suelo y el brazo quede alineado con el hombro. Vuelve a la posición inicial y repite con el otro lado";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 12;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = brazo4.getText().toString();
                String descrip = "Camina con tus manos hacia adelante hasta que estés apoyando todo tu peso en tus manos y dedos de los pies. Tu cuerpo debe hacer una línea recta y tus manos deben alinearse con tus hombros. Camina tus pies hacia adelante para encontrarte con tus manos";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 13;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = brazo5.getText().toString();
                String descrip = "Acuéstate boca abajo y coloque las manos en el suelo al ancho de los hombros. Levanta el cuerpo hacia arriba y ve enderezando los brazos. El cuerpo debe apoyarse únicamente sobre las manos y los dedos de los pies. Bajamos el cuerpo doblando los brazos, volvemos a la posición inicial extendiendo los brazos";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 14;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = brazo6.getText().toString();
                String descrip = "Colócate en posición de lucha, con los puños hacia arriba y las palmas enfrentadas. Rota las caderas a la izquierda y extiende el brazo derecho girando el antebrazo, de modo que las uñas apunten al suelo y el brazo quede alineado con el hombro. Vuelve a la posición inicial y repite con el otro lado";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 15;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = brazo7.getText().toString();
                String descrip = "Pon tus manos bajo los hombros en el piso. Estira los brazos y mantén una ligera curva en los codos. Dobla lentamente los codos y baja el torso hasta que tus brazos lleguen a un ángulo de 90º. Una vez que has llegado a tu tope, empuja con las manos y vuelve a levantarte a la posición original";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 16;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAd17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = brazo8.getText().toString();
                String descrip = "Colócate en la posición normal de flexión. El cuerpo debe formar una línea recta, baja lentamente el cuerpo hasta el suelo. Cuando el pecho toque el suelo vuelve a subir impulsándote a la posición inicial. En esta posición alza un brazo, girando la parte superior del cuerpo en la misma dirección hasta que el cuerpo quede en forma de T.";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 17;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = brazo9.getText().toString();
                String descrip = "Mantener tu abdomen bien apretato. Brinca lo mas alto que puedas, tus puntas de los pies deben caer primero y despues tu talón";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 18;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAd19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = brazo10.getText().toString();

                String descrip = "Colócate en posición de plancha frontal, ahora lleva el brazo derecho hacia adelante y la pierna izquierda atrás. Repite con la pierna y brazo contrario y alterna los movimientos";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 19;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = pierna1.getText().toString();
                String descrip = "Mantener la cabeza horizontal, colocar los pies al ancho de los hombros y flexionar la rodilla sin sobrepasar la punta de los pies";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 20;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = pierna2.getText().toString();
                String descrip = "Ubique las manos en la cintura y separe los pies al ancho de los hombros. Despues deslice un pie hacia atras y baje la cadera de manera que la rodilla quede flexionada en un angulo de 90 grados";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 21;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = pierna3.getText().toString();
                String descrip = "Realice una sentadilla echando las caderas hacia atra contra una pared y antenga los talones apoyados y las rodillas hacia afuera, si lo desea levante los brazos hacia adelante para mantener el equilibrio";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 22;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = pierna4.getText().toString();
                String descrip = "Ubiquese en cuatro puntos con las rodillas apoyadas en el suelo y los brazos separados al ancho de los hombros. Deje la pierna derecha en su posicion y eleve la pierna izquierda flexionada y apriee el gluteo";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 23;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = pierna5.getText().toString();
                String descrip = "Ubiquese en cuatro puntos con las rodillas apoyadas en el suelo y los brazos separados al ancho de los hombros. Deje la pierna izquierda en su posicion y eleve la pierna derecha flexionada y apriee el gluteo";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 24;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAd25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = pierna6.getText().toString();
                String descrip = "Ubiquese en cuatro puntos con las rodillas apoyadas en el suelo y los brazos separados al ancho de los hombros, con la rodilla derecha doblada levanta al lado y vuelva a colocarla en la posicion incial. Haga los mismo con la otra pierna";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 25;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = pierna7.getText().toString();
                String descrip = "Ubique las manos manos en la cintura, separe los pies al ancho de los hombros y apriete abdomen. De un paso largo hacia adelante y flexione sin que la rodilla sobrepase la punta del pie";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 26;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAd27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = pierna8.getText().toString();
                String descrip = "Separe los pies al ancho de los hombros y coloque las manos en la cintura, flexiones las rodillas y baje la cadera y a medida que desciende eleve los talones, manteniendo siempre la espalda recto";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 27;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = pierna9.getText().toString();
                String descrip = "Pongase de pie derecho, si lo desea estire los brazos para mayor estabilidad y empiece a subir los dedos como si se pusiera en puntas de pie, comience a bajar lentamente y repita";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 28;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAd29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = abs1.getText().toString();
                String descrip = "Acuéstate, estira brazos y piernas, elévalas y haz que se toquen manos con pies en el centro.";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 29;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = abs2.getText().toString();
                String descrip = "Acuéstate y apoya los talones en el suelo, estira los brazos e intenta tocar las rodillas, la cabeza siempre debe estar levantada.";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 30;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = abs3.getText().toString();
                String descrip = "Acuéstate y levanta las piernas a una altura de 20 cm aproximadamente, coloca las manos en la nuca y realiza elevaciones con piernas juntas hasta formar un ángulo de 90° con el tronco, no puedes dejar caer las piernas totalmente.";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 31;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = abs4.getText().toString();
                String descrip = "Acomódate mirando boca abajo, apóyate sobre los antebrazos, levantas la cola de forma que tu cuerpo quede recto, no se puede tener la cola muy arriba ni tampoco apoyar el abdomen en el suelo, mantén esa posición según el tiempo indicado.";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 32;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = abs5.getText().toString();
                String descrip = "Acuéstate y apoya talones en el suelo, coloca los brazos en el pecho, cada que levantes el tronco giras por lado izquierdo y por lado derecho.";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 33;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = abs6.getText().toString();
                String descrip = "Acuéstate, recoge las piernas, pega los talones al suelo y sepáralas al ancho de los hombros, posteriormente intenta tocar el talón derecho con la mano derecha y viceversa, de manera alterna.";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 34;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAd35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = abs7.getText().toString();
                String descrip = "Acuéstate, recoge las piernas y pega los talones al suelo, separa las piernas un poco menos del ancho de los hombros, coloca manos en la nuca o en el pecho y sube el tronco.";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 35;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = abs8.getText().toString();
                String descrip = "Colócate en 4 apoyos en el suelo, sube las rodillas de manera alterna al pecho de manera rápida";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 36;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAd37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = abs9.getText().toString();
                String descrip = "Apoyar sobre el suelo la palma de las manos con una anchura superior que los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 37;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = hombro1.getText().toString();
                String descrip = "Comenzamos de pie, con las piernas ligeramente flexionadas y el tronco inclinado hacia delante. Fíjate bien que la espalda esté recta, coloca el brazo en horizontal y paralelo al cuerpo con el codo flexionado y un objeto liviano en la mano. Inspirar y realizar una extensión del antebrazo, expirar al final del movimiento.";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 38;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAd39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = hombro2.getText().toString();
                String descrip = "Debemos colocarnos con la espalda apoyada en el piso y la vista hacia arriba. Para que la columna lumbar quede apoyada totalmente, es recomendable flexionar las rodillas y descansar los pies en el suelo. Debemos colocar los brazos a los lados, de manera que queden perpendicular al cuerpo. Desde allí, empujamos con los codos hacia el suelo para despegar los hombros y la espalda alta de la superficie.";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 39;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = hombro3.getText().toString();
                String descrip = "En posición de perrito con los brazos totalmente estirados y las piernas juntas, lleva primero el estomago hacia afuera, elevando la espalda y metiendo cola lo más posible sin perder la postura, posteriormente realizas el mismo movimiento pero esta vez metiendo la espalda y sacando la cola";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 40;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = hombro4.getText().toString();
                String descrip = "Poner las manos sobre una silla o una banqueta que esté bien firme al suelo y no se vaya a mover mientras realizamos el ejercicio, y los pies serán los otros dos puntos de apoyo. Por ultimo realizar una flexion llevando la el pecho a la silla";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 41;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = hombro5.getText().toString();
                String descrip = "Empiece acostado boca arriba en el piso. Flexione las rodillas y abrácelas contra el pecho. Abra las rodillas hacia las axilas y tome los extremos externos de los pies con las manos. Mantenga la espalda en el piso y mézase suavemente de izquierda a derecha, si siente cómodo haciéndolo. En este punto tome por lo menos cinco respiraciones profundas";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 42;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = hombro6.getText().toString();
                String descrip = "Iniciamos acostados boca abajo en una esterilla y elevaremos el tronco levemente, con las manos por detrás de la cabeza o del glúteo. Es recomendable, que elevemos simultáneamente a la cabeza las piernas, quedando únicamente el abdomen en contacto con el suelo. Volveremos al punto de partida nuevamente.";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 43;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = hombro7.getText().toString();
                String descrip = "Comienza por recostarte boca abajo, apoyando tus brazos y piernas sobre el piso. Extiende lentamente tus brazos hacia el frente y tus piernas hacia atrás. Luego levanta del suelo unas cuantas pulgadas los brazos, la parte superior del pecho y las piernas simultáneamente. Mantén esta posición un momento antes de volver a bajar suavemente tus brazos y piernas.";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 44;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAd45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = hombro8.getText().toString();
                String descrip = "Inicia totalmente derecho, luego lleva las manos justo delante de los pies y camina con las manos hasta tener el cuerpo totalmente estirado, te devuelves de la misma forma";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 45;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });

        miAdd46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RutinasPersonalizadas.this,CrearMiRutina.class);
                String nombre = hombro9.getText().toString();
                String descrip = "Iniciamos con los antebrazos en el suelo, las palmas de las manos unidas entre sí y el cuerpo en forma de V invertida. Con la espalda recta en todo momento, descenderemos el tronco para alinear el cuerpo y colocarlo paralelo al suelo. Los hombros deben bajar hasta quedar cerca de las muñecas";
                String series = "0";
                String key = keydoes;
                String username = usuario;
                int number = 46;
                intent.putExtra("ElNumero",number);
                intent.putExtra("elNombre",nombre);
                intent.putExtra("laDescrip",descrip);
                intent.putExtra("elKey",key);
                intent.putExtra("usuario",username);
                intent.putExtra("lasSeries",series);
                intent.putExtra("EldoesNum",doesNum);
                startActivity(intent);

            }
        });





    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_mis_rutinas);
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
                Intent perfil = new Intent(RutinasPersonalizadas.this,Perfil.class);
                perfil.putExtra("usuario",usuario);
                perfil.putExtra("nombre",nombre);
                perfil.putExtra("clave",clave);
                perfil.putExtra("email",correo);

                startActivity(perfil);
                break;
            case R.id.nav_yoga:
                Intent yoga = new Intent(RutinasPersonalizadas.this,Yoga.class);
                yoga.putExtra("usuario",usuario);
                yoga.putExtra("nombre",nombre);
                yoga.putExtra("clave",clave);
                yoga.putExtra("email",correo);
                startActivity(yoga);
                break;
            case R.id.nav_peso_y_medidas:
                Intent peso = new Intent(RutinasPersonalizadas.this,Probando.class);
                startActivity(peso);
                break;
            case R.id.nav_meditacion:
                Intent meditacion = new Intent(RutinasPersonalizadas.this,PantallaMeditacion.class);
                meditacion.putExtra("usuario",usuario);
                meditacion.putExtra("nombre",nombre);
                meditacion.putExtra("clave",clave);
                meditacion.putExtra("email",correo);
                startActivity(meditacion);
                break;
        }
        return true;

    }
}