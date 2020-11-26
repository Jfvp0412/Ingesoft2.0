package com.company.workpeace.ClasesPrincipales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.company.workpeace.ClasesAuxiliares.Firebase.EjercicioAux;
import com.company.workpeace.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RutinasEjercicio extends AppCompatActivity {

    TextView ejercicio,ejercicio2,ejercicio3,ejercicio4,ejercicio5,nombre;
    FirebaseDatabase rutaMarcas;
    DatabaseReference referenciaMarcas;

    ImageView volver;

    DatabaseReference referencia;
    DatabaseReference baseDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutinas_ejercicio);

        ejercicio = findViewById(R.id.pecho);
        ejercicio2 = findViewById(R.id.brazo);
        ejercicio3 = findViewById(R.id.pierna);
        ejercicio4 = findViewById(R.id.abdomen);
        ejercicio5 = findViewById(R.id.espalda);

        final String usuarios,correos,claves,nombres;

        Intent intent = getIntent();
        usuarios = intent.getStringExtra("usuario");
        correos = intent.getStringExtra("email");
        claves = intent.getStringExtra("clave");
        nombres = intent.getStringExtra("nombre");

        volver = findViewById(R.id.volverWorkout);
        referenciaMarcas = FirebaseDatabase.getInstance().getReference("Workouts");
        rutaMarcas = FirebaseDatabase.getInstance();
        referencia = rutaMarcas.getReference("Workouts");
        baseDatos = FirebaseDatabase.getInstance().getReference();
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver = new Intent(RutinasEjercicio.this,Init.class);
                volver.putExtra("usuario",usuarios);
                volver.putExtra("email",correos);
                volver.putExtra("clave",claves);
                volver.putExtra("nombre",nombres);
                startActivity(volver);
            }
        });
        final Intent recibir = getIntent();
        final int a = recibir.getIntExtra("rut1",0);
        String nombreRutina = recibir.getStringExtra("rutNombre");
        nombre = findViewById(R.id.rutinas);
        nombre.setText(nombreRutina);

        final String pecho1 = "Fortalecimiento principiantes pecho";
        EjercicioAux ejercicioAux = new EjercicioAux(
                "Flexiones con inclinación"
                ,"Flexiones con apoyo de rodillas"
                ,"Flexiones"
                ,"Flexiones con brazos abiertos",
                "Flexiones hindúes"
                ,"Flexiones con inclinación"
                ,pecho1," Sobre una superficie elevada colocar la palma de las manos a la anchura de los hombros, con los codos extendidos y el cuerpo recto. A continuación, se baja el pecho hasta que quede muy cerca de la superficie y se extiende los brazos para volver a la posición inicial "," Apoyar las rodillas sobre el suelo y levantar ligeramente los pies, colocar la palma de las manos separadas y los brazos completamente estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial ", "Apoyar sobre el suelo la palma de las manos a la anchura de los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial ", "Apoyar sobre el suelo la palma de las manos con una anchura superior que los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial"," Apoyar sobre el suelo la palma de las manos a la anchura de los hombros, con la espalda recta y la cadera elevada. A continuación, se baja el pecho hasta que el cuerpo quede recto y se extiende los brazos y sube la cadera para volver a la posición inicial "," Sobre una superficie elevada colocar la palma de las manos a la anchura de los hombros, con los codos extendidos y el cuerpo recto. A continuación, se baja el pecho hasta que quede muy cerca de la superficie y se extiende los brazos para volver a la posición inicial ", " 3 sets de 8 reps "," 3 sets de 6 reps "," 3 sets de 6 reps "," 3 sets de 6 reps "," 2 sets de 6 reps ", " 2 sets de 8 reps");
        referencia.child(pecho1).setValue(ejercicioAux);


        final String pecho2 = "Fortalecimiento intermedios pecho";
        EjercicioAux ejercicioAux2 = new EjercicioAux("Flexiones con apoyo de rodillas"
                ,"Flexiones"
                ,"Flexiones hindúes"
                ,"Flexiones escalonadas",
                "Flexiones con brazos abiertos"
                ,"Burpees"
                ,pecho2,
                "Apoyar sobre el suelo la palma de las manos a la anchura de los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial "
                ,"Apoyar sobre el suelo la palma de las manos a la anchura de los hombros, con la espalda recta y la cadera elevada. A continuación, se baja el pecho hasta que el cuerpo quede recto y se extiende los brazos y sube la cadera para volver a la posición inicial "
                , "Con el cuerpo recto, apoyar una mano a la anchura de los hombros y la otra mano por debajo del hombro. A continuación, se baja el pecho hasta que quedar cerca del suelo y se extiende los brazos para volver a la posición inicial. Después se intercambia la posición de las manos y repite "
                ,"Apoyar sobre el suelo la palma de las manos con una anchura superior que los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial "
                ," Empieza con el cuerpo erguido. Se debe agachar y apoyar las manos en el suelo y enseguida estirar los pies hacia atrás, dejando los brazos a la altura del hombro. A continuación, se realiza una flexión normal e impulsa los pies hacia adelante. Ahora realiza un salto extendiendo los brazos hacia arriba"
                ,"Apoyar sobre el suelo la palma de las manos con una anchura superior que los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial"
                ,"3 sets de 6 reps "
                ,"3 sets de 4 reps "
                ,"3 sets de 4 reps "
                ,"3 sets de 4 reps "
                ,"3 sets de 8 reps "
                ,"3 sets de 8 reps ");

        referencia.child(pecho2).setValue(ejercicioAux2);

        final String pecho3 = "Fortalecimiento avanzados pecho";
        EjercicioAux ejercicioAux3 = new EjercicioAux("Burpees"
                ,"Flexiones escalonadas"
                ,"Flexiones hindúes"
                ,"Flexión y rotación",
                "Flexiones en diamante"
                ,"Burpees"
                ,pecho3
                ,"Empieza con el cuerpo erguido. Se debe agachar y apoyar las manos en el suelo y enseguida estirar los pies hacia atrás, dejando los brazos a la altura del hombro. A continuación, se realiza una flexión normal e impulsa los pies hacia adelante. Ahora realiza un salto extendiendo los brazos hacia arriba"
                ,"Con el cuerpo recto, apoyar una mano a la anchura de los hombros y la otra mano por debajo del hombro. A continuación, se baja el pecho hasta que quedar cerca del suelo y se extiende los brazos para volver a la posición inicial. Después se intercambia la posición de las manos y repite "
                ," Apoyar sobre el suelo la palma de las manos a la anchura de los hombros, con la espalda recta y la cadera elevada. A continuación, se baja el pecho hasta que el cuerpo quede recto y se extiende los brazos y sube la cadera para volver a la posición inicial "
                , "Apoyar sobre el suelo la palma de las manos a la anchura de los hombros con el cuerpo recto. A continuación, se baja el pecho hasta quedar cerca del suelo y se extiende los brazos para volver a la posición inicial. Ahora se gira el tronco y se extiende hacia arriba una mano "
                ,"Apoyar sobre el suelo ambas manos juntas, con el cuerpo recto y a la altura de los hombros. A continuación, se baja el pecho hasta que quede muy cerca de suelo y se extiende los brazos para volver a la posición inicial "
                ,"Empieza con el cuerpo erguido. Se debe agachar y apoyar las manos en el suelo y enseguida estirar los pies hacia atrás, dejando los brazos a la altura del hombro. A continuación, se realiza una flexión normal e impulsa los pies hacia adelante. Ahora realiza un salto extendiendo los brazos hacia arriba"
                ,"3 sets de 15 reps "
                ,"3 sets de 12 reps "
                ,"2 sets de 12 reps "
                ,"4 sets de 8 reps "
                ,"3 sets de 8 reps "
                ,"3 sets de 12 reps");

        referencia.child(pecho3).setValue(ejercicioAux3);

        final String pecho4 = "Acondicionamiento principiantes pecho";
        EjercicioAux ejercicioAux4 = new EjercicioAux("Saltos De Tijera"
                ,"Flexiones con Apoyo de Rodillas"
                ,"Flexiones"
                ,"Flexiones con brazos abiertos",
                "flexiones escalonadas"
                ,"Burpees"
                ,pecho4
                ,"Párese derecho con los pies juntos y las manos a los lados. Salte, abra los pies y ponga ambas manos juntas sobre su cabeza. Saltar de nuevo y volver a la posición inicial. Repita hasta que el juego esté completo."
                ,"Apoyar las rodillas sobre el suelo y levantar ligeramente los pies, colocar la palma de las manos separadas y los brazos completamente estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial "
                ,"Apoyar sobre el suelo la palma de las manos a la anchura de los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial "
                ,"Apoyar sobre el suelo la palma de las manos con una anchura superior que los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial "
                ,"Con el cuerpo recto, apoyar una mano a la anchura de los hombros y la otra mano por debajo del hombro. A continuación, se baja el pecho hasta que quedar cerca del suelo y se extiende los brazos para volver a la posición inicial. Después se intercambia la posición de las manos y repite "
                ," Empieza con el cuerpo erguido. Se debe agachar y apoyar las manos en el suelo y enseguida estirar los pies hacia atrás, dejando los brazos a la altura del hombro. A continuación, se realiza una flexión normal e impulsa los pies hacia adelante. Ahora realiza un salto extendiendo los brazos hacia arriba "
                ,"4 sets de 6 reps "
                ,"3 sets de 6 reps "
                ,"3 sets de 6 reps "
                ,"3 sets de 8 reps "
                ,"3 sets de 8 reps"
                ,"2 sets de 12 reps");

        referencia.child(pecho4).setValue(ejercicioAux4);

        final String pecho5 = "Acondicionamiento intermedios pecho";
        EjercicioAux ejercicioAux5 = new EjercicioAux("Flexiones spiderman"
                ,"Saltos de tijera"
                ,"Flexiones con Inclinación"
                ,"Flexiones",
                "Flexiones con Brazos Abiertos"
                ,"flexiones en Caja"
                ,pecho5
                ,"Ponte en la posición clásica de flexiones con las piernas estiradas y los abdominales contraídos.Al descender, dobla la pierna derecha y rota la rodilla derecha de modo que vaya más allá del codo derecho. Al subir, lleva la pierna de nuevo a la posición inicial y acerca ahora la pierna izquierda al codo izquierda. Repite el movimiento con cada pierna"
                ,"Con el cuerpo erguido, dar un salto y abrir las piernas, estirando al mismo tiempo los brazos hacia afuera. A continuación, se da un salto y se juntan los pies, juntando al mismo tiempo ambos brazos hacia arriba "
                ,"Sobre una superficie elevada colocar la palma de las manos a la anchura de los hombros, con los codos extendidos y el cuerpo recto. A continuación, se baja el pecho hasta que quede muy cerca de la superficie y se extiende los brazos para volver a la posición inicial "
                ,"Apoyar sobre el suelo la palma de las manos a la anchura de los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial "
                ,"Apoyar sobre el suelo la palma de las manos con una anchura superior que los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial "
                ,"Apoyar las rodillas y pies sobre el suelo, colocar la palma de las manos separadas y los brazos completamente estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial "
                ,"3 sets de 12 reps "
                ,"3 sets de 6 reps "
                ,"3 sets de 6 reps "
                ,"3 sets de 4 reps "
                ,"3 sets de 6 reps "
                ,"4 sets de 8 reps");

        referencia.child(pecho5).setValue(ejercicioAux5);

        final String pecho6 = "Acondicionamiento avanzados pecho";
        EjercicioAux ejercicioAux6 = new EjercicioAux("Flexiones hindúes"
                ,"Flexiones con brazos abiertos"
                ,"Burpees"
                ,"Flexiones escalonadas"
                ,"Flexión y rotación"
                ,"Flexiones"
                ,pecho6
                ,"Apoyar sobre el suelo la palma de las manos con una anchura superior que los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial "
                ,"Empieza con el cuerpo erguido. Se debe agachar y apoyar las manos en el suelo y enseguida estirar los pies hacia atrás, dejando los brazos a la altura del hombro. A continuación, se realiza una flexión normal e impulsa los pies hacia adelante. Ahora realiza un salto extendiendo los brazos hacia arriba "
                ,"Con el cuerpo recto, apoyar una mano a la anchura de los hombros y la otra mano por debajo del hombro. A continuación, se baja el pecho hasta que quedar cerca del suelo y se extiende los brazos para volver a la posición inicial. Después se intercambia la posición de las manos y repite "
                ,"Apoyar sobre el suelo la palma de las manos a la anchura de los hombros con el cuerpo recto. A continuación, se baja el pecho hasta quedar cerca del suelo y se extiende los brazos para volver a la posición inicial. Ahora se gira el tronco y se extiende hacia arriba una mano "
                ,"Apoyar sobre el suelo la palma de las manos a la anchura de los hombros con el cuerpo recto. A continuación, se baja el pecho hasta quedar cerca del suelo y se extiende los brazos para volver a la posición inicial. Ahora se gira el tronco y se extiende hacia arriba una mano"
                ,"Apoyar sobre el suelo la palma de las manos a la anchura de los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial "
                ,"3 sets de 6 reps"
                ,"3 sets de 8 reps"
                ,"3 sets de 6 reps"
                ,"3 sets de 4 reps"
                ,"2 sets de 6 reps"
                ,"3 sets de 10 reps");
        referencia.child(pecho6).setValue(ejercicioAux6);

        final String pecho7 = "Bajar de peso principiantes pecho";
        EjercicioAux ejercicioAux7 = new EjercicioAux(
                "Saltos De Tijera"
                ,"Flexiones con Apoyo de Rodillas"
                ,"Flexiones"
                ,"Flexiones con brazos abiertos",
                "flexiones escalonadas"
                ,"Burpees"
                ,pecho7,"Con el cuerpo erguido, dar un salto y abrir las piernas, estirando al mismo tiempo los brazos hacia afuera. A continuación, se da un salto y se juntan los pies, juntando al mismo tiempo ambos brazos hacia arriba ", "Apoyar las rodillas sobre el suelo y levantar ligeramente los pies, colocar la palma de las manos separadas y los brazos completamente estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial ","Apoyar sobre el suelo la palma de las manos a la anchura de los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial ","Apoyar sobre el suelo la palma de las manos con una anchura superior que los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial "," Con el cuerpo recto, apoyar una mano a la anchura de los hombros y la otra mano por debajo del hombro. A continuación, se baja el pecho hasta que quedar cerca del suelo y se extiende los brazos para volver a la posición inicial. Después se intercambia la posición de las manos y repite ","Empieza con el cuerpo erguido. Se debe agachar y apoyar las manos en el suelo y enseguida estirar los pies hacia atrás, dejando los brazos a la altura del hombro. A continuación, se realiza una flexión normal e impulsa los pies hacia adelante. Ahora realiza un salto extendiendo los brazos hacia arriba ","3 sets de 12 reps ","3 sets de 6 reps ","3 sets de 6 reps ","3 sets de 4 reps ","2 sets de 6 reps ","3 sets de 6 reps ");

        referencia.child(pecho7).setValue(ejercicioAux7);

        final String pecho8 = "Bajar de peso intermedios pecho";
        EjercicioAux ejercicioAux8 = new EjercicioAux(
                "Flexiones con inclinación"
                ,"Flexiones con Apoyo de Rodillas"
                ,"Flexiones"
                ,"Flexiones con brazos abiertos",
                "Flexiones hindúes"
                ,"Flexiones con inclinación"
                ,pecho8,"Sobre una superficie elevada colocar la palma de las manos a la anchura de los hombros, con los codos extendidos y el cuerpo recto. A continuación, se baja el pecho hasta que quede muy cerca de la superficie y se extiende los brazos para volver a la posición inicial "," Apoyar las rodillas sobre el suelo y levantar ligeramente los pies, colocar la palma de las manos separadas y los brazos completamente estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial ","Apoyar sobre el suelo la palma de las manos a la anchura de los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial ","Apoyar sobre el suelo la palma de las manos con una anchura superior que los hombros, con el cuerpo recto y los brazos estirados. A continuación, se baja el pecho hasta que quede muy cerca del suelo y se extiende los brazos para volver a la posición inicial ","Apoyar sobre el suelo la palma de las manos a la anchura de los hombros, con la espalda recta y la cadera elevada. A continuación, se baja el pecho hasta que el cuerpo quede recto y se extiende los brazos y sube la cadera para volver a la posición inicial ","Sobre una superficie elevada colocar la palma de las manos a la anchura de los hombros, con los codos extendidos y el cuerpo recto. A continuación, se baja el pecho hasta que quede muy cerca de la superficie y se extiende los brazos para volver a la posición inicial ","3 sets de 6 reps ","3 sets de 6 reps ","3 sets de 6 reps ","3 sets de 4 reps ","3 sets de 4 reps ","2 sets de 6 reps ");

        referencia.child(pecho8).setValue(ejercicioAux8);

        final String pecho9 = "Bajar de peso avanzados pecho";
        EjercicioAux ejercicioAux9 = new EjercicioAux(
                "Burpees"
                ,"Flexiones escalonadas"
                ,"Flexiones hindúes"
                ,"Flexión y rotación",
                "Flexiones en diamante"
                ,"Burpees"
                ,pecho9
                , " Empieza con el cuerpo erguido. Se debe agachar y apoyar las manos en el suelo y enseguida estirar los pies hacia atrás, dejando los brazos a la altura del hombro. A continuación, se realiza una flexión normal e impulsa los pies hacia adelante. Ahora realiza un salto extendiendo los brazos hacia arriba "
                ," Con el cuerpo recto, apoyar una mano a la anchura de los hombros y la otra mano por debajo del hombro. A continuación, se baja el pecho hasta que quedar cerca del suelo y se extiende los brazos para volver a la posición inicial. Después se intercambia la posición de las manos y repite "
                ," Apoyar sobre el suelo la palma de las manos a la anchura de los hombros, con la espalda recta y la cadera elevada. A continuación, se baja el pecho hasta que el cuerpo quede recto y se extiende los brazos y sube la cadera para volver a la posición inicial "
                ,"Apoyar sobre el suelo la palma de las manos a la anchura de los hombros con el cuerpo recto. A continuación, se baja el pecho hasta quedar cerca del suelo y se extiende los brazos para volver a la posición inicial. Ahora se gira el tronco y se extiende hacia arriba una mano "
                ,"Apoyar sobre el suelo ambas manos juntas, con el cuerpo recto y a la altura de los hombros. A continuación, se baja el pecho hasta que quede muy cerca de suelo y se extiende los brazos para volver a la posición inicial "
                ,"Empieza con el cuerpo erguido. Se debe agachar y apoyar las manos en el suelo y enseguida estirar los pies hacia atrás, dejando los brazos a la altura del hombro. A continuación, se realiza una flexión normal e impulsa los pies hacia adelante. Ahora realiza un salto extendiendo los brazos hacia arriba "
                ,"3 sets de 8 reps "
                ,"3 sets de 6 reps "
                ,"3 sets de 6 reps "
                ,"3 sets de 4 reps "
                ,"2 sets de 6 reps "
                ,"3 sets de 8 reps ");

        referencia.child(pecho9).setValue(ejercicioAux9);

//------------------------- EJERCICIOS BRAZO-----------------------------------------------//
        final String brazo10 = "Fortalecimiento principiantes brazo";
        EjercicioAux ejercicioAux10 = new EjercicioAux(
                "Triceps en silla"
                ,"Flexiones en diamante"
                ,"Plancha diagonal"
                ,"Puñetazos",
                "Inchworms"
                ,"Flexiones"
                ,brazo10
                ,"Sentados en una silla colocando las manos al lado del cuerpo con los dedos mirando hacia delante, luego nos sostenemos sobre los brazos bajando los glúteos hasta que tus codos queden lo más cerca de un ángulo de 90 grados. Empujamos ejerciendo fuerza con los tríceps para volver a la posición inicial de manera que los brazos queden estirados."
                ,"Colócate en la misma posición que para las flexiones clásicas. Coloca las manos formando un triángulo. Inspira, contrae los brazos al bajar y mantén los pies juntos. Expira profundamente al acabar el movimiento, metiendo el abdomen para trabajar los abdominales interiores."
                ,"Colócate en posición de plancha frontal, ahora lleva el brazo derecho hacia adelante y la pierna izquierda atrás. Repite con la pierna y brazo contrario y alterna los movimientos"
                ,"Colócate en posición de lucha, con los puños hacia arriba y las palmas enfrentadas. Rota las caderas a la izquierda y extiende el brazo derecho girando el antebrazo, de modo que las uñas apunten al suelo y el brazo quede alineado con el hombro. Vuelve a la posición inicial y repite con el otro lado"
                ,"Camina con tus manos hacia adelante hasta que estés apoyando todo tu peso en tus manos y dedos de los pies. Tu cuerpo debe hacer una línea recta y tus manos deben alinearse con tus hombros. Camina tus pies hacia adelante para encontrarte con tus manos."
                ,"Acuéstate boca abajo y coloque las manos en el suelo al ancho de los hombros. Levanta el cuerpo hacia arriba y ve enderezando los brazos. El cuerpo debe apoyarse únicamente sobre las manos y los dedos de los pies. Bajamos el cuerpo doblando los brazos, volvemos a la posición inicial extendiendo los brazos."
                ,"3 sets de 6 reps"
                ,"2 sets de 6 reps"
                ,"4 sets de 4 reps"
                ,"3 sets de 12 reps"
                ,"2 sets de 6 resp"
                ,"3 sets de 6 reps");

        referencia.child(brazo10).setValue(ejercicioAux10);

        final String brazo11 = "Fortalecimiento intermedios brazo";
        EjercicioAux ejercicioAux11 = new EjercicioAux(
                "Flexiones en la pared"
                ,"Plancha diagonal"
                ,"Triceps en silla"
                ,"Flexiones",
                "Triceps en suelo"
                ,"Fondos militares"
                ,brazo11
                ,"De pie con los pies paralelos, separados a la anchura de las caderas. Apoya las manos contra la pared. Exhala por la boca contrayendo el abdomen mientras flexionas los codos apuntando hacia el suelo y acercas el tronco en bloque hacia la pared. Inhala estirando lentamente los brazos para regresar a la posición inicial."
                ,"Colócate en posición de plancha frontal, ahora lleva el brazo derecho hacia adelante y la pierna izquierda atrás. Repite con la pierna y brazo contrario y alterna los movimientos"
                ,"Sentados en una silla colocando las manos al lado del cuerpo con los dedos mirando hacia delante, luego nos sostenemos sobre los brazos bajando los glúteos hasta que tus codos queden lo más cerca de un ángulo de 90 grados. Empujamos ejerciendo fuerza con los tríceps para volver a la posición inicial de manera que los brazos queden estirados."
                ,"Acuéstate boca abajo y coloque las manos en el suelo al ancho de los hombros. Levanta el cuerpo hacia arriba y ve enderezando los brazos. El cuerpo debe apoyarse únicamente sobre las manos y los dedos de los pies. Bajamos el cuerpo doblando los brazos, volvemos a la posición inicial extendiendo los brazos."
                ,"Pon tus manos bajo los hombros en el piso. Estira los brazos y mantén una ligera curva en los codos. Dobla lentamente los codos y baja el torso hasta que tus brazos lleguen a un ángulo de 90º. Una vez que has llegado a tu tope, empuja con las manos y vuelve a levantarte a la posición original"
                ,"Colócate en posición de lucha, con los puños hacia arriba y las palmas enfrentadas. Rota las caderas a la izquierda y extiende el brazo derecho girando el antebrazo, de modo que las uñas apunten al suelo y el brazo quede alineado con el hombro. Vuelve a la posición inicial y repite con el otro lado"
                ,"3 sets de 12 reps"
                ,"3 sets de 10 reps"
                ,"3 sets de 10 reps"
                ,"2 sets de 8 reps"
                ,"3 sets de 10 reps"
                ,"3 sets de 12 reps");


        referencia.child(brazo11).setValue(ejercicioAux11);

        final String brazo12 = "Fortalecimiento avanzados brazo";
        EjercicioAux ejercicioAux12 = new EjercicioAux(
                "Puñetazos"
                ,"Flexión y rotación"
                ,"Burpees"
                ,"Fondos militares",
                "Saltos sin cuerda"
                ,"Inchworms"
                ,brazo12
                ,"Colócate en posición de lucha, con los puños hacia arriba y las palmas enfrentadas. Rota las caderas a la izquierda y extiende el brazo derecho girando el antebrazo, de modo que las uñas apunten al suelo y el brazo quede alineado con el hombro. Vuelve a la posición inicial y repite con el otro lado"
                ,"Empiece en posición de flexión. Completa una flexión de brazos completa. En la parte superior de la flexión de brazos, gira el brazo desde el centro directamente hacia arriba en una tabla lateral. Gira en los dedos de los pies para permitirte rotar en el tablón lateral. devuélvela al suelo y repite en la izquierda"
                ,"Empieza con el cuerpo erguido. Se debe agachar y apoyar las manos en el suelo y enseguida estirar los pies hacia atrás, dejando los brazos a la altura del hombro. A continuación, se realiza una flexión normal e impulsa los pies hacia adelante. Ahora realiza un salto extendiendo los brazos hacia arriba"
                ,"Colócate en posición de lucha, con los puños hacia arriba y las palmas enfrentadas. Rota las caderas a la izquierda y extiende el brazo derecho girando el antebrazo, de modo que las uñas apunten al suelo y el brazo quede alineado con el hombro. Vuelve a la posición inicial y repite con el otro lado"
                ,"Mantener tu abdomen bien apretato. Brinca lo mas alto que puedas, tus puntas de los pies deben caer primero y despues tu talón"
                ,"Inicia totalmente derecho, luego lleva las manos justo delante de los pies y camina con las manos hasta tener el cuerpo totalmente estirado, te devuelves de la misma forma"
                ,"4 sets de 12 reps"
                ,"3 sets de 12 reps"
                ,"3 sets de 15 reps"
                ,"4 sets de 8 reps"
                ,"4 sets de 12 reps"
                ,"3 sets de 10 reps");


        referencia.child(brazo12).setValue(ejercicioAux12);


        final String brazo13 = "Acondicionamiento principiante brazo";
        EjercicioAux ejercicioAux13 = new EjercicioAux(
                "Triceps en silla"
                ,"Puñetazos"
                ,"Saltos sin cuerda"
                ,"Triceps en suelo"
                , "Fondos militares"
                ,"Flexiones en diamante"
                ,brazo13
                ,"Sentados en una silla colocando las manos al lado del cuerpo con los dedos mirando hacia delante, luego nos sostenemos sobre los brazos bajando los glúteos hasta que tus codos queden lo más cerca de un ángulo de 90 grados. Empujamos ejerciendo fuerza con los tríceps para volver a la posición inicial de manera que los brazos queden estirados."
                ,"Colócate en posición de lucha, con los puños hacia arriba y las palmas enfrentadas. Rota las caderas a la izquierda y extiende el brazo derecho girando el antebrazo, de modo que las uñas apunten al suelo y el brazo quede alineado con el hombro. Vuelve a la posición inicial y repite con el otro lado"
                ,"Mantener tu abdomen bien apretato. Brinca lo mas alto que puedas, tus puntas de los pies deben caer primero y despues tu talón"
                ,"Pon tus manos bajo los hombros en el piso. Estira los brazos y mantén una ligera curva en los codos. Dobla lentamente los codos y baja el torso hasta que tus brazos lleguen a un ángulo de 90º. Una vez que has llegado a tu tope, empuja con las manos y vuelve a levantarte a la posición original"
                ,"Colócate en posición de lucha, con los puños hacia arriba y las palmas enfrentadas. Rota las caderas a la izquierda y extiende el brazo derecho girando el antebrazo, de modo que las uñas apunten al suelo y el brazo quede alineado con el hombro. Vuelve a la posición inicial y repite con el otro lado"
                ,"Colócate en la misma posición que para las flexiones clásicas. Coloca las manos formando un triángulo. Inspira, contrae los brazos al bajar y mantén los pies juntos. Expira profundamente al acabar el movimiento, metiendo el abdomen para trabajar los abdominales interiores."
                ,"2 sets de 6 reps"
                ,"3 sets de 6 reps"
                ,"3 sets de 4 reps"
                ,"3 sets de 8 reps"
                ,"2 sets de 12 reps"
                ,"2 sets de 10 reps");

        referencia.child(brazo13).setValue(ejercicioAux13);



        final String brazo14 = "Acondicionamiento intermedios brazo";
        EjercicioAux ejercicioAux14 = new EjercicioAux(
                "Triceps en silla"
                ,"Puñetazos"
                ,"Burpees"
                ,"Saltos sin cuerda",
                "Flexiones en diamante"
                ,"Flexión y rotación"
                ,brazo14
                ,"Sentados en una silla colocando las manos al lado del cuerpo con los dedos mirando hacia delante, luego nos sostenemos sobre los brazos bajando los glúteos hasta que tus codos queden lo más cerca de un ángulo de 90 grados. Empujamos ejerciendo fuerza con los tríceps para volver a la posición inicial de manera que los brazos queden estirados."
                ,"Colócate en posición de lucha, con los puños hacia arriba y las palmas enfrentadas. Rota las caderas a la izquierda y extiende el brazo derecho girando el antebrazo, de modo que las uñas apunten al suelo y el brazo quede alineado con el hombro. Vuelve a la posición inicial y repite con el otro lado"
                ,"Empieza con el cuerpo erguido. Se debe agachar y apoyar las manos en el suelo y enseguida estirar los pies hacia atrás, dejando los brazos a la altura del hombro. A continuación, se realiza una flexión normal e impulsa los pies hacia adelante. Ahora realiza un salto extendiendo los brazos hacia arriba"
                ,"Mantener tu abdomen bien apretato. Brinca lo mas alto que puedas, tus puntas de los pies deben caer primero y despues tu talón"
                ,"Colócate en la misma posición que para las flexiones clásicas. Coloca las manos formando un triángulo. Inspira, contrae los brazos al bajar y mantén los pies juntos. Expira profundamente al acabar el movimiento, metiendo el abdomen para trabajar los abdominales interiores."
                ,"Colócate en la posición normal de flexión. El cuerpo debe formar una línea recta, baja lentamente el cuerpo hasta el suelo. Cuando el pecho toque el suelo vuelve a subir impulsándote a la posición inicial. En esta posición alza un brazo, girando la parte superior del cuerpo en la misma dirección hasta que el cuerpo quede en forma de T."
                ,"3 sets de 10 reps"
                ,"2 sets de 10 reps"
                ,"3 sets de 12 reps"
                ,"2 sets de 10 reps"
                ,"4 sets de 12 reps"
                ,"3 sets de 10 reps");

        referencia.child(brazo14).setValue(ejercicioAux14);


        final String brazo15 = "Acondicionamiento avanzados brazo";
        EjercicioAux ejercicioAux15 = new EjercicioAux(
                "Flexiones en la pared"
                ,"Plancha diagonal"
                ,"Triceps en silla"
                ,"Flexiones",
                "Triceps en suelo"
                ,"Fondos militares"
                ,brazo15
                ,"De pie con los pies paralelos, separados a la anchura de las caderas. Apoya las manos contra la pared. Exhala por la boca contrayendo el abdomen mientras flexionas los codos apuntando hacia el suelo y acercas el tronco en bloque hacia la pared. Inhala estirando lentamente los brazos para regresar a la posición inicial."
                ,"Colócate en posición de plancha frontal, ahora lleva el brazo derecho hacia adelante y la pierna izquierda atrás. Repite con la pierna y brazo contrario y alterna los movimientos"
                ,"Sentados en una silla colocando las manos al lado del cuerpo con los dedos mirando hacia delante, luego nos sostenemos sobre los brazos bajando los glúteos hasta que tus codos queden lo más cerca de un ángulo de 90 grados. Empujamos ejerciendo fuerza con los tríceps para volver a la posición inicial de manera que los brazos queden estirados."
                ,"Acuéstate boca abajo y coloque las manos en el suelo al ancho de los hombros. Levanta el cuerpo hacia arriba y ve enderezando los brazos. El cuerpo debe apoyarse únicamente sobre las manos y los dedos de los pies. Bajamos el cuerpo doblando los brazos, volvemos a la posición inicial extendiendo los brazos. "
                ,"Pon tus manos bajo los hombros en el piso. Estira los brazos y mantén una ligera curva en los codos. Dobla lentamente los codos y baja el torso hasta que tus brazos lleguen a un ángulo de 90º. Una vez que has llegado a tu tope, empuja con las manos y vuelve a levantarte a la posición original"
                ,"Colócate en posición de lucha, con los puños hacia arriba y las palmas enfrentadas. Rota las caderas a la izquierda y extiende el brazo derecho girando el antebrazo, de modo que las uñas apunten al suelo y el brazo quede alineado con el hombro. Vuelve a la posición inicial y repite con el otro lado"
                ,"4 sets de 12 reps"
                ,"3 sets de 12 reps"
                ,"3 sets de 15 reps"
                ,"4 sets de 8 reps"
                ,"4 sets de 12 reps"
                ,"3 sets de 10 reps");
        referencia.child(brazo15).setValue(ejercicioAux15);


        final String brazo16 = "Bajar de peso principiantes brazo";
        EjercicioAux ejercicioAux16 = new EjercicioAux(
                "Puñetazos"
                ,"Flexión y rotación"
                ,"Burpees"
                ,"Saltos sin cuerda",
                "Inchworms"
                ,"Fondos militares"
                ,brazo16
                ,"Colócate en posición de lucha, con los puños hacia arriba y las palmas enfrentadas. Rota las caderas a la izquierda y extiende el brazo derecho girando el antebrazo, de modo que las uñas apunten al suelo y el brazo quede alineado con el hombro. Vuelve a la posición inicial y repite con el otro lado"
                ," Colócate en la posición normal de flexión. El cuerpo debe formar una línea recta, baja lentamente el cuerpo hasta el suelo. Cuando el pecho toque el suelo vuelve a subir impulsándote a la posición inicial. En esta posición alza un brazo, girando la parte superior del cuerpo en la misma dirección hasta que el cuerpo quede en forma de T. "
                ,"Empieza con el cuerpo erguido. Se debe agachar y apoyar las manos en el suelo y enseguida estirar los pies hacia atrás, dejando los brazos a la altura del hombro. A continuación, se realiza una flexión normal e impulsa los pies hacia adelante. Ahora realiza un salto extendiendo los brazos hacia arriba"
                ,"Mantener tu abdomen bien apretato. Brinca lo mas alto que puedas, tus puntas de los pies deben caer primero y despues tu talón"
                ,"Inicia totalmente derecho, luego lleva las manos justo delante de los pies y camina con las manos hasta tener el cuerpo totalmente estirado, te devuelves de la misma forma"
                ,"Colócate en posición de lucha, con los puños hacia arriba y las palmas enfrentadas. Rota las caderas a la izquierda y extiende el brazo derecho girando el antebrazo, de modo que las uñas apunten al suelo y el brazo quede alineado con el hombro. Vuelve a la posición inicial y repite con el otro lado"
                ,"2 sets de 12 reps"
                ,"3 sets de 8 reps"
                ,"2 sets de 15 reps"
                ,"2 sets de 8 reps"
                ,"2 sets de 12 reps"
                ,"3 sets de 8 reps");

        referencia.child(brazo16).setValue(ejercicioAux16);


        final String brazo17 = "Bajar de peso intermedio brazo";
        EjercicioAux ejercicioAux17 = new EjercicioAux(
                "Triceps en silla"
                ,"Puñetazos"
                ,"Saltos sin cuerda"
                ,"Triceps en suelo",
                "Fondos militares"
                ,"Flexiones en diamante"
                ,brazo17
                ,"Sentados en una silla colocando las manos al lado del cuerpo con los dedos mirando hacia delante, luego nos sostenemos sobre los brazos bajando los glúteos hasta que tus codos queden lo más cerca de un ángulo de 90 grados. Empujamos ejerciendo fuerza con los tríceps para volver a la posición inicial de manera que los brazos queden estirados."
                ,"Colócate en posición de lucha, con los puños hacia arriba y las palmas enfrentadas. Rota las caderas a la izquierda y extiende el brazo derecho girando el antebrazo, de modo que las uñas apunten al suelo y el brazo quede alineado con el hombro. Vuelve a la posición inicial y repite con el otro lado"
                ,"Mantener tu abdomen bien apretato. Brinca lo mas alto que puedas, tus puntas de los pies deben caer primero y despues tu talón"
                ,"Pon tus manos bajo los hombros en el piso. Estira los brazos y mantén una ligera curva en los codos. Dobla lentamente los codos y baja el torso hasta que tus brazos lleguen a un ángulo de 90º. Una vez que has llegado a tu tope, empuja con las manos y vuelve a levantarte a la posición original"
                ,"Colócate en posición de lucha, con los puños hacia arriba y las palmas enfrentadas. Rota las caderas a la izquierda y extiende el brazo derecho girando el antebrazo, de modo que las uñas apunten al suelo y el brazo quede alineado con el hombro. Vuelve a la posición inicial y repite con el otro lado"
                ,"Colócate en la misma posición que para las flexiones clásicas. Coloca las manos formando un triángulo. Inspira, contrae los brazos al bajar y mantén los pies juntos. Expira profundamente al acabar el movimiento, metiendo el abdomen para trabajar los abdominales interiores."
                ,"4 sets de 12 reps"
                ,"3 sets de 12 reps"
                ,"3 sets de 15 reps"
                ,"4 sets de 8 reps"
                ,"4 sets de 12 reps"
                ,"3 sets de 10 reps");

        referencia.child(brazo17).setValue(ejercicioAux17);


        final String brazo18 = "Bajar de peso avanzado brazo";
        EjercicioAux ejercicioAux18 = new EjercicioAux(
                "Triceps en silla"
                ,"Flexiones en diamante"
                ,"Plancha diagonal"
                ,"Puñetazos"
                , "Inchworms"
                ,"Flexiones"
                ,brazo18
                ,"Sentados en una silla colocando las manos al lado del cuerpo con los dedos mirando hacia delante, luego nos sostenemos sobre los brazos bajando los glúteos hasta que tus codos queden lo más cerca de un ángulo de 90 grados. Empujamos ejerciendo fuerza con los tríceps para volver a la posición inicial de manera que los brazos queden estirados."
                ,"Colócate en la misma posición que para las flexiones clásicas. Coloca las manos formando un triángulo. Inspira, contrae los brazos al bajar y mantén los pies juntos. Expira profundamente al acabar el movimiento, metiendo el abdomen para trabajar los abdominales interiores."
                ,"Colócate en posición de plancha frontal, ahora lleva el brazo derecho hacia adelante y la pierna izquierda atrás. Repite con la pierna y brazo contrario y alterna los movimientos"
                ,"Colócate en posición de lucha, con los puños hacia arriba y las palmas enfrentadas. Rota las caderas a la izquierda y extiende el brazo derecho girando el antebrazo, de modo que las uñas apunten al suelo y el brazo quede alineado con el hombro. Vuelve a la posición inicial y repite con el otro lado"
                ,"Inicia totalmente derecho, luego lleva las manos justo delante de los pies y camina con las manos hasta tener el cuerpo totalmente estirado, te devuelves de la misma forma"
                ,"Acuéstate boca abajo y coloque las manos en el suelo al ancho de los hombros. Levanta el cuerpo hacia arriba y ve enderezando los brazos. El cuerpo debe apoyarse únicamente sobre las manos y los dedos de los pies. Bajamos el cuerpo doblando los brazos, volvemos a la posición inicial extendiendo los brazos."
                ,"4 sets de 15 reps"
                ,"3 sets de 20 reps"
                ,"3 sets de 15 reps"
                ,"4 sets de 8 reps"
                ,"4 sets de 10 reps"
                ,"3 sets de 10 reps");

        referencia.child(brazo18).setValue(ejercicioAux18);
//-----------------------------------INICIO EJERCICIOS PIERNA----------------------------------//

        final String pierna19 = "Fortalecimiento principiantes pierna";
        EjercicioAux ejercicioAux19 = new EjercicioAux(
                "Sentadillas"
                ,"Estocada hacia atrás"
                ,"Donkey kicks Izquierda"
                ,"Donkey kicks Derecha"
                , "Sentadilla en pared"
                ,"Sentadillas"
                ,pierna19, "Mantener la cabeza horizontal, colocar los pies al ancho de los hombros y flexionar la rodilla sin sobrepasar la punta de los pies",
                "Ubique las manos en la cintura y separe los pies al ancho de los hombros. Despues deslice un pie hacia atras y baje la cadera de manera que la rodilla quede flexionada en un angulo de 90 grados",
                "Ubiquese en cuatro puntos con las rodillas apoyadas en el suelo y los brazos separados al ancho de los hombros. Deje la pierna derecha en su posicion y eleve la pierna izquierda flexionada y apriee el gluteo",
                "Ubiquese en cuatro puntos con las rodillas apoyadas en el suelo y los brazos separados al ancho de los hombros. Deje la pierna izquierda en su posicion y eleve la pierna derecha flexionada y apriee el gluteo",
                "Realice una sentadilla echando las caderas hacia atra contra una pared y antenga los talones apoyados y las rodillas hacia afuera, si lo desea levante los brazos hacia adelante para mantener el equilibrio",
                "Mantener la cabeza horizontal, colocar los pies al ancho de los hombros y flexionar la rodilla sin sobrepasar la punta de los pies", "5 sets de 12 reps", "4 sets de 15 reps"
                , "4 sets de 15 reps", "5 sets de 30 reps ", "5 sets de 12 reps", "5 sets de 12 reps");

        referencia.child(pierna19).setValue(ejercicioAux19);


        final String pierna20 = "Fortalecimiento intermedios pierna";
        EjercicioAux ejercicioAux20 = new EjercicioAux(
                "Fire hydrant"
                ,"Zancada frontal"
                ,"Sentadilla de sumo"
                ,"Zancada frontal"
                , "Sentadilla con salto y giro"
                ,"Levantamiento de pantorrillas"
                ,pierna20, "Ubiquese en cuatro puntos con las rodillas apoyadas en el suelo y los brazos separados al ancho de los hombros, con la rodilla derecha doblada levanta al lado y vuelva a colocarla en la posicion incial. Haga los mismo con la otra pierna",
                "Ubique las manos manos en la cintura, separe los pies al ancho de los hombros y apriete abdomen. De un paso largo hacia adelante y flexione sin que la rodilla sobrepase la punta del pie",
                "Separe los pies al ancho de los hombros y coloque las manos en la cintura, flexiones las rodillas y baje la cadera y a medida que desciende eleve los talones, manteniendo siempre la espalda recto",
                "Ubique las manos manos en la cintura, separe los pies al ancho de los hombros y apriete abdomen. De un paso largo hacia adelante y flexione sin que la rodilla sobrepase la punta del pie",
                "Ubiquese de pie con los pies juntos y coloque las manos en los muslos, flexiones las rodillas, salte y separe los pies en lo alto. Deje caer los pies separados mas anchos que los hombres hasta quedar en una sentadilla",
                "Pongase de pie derecho, si lo desea estire los brazos para mayor estabilidad y empiece a subir los dedos como si se pusiera en puntas de pie, comience a bajar lentamente y repita ","5 sets de 10 reps", "3 sets de 20 reps"
                , "4 sets de 15 reps", "3 sets de 20 reps", "4 sets de 10 reps", "5 sets de 15 reps");

        referencia.child(pierna20).setValue(ejercicioAux20);


        final String pierna21 = "Fortalecimiento avanzados pierna";
        EjercicioAux ejercicioAux21 = new EjercicioAux(
                "Sentadilla"
                ,"Sentadilla en pared"
                ,"Sentadilla bulgara (Ambos lados)"
                ,"Zancada frontal"
                , "Sentadilla con salto y giro"
                ,"Levantamiento de pantorrillas"
                ,pierna21, "Mantener la cabeza horizontal, colocar los pies al ancho de los hombros y flexionar la rodilla sin sobrepasar la punta de los pies",
                "Realice una sentadilla echando las caderas hacia atra contra una pared y antenga los talones apoyados y las rodillas hacia afuera, si lo desea levante los brazos hacia adelante para mantener el equilibrio",
                "Coloque un pie encima de una silla o un objeto parecido, mantengase erguido y baje la rodilla al suelo mientras que la otra pierna hace una flexion con angulo de 90 grados. Haga los mismo con la otra pierna. Haga lo mismo con la otra pierna ",
                "Ubique las manos manos en la cintura, separe los pies al ancho de los hombros y apriete abdomen. De un paso largo hacia adelante y flexione sin que la rodilla sobrepase la punta del pie",
                "Ubiquese de pie con los pies juntos y coloque las manos en los muslos, flexiones las rodillas, salte y separe los pies en lo alto. Deje caer los pies separados mas anchos que los hombres hasta quedar en una sentadilla",
                "Pongase de pie derecho, si lo desea estire los brazos para mayor estabilidad y empiece a subir los dedos como si se pusiera en puntas de pie, comience a bajar lentamente y repita "
                ,"5 sets de 15 reps"
                , "4 sets de 20 reps "
                , "5 sets de 15 reps"
                , "3 sets de 20 reps"
                , "5 sets de 10 reps"
                , "4 sets de 20 reps");

        referencia.child(pierna21).setValue(ejercicioAux21);


        final String pierna22 = "Acondicionamiento principiantes pierna";
        EjercicioAux ejercicioAux22 = new EjercicioAux(
                "Sentadilla bulgara (Ambos lados)"
                ,"Levantamiento de pantorrilla con sentadilla"
                ,"Levantamiento de pantorrilla con pared"
                ,"Donkey kicks (ambos lados)"
                , "Levantamiento de pantorrillas"
                ,"Zancada frontal"
                ,pierna22
                , "Coloque un pie encima de una silla o un objeto parecido, mantengase erguido y baje la rodilla al suelo mientras que la otra pierna hace una flexion con angulo de 90 grados. Haga los mismo con la otra pierna "
                , "Ubiques como en sentadilla de sumo con los pies apuntando a los lados, levante los talones del suelo y apriete la pantorrilla y baje los talones lentamente hasta su posicion incial"
                ,"Mantenga la pierna derecha hacia dealnte con el pie pegado sin despegar del suelo y estire la pierna izquierda hacia atras. Inclinese sobre la pared hasta que sienta que estira el area de la pantorrilla de la pierna que se encuantra estirasa. Haga lo mismo con la otra pierna "
                ,"Ubiquese en cuatro puntos con las rodillas apoyadas en el suelo y los brazos separados al ancho de los hombros. Deje la pierna derecha en su posicion y eleve la pierna izquierda flexionada y apriee el gluteo. Haga lo mismo con la otra pierna."
                ,"Pongase de pie derecho, si lo desea estire los brazos para mayor estabilidad y empiece a subir los dedos como si se pusiera en puntas de pie, comience a bajar lentamente y repita "
                ,"Ubique las manos manos en la cintura, separe los pies al ancho de los hombros y apriete abdomen. De un paso largo hacia adelante y flexione sin que la rodilla sobrepase la punta del pie"
                , "3 sets de 12 reps"
                , "5 sets de 12 reps"
                , "4 sets de 8 reps"
                , "3 sets de 15 reps"
                , "5 sets de 15 reps"
                , " 4 sets de 12 reps");

        referencia.child(pierna22).setValue(ejercicioAux22);


        final String pierna23 = "Acondicionamiento intermedios pierna";
        EjercicioAux ejercicioAux23 = new EjercicioAux(
                "Salto Lateral"
                ,"Sentadillas"
                ,"Sentadillas"
                ,"Estocada Hacia Atrás"
                , "Levantamiento de pantorrillas"
                ,"Zancada frontal"
                ,pierna23
                , " Pongase de pie con los pies juntos y las rodillas ligeramente flexionadas, da un salto a la izquierda cayendo unicamente en el pie de costado y el codo del lado opuesto deber estar flexionado en un angulo de 90 grados. Hacer lo mismo al otro lado",
                "Mantener la cabeza horizontal, colocar los pies al ancho de los hombros y flexionar la rodilla sin sobrepasar la punta de los pies",
                "Mantener la cabeza horizontal, colocar los pies al ancho de los hombros y flexionar la rodilla sin sobrepasar la punta de los pies",
                "Ubique las manos en la cintura y separe los pies al ancho de los hombros. Despues deslice un pie hacia atras y baje la cadera de manera que la rodilla quede flexionada en un angulo de 90 grados",
                "Pongase de pie derecho, si lo desea estire los brazos para mayor estabilidad y empiece a subir los dedos como si se pusiera en puntas de pie, comience a bajar lentamente y repita ",
                "Ubique las manos manos en la cintura, separe los pies al ancho de los hombros y apriete abdomen. De un paso largo hacia adelante y flexione sin que la rodilla sobrepase la punta del pie"
                , "3 sets de 8 reps", "4 sets de 20 reps", "4 sets de 20 reps", "3 sets de 15 reps", "5 sets de 25 reps", " 3 sets de 10 reps");
        referencia.child(pierna23).setValue(ejercicioAux23);

        final String pierna24 = "Acondicionamiento avanzados pierna";
        EjercicioAux ejercicioAux24 = new EjercicioAux(
                "Fire hydrant Derecha"
                ,"Fire hydrant Izquierda"
                ,"Zancada frontal"
                ,"Sentadilla búlgara"
                , "Burpees"
                ,"Sentadilla de Sumo"
                ,pierna24
                , "Ubiquese en cuatro puntos con las rodillas apoyadas en el suelo y los brazos separados al ancho de los hombros, con la rodilla derecha doblada levanta al lado y vuelva a colocarla en la posicion incial ",
                "Ubiquese en cuatro puntos con las rodillas apoyadas en el suelo y los brazos separados al ancho de los hombros, con la rodilla izquierda doblada levanta al lado y vuelva a colocarla en la posicion incial ",
                "Ubique las manos manos en la cintura, separe los pies al ancho de los hombros y apriete abdomen. De un paso largo hacia adelante y flexione sin que la rodilla sobrepase la punta del pie",
                "Coloque un pie encima de una silla o un objeto parecido, mantengase erguido y baje la rodilla al suelo mientras que la otra pierna hace una flexion con angulo de 90 grados. Haga los mismo con la otra pierna ",
                "Ubiquese en posicion de cuclillas, apoye las manos en el piso, desplace las piernas hacia atras con los pies juntos y realice una flexion de pecho",
                "Separe los pies al ancho de los hombros y coloque las manos en la cintura, flexiones las rodillas y baje la cadera y a medida que desciende eleve los talones, manteniendo siempre la espalda recto"
                , "5 sets de 20 reps"
                , "5 sets de 20 reps"
                , "3 sets de 15 reps"
                , "3 sets de 8 reps", "2 sets de 10 reps", "3 sets de 20 reps");
        referencia.child(pierna24).setValue(ejercicioAux24);

        final String pierna25 = "Bajar de peso principiantes pierna";
        EjercicioAux ejercicioAux25 = new EjercicioAux(
                "Sentadilla búlgara"
                ,"Sentadilla en Pared"
                ,"Burpees"
                ,"Sentadillas"
                , "Zancada cruzada Izquierda"
                ,"Zancada cruzada Derecha"
                ,pierna25
                , "Coloque un pie encima de una silla o un objeto parecido, mantengase erguido y baje la rodilla al suelo mientras que la otra pierna hace una flexion con angulo de 90 grados. Haga los mismo con la otra pierna ",
                "Realice una sentadilla echando las caderas hacia atra contra una pared y antenga los talones apoyados y las rodillas hacia afuera, si lo desea levante los brazos hacia adelante para mantener el equilibrio",
                "Ubiquese en posicion de cuclillas, apoye las manos en el piso, desplace las piernas hacia atras con los pies juntos y realice una flexion de pecho",
                "Mantener la cabeza horizontal, colocar los pies al ancho de los hombros y flexionar la rodilla sin sobrepasar la punta de los pies",
                "Parese ergido con los pies juntos y los brazos a los lados, mueva el pie izquierdo hacia adelante y hacia la derecha doblando la rodilla en un angulo de 90 grados. La pierna derecha debe estar estirada detras de usted",
                "Parese ergido con los pies juntos y los brazos a los lados, mueva el pie derecho hacia adelante y hacia la izquierda doblando la rodilla en un angulo de 90 grados. La pierna izquierda debe estar estirada detras de usted"
                , "4 sets de 12 reps"
                , "3 ses de 45 reps"
                , "2 sets de 8 reps"
                , "3 sets de 20 reps"
                , "4 sets de 12 reps"
                , "4 sets de 12 reps");

        referencia.child(pierna25).setValue(ejercicioAux25);

        final String pierna26 = "Bajar de peso intermedios pierna";
        EjercicioAux ejercicioAux26 = new EjercicioAux(
                "Sentadillas Con Salto y giro"
                ,"Sentadilla en Pared"
                ,"Levantamiento de pantorrillas"
                ,"Zancada frontal"
                , "Burpees"
                ,"Sentadillas"
                ,pierna26
                , "Ubiquese de pie con los pies juntos y coloque las manos en los muslos, flexiones las rodillas, salte y separe los pies en lo alto. Deje caer los pies separados mas anchos que los hombres hasta quedar en una sentadilla",
                "Realice una sentadilla echando las caderas hacia atra contra una pared y antenga los talones apoyados y las rodillas hacia afuera, si lo desea levante los brazos hacia adelante para mantener el equilibrio",
                "Pongase de pie derecho, si lo desea estire los brazos para mayor estabilidad y empiece a subir los dedos como si se pusiera en puntas de pie, comience a bajar lentamente y repita ",
                "Ubique las manos manos en la cintura, separe los pies al ancho de los hombros y apriete abdomen. De un paso largo hacia adelante y flexione sin que la rodilla sobrepase la punta del pie",
                "Ubiquese en posicion de cuclillas, apoye las manos en el piso, desplace las piernas hacia atras con los pies juntos y realice una flexion de pecho",
                "Mantener la cabeza horizontal, colocar los pies al ancho de los hombros y flexionar la rodilla sin sobrepasar la punta de los pies"
                , "3 sets de 10 reps", "5 sets de 20 reps", "5 sets de 25 reps", "4 sets de 10 reps", "2 sets de 15 reps", "5 sets de 20 reps");

        referencia.child(pierna26).setValue(ejercicioAux26);

        final String pierna27 = "Bajar de peso avanzados pierna";
        EjercicioAux ejercicioAux27 = new EjercicioAux(
                "Sentadillas "
                ,"Sentadilla en Pared"
                ,"Donkey kicks Izquierda"
                ,"Donkey kicks Derecha"
                , "Sentadilla en pared"
                ,"Sentadillas"
                ,pierna27
                , "Mantener la cabeza horizontal, colocar los pies al ancho de los hombros y flexionar la rodilla sin sobrepasar la punta de los pies",
                "Realice una sentadilla echando las caderas hacia atra contra una pared y antenga los talones apoyados y las rodillas hacia afuera, si lo desea levante los brazos hacia adelante para mantener el equilibrio",
                "Ubiquese en cuatro puntos con las rodillas apoyadas en el suelo y los brazos separados al ancho de los hombros. Deje la pierna derecha en su posicion y eleve la pierna izquierda flexionada y apriee el gluteo",
                "Ubiquese en cuatro puntos con las rodillas apoyadas en el suelo y los brazos separados al ancho de los hombros. Deje la pierna izquierda en su posicion y eleve la pierna derecha flexionada y apriee el gluteo",
                "Realice una sentadilla echando las caderas hacia atra contra una pared y antenga los talones apoyados y las rodillas hacia afuera, si lo desea levante los brazos hacia adelante para mantener el equilibrio",
                "Mantener la cabeza horizontal, colocar los pies al ancho de los hombros y flexionar la rodilla sin sobrepasar la punta de los pies"
                , "5 sets de 12 reps", "4 sets de 30 reps", "4 sets de 25 reps", "4 sets de 25 reps"
                , "4 sets de 30 reps", "5 sets de 12 reps");

        referencia.child(pierna27).setValue(ejercicioAux27);

//----------------------INICIO EJERCICIOS ABODMEN--------------------------------------------//


        final String abs28 = "Fortalecimiento principiantes abdomen";
        EjercicioAux ejercicioAux28 = new EjercicioAux(
                "Crunch Abdominales"
                ,"Twist ruso"
                ,"Escalada de montaña"
                ,"Toque al talon"
                , "Elevaciones de piernas"
                ,"Plancha"
                ,abs28,
                "Acuéstate y apoya los talones en el suelo, estira los brazos e intenta tocar las rodillas, la cabeza siempre debe estar levantada.",
                "Acuéstate y apoya talones en el suelo, coloca los brazos en el pecho, cada que levantes el tronco giras por lado izquierdo y por lado derecho",
                "Colócate en 4 apoyos en el suelo, sube las rodillas de manera alterna al pecho de manera rápida.",
                "Acuéstate, recoge las piernas, pega los talones al suelo y sepáralas al ancho de los hombros, posteriormente intenta tocar el talón derecho con la mano derecha y viceversa, de manera alterna",
                "Acuéstate y levanta las piernas a una altura de 20 cm aproximadamente, coloca las manos en la nuca y realiza elevaciones con piernas juntas hasta formar un ángulo de 90° con el tronco, no puedes dejar caer las piernas totalmente.",
                "Acomódate mirando boca abajo, apóyate sobre los antebrazos, levantas la cola de forma que tu cuerpo quede recto, no se puede tener la cola muy arriba ni tampoco apoyar el abdomen en el suelo, mantén esa posición según el tiempo indicado.",
                "2 sets de 12 reps",
                "2 sets de 14 reps",
                "3 sets de 26 reps",
                "2 sets de 25 reps",
                "2 sets de 15 reps",
                "2 sets de 30 seg");
        referencia.child(abs28).setValue(ejercicioAux28);

        final String abs29 = "Fortalecimiento intermedios abdomen";
        EjercicioAux ejercicioAux29 = new EjercicioAux(
                "Toque al talón"
                ,"Abdominal cruzado"
                ,"Butt Bridge"
                ,"Crunch de bicicleta"
                , "Crunch Abdominal"
                ,"Plancha"
                ,abs29
                , "Acuéstate, recoge las piernas, pega los talones al suelo y sepáralas al ancho de los hombros, posteriormente intenta tocar el talón derecho con la mano derecha y viceversa, de manera alterna.",
                "Acuéstate, eleva las piernas a una altura de 25 cm aproximadamente, coloca las manos en la nuca, recoge una pierna y toca tu rodilla con el codo contrario, recuerda no bajar las piernas hasta terminar tu ejercicio.",
                "Acuéstate, extiende los brazos, recoge las piernas y apoya talones en el suelo, separa las piernas al ancho de los hombros y eleva el tronco, recuerda que el tronco no debe tocar el suelo hasta terminar el ejercicio.",
                "Acuéstate, coloca las manos en la nuca, recoge las piernas y apoya talones en el suelo, separa las piernas al ancho de los hombros, manda una rodilla al pecho y trata de tocarla con el codo del brazo contrario.",
                "Acuéstate y apoya los talones en el suelo, estira los brazos e intenta tocar las rodillas, la cabeza siempre debe estar levantada.",
                "Acomódate mirando boca abajo, apóyate sobre los antebrazos, levantas la cola de forma que tu cuerpo quede recto, no se puede tener la cola muy arriba ni tampoco apoyar el abdomen en el suelo, mantén esa posición según el tiempo indicado.",
                "3 sets de 30 reps",
                "2 sets de 14 reps",
                "3 sets de 20 reps",
                "3 sets de 18 reps",
                "3 sets de 16 reps",
                "3 sets de 40 seg");
        referencia.child(abs29).setValue(ejercicioAux29);

        final String abs30 = "Fortalecimiento avanzados abdomen";
        EjercicioAux ejercicioAux30 = new EjercicioAux(
                "Abdominales"
                ,"Puente lateral Izquierdo"
                ,"Puente lateral Derecho"
                ,"Crunch de bicicleta"
                , "Plancha"
                ,"Escalada de montaña"
                ,abs30
                , "Acuéstate, recoge las piernas y pega los talones al suelo, separa las piernas un poco menos del ancho de los hombros, coloca manos en la nuca o en el pecho y sube el tronco.",
                "Sitúate en tu costado izquierdo, apóyate sobre tu antebrazo izquierdo y eleva la cadera, el brazo derecho puede estar estirado o sobre la cadera, recuerda no dejar caer completamente la cadera.",
                "Sitúate en tu costado derecho, apóyate sobre tu antebrazo derecho y eleva la cadera, el brazo izquierdo puede estar estirado o sobre la cadera, recuerda no dejar caer completamente la cadera.",
                "Acuéstate, coloca las manos en la nuca, recoge las piernas y apoya talones en el suelo, separa las piernas al ancho de los hombros, manda una rodilla al pecho y trata de tocarla con el codo del brazo contrario.",
                "Acomódate mirando boca abajo, apóyate sobre los antebrazos, levantas la cola de forma que tu cuerpo quede recto, no se puede tener la cola muy arriba ni tampoco apoyar el abdomen en el suelo, mantén esa posición según el tiempo indicado.",
                "Colócate en 4 apoyos en el suelo, sube las rodillas de manera alterna al pecho de manera rápida.",
                "4 sets de 25 reps",
                "2 sets de 20 reps",
                "2 sets de 20 reps",
                "4 sets de 24 reps",
                "4 sets de 60 seg",
                "5 sets de 50 reps");
        referencia.child(abs30).setValue(ejercicioAux30);

        final String abs31 = "Acondicionamiento principiantes abdomen";
        EjercicioAux ejercicioAux31 = new EjercicioAux(
                "Abdominales en V"
                ,"Crunch abdominales"
                ,"Elevaciones de pierna"
                ,"Plancha"
                , "Twist Ruso"
                ,"Toque al talón"
                ,abs31
                ,"Acuéstate, estira brazos y piernas, elévalas y haz que se toquen manos con pies en el centro.",
                "Acuéstate y apoya los talones en el suelo, estira los brazos e intenta tocar las rodillas, la cabeza siempre debe estar levantada.",
                "Acuéstate y levanta las piernas a una altura de 20 cm aproximadamente, coloca las manos en la nuca y realiza elevaciones con piernas juntas hasta formar un ángulo de 90° con el tronco, no puedes dejar caer las piernas totalmente.",
                "Acomódate mirando boca abajo, apóyate sobre los antebrazos, levantas la cola de forma que tu cuerpo quede recto, no se puede tener la cola muy arriba ni tampoco apoyar el abdomen en el suelo, mantén esa posición según el tiempo indicado.",
                "Acuéstate y apoya talones en el suelo, coloca los brazos en el pecho, cada que levantes el tronco giras por lado izquierdo y por lado derecho.",
                "Acuéstate, recoge las piernas, pega los talones al suelo y sepáralas al ancho de los hombros, posteriormente intenta tocar el talón derecho con la mano derecha y viceversa, de manera alterna.",
                "1 set de 25 reps",
                "2 sets de 15 reps",
                "1 set de 20 reps",
                "1 set de 40 seg",
                "2 sets de 24 seg",
                "2 sets de 26 reps");

        referencia.child(abs31).setValue(ejercicioAux31);

        final String abs32 = "Acondicionamiento intermedios abdomen";
        EjercicioAux ejercicioAux32 = new EjercicioAux(
                "Elevaciones de piernas"
                ,"Abdominal cruzado"
                ,"Escalada de montaña"
                ,"Puente lateral Izquierdo"
                , "Puente lateral Derecho"
                ,"Toque al talón"
                ,abs32
                ,"Acuéstate y levanta las piernas a una altura de 20 cm aproximadamente, coloca las manos en la nuca y realiza elevaciones con piernas juntas hasta formar un ángulo de 90° con el tronco, no puedes dejar caer las piernas totalmente.",
                "Acuéstate, eleva las piernas a una altura de 25 cm aproximadamente, coloca las manos en la nuca, recoge una pierna y toca tu rodilla con el codo contrario, recuerda no bajar las piernas hasta terminar tu ejercicio. ",
                "Colócate en 4 apoyos en el suelo, sube las rodillas de manera alterna al pecho de manera rápida.",
                "Sitúate en tu costado izquierdo, apóyate sobre tu antebrazo izquierdo y eleva la cadera, el brazo derecho puede estar estirado o sobre la cadera, recuerda no dejar caer completamente la cadera.",
                "Sitúate en tu costado derecho, apóyate sobre tu antebrazo derecho y eleva la cadera, el brazo izquierdo puede estar estirado o sobre la cadera, recuerda no dejar caer completamente la cadera.",
                "Acuéstate, recoge las piernas, pega los talones al suelo y sepáralas al ancho de los hombros, posteriormente intenta tocar el talón derecho con la mano derecha y viceversa, de manera alterna.",
                "2 sets de 20 reps",
                "2 sets de 18 reps",
                "3 sets de 36 reps",
                "2 sets de 20 reps",
                "2 sets de 2 reps",
                "2 sets de 30 reps");
        referencia.child(abs32).setValue(ejercicioAux32);

        final String abs33 = "Acondicionamiento avanzados abdomen";
        EjercicioAux ejercicioAux33 = new EjercicioAux(
                "Crunch Abdominales"
                ,"Twist ruso"
                ,"Toque al talon"
                ,"Toque al talon"
                , "Elevaciones de piernas"
                ,"Plancha"
                ,abs33
                ,"Acuéstate y apoya los talones en el suelo, estira los brazos e intenta tocar las rodillas, la cabeza siempre debe estar levantada.",
                "Acuéstate y apoya talones en el suelo, coloca los brazos en el pecho, cada que levantes el tronco giras por lado izquierdo y por lado derecho.",
                "Acuéstate, recoge las piernas, pega los talones al suelo y sepáralas al ancho de los hombros, posteriormente intenta tocar el talón derecho con la mano derecha y viceversa, de manera alterna.",
                "Acuéstate, recoge las piernas, pega los talones al suelo y sepáralas al ancho de los hombros, posteriormente intenta tocar el talón derecho con la mano derecha y viceversa, de manera alterna.",
                "Acuéstate y levanta las piernas a una altura de 20 cm aproximadamente, coloca las manos en la nuca y realiza elevaciones con piernas juntas hasta formar un ángulo de 90° con el tronco, no puedes dejar caer las piernas totalmente.",
                "Acomódate mirando boca abajo, apóyate sobre los antebrazos, levantas la cola de forma que tu cuerpo quede recto, no se puede tener la cola muy arriba ni tampoco apoyar el abdomen en el suelo, mantén esa posición según el tiempo indicado.",
                "3 sets de 20 reps",
                "3 sets de 22 reps",
                "2 sets de 30 reps",
                "2 sets de 30 reps",
                "2 sets de 25 reps",
                "3 sets de 45 seg");

        referencia.child(abs33).setValue(ejercicioAux33);

        final String abs34 = "Bajar de peso principiantes abdomen";
        EjercicioAux ejercicioAux34 = new EjercicioAux(
                "Abdominales en V"
                ,"Crunch abdominales"
                ,"Elevaciones de pierna"
                ,"Plancha"
                , "Twist Ruso"
                ,"Toque al talón"
                ,abs34
                , "Acuéstate, estira brazos y piernas, elévalas y haz que se toquen manos con pies en el centro.",
                "Acuéstate y apoya los talones en el suelo, estira los brazos e intenta tocar las rodillas, la cabeza siempre debe estar levantada.",
                "Acuéstate y levanta las piernas a una altura de 20 cm aproximadamente, coloca las manos en la nuca y realiza elevaciones con piernas juntas hasta formar un ángulo de 90° con el tronco, no puedes dejar caer las piernas totalmente.",
                "Acomódate mirando boca abajo, apóyate sobre los antebrazos, levantas la cola de forma que tu cuerpo quede recto, no se puede tener la cola muy arriba ni tampoco apoyar el abdomen en el suelo, mantén esa posición según el tiempo indicado.",
                "Acuéstate y apoya talones en el suelo, coloca los brazos en el pecho, cada que levantes el tronco giras por lado izquierdo y por lado derecho.",
                "Acuéstate, recoge las piernas, pega los talones al suelo y sepáralas al ancho de los hombros, posteriormente intenta tocar el talón derecho con la mano derecha y viceversa, de manera alterna.",
                "1 set de 20 reps",
                "2 sets de 20 reps",
                "1 sets de 25 reps",
                "2 sets de 30 seg",
                "2 sets de 22 reps",
                "2 sets de 28 reps");
        referencia.child(abs34).setValue(ejercicioAux34);

        final String abs35 = "Bajar de peso intermedios abdomen";
        EjercicioAux ejercicioAux35 = new EjercicioAux(
                "Crunch abdominales"
                ,"Plancha"
                ,"Twist Ruso"
                ,"Toque al talón"
                , "Abdominales en V"
                ,"Butt Bridge"
                ,abs35,"Acuéstate y apoya los talones en el suelo, estira los brazos e intenta tocar las rodillas, la cabeza siempre debe estar levantada.",
                "Acomódate mirando boca abajo, apóyate sobre los antebrazos, levantas la cola de forma que tu cuerpo quede recto, no se puede tener la cola muy arriba ni tampoco apoyar el abdomen en el suelo, mantén esa posición según el tiempo indicado.",
                "Acuéstate y apoya talones en el suelo, coloca los brazos en el pecho, cada que levantes el tronco giras por lado izquierdo y por lado derecho.",
                "Acuéstate, recoge las piernas, pega los talones al suelo y sepáralas al ancho de los hombros, posteriormente intenta tocar el talón derecho con la mano derecha y viceversa, de manera alterna.",
                "Acuéstate, estira brazos y piernas, elévalas y haz que se toquen manos con pies en el centro.",
                "Acuéstate, extiende los brazos, recoge las piernas y apoya talones en el suelo, separa las piernas al ancho de los hombros y eleva el tronco, recuerda que el tronco no debe tocar el suelo hasta terminar el ejercicio.",
                "2 sets de 24 reps",
                "2 sets de 40 seg",
                "2 sets de 32 reps",
                "3 sets de 40 reps",
                "2 sets de 25 reps",
                "3 sets de 30 reps");
        referencia.child(abs35).setValue(ejercicioAux35);


        final String abs36 = "Bajar de peso avanzados abdomen";
        EjercicioAux ejercicioAux36 = new EjercicioAux(
                "Toque al talón"
                ,"Abdominal cruzado"
                ,"Butt Bridge"
                ,"Crunch de bicicleta"
                , "Abdominales en V"
                ,"Crunch Abdominal"
                ,abs36
                , "Acuéstate, recoge las piernas, pega los talones al suelo y sepáralas al ancho de los hombros, posteriormente intenta tocar el talón derecho con la mano derecha y viceversa, de manera alterna.",
                "Acuéstate, eleva las piernas a una altura de 25 cm aproximadamente, coloca las manos en la nuca, recoge una pierna y toca tu rodilla con el codo contrario, recuerda no bajar las piernas hasta terminar tu ejercicio.",
                "Acuéstate, extiende los brazos, recoge las piernas y apoya talones en el suelo, separa las piernas al ancho de los hombros y eleva el tronco, recuerda que el tronco no debe tocar el suelo hasta terminar el ejercicio.",
                "Acuéstate, coloca las manos en la nuca, recoge las piernas y apoya talones en el suelo, separa las piernas al ancho de los hombros, manda una rodilla al pecho y trata de tocarla con el codo del brazo contrario.",
                "Acuéstate, estira brazos y piernas, elévalas y haz que se toquen manos con pies en el centro.",
                "Acuéstate y apoya los talones en el suelo, estira los brazos e intenta tocar las rodillas, la cabeza siempre debe estar levantada.",
                "4 sets de 30 reps",
                "3 sets de 24 seg",
                "4 sets de 30 reps",
                "4 sets de 28 reps",
                "3 sets de 25 reps",
                "4 sets de 20 reps");
        referencia.child(abs36).setValue(ejercicioAux36);

//------------------------INICIO EJERCICIOS ESPALDA Y HOMBRO----------------------------------//

        final String hombro37 = "Fortalecimiento principiantes espalda";
        EjercicioAux ejercicioAux37 = new EjercicioAux(
                "Elevaciones de brazos"
                ,"Inchworms"
                ,"Elevaciones laterales de brazos"
                ,"Flexión con apoyo de rodillas"
                , "Flexiones en pica"
                ,"Postura gato"
                ,hombro37
                ,"Parado con los pies juntos y cuerpo derecho, eleva controladamente los brazos totalmente estirados hacia adelante hasta alcanzar la altura de los hombros, se puede realizar con objetos del mismo peso en cada brazo"
                ,"Inicia totalmente derecho, luego lleva las manos justo delante de los pies y camina con las manos hasta tener el cuerpo totalmente estirado, te devuelves de la misma forma"
                ,"Parado con los pies juntos y cuerpo derecho, eleva controladamente los brazos totalmente estirados de forma lateral hasta alcanzar la altura de los hombros,  se puede realizar con objetos del mismo peso en cada brazo"
                ,"Ponte de rodillas en una superficie blanda, posteriormente pon los brazos al nivel de los hombros y realiza una flexión manteniendo los codos haciendo un triangulo con el tronco del cuerpo"
                ,"Parado con los pies a la anchura de los hombros, lleva el cuerpo hacia al piso sin flexionar las rodillas ni los brazos, las manos deben quedar apoyadas en el piso a la anchura de los hombros. Finalmente realiza una flexión llevando la cabeza al piso manteniendo los codos lo mas cerca al cuerpo posible pero sin modificar la posición de las manos"
                ,"En posición de perrito con los brazos totalmente estirados y las piernas juntas, lleva primero el estomago hacia afuera, elevando la espalda y metiendo cola lo más posible sin perder la postura, posteriormente realizas el mismo movimiento pero esta vez metiendo la espalda y sacando la cola "
                ,"5 sets de 20 reps"
                ,"3 sets de 10 reps"
                ,"5 sets de 20 reps"
                ,"3 sets de 15 reps"
                ,"4 sets de 10 reps"
                ,"3 sets de 10 reps");
        referencia.child(hombro37).setValue(ejercicioAux37);

        final String hombro38 = "Fortalecimiento intermedios espalda";
        EjercicioAux ejercicioAux38 = new EjercicioAux(
                "Extensiones hacia atrás de triceps"
                ,"Flexiones con inclinación"
                ,"Triceps en suelo"
                ,"Flexiones hover"
                , "Superman y nadador"
                ,"Postura de bebé"
                ,hombro38
                ,"Comenzamos de pie, con las piernas ligeramente flexionadas y el tronco inclinado hacia delante. Fíjate bien que la espalda esté recta, coloca el brazo en horizontal y paralelo al cuerpo con el codo flexionado y un objeto liviano en la mano. Inspirar y realizar una extensión del antebrazo, expirar al final del movimiento."
                ,"Poner las manos sobre una silla o una banqueta que esté bien firme al suelo y no se vaya a mover mientras realizamos el ejercicio, y los pies serán los otros dos puntos de apoyo. Por ultimo realizar una flexion llevando la el pecho a la silla "
                ,"Nos colocamos de manera perpendicular a un banco con nuestras palmas en el filo y con la cara externa de las manos mirando hacia nosotros, las manos deben de estar a la anchura de los hombros. Ahora podemos apoyar las piernas en el suelo y las piernas deben de permanecer rectas durante todo el movimiento. Bajaremos hasta que nuestros brazos formen un ángulo de unos 90º y subiremos."
                ,"Colócate en la posición clásica para hacer flexiones, con las manos apoyadas en el suelo a la anchura de los hombros. y adelanta el brazo derecho. Flexiona los brazos inspirando y desciende el torso de manera controlada. Inmediatamente, estira los brazos de manera explosiva, y aprovecha el impulso para adelantar el brazo izquierdo mientras desplazas el derecho hacia detrás. "
                ,"Comienza por recostarte boca abajo, apoyando tus brazos y piernas sobre el piso. Extiende lentamente tus brazos hacia el frente y tus piernas hacia atrás. Luego levanta del suelo unas cuantas pulgadas los brazos, la parte superior del pecho y las piernas simultáneamente. Mantén esta posición un momento antes de volver a bajar suavemente tus brazos y piernas."
                ,"Empiece acostado boca arriba en el piso. Flexione las rodillas y abrácelas contra el pecho. Abra las rodillas hacia las axilas y tome los extremos externos de los pies con las manos. Mantenga la espalda en el piso y mézase suavemente de izquierda a derecha, si siente cómodo haciéndolo. En este punto tome por lo menos cinco respiraciones profundas"
                ,"5 sets de 12 reps"
                ,"3 sets de 15 reps"
                ,"3 sets de 13 reps"
                ,"3 sets de 12 reps"
                ,"2 sets de 19 reps"
                ,"3 sets de 7 reps");
        referencia.child(hombro38).setValue(ejercicioAux38);


        final String hombro39 = "Fortalecimiento avanzados espalda";
        EjercicioAux ejercicioAux39 = new EjercicioAux(
                "Saltos de tijera"
                ,"Hiperextensión"
                ,"Flexiones en pica"
                ,"Flexiones inversas"
                , "Superman"
                ,"Inchworms"
                ,hombro39
                ,"Inicia de pie, con los pies juntos y los brazos extendidos hacia abajo, pegados al cuerpo, se procede a saltar, separar los pies y abrir los brazos hasta hacer una X con el cuerpo, una vez que se toca el piso se salta y se vuelve a la posición inicial."
                ,"Iniciamos acostados boca abajo en una esterilla y elevaremos el tronco levemente, con las manos por detrás de la cabeza o del glúteo. Es recomendable, que elevemos simultáneamente a la cabeza las piernas, quedando únicamente el abdomen en contacto con el suelo. Volveremos al punto de partida nuevamente."
                ,"Parado con los pies a la anchura de los hombros, lleva el cuerpo hacia al piso sin flexionar las rodillas ni los brazos, las manos deben quedar apoyadas en el piso a la anchura de los hombros. Finalmente realiza una flexión llevando la cabeza al piso manteniendo los codos lo mas cerca al cuerpo posible pero sin modificar la posición de las manos"
                ,"Comienza por recostarte boca abajo, apoyando tus brazos y piernas sobre el piso. Extiende lentamente tus brazos hacia el frente y tus piernas hacia atrás. Luego levanta del suelo unas cuantas pulgadas los brazos, la parte superior del pecho y las piernas simultáneamente. Mantén esta posición un momento antes de volver a bajar suavemente tus brazos y piernas."
                ,"Inicia totalmente derecho, luego lleva las manos justo delante de los pies y camina con las manos hasta tener el cuerpo totalmente estirado, te devuelves de la misma forma"
                ,"Inicia totalmente derecho, luego lleva las manos justo delante de los pies y camina con las manos hasta tener el cuerpo totalmente estirado, te devuelves de la misma forma"
                ,"5 sets de 10 reps"
                ,"2 sets de 14 reps"
                ,"5 sets de 21 reps"
                ,"3 sets de 12 reps"
                ,"4 sets de 18 reps"
                ,"5 sets de 2 reps");
        referencia.child(hombro39).setValue(ejercicioAux39);

        final String hombro40 = "Acondicionamiento principiantes espalda";
        EjercicioAux ejercicioAux40 = new EjercicioAux(
                "Extensiones hacia atrás de triceps"
                ,"Flexiones con inclinación"
                ,"Triceps en suelo"
                ,"Flexiones hover"
                , "Superman y nadador"
                ,"Postura de bebé"
                ,hombro40
                ,"Comenzamos de pie, con las piernas ligeramente flexionadas y el tronco inclinado hacia delante. Fíjate bien que la espalda esté recta, coloca el brazo en horizontal y paralelo al cuerpo con el codo flexionado y un objeto liviano en la mano. Inspirar y realizar una extensión del antebrazo, expirar al final del movimiento."
                ,"Poner las manos sobre una silla o una banqueta que esté bien firme al suelo y no se vaya a mover mientras realizamos el ejercicio, y los pies serán los otros dos puntos de apoyo. Por ultimo realizar una flexion llevando la el pecho a la silla "
                ,"Nos colocamos de manera perpendicular a un banco con nuestras palmas en el filo y con la cara externa de las manos mirando hacia nosotros, las manos deben de estar a la anchura de los hombros. Ahora podemos apoyar las piernas en el suelo y las piernas deben de permanecer rectas durante todo el movimiento. Bajaremos hasta que nuestros brazos formen un ángulo de unos 90º y subiremos."
                ,"Colócate en la posición clásica para hacer flexiones, con las manos apoyadas en el suelo a la anchura de los hombros. y adelanta el brazo derecho. Flexiona los brazos inspirando y desciende el torso de manera controlada. Inmediatamente, estira los brazos de manera explosiva, y aprovecha el impulso para adelantar el brazo izquierdo mientras desplazas el derecho hacia detrás. "
                ,"Comienza por recostarte boca abajo, apoyando tus brazos y piernas sobre el piso. Extiende lentamente tus brazos hacia el frente y tus piernas hacia atrás. Luego levanta del suelo unas cuantas pulgadas los brazos, la parte superior del pecho y las piernas simultáneamente. Mantén esta posición un momento antes de volver a bajar suavemente tus brazos y piernas."
                ,"Empiece acostado boca arriba en el piso. Flexione las rodillas y abrácelas contra el pecho. Abra las rodillas hacia las axilas y tome los extremos externos de los pies con las manos. Mantenga la espalda en el piso y mézase suavemente de izquierda a derecha, si siente cómodo haciéndolo. En este punto tome por lo menos cinco respiraciones profundas"
                ,"3 sets de 12 reps"
                ,"2 sets de 1 reps"
                ,"1 sets de 13 reps"
                ,"2 sets de 23 reps"
                ,"4 sets de 6 reps"
                ,"2 sets de 7 reps");
        referencia.child(hombro39).setValue(ejercicioAux40);

        final String hombro41 = "Acondicionamiento intermedios espalda";
        EjercicioAux ejercicioAux41 = new EjercicioAux(
                "Saltos de tijera"
                ,"Hiperextensión"
                ,"Flexiones en pica"
                ,"Flexiones Delfín"
                , "Superman "
                ,"Inchworms"
                ,hombro41
                ,"Inicia de pie, con los pies juntos y los brazos extendidos hacia abajo, pegados al cuerpo, se procede a saltar, separar los pies y abrir los brazos hasta hacer una X con el cuerpo, una vez que se toca el piso se salta y se vuelve a la posición inicial."
                ,"Iniciamos acostados boca abajo en una esterilla y elevaremos el tronco levemente, con las manos por detrás de la cabeza o del glúteo. Es recomendable, que elevemos simultáneamente a la cabeza las piernas, quedando únicamente el abdomen en contacto con el suelo. Volveremos al punto de partida nuevamente."
                ,"Parado con los pies a la anchura de los hombros, lleva el cuerpo hacia al piso sin flexionar las rodillas ni los brazos, las manos deben quedar apoyadas en el piso a la anchura de los hombros. Finalmente realiza una flexión llevando la cabeza al piso manteniendo los codos lo mas cerca al cuerpo posible pero sin modificar la posición de las manos"
                ,"Iniciamos con los antebrazos en el suelo, las palmas de las manos unidas entre sí y el cuerpo en forma de V invertida. Con la espalda recta en todo momento, descenderemos el tronco para alinear el cuerpo y colocarlo paralelo al suelo. Los hombros deben bajar hasta quedar cerca de las muñecas ."
                ,"Comienza por recostarte boca abajo, apoyando tus brazos y piernas sobre el piso. Extiende lentamente tus brazos hacia el frente y tus piernas hacia atrás. Luego levanta del suelo unas cuantas pulgadas los brazos, la parte superior del pecho y las piernas simultáneamente. Mantén esta posición un momento antes de volver a bajar suavemente tus brazos y piernas."
                ,"Inicia totalmente derecho, luego lleva las manos justo delante de los pies y camina con las manos hasta tener el cuerpo totalmente estirado, te devuelves de la misma forma"
                ,"5 sets de 11 reps"
                ,"6 sets de 3 reps"
                ,"3 sets de 13 reps"
                ,"4 sets de 23 reps"
                ,"2 sets de 6 reps"
                ,"2 sets de 7 reps");
        referencia.child(hombro41).setValue(ejercicioAux41);


        final String hombro42 = "Acondicionamiento avanzados espalda";
        EjercicioAux ejercicioAux42 = new EjercicioAux(
                "Elevaciones de brazos"
                ,"Flexiones Delfín"
                ,"Elevaciones laterales de brazos"
                ,"Flexión con apoyo de rodillas"
                , "Superman"
                ,"Postura del gato"
                ,hombro42
                ,"Parado con los pies juntos y cuerpo derecho, eleva controladamente los brazos totalmente estirados hacia adelante hasta alcanzar la altura de los hombros, se puede realizar con objetos del mismo peso en cada brazo"
                ,"Comienza por recostarte boca abajo, apoyando tus brazos y piernas sobre el piso. Extiende lentamente tus brazos hacia el frente y tus piernas hacia atrás. Luego levanta del suelo unas cuantas pulgadas los brazos, la parte superior del pecho y las piernas simultáneamente. Mantén esta posición un momento antes de volver a bajar suavemente tus brazos y piernas."
                ,"Parado con los pies juntos y cuerpo derecho, eleva controladamente los brazos totalmente estirados de forma lateral hasta alcanzar la altura de los hombros,  se puede realizar con objetos del mismo peso en cada brazo"
                ,"Ponte de rodillas en una superficie blanda, posteriormente pon los brazos al nivel de los hombros y realiza una flexión manteniendo los codos haciendo un triangulo con el tronco del cuerpo"
                ,"Comienza por recostarte boca abajo, apoyando tus brazos y piernas sobre el piso. Extiende lentamente tus brazos hacia el frente y tus piernas hacia atrás. Luego levanta del suelo unas cuantas pulgadas los brazos, la parte superior del pecho y las piernas simultáneamente. Mantén esta posición un momento antes de volver a bajar suavemente tus brazos y piernas."
                ,"En posición de perrito con los brazos totalmente estirados y las piernas juntas, lleva primero el estomago hacia afuera, elevando la espalda y metiendo cola lo más posible sin perder la postura, posteriormente realizas el mismo movimiento pero esta vez metiendo la espalda y sacando la cola "
                ,"5 sets de 20 reps"
                ,"3 sets de 10 reps"
                ,"5 sets de 20 reps"
                ,"3 sets de 15 reps"
                ,"4 sets de 10 reps"
                ,"3 sets de 10 reps");
        referencia.child(hombro42).setValue(ejercicioAux42);


        final String hombro44 = "Bajar de peso principiantes espalda";
        EjercicioAux ejercicioAux44 = new EjercicioAux(
                "Saltos de tijera"
                ,"Hiperextensión"
                ,"Flexiones en pica"
                ,"Flexiones Delfín"
                , "Superman"
                ,"Inchworms"
                ,hombro44
                ,"Inicia de pie, con los pies juntos y los brazos extendidos hacia abajo, pegados al cuerpo, se procede a saltar, separar los pies y abrir los brazos hasta hacer una X con el cuerpo, una vez que se toca el piso se salta y se vuelve a la posición inicial."
                ,"Iniciamos acostados boca abajo en una esterilla y elevaremos el tronco levemente, con las manos por detrás de la cabeza o del glúteo. Es recomendable, que elevemos simultáneamente a la cabeza las piernas, quedando únicamente el abdomen en contacto con el suelo. Volveremos al punto de partida nuevamente."
                ,"Parado con los pies a la anchura de los hombros, lleva el cuerpo hacia al piso sin flexionar las rodillas ni los brazos, las manos deben quedar apoyadas en el piso a la anchura de los hombros. Finalmente realiza una flexión llevando la cabeza al piso manteniendo los codos lo mas cerca al cuerpo posible pero sin modificar la posición de las manos"
                ,"Iniciamos con los antebrazos en el suelo, las palmas de las manos unidas entre sí y el cuerpo en forma de V invertida. Con la espalda recta en todo momento, descenderemos el tronco para alinear el cuerpo y colocarlo paralelo al suelo. Los hombros deben bajar hasta quedar cerca de las muñecas ."
                ,"Comienza por recostarte boca abajo, apoyando tus brazos y piernas sobre el piso. Extiende lentamente tus brazos hacia el frente y tus piernas hacia atrás. Luego levanta del suelo unas cuantas pulgadas los brazos, la parte superior del pecho y las piernas simultáneamente. Mantén esta posición un momento antes de volver a bajar suavemente tus brazos y piernas."
                ,"Inicia totalmente derecho, luego lleva las manos justo delante de los pies y camina con las manos hasta tener el cuerpo totalmente estirado, te devuelves de la misma forma"
                ,"5 sets de 21 reps"
                ,"6 sets de 5 reps"
                ,"3 sets de 23 reps"
                ,"3 sets de 12 reps"
                ,"3 sets de 7 reps"
                ,"3 sets de 4 reps");
        referencia.child(hombro44).setValue(ejercicioAux44);


        final String hombro45 = "Bajar de peso intermedios espalda";
        EjercicioAux ejercicioAux45 = new EjercicioAux(
                "Flexiones en pica"
                ,"Inchworms"
                ,"Flexión supina"
                ,"Superman"
                , "Postura de bebé"
                ,"Inchworms"
                ,hombro45
                ,"Parado con los pies a la anchura de los hombros, lleva el cuerpo hacia al piso sin flexionar las rodillas ni los brazos, las manos deben quedar apoyadas en el piso a la anchura de los hombros. Finalmente realiza una flexión llevando la cabeza al piso manteniendo los codos lo mas cerca al cuerpo posible pero sin modificar la posición de las manos"
                ,"Inicia totalmente derecho, luego lleva las manos justo delante de los pies y camina con las manos hasta tener el cuerpo totalmente estirado, te devuelves de la misma forma"
                ,"Debemos colocarnos con la espalda apoyada en el piso y la vista hacia arriba. Para que la columna lumbar quede apoyada totalmente, es recomendable flexionar las rodillas y descansar los pies en el suelo. Debemos colocar los brazos a los lados, de manera que queden perpendicular al cuerpo. Desde allí, empujamos con los codos hacia el suelo para despegar los hombros y la espalda alta de la superficie."
                ,"Comienza por recostarte boca abajo, apoyando tus brazos y piernas sobre el piso. Extiende lentamente tus brazos hacia el frente y tus piernas hacia atrás. Luego levanta del suelo unas cuantas pulgadas los brazos, la parte superior del pecho y las piernas simultáneamente. Mantén esta posición un momento antes de volver a bajar suavemente tus brazos y piernas."
                ,"Empiece acostado boca arriba en el piso. Flexione las rodillas y abrácelas contra el pecho. Abra las rodillas hacia las axilas y tome los extremos externos de los pies con las manos. Mantenga la espalda en el piso y mézase suavemente de izquierda a derecha, si siente cómodo haciéndolo. En este punto tome por lo menos cinco respiraciones profundas"
                ,"Inicia totalmente derecho, luego lleva las manos justo delante de los pies y camina con las manos hasta tener el cuerpo totalmente estirado, te devuelves de la misma forma"
                ,"5 sets de 20 reps"
                ,"3 sets de 10 reps"
                ,"5 sets de 20 reps"
                ,"3 sets de 15 reps"
                ,"4 sets de 10 reps"
                ,"3 sets de 10 reps");
        referencia.child(hombro45).setValue(ejercicioAux45);

        final String hombro46 = "Bajar de peso avanzados espalda";
        EjercicioAux ejercicioAux46 = new EjercicioAux(
                "Extensiones hacia atrás de triceps"
                ,"Flexiones con inclinación"
                ,"Triceps en suelo"
                ,"Flexiones hover"
                , "Superman"
                ,"Postura de bebe"
                ,hombro46
                ,"Comenzamos de pie, con las piernas ligeramente flexionadas y el tronco inclinado hacia delante. Fíjate bien que la espalda esté recta, coloca el brazo en horizontal y paralelo al cuerpo con el codo flexionado y un objeto liviano en la mano. Inspirar y realizar una extensión del antebrazo, expirar al final del movimiento."
                ,"Poner las manos sobre una silla o una banqueta que esté bien firme al suelo y no se vaya a mover mientras realizamos el ejercicio, y los pies serán los otros dos puntos de apoyo. Por ultimo realizar una flexion llevando la el pecho a la silla "
                ,"Nos colocamos de manera perpendicular a un banco con nuestras palmas en el filo y con la cara externa de las manos mirando hacia nosotros, las manos deben de estar a la anchura de los hombros. Ahora podemos apoyar las piernas en el suelo y las piernas deben de permanecer rectas durante todo el movimiento. Bajaremos hasta que nuestros brazos formen un ángulo de unos 90º y subiremos."
                ,"Colócate en la posición clásica para hacer flexiones, con las manos apoyadas en el suelo a la anchura de los hombros. y adelanta el brazo derecho. Flexiona los brazos inspirando y desciende el torso de manera controlada. Inmediatamente, estira los brazos de manera explosiva, y aprovecha el impulso para adelantar el brazo izquierdo mientras desplazas el derecho hacia detrás. "
                ,"Comienza por recostarte boca abajo, apoyando tus brazos y piernas sobre el piso. Extiende lentamente tus brazos hacia el frente y tus piernas hacia atrás. Luego levanta del suelo unas cuantas pulgadas los brazos, la parte superior del pecho y las piernas simultáneamente. Mantén esta posición un momento antes de volver a bajar suavemente tus brazos y piernas."
                ,"Empiece acostado boca arriba en el piso. Flexione las rodillas y abrácelas contra el pecho. Abra las rodillas hacia las axilas y tome los extremos externos de los pies con las manos. Mantenga la espalda en el piso y mézase suavemente de izquierda a derecha, si siente cómodo haciéndolo. En este punto tome por lo menos cinco respiraciones profundas"
                ,"5 sets de 12 reps"
                ,"6 sets de 12 reps"
                ,"7 sets de 12 reps"
                ,"3 sets de 12 reps"
                ,"5 sets de 14 reps"
                ,"6 sets de 13 reps");
        referencia.child(hombro46).setValue(ejercicioAux46);



        referenciaMarcas = FirebaseDatabase.getInstance().getReference("Workouts");

        ejercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Map<String,Object> rutina = new HashMap<String,Object>();
                //Toast.makeText(RutinasEjercicio.this,":"+a,Toast.LENGTH_LONG).show();
                if(a == 1){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Fortalecimiento pecho principiante");
                                rutina.put("Duracion", "25 a 35 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPecho").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkYoga = referencia.orderByChild("nombre").equalTo(pecho1);
                    checkYoga.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pecho1).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pecho1).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pecho1).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pecho1).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pecho1).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pecho1).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pecho1).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pecho1).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pecho1).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pecho1).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pecho1).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pecho1).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pecho1).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pecho1).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pecho1).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pecho1).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pecho1).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pecho1).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);

                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.flexiones_con_inclinacion);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.flexiones_con_apoyo_de_rodillas);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.flexiones);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.flexiones_con_brazos_abiertos);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.flexiones_hindues);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.flexiones_con_inclinacion);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }
                else if(a ==2){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Fortalecimiento pecho intermedio");
                                rutina.put("Duracion", "30 a 40 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPecho").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkYoga2 = referencia.orderByChild("nombre").equalTo(pecho2);
                    checkYoga2.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pecho2).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pecho2).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pecho2).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pecho2).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pecho2).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pecho2).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pecho2).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pecho2).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pecho2).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pecho2).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pecho2).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pecho2).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pecho2).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pecho2).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pecho2).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pecho2).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pecho2).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pecho2).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);

                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.flexiones_con_apoyo_de_rodillas);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.flexiones);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.flexiones_hindues);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.flexiones_escalonadas);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.flexiones_con_brazos_abiertos);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.burpees);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
                else if(a ==3){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Fortalecimiento pecho avanzado");
                                rutina.put("Duracion", "40 a 50 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPecho").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkYoga3 = referencia.orderByChild("nombre").equalTo(pecho3);
                    checkYoga3.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pecho3).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pecho3).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pecho3).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pecho3).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pecho3).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pecho3).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pecho3).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pecho3).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pecho3).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pecho3).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pecho3).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pecho3).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pecho3).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pecho3).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pecho3).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pecho3).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pecho3).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pecho3).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);

                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.burpees);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.flexiones_escalonadas);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.flexiones_hindues);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.flexion_y_rotacion);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.flexiones_en_diamante);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.burpees);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }
                else if(a ==4){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Acondicionamiento pecho principiante");
                                rutina.put("Duracion", "25 a 35 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPecho").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkYoga4 = referencia.orderByChild("nombre").equalTo(pecho4);
                    checkYoga4.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pecho4).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pecho4).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pecho4).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pecho4).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pecho4).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pecho4).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pecho4).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pecho4).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pecho4).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pecho4).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pecho4).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pecho4).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pecho4).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pecho4).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pecho4).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pecho4).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pecho4).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pecho4).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);


                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.saltos_de_tijera);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.flexiones_con_apoyo_de_rodillas);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.flexiones);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.flexiones_con_brazos_abiertos);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.flexiones_escalonadas);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.burpees);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }
                else if(a ==5){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Acondicionamiento pecho intermedio");
                                rutina.put("Duracion", "30 a 40 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPecho").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkYoga5 = referencia.orderByChild("nombre").equalTo(pecho5);
                    checkYoga5.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pecho5).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pecho5).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pecho5).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pecho5).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pecho5).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pecho5).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pecho5).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pecho5).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pecho5).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pecho5).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pecho5).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pecho5).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pecho5).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pecho5).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pecho5).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pecho5).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pecho5).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pecho5).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);

                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.flexiones_spiderman);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.saltos_de_tijera);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.flexiones_con_inclinacion);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.flexiones);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.flexiones_con_brazos_abiertos);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.flexiones_en_caja);


                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
                else if(a ==6){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Acondicionamiento pecho avanzado");
                                rutina.put("Duracion", "45 a 55 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPecho").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkYoga6 = referencia.orderByChild("nombre").equalTo(pecho6);
                    checkYoga6.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pecho6).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pecho6).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pecho6).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pecho6).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pecho6).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pecho6).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pecho6).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pecho6).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pecho6).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pecho6).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pecho6).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pecho6).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pecho6).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pecho6).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pecho6).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pecho6).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pecho6).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pecho6).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);


                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.flexiones_hindues);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.flexiones_con_brazos_abiertos);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.burpees);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.flexiones);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.flexion_y_rotacion);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.flexiones);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
                else if(a ==7){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Bajar de peso pecho principiante");
                                rutina.put("Duracion", "25 a 35 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPecho").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkYoga7 = referencia.orderByChild("nombre").equalTo(pecho7);
                    checkYoga7.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pecho7).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pecho7).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pecho7).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pecho7).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pecho7).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pecho7).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pecho7).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pecho7).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pecho7).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pecho7).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pecho7).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pecho7).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pecho7).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pecho7).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pecho7).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pecho7).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pecho7).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pecho7).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.saltos_de_tijera);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.flexiones_con_apoyo_de_rodillas);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.flexiones);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.flexiones_con_brazos_abiertos);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.flexiones_escalonadas);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.burpees);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
                else if(a ==8){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Bajar de peso pecho intermedio");
                                rutina.put("Duracion", "40 a 45 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPecho").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkYoga8 = referencia.orderByChild("nombre").equalTo(pecho8);
                    checkYoga8.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                // Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pecho8).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pecho8).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pecho8).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pecho8).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pecho8).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pecho8).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pecho8).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pecho8).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pecho8).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pecho8).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pecho8).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pecho8).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pecho8).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pecho8).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pecho8).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pecho8).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pecho8).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pecho8).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.burpees);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.flexiones_escalonadas);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.flexiones_hindues);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.flexion_y_rotacion);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.flexiones_en_diamante);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.burpees);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
                else if(a ==9){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Bajar de peso pecho avanzado");
                                rutina.put("Duracion", "40 a 50 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPecho").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkYoga9 = referencia.orderByChild("nombre").equalTo(pecho9);
                    checkYoga9.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                // Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pecho9).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pecho9).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pecho9).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pecho9).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pecho9).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pecho9).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pecho9).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pecho9).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pecho9).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pecho9).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pecho9).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pecho9).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pecho9).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pecho9).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pecho9).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pecho9).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pecho9).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pecho9).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.burpees);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.flexiones_escalonadas);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.flexiones_hindues);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.flexion_y_rotacion);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.flexiones_en_diamante);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.burpees);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }

            }
        });

        ejercicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a ==1){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Fortalecimiento brazo principiante");
                                rutina.put("Duracion", "25 a 35 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nBrazo").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkBrazo1 = referencia.orderByChild("nombre").equalTo(brazo10);
                    checkBrazo1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                // Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(brazo10).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(brazo10).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(brazo10).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(brazo10).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(brazo10).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(brazo10).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(brazo10).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(brazo10).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(brazo10).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(brazo10).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(brazo10).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(brazo10).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(brazo10).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(brazo10).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(brazo10).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(brazo10).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(brazo10).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(brazo10).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);


                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.triceps_en_silla);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.flexiones_en_diamante);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.plancha_diagonal);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.punetazos);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.inchworms);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.flexiones);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
                else if(a==2){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Fortalecimiento brazo intermedio");
                                rutina.put("Duracion", "30 a 40 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nBrazo").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkBrazo2 = referencia.orderByChild("nombre").equalTo(brazo11);
                    checkBrazo2.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(brazo11).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(brazo11).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(brazo11).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(brazo11).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(brazo11).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(brazo11).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(brazo11).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(brazo11).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(brazo11).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(brazo11).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(brazo11).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(brazo11).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(brazo11).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(brazo11).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(brazo11).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(brazo11).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(brazo11).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(brazo11).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);


                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.flexion_en_la_pared);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.plancha_diagonal);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.triceps_en_silla);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.flexiones);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.triceps_en_suelo);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.fondos_militares);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==3){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Fortalecimiento brazo avanzado");
                                rutina.put("Duracion", "40 a 50 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nBrazo").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkBrazo3 = referencia.orderByChild("nombre").equalTo(brazo12);
                    checkBrazo3.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                // Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(brazo12).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(brazo12).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(brazo12).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(brazo12).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(brazo12).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(brazo12).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(brazo12).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(brazo12).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(brazo12).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(brazo12).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(brazo12).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(brazo12).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(brazo12).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(brazo12).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(brazo12).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(brazo12).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(brazo12).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(brazo12).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.punetazos);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.flexion_y_rotacion);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.burpees);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.fondos_militares);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.saltos_sin_cuerda);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.inchworms);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }

                else if(a==4){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Acondicionamiento brazo principiante");
                                rutina.put("Duracion", "25 a 35 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nBrazo").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkBrazo4 = referencia.orderByChild("nombre").equalTo(brazo13);
                    checkBrazo4.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(brazo13).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(brazo13).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(brazo13).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(brazo13).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(brazo13).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(brazo13).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(brazo13).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(brazo13).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(brazo13).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(brazo13).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(brazo13).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(brazo13).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(brazo13).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(brazo13).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(brazo13).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(brazo13).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(brazo13).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(brazo13).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);


                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.triceps_en_silla);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.punetazos);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.saltos_sin_cuerda);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.triceps_en_suelo);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.fondos_militares);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.flexiones_en_diamante);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }

                else if(a==5){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Acondicionamiento brazo intermedio");
                                rutina.put("Duracion", "30 a 40 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nBrazo").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkBrazo5 = referencia.orderByChild("nombre").equalTo(brazo14);
                    checkBrazo5.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(brazo14).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(brazo14).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(brazo14).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(brazo14).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(brazo14).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(brazo14).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(brazo14).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(brazo14).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(brazo14).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(brazo14).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(brazo14).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(brazo14).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(brazo14).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(brazo14).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(brazo14).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(brazo14).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(brazo14).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(brazo14).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);


                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.triceps_en_silla);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.punetazos);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.burpees);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.saltos_sin_cuerda);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.flexiones_en_diamante);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.flexion_y_rotacion);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==6){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Acondicionamiento brazo avanzado");
                                rutina.put("Duracion", "45 a 55 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nBrazo").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkBrazo6 = referencia.orderByChild("nombre").equalTo(brazo15);
                    checkBrazo6.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(brazo15).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(brazo15).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(brazo15).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(brazo15).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(brazo15).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(brazo15).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(brazo15).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(brazo15).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(brazo15).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(brazo15).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(brazo15).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(brazo15).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(brazo15).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(brazo15).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(brazo15).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(brazo15).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(brazo15).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(brazo15).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.flexion_en_la_pared);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.plancha_diagonal);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.triceps_en_silla);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.flexiones);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.triceps_en_suelo);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.fondos_militares);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==7){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Bajar de peso brazo principiante");
                                rutina.put("Duracion", "25 a 35 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nBrazo").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkBrazo7 = referencia.orderByChild("nombre").equalTo(brazo16);
                    checkBrazo7.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(brazo16).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(brazo16).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(brazo16).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(brazo16).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(brazo16).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(brazo16).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(brazo16).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(brazo16).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(brazo16).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(brazo16).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(brazo16).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(brazo16).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(brazo16).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(brazo16).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(brazo16).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(brazo16).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(brazo16).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(brazo16).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();

                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.punetazos);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.flexion_y_rotacion);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.burpees);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.saltos_sin_cuerda);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.inchworms);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.fondos_militares);


                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==8){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Bajar de peso brazo intermedio");
                                rutina.put("Duracion", "40 a 45 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nBrazo").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkBrazo8 = referencia.orderByChild("nombre").equalTo(brazo17);
                    checkBrazo8.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(brazo17).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(brazo17).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(brazo17).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(brazo17).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(brazo17).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(brazo17).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(brazo17).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(brazo17).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(brazo17).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(brazo17).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(brazo17).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(brazo17).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(brazo17).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(brazo17).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(brazo17).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(brazo17).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(brazo17).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(brazo17).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.triceps_en_silla);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.punetazos);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.saltos_sin_cuerda);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.triceps_en_suelo);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.fondos_militares);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.flexiones_en_diamante);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==9){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Bajar de peso brazo avanzado");
                                rutina.put("Duracion", "40 a 50 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nBrazo").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkBrazo9 = referencia.orderByChild("nombre").equalTo(brazo18);
                    checkBrazo9.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                // Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(brazo18).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(brazo18).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(brazo18).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(brazo18).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(brazo18).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(brazo18).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(brazo18).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(brazo18).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(brazo18).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(brazo18).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(brazo18).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(brazo18).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(brazo18).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(brazo18).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(brazo18).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(brazo18).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(brazo18).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(brazo18).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.triceps_en_silla);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.flexiones_en_diamante);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.plancha_diagonal);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.punetazos);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.inchworms);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.flexiones);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }


            }
        });

        ejercicio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==1){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Pierna principiante");
                                rutina.put("Duracion", "25 a 35 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPierna").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkPierna1 = referencia.orderByChild("nombre").equalTo(pierna19);
                    checkPierna1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pierna19).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pierna19).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pierna19).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pierna19).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pierna19).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pierna19).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pierna19).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pierna19).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pierna19).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pierna19).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pierna19).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pierna19).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pierna19).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pierna19).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pierna19).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pierna19).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pierna19).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pierna19).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.sentadilla);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.estocada_hacia_atras);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.donkey_isq);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.donkey_dere);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.sentadilla_en_pared);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.sentadilla);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                else if(a==2){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Fortalecimiento pierna intermedio");
                                rutina.put("Duracion", "30 a 40 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPierna").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkPierna2 = referencia.orderByChild("nombre").equalTo(pierna20);
                    checkPierna2.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pierna20).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pierna20).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pierna20).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pierna20).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pierna20).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pierna20).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pierna20).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pierna20).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pierna20).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pierna20).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pierna20).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pierna20).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pierna20).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pierna20).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pierna20).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pierna20).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pierna20).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pierna20).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.fire);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.zancada_frontal);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.sentadilla_de_sumo);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.zancada_frontal);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.sentadilla_con_salto_y_giro);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.levantamiento_de_pantorrillas);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==3){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Fortalecimiento pierna avanzado");
                                rutina.put("Duracion", "40 a 50 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPierna").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkPierna3 = referencia.orderByChild("nombre").equalTo(pierna21);
                    checkPierna3.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pierna21).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pierna21).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pierna21).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pierna21).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pierna21).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pierna21).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pierna21).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pierna21).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pierna21).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pierna21).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pierna21).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pierna21).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pierna21).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pierna21).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pierna21).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pierna21).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pierna21).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pierna21).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.sentadilla);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.sentadilla_en_pared);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.sentadilla_bulgara);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.zancada_frontal);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.sentadilla_con_salto_y_giro);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.levantamiento_de_pantorrillas);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==4){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Acondicionamiento pierna principiante");
                                rutina.put("Duracion", "25 a 35 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPierna").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkPierna4 = referencia.orderByChild("nombre").equalTo(pierna22);
                    checkPierna4.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                // Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pierna22).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pierna22).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pierna22).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pierna22).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pierna22).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pierna22).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pierna22).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pierna22).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pierna22).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pierna22).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pierna22).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pierna22).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pierna22).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pierna22).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pierna22).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pierna22).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pierna22).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pierna22).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);


                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.sentadilla_bulgara);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.levantamiento_de_pantorrilla_con_sentadilla);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.levantamiento_de_pantorrillas_con_pared);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.donkey_dere);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.levantamiento_de_pantorrillas);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.zancada_frontal);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==5){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Acondicionamiento pierna intermedio");
                                rutina.put("Duracion", "30 a 40 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPierna").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkPierna5 = referencia.orderByChild("nombre").equalTo(pierna23);
                    checkPierna5.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                // Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pierna23).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pierna23).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pierna23).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pierna23).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pierna23).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pierna23).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pierna23).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pierna23).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pierna23).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pierna23).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pierna23).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pierna23).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pierna23).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pierna23).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pierna23).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pierna23).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pierna23).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pierna23).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);


                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.salto_lateral);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.sentadilla);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.sentadilla);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.estocada_hacia_atras);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.levantamiento_de_pantorrillas);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.zancada_frontal);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==6){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Acondicionamiento pierna avanzado");
                                rutina.put("Duracion", "45 a 55 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPierna").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkPierna6 = referencia.orderByChild("nombre").equalTo(pierna24);
                    checkPierna6.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pierna24).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pierna24).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pierna24).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pierna24).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pierna24).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pierna24).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pierna24).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pierna24).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pierna24).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pierna24).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pierna24).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pierna24).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pierna24).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pierna24).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pierna24).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pierna24).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pierna24).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pierna24).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);


                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.fire);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.fire);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.zancada_frontal);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.sentadilla_bulgara);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.burpees);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.sentadilla_de_sumo);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==7){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Bajar de peso pierna principiante");
                                rutina.put("Duracion", "25 a 35 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPierna").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkPierna7 = referencia.orderByChild("nombre").equalTo(pierna25);
                    checkPierna7.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pierna25).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pierna25).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pierna25).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pierna25).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pierna25).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pierna25).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pierna25).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pierna25).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pierna25).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pierna25).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pierna25).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pierna25).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pierna25).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pierna25).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pierna25).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pierna25).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pierna25).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pierna25).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.sentadilla_bulgara);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.sentadilla_en_pared);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.burpees);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.sentadilla);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.zancada_cruzada);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.zancada_cruzada);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==8){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Bajar de peso pierna intermedio");
                                rutina.put("Duracion", "40 a 45 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPierna").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkPierna8 = referencia.orderByChild("nombre").equalTo(pierna26);
                    checkPierna8.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pierna26).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pierna26).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pierna26).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pierna26).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pierna26).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pierna26).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pierna26).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pierna26).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pierna26).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pierna26).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pierna26).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pierna26).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pierna26).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pierna26).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pierna26).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pierna26).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pierna26).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pierna26).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.sentadilla_con_salto_y_giro);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.sentadilla_en_pared);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.levantamiento_de_pantorrillas);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.zancada_frontal);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.burpees);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.sentadilla);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==9){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Bajar de peso pierna avanzado");
                                rutina.put("Duracion", "40 a 50 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nPierna").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkPierna9 = referencia.orderByChild("nombre").equalTo(pierna27);
                    checkPierna9.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(pierna27).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(pierna27).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(pierna27).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(pierna27).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(pierna27).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(pierna27).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(pierna27).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(pierna27).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(pierna27).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(pierna27).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(pierna27).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(pierna27).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pierna27).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pierna27).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pierna27).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pierna27).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pierna27).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pierna27).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);


                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.sentadilla);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.sentadilla_en_pared);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.donkey_dere);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.donkey_isq);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.sentadilla_en_pared);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.sentadilla);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });

        ejercicio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==1){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Fortalecimiento abdomen principiante");
                                rutina.put("Duracion", "25 a 35 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nAbdomen").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkAbs1 = referencia.orderByChild("nombre").equalTo(abs28);
                    checkAbs1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(abs28).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(abs28).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(abs28).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(abs28).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(abs28).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(abs28).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(abs28).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(abs28).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(abs28).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(abs28).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(abs28).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(abs28).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(abs28).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(abs28).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(abs28).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(abs28).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(abs28).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(abs28).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.crunch_abdominales);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.twist_ruso);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.escalada_de_montana);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.toque_al_talon);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.elevaciones_de_piernas);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.plancha);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==2){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Fortalecimiento abdomen intermedio");
                                rutina.put("Duracion", "30 a 40 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nAbdomen").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkAbs2 = referencia.orderByChild("nombre").equalTo(abs29);
                    checkAbs2.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(abs29).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(abs29).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(abs29).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(abs29).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(abs29).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(abs29).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(abs29).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(abs29).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(abs29).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(abs29).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(abs29).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(abs29).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(abs29).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(abs29).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(abs29).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(abs29).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(abs29).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(abs29).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);


                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.toque_al_talon);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.abdominal_cruzado);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.butt_bridge);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.crunch_de_bicicleta);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.crunch_abdominales);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.plancha);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==3){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Fortalecimiento abdomen avanzado");
                                rutina.put("Duracion", "40 a 50 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nAbdomen").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkAbs3 = referencia.orderByChild("nombre").equalTo(abs30);
                    checkAbs3.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(abs30).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(abs30).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(abs30).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(abs30).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(abs30).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(abs30).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(abs30).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(abs30).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(abs30).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(abs30).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(abs30).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(abs30).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(abs30).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(abs30).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(abs30).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(abs30).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(abs30).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(abs30).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);


                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.abdomen1);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.puente_lateral);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.puente_lateral);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.crunch_abdominales);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.plancha);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.escalada_de_montana);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==4){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Acondicionamiento abdomen principiante");
                                rutina.put("Duracion", "25 a 35 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nAbdomen").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkAbs4 = referencia.orderByChild("nombre").equalTo(abs31);
                    checkAbs4.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                // Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(abs31).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(abs31).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(abs31).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(abs31).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(abs31).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(abs31).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(abs31).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(abs31).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(abs31).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(abs31).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(abs31).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(abs31).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(abs31).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(abs31).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(abs31).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(abs31).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(abs31).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(abs31).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);

                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.abs_v);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.crunch_abdominales);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.elevaciones_de_piernas);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.plancha);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.twist_ruso);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.toque_al_talon);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==5){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Acondicionamiento abdomen intermedio");
                                rutina.put("Duracion", "30 a 40 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nAbdomen").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkAbs5 = referencia.orderByChild("nombre").equalTo(abs32);
                    checkAbs5.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(abs32).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(abs32).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(abs32).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(abs32).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(abs32).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(abs32).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(abs32).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(abs32).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(abs32).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(abs32).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(abs32).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(abs32).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(abs32).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(abs32).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(abs32).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(abs32).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(abs32).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(abs32).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);


                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.elevaciones_de_piernas);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.abdominal_cruzado);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.escalada_de_montana);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.puente_lateral);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.puente_lateral);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.toque_al_talon);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==6){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Acondicionamiento abdomen avanzado");
                                rutina.put("Duracion", "45 a 55 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nAbdomen").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkAbs6 = referencia.orderByChild("nombre").equalTo(abs33);
                    checkAbs6.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(abs33).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(abs33).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(abs33).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(abs33).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(abs33).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(abs33).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(abs33).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(abs33).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(abs33).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(abs33).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(abs33).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(abs33).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(abs33).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(abs33).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(abs33).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(abs33).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(abs33).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(abs33).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);


                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);

                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.crunch_abdominales);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.twist_ruso);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.toque_al_talon);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.toque_al_talon);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.elevaciones_de_piernas);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.plancha);


                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==7){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Bajar de peso abdomen principiante");
                                rutina.put("Duracion", "25 a 35 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nAbdomen").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkAbs7 = referencia.orderByChild("nombre").equalTo(abs34);
                    checkAbs7.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                // Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(abs34).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(abs34).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(abs34).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(abs34).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(abs34).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(abs34).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(abs34).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(abs34).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(abs34).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(abs34).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(abs34).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(abs34).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(abs34).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(abs34).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(abs34).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(abs34).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(abs34).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(abs34).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);


                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);

                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.abs_v);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.crunch_abdominales);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.elevaciones_de_piernas);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.plancha);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.twist_ruso);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.toque_al_talon);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==8){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Bajar de peso abdomen intermedio");
                                rutina.put("Duracion", "40 a 45 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nAbdomen").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkAbs8 = referencia.orderByChild("nombre").equalTo(abs35);
                    checkAbs8.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(abs35).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(abs35).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(abs35).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(abs35).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(abs35).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(abs35).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(abs35).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(abs35).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(abs35).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(abs35).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(abs35).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(abs35).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(abs35).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(abs35).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(abs35).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(abs35).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(abs35).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(abs35).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);

                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.crunch_abdominales);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.plancha);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.twist_ruso);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.toque_al_talon);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.abs_v);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.butt_bridge);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==9){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Bajar de peso abdomen avanzado");
                                rutina.put("Duracion", "40 a 50 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nAbdomen").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkAbs9 = referencia.orderByChild("nombre").equalTo(abs36);
                    checkAbs9.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(abs36).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(abs36).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(abs36).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(abs36).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(abs36).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(abs36).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(abs36).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(abs36).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(abs36).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(abs36).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(abs36).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(abs36).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(abs36).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(abs36).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(abs36).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(abs36).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(abs36).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(abs36).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);

                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.toque_al_talon);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.abdominal_cruzado);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.butt_bridge);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.crunch_abdominales);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.abs_v);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.crunch_abdominales);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });

        ejercicio5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==1){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Fortalecimiento hombro y espalda principiante");
                                rutina.put("Duracion", "25 a 35 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nHombro").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkHombro1 = referencia.orderByChild("nombre").equalTo(hombro37);
                    checkHombro1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(hombro37).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(hombro37).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(hombro37).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(hombro37).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(hombro37).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(hombro37).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(hombro37).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(hombro37).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(hombro37).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(hombro37).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(hombro37).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(hombro37).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(hombro37).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(hombro37).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(hombro37).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(hombro37).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(hombro37).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(hombro37).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.elevaciones_de_brazos);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.inchworms);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.elevaciones_de_brazos);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.flexiones_con_apoyo_de_rodillas);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.flexiones_en_pica);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.pose_gato);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                else if(a==2){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Fortalecimiento hombro y espalda intermedio");
                                rutina.put("Duracion", "30 a 40 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nHombro").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkHombro2 = referencia.orderByChild("nombre").equalTo(hombro38);
                    checkHombro2.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(hombro38).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(hombro38).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(hombro38).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(hombro38).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(hombro38).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(hombro38).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(hombro38).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(hombro38).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(hombro38).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(hombro38).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(hombro38).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(hombro38).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(hombro38).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(hombro38).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(hombro38).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(hombro38).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(hombro38).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(hombro38).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.extension_espalda);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.flexiones_con_inclinacion);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.triceps_en_suelo);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.hover);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.superman);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.inchworms);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==3){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Fortalecimiento hombro y espalda avanzado");
                                rutina.put("Duracion", "40 a 50 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nHombro").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkHombro3 = referencia.orderByChild("nombre").equalTo(hombro39);
                    checkHombro3.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                // Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(hombro39).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(hombro39).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(hombro39).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(hombro39).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(hombro39).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(hombro39).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(hombro39).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(hombro39).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(hombro39).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(hombro39).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(hombro39).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(hombro39).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(hombro39).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(hombro39).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(hombro39).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(hombro39).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(hombro39).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(hombro39).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.saltos_de_tijera);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.superman);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.flexiones_en_pica);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.delfin);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.superman);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.inchworms);


                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==4){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Acondicionamiento hombro y espalda principiante");
                                rutina.put("Duracion", "25 a 35 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nHombro").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkHombro4 = referencia.orderByChild("nombre").equalTo(hombro40);
                    checkHombro4.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                // Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(hombro40).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(hombro40).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(hombro40).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(hombro40).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(hombro40).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(hombro40).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(hombro40).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(hombro40).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(hombro40).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(hombro40).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(hombro40).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(hombro40).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(hombro40).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(hombro40).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(hombro40).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(hombro40).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(hombro40).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(hombro40).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.extension_espalda);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.flexiones_con_inclinacion);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.triceps_en_suelo);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.hover);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.superman);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.postura_bebe);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==5){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Acondicionamiento hombro y espalda intermedio");
                                rutina.put("Duracion", "30 a 40 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nHombro").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkHombro5 = referencia.orderByChild("nombre").equalTo(hombro41);
                    checkHombro5.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(hombro41).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(hombro41).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(hombro41).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(hombro41).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(hombro41).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(hombro41).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(hombro41).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(hombro41).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(hombro41).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(hombro41).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(hombro41).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(hombro41).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(hombro41).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(hombro41).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(hombro41).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(hombro41).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(hombro41).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(hombro41).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.saltos_de_tijera);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.superman);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.flexiones_en_pica);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.delfin);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.superman);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.inchworms);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==6){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Acondicionamiento hombro y espalda avanzado");
                                rutina.put("Duracion", "25 a 35 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nHombro").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkHombro6 = referencia.orderByChild("nombre").equalTo(hombro42);
                    checkHombro6.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(hombro42).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(hombro42).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(hombro42).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(hombro42).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(hombro42).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(hombro42).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(hombro42).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(hombro42).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(hombro42).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(hombro42).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(hombro42).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(hombro42).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(pecho1).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(pecho1).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(pecho1).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(pecho1).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(pecho1).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(pecho1).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);


                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.elevaciones_de_brazos);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.delfin);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.elevaciones_de_brazos);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.flexiones_con_apoyo_de_rodillas);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.superman);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.pose_gato);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==7){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Bajar de peso hombro y espalda principiante");
                                rutina.put("Duracion", "25 a 35 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nHombro").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkHombro7 = referencia.orderByChild("nombre").equalTo(hombro44);
                    checkHombro7.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                // Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(hombro44).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(hombro44).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(hombro44).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(hombro44).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(hombro44).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(hombro44).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(hombro44).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(hombro44).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(hombro44).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(hombro44).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(hombro44).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(hombro44).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(hombro44).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(hombro44).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(hombro44).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(hombro44).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(hombro44).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(hombro44).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.saltos_de_tijera);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.superman);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.flexiones_en_pica);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.delfin);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.superman);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.inchworms);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==8){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Bajar de peso hombro y espalda intermedio");
                                rutina.put("Duracion", "40 a 45 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nHombro").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkHombro8 = referencia.orderByChild("nombre").equalTo(hombro45);
                    checkHombro8.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(hombro45).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(hombro45).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(hombro45).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(hombro45).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(hombro45).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(hombro45).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(hombro45).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(hombro45).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(hombro45).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(hombro45).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(hombro45).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(hombro45).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(hombro45).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(hombro45).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(hombro45).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(hombro45).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(hombro45).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(hombro45).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.flexiones_en_pica);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.inchworms);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.supina);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.superman);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.postura_bebe);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.inchworms);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                else if(a==9){
                    baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                        Map<String,Object> rutina = new HashMap<String,Object>();
                        Date fecha = new Date();
                        int flag = 0;
                        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                            if(flag == 0)
                            {
                                rutina.put("Nombre ejercicio", "Bajar de peso hombro y espalda avanzado");
                                rutina.put("Duracion", "40 a 50 minutos");
                                rutina.put("Fecha de realización", fecha.toString());
                                //se obtiene el numeral de hijos que tiene
                                //i+=1;
                                int consecutivo = 0;
                                int nZona = 0;
                                consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPecho").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nBrazo").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nPierna").getValue().toString())
                                        + Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nAbdomen").getValue().toString())
                                        +Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                consecutivo += 1;
                                nZona = Integer.parseInt(datasnapshot.child(usuarios).child("nEjercicios").child("nHombro").getValue().toString());
                                nZona++;
                                flag++;
                                baseDatos.child("Usuarios").child(usuarios).child("nEjercicios").child("nHombro").setValue(nZona);
                                baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                            }
                            //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Query checkHombro9 = referencia.orderByChild("nombre").equalTo(hombro46);
                    checkHombro9.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //Toast.makeText(RutinasEjercicio.this, ":llegue", Toast.LENGTH_SHORT).show();
                                final String cant1,cant2,cant3,cant4,cant5,cant6,desc1,desc2,desc3,desc4,desc5,desc6,tiempo1,tiempo2,tiempo3,tiempo4
                                        ,tiempo5,tiempo6;
                                cant1 = dataSnapshot.child(hombro46).child("ejercicio1").getValue(String.class);
                                cant2 = dataSnapshot.child(hombro46).child("ejercicio2").getValue(String.class);
                                cant3 = dataSnapshot.child(hombro46).child("ejercicio3").getValue(String.class);
                                cant4 = dataSnapshot.child(hombro46).child("ejercicio4").getValue(String.class);
                                cant5 = dataSnapshot.child(hombro46).child("ejercicio5").getValue(String.class);
                                cant6 = dataSnapshot.child(hombro46).child("ejercicio6").getValue(String.class);

                                desc1 = dataSnapshot.child(hombro46).child("descripcion1").getValue(String.class);
                                desc2 = dataSnapshot.child(hombro46).child("descripcion2").getValue(String.class);
                                desc3 = dataSnapshot.child(hombro46).child("descripcion3").getValue(String.class);
                                desc4 = dataSnapshot.child(hombro46).child("descripcion4").getValue(String.class);
                                desc5 = dataSnapshot.child(hombro46).child("descripcion5").getValue(String.class);
                                desc6 = dataSnapshot.child(hombro46).child("descripcion6").getValue(String.class);


                                tiempo1 = dataSnapshot.child(hombro46).child("cantidad1").getValue(String.class);
                                tiempo2 = dataSnapshot.child(hombro46).child("cantidad2").getValue(String.class);
                                tiempo3 = dataSnapshot.child(hombro46).child("cantidad3").getValue(String.class);
                                tiempo4 = dataSnapshot.child(hombro46).child("cantidad4").getValue(String.class);
                                tiempo5 = dataSnapshot.child(hombro46).child("cantidad5").getValue(String.class);
                                tiempo6 = dataSnapshot.child(hombro46).child("cantidad6").getValue(String.class);

                                //Toast.makeText(RutinasEjercicio.this, ":"+cant1, Toast.LENGTH_SHORT).show();



                                Intent recibir = getIntent();
                                int tipoRutina = recibir.getIntExtra("rut1",0);
                                String rutNombre = recibir.getStringExtra("rutNombre");
                                Intent RutinaYoga1 = new Intent(RutinasEjercicio.this,Exercise.class);
                                RutinaYoga1.putExtra("eje1",cant1);
                                RutinaYoga1.putExtra("eje2",cant2);
                                RutinaYoga1.putExtra("eje3",cant3);
                                RutinaYoga1.putExtra("eje4",cant4);
                                RutinaYoga1.putExtra("eje5",cant5);
                                RutinaYoga1.putExtra("eje6",cant6);

                                RutinaYoga1.putExtra("desc1",desc1);
                                RutinaYoga1.putExtra("desc2",desc2);
                                RutinaYoga1.putExtra("desc3",desc3);
                                RutinaYoga1.putExtra("desc4",desc4);
                                RutinaYoga1.putExtra("desc5",desc5);
                                RutinaYoga1.putExtra("desc6",desc6);

                                RutinaYoga1.putExtra("usuario",usuarios);
                                RutinaYoga1.putExtra("email",correos);
                                RutinaYoga1.putExtra("clave",claves);
                                RutinaYoga1.putExtra("nombre",nombres);

                                RutinaYoga1.putExtra("cant1",tiempo1);
                                RutinaYoga1.putExtra("cant2",tiempo2);
                                RutinaYoga1.putExtra("cant3",tiempo3);
                                RutinaYoga1.putExtra("cant4",tiempo4);
                                RutinaYoga1.putExtra("cant5",tiempo5);
                                RutinaYoga1.putExtra("cant6",tiempo6);
                                RutinaYoga1.putExtra("rut1",tipoRutina);
                                RutinaYoga1.putExtra("rutNombre",rutNombre);
                                RutinaYoga1.putExtra("imgWorkout1",R.drawable.extension_espalda);
                                RutinaYoga1.putExtra("imgWorkout2",R.drawable.flexiones_con_inclinacion);
                                RutinaYoga1.putExtra("imgWorkout3",R.drawable.triceps_en_suelo);
                                RutinaYoga1.putExtra("imgWorkout4",R.drawable.hover);
                                RutinaYoga1.putExtra("imgWorkout5",R.drawable.superman);
                                RutinaYoga1.putExtra("imgWorkout6",R.drawable.postura_bebe);

                                startActivity(RutinaYoga1);
                            }

                            else{
                                Toast.makeText(RutinasEjercicio.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }


            }
        });



    }
}