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

import com.company.workpeace.ClasesAuxiliares.Firebase.MarcasAux;
import com.company.workpeace.ClasesAuxiliares.Firebase.YogaAux;
import com.company.workpeace.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Yoga extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView menuIcon;
    TextView rutinaYoga1;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ProgressBar progressBar;
    TextView rutina1, rutina2, rutina3, rutina4, rutina5, rutina6, rutina7, rutina8, rutina9,rutina10,rutina11,rutina12;
    TextView nombreRutina,nombreRutina2,nombreRutina3,nombreRutina4;
    FirebaseDatabase rutaMarcas;
    DatabaseReference referenciaMarcas;

    DatabaseReference referencia;
    DatabaseReference baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_yoga);
        rutaMarcas = FirebaseDatabase.getInstance();
        referenciaMarcas = rutaMarcas.getReference("Yoga");

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        rutina1 = findViewById(R.id.yoga1Titulo);
        rutina2 = findViewById(R.id.yoga2Titulo);
        rutina3 = findViewById(R.id.yoga3Titulo);
        rutina4 = findViewById(R.id.yoga4Titulo);
        rutina5 = findViewById(R.id.yoga5titulo);
        rutina6 = findViewById(R.id.yoga6Titulo);
        rutina7 = findViewById(R.id.yoga7Titulo);
        rutina8 = findViewById(R.id.yoga8Titulo);
        rutina9 = findViewById(R.id.yoga9Titulo);
        rutina10 = findViewById(R.id.yoga13Titulo);
        rutina11 = findViewById(R.id.yoga14Titulo);
        rutina12 = findViewById(R.id.yoga15Titulo);
        nombreRutina = findViewById(R.id.nombreRutinaYoga);
        nombreRutina2 = findViewById(R.id.nombreRutinaYoga2);
        nombreRutina3 = findViewById(R.id.nombreRutinaYoga3);
        nombreRutina4 = findViewById(R.id.nombreRutinaYoga5);
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
        final String tiempoTotal = "3 a 7 minutos";
        final String tiempoTotal2 = "6 a 10 minutos";
        final String tiempoTotal3 = "8 a 12 minutos";
        final String tiempoPose = "20 segundos";
        final String tiempoPose2 = "40 segundos";
        final String tiempoPose3 = "60 segundos";

        final String nombre1 = "Fuerza principiantes";
        YogaAux yogaAux = new YogaAux(
                "Pose elevada dinámica"
                ,"Elevación subiendo talones"
                ,"Elevación estirando los hombros"
                ,"Estiramiento de cuello"
                ,"Sentadillas en pose de silla"
                ,"Pose del gato"
                ,"Circulos en pose silla"
                ,"Pose del muerto"
                ,nombre1,tiempoTotal,tiempoPose
                ,"Empieza acostado boca arriba en el piso. Flexiona las rodillas y coloca los pies en el piso separados por el ancho de la cadera y con los brazos a los costados extendidos hacia los talones. Los lados externos de los pies están paralelos. Presiona sobre los pies, extiéndete con el coxis y levanta las caderas."
                ,"Sitúate en pie delante de un escalón, párate con el cuerpo bien recto e intenta involucrar los músculos del torso retrayendo las costillas superiores. Asegúrate de que las puntas de los pies estén plantadas en el borde del escalón. Los talones deben permanecer en el borde. Levanta los talones hasta que estés aguantándote con las puntas de los pies. "
                ,"Nos colocamos frente a una pared y vamos deslizándonos con los dedos de las manos hacia arriba hasta llegar lo más alto posible. Descender lentamente hasta la posición inicial."
                ,"Estando de pie, párate derecho con la espalda recta, intenta alejar los hombros lo más que puedas de las orejas. Inclina la cabeza hacia un lado mirando al frente y cuenta hasta veinte. Si no sientes el estiramiento, ayúdate suavemente con la mano empujando la cabeza hacia el costado. Repite el movimiento hacia el otro lado."
                ,"Partiremos con los brazos a ambos lados del cuerpo y los pies separados aproximadamente a la anchura de la cadera. Elevamos nuestros brazos hacia el techo, y hasta que los llevamos aproximadamente a la altura de las orejas. Al soltar el aire flexionamos las rodillas, intentando que estas queden prácticamente a la misma altura que los tobillos "
                ,"Sitúate en posición cuadrúpeda. Las muñecas tienen que estar justo debajo de los hombros, y tan separadas entre sí como las rodillas. La cabeza tiene que estar mirando hacia abajo. Vacía tus pulmones.  Inspira profundamente mientras elevas la espalda, arqueándola, sin despegar las manos del piso, agachas la cabeza, y metes el abdomen hacia dentro. Necesitarás estirar los brazos. "
                ,"Siéntate con los pies separados a la altura de las caderas y las manos apoyadas en las rodillas. Inhala y empieza a girar el torso en el sentido de las agujas del reloj, asegurándote de iniciar el movimiento desde la base de la columna vertebral. "
                ,"Tiéndete en la esterilla boca arriba, coloca los brazos a ambos lados del cuerpo. Mantén las palmas hacia arriba y procura que tus dedos estén en una posición cómoda. Deja las piernas relativamente abiertas de manera que te quede cómodo y los pies más o menos a unos 30 centímetros de distancia cada uno. ");
        referenciaMarcas.child(nombre1).setValue(yogaAux);

        final String nombre2 = "Fuerza intermedios";

        YogaAux yogaAux2 = new YogaAux(
                "De pie doblando al lado derecho"
                ,"De pie doblando al lado izquierdo"
                ,"Pose del barco"
                ,"Pose del tigre derecha"
                , "Pose del tigre izquierda"
                ,"Pose del saltamones"
                ,"Respiración en pose del rayo"
                ,"Pose del muerto"
                ,nombre2,tiempoTotal2,tiempoPose2
                ,"Separar las piernas a la altura de los hombros, girar hacia dentro el pie izquierdo, y 90º hacia afuera el pie derecho. Flexiónate lateralmente sobre la pierna derecha, agarrándote la espinilla. Estira hacia arriba el brazo izquierdo con la palma de la mano vuelta hacia delante. Gira el tronco hacia arriba moviendo el lado izquierdo del tronco hacia atrás. "
                ,"Separar las piernas a la altura de los hombros, girar hacia dentro el pie derecho, y 90º hacia afuera el pie izquierdo. Flexiónate lateralmente sobre la pierna izquierdo, agarrándote la espinilla. Estira hacia arriba el brazo derecho con la palma de la mano vuelta hacia delante. Gira el tronco hacia arriba moviendo el lado izquierdo del tronco hacia atrás. "
                ,"Comienza a sentarte, dobla las rodillas, reclínate hacia atrás y levanta los pies hasta que tus espinillas estén paralelas al piso. Si te sientes cómoda con esa posición, extiende tus brazos hacia adelante. Estira tus piernas para que tu cuerpo esté en forma de V."
                ,"Empieza con las manos y las rodillas sobre el tapete o piso. La espalda plana y de manera neutral. Extiende la pierda derecha, y esfuerza para que el estiramiento se siente hasta el talón. Al mismo tiempo, extiende el brazo izquierdo, De manera que sientas que el lado del cuerpo se está estirando hasta las yemas de los dedos."
                ,"Empieza con las manos y las rodillas sobre el tapete o piso. La espalda plana y de manera neutral. Extiende la pierda izquierda, y esfuerza para que el estiramiento se siente hasta el talón. Al mismo tiempo, extiende el brazo derecho, De manera que sientas que el lado del cuerpo se está estirando hasta las yemas de los dedos."
                ,"Recuéstate sobre tu estomago con la cara hacia abajo, los brazos a los lados y las palmas hacia arriba. Inspira a la vez que levantas la cabeza, el pecho y las piernas del suelo. Levanta los brazos paralelos al suelo. Espira al bajar las extremidades."
                ,"Siéntate con la espalda recta en una postura sentada. Ponte en posición cuadrúpeda, con las muñecas justo debajo de los hombros y las rodillas debajo de las caderas. Junta las piernas y lleva el tronco hacia atrás para ponerte de rodillas, con la espalda recta. Siéntate sobre tus talones manteniendo la espalda recta. Pon las manos sobre tus rodillas."
                ,"Tiéndete en la esterilla boca arriba, coloca los brazos a ambos lados del cuerpo. Mantén las palmas hacia arriba y procura que tus dedos estén en una posición cómoda. Deja las piernas relativamente abiertas de manera que te quede cómodo y los pies más o menos a unos 30 centímetros de distancia cada uno. ");
        referenciaMarcas.child(nombre2).setValue(yogaAux2);

        final String nombre3 = "Fuerza avanzados";

        YogaAux yogaAux3 = new YogaAux(
                "Pose del sauce curva lateral derecha"
                ,"Pose del sauce curva lateral izquierda"
                ,"Pose del zapatero dinámica"
                ,"Supino giro derecha"
                , "Supino giro izquierda"
                ,"Supino estiramiento dinámico de una pierna derecha"
                ,"Supino estiramiento dinámico de una pierna izquierda"
                ,"Pose del muerto"
                ,nombre3,tiempoTotal3,tiempoPose3
                ,"Comienza sentado y piernas estiradas. Dobla lentamente y con la pierna derecha de modo que el pie se encuentre frente al perineo y la planta del pie esta justo debajo del muslo izquierdo. Respira mientras alzas las manos y las juntas con las palmas al frente y al exhala todo el aire, inclina el cuerpo hacia delante y sin separar las manos del todo sujétate a los dedos del pie."
                ,"Comienza sentado y piernas estiradas. Dobla lentamente y con la pierna izquierda de modo que el pie se encuentre frente al perineo y la planta del pie esta justo debajo del muslo derecho.Respira mientras alzas las manos y las juntas con las palmas al frente y al exhala todo el aire, inclina el cuerpo hacia delante y sin separar las manos del todo sujétate a los dedos del pie. "
                ,"Se comienza esta postura con la posición sentada. Después separara las piernas manteniendo la espalda recta y los dedos de los pies mirando hacia arriba. Dobla las rodillas y acerca los pies al cuerpo. Entrelaza los dedos de manos con los dedos de los pies y usa las manos para acercar más los pies al cuerpo y retoma la posición sentada."
                ,"Acuéstate sobre el suelo boca arriba con las rodillas contra el pecho. Esta es la posición inicial. Estira la pierna izquierda y cruza la rodilla derecha hacia el lado contrario manteniendo los omóplatos pegados al suelo. Estira el brazo y gira la cabeza hacia el lado contrario del que estás girando. Mantén la otra mano sujetando la rodilla."
                ,"Acuéstate sobre el suelo boca arriba con las rodillas contra el pecho. Esta es la posición inicial. Estira la pierna derecha y cruza la rodilla izquierda hacia el lado contrario manteniendo los omóplatos pegados al suelo. Estira el brazo y gira la cabeza hacia el lado contrario del que estás girando. Mantén la otra mano sujetando la rodilla."
                ,"Acuéstate sobre el suelo boca arriba con las rodillas contra el pecho. Esta es la posición inicial. Estira la pierna izquierda y cruza la rodilla derecha hacia el lado contrario manteniendo los omóplatos pegados al suelo. Estira el brazo y gira la cabeza hacia el lado contrario del que estás girando. Mantén la otra mano sujetando la rodilla."
                ,"Acuéstate sobre el suelo boca arriba con las rodillas contra el pecho. Esta es la posición inicial. Estira la pierna derecha y cruza la rodilla izquierda hacia el lado contrario manteniendo los omóplatos pegados al suelo. Estira el brazo y gira la cabeza hacia el lado contrario del que estás girando. Mantén la otra mano sujetando la rodilla."
                ,"Tiéndete en la esterilla boca arriba, coloca los brazos a ambos lados del cuerpo. Mantén las palmas hacia arriba y procura que tus dedos estén en una posición cómoda. Deja las piernas relativamente abiertas de manera que te quede cómodo y los pies más o menos a unos 30 centímetros de distancia cada uno. ");
        referenciaMarcas.child(nombre3).setValue(yogaAux3);



        final String nombre4 = "Flexibilidad principiantes";

        YogaAux yogaAux4 = new YogaAux(
                "Pose del gato"
                ,"Pose del barco"
                ,"Sentado giro y curva lateral derecha"
                ,"Sentado giro y curva lateral izquierda"
                , "Supino giro izquierda"
                ,"Supino giro derecha"
                ,"Respiración en pose del rayo"
                ,"Pose del muerto"
                ,nombre4,tiempoTotal,tiempoPose
                ,"Sitúate en posición cuadrúpeda. Las muñecas tienen que estar justo debajo de los hombros, y tan separadas entre sí como las rodillas. La cabeza tiene que estar mirando hacia abajo. Vacía tus pulmones.  Inspira profundamente mientras elevas la espalda, arqueándola, sin despegar las manos del piso, agachas la cabeza, y metes el abdomen hacia dentro. Necesitarás estirar los brazos."
                ,"Comienza a sentarte, dobla las rodillas, reclínate hacia atrás y levanta los pies hasta que tus espinillas estén paralelas al piso. Si te sientes cómoda con esa posición, extiende tus brazos hacia adelante. Estira tus piernas para que tu cuerpo esté en forma de V. Mantén esa postura por 8 o 10 respiraciones."
                ,"Comienza sentado y piernas estiradas. Dobla lentamente y con la pierna derecha de modo que el pie se encuentre frente al perineo y la planta del pie esta justo debajo del muslo izquierdo.Respira mientras alzas las manos y las juntas con las palmas al frente y al exhala todo el aire, inclina el cuerpo hacia delante y sin separar las manos del todo sujétate a los dedos del pie."
                ,"Comienza sentado y piernas estiradas. Dobla lentamente y con la pierna izquierda de modo que el pie se encuentre frente al perineo y la planta del pie esta justo debajo del muslo derecho.Respira mientras alzas las manos y las juntas con las palmas al frente y al exhala todo el aire, inclina el cuerpo hacia delante y sin separar las manos del todo sujétate a los dedos del pie."
                ,"Acuéstate sobre el suelo boca arriba con las rodillas contra el pecho. Esta es la posición inicial. Estira la pierna derecha y cruza la rodilla izquierda hacia el lado contrario manteniendo los omóplatos pegados al suelo. Estira el brazo y gira la cabeza hacia el lado contrario del que estás girando. Mantén la otra mano sujetando la rodilla. "
                ,"Acuéstate sobre el suelo boca arriba con las rodillas contra el pecho. Esta es la posición inicial. Estira la pierna izquierda y cruza la rodilla derecha hacia el lado contrario manteniendo los omóplatos pegados al suelo. Estira el brazo y gira la cabeza hacia el lado contrario del que estás girando. Mantén la otra mano sujetando la rodilla. "
                ,"Siéntate con la espalda recta en una postura sentada. Ponte en posición cuadrúpeda, con las muñecas justo debajo de los hombros y las rodillas debajo de las caderas. Junta las piernas y lleva el tronco hacia atrás para ponerte de rodillas, con la espalda recta. Siéntate sobre tus talones manteniendo la espalda recta. Pon las manos sobre tus rodillas."
                ,"Tiéndete en la esterilla boca arriba, coloca los brazos a ambos lados del cuerpo. Mantén las palmas hacia arriba y procura que tus dedos estén en una posición cómoda. Deja las piernas relativamente abiertas de manera que te quede cómodo y los pies más o menos a unos 30 centímetros de distancia cada uno. ");
        referenciaMarcas.child(nombre4).setValue(yogaAux4);



        final String nombre5 = "Flexibilidad intermedios";

        YogaAux yogaAux5 = new YogaAux(
                "Pose del gato"
                ,"Pose del barco"
                ,"Sentado giro y curva lateral derecha"
                ,"Sentado giro y curva lateral izquierda"
                , "Supino giro izquierda"
                ,"Supino giro derecha"
                ,"Respiración en pose del rayo"
                ,"Pose del muerto"
                ,nombre5,tiempoTotal2,tiempoPose2
                ,"Sitúate en posición cuadrúpeda. Las muñecas tienen que estar justo debajo de los hombros, y tan separadas entre sí como las rodillas. La cabeza tiene que estar mirando hacia abajo. Vacía tus pulmones.  Inspira profundamente mientras elevas la espalda, arqueándola, sin despegar las manos del piso, agachas la cabeza, y metes el abdomen hacia dentro. Necesitarás estirar los brazos."
                ,"Comienza a sentarte, dobla las rodillas, reclínate hacia atrás y levanta los pies hasta que tus espinillas estén paralelas al piso. Si te sientes cómoda con esa posición, extiende tus brazos hacia adelante. Estira tus piernas para que tu cuerpo esté en forma de V. Mantén esa postura por 8 o 10 respiraciones."
                ,"Comienza sentado y piernas estiradas. Dobla lentamente y con la pierna derecha de modo que el pie se encuentre frente al perineo y la planta del pie esta justo debajo del muslo izquierdo.Respira mientras alzas las manos y las juntas con las palmas al frente y al exhala todo el aire, inclina el cuerpo hacia delante y sin separar las manos del todo sujétate a los dedos del pie."
                ,"Acuéstate sobre el suelo boca arriba con las rodillas contra el pecho. Esta es la posición inicial. Estira la pierna derecha y cruza la rodilla izquierda hacia el lado contrario manteniendo los omóplatos pegados al suelo. Estira el brazo y gira la cabeza hacia el lado contrario del que estás girando. Mantén la otra mano sujetando la rodilla. "
                ,"Acuéstate sobre el suelo boca arriba con las rodillas contra el pecho. Esta es la posición inicial. Estira la pierna derecha y cruza la rodilla izquierda hacia el lado contrario manteniendo los omóplatos pegados al suelo. Estira el brazo y gira la cabeza hacia el lado contrario del que estás girando. Mantén la otra mano sujetando la rodilla."
                ,"Acuéstate sobre el suelo boca arriba con las rodillas contra el pecho. Esta es la posición inicial. Estira la pierna izquierda y cruza la rodilla derecha hacia el lado contrario manteniendo los omóplatos pegados al suelo. Estira el brazo y gira la cabeza hacia el lado contrario del que estás girando. Mantén la otra mano sujetando la rodilla. "
                ,"Siéntate con la espalda recta en una postura sentada. Ponte en posición cuadrúpeda, con las muñecas justo debajo de los hombros y las rodillas debajo de las caderas. Junta las piernas y lleva el tronco hacia atrás para ponerte de rodillas, con la espalda recta. Siéntate sobre tus talones manteniendo la espalda recta. Pon las manos sobre tus rodillas."
                ,"Tiéndete en la esterilla boca arriba, coloca los brazos a ambos lados del cuerpo. Mantén las palmas hacia arriba y procura que tus dedos estén en una posición cómoda. Deja las piernas relativamente abiertas de manera que te quede cómodo y los pies más o menos a unos 30 centímetros de distancia cada uno. ");

        referenciaMarcas.child(nombre5).setValue(yogaAux5);


        final String nombre6 = "Flexibilidad Avanzados";

        YogaAux yogaAux6 = new YogaAux(
                "Giros de la parte superior del cuerpo"
                ,"De pie doblando lateralmente"
                ,"Guerrero dinámico derecha"
                ,"Guerrero dinámico izquierda"
                , "Plancha en pose del delfin"
                ,"Pose del saltamontes"
                ,"Pose de la diosa reclinada"
                ,"Pose del muerto"
                ,nombre6,tiempoTotal3,tiempoPose3
                ,"Siéntate sobre tus talones y coloca las manos sobre los hombros. Inhala girando el torso hacia la izquierda y exhala girando a la derecha. Acompaña la cabeza hacia los lados. Mantén los codos paralelos al suelo, permitiendo que los brazos giren libremente con el cuerpo. Este ejercicio también se puede hacer de pie."
                ,"Ponte con los pies abiertos, superando el ancho de los hombros, con los brazos extendidos a los lados. El pie que está delante se dirige hacia el frente y la otra gira 90 grados. Coloca tu mano sobre la pierna delantera y, manteniendo la espalda recta, levanta el brazo opuesto, tira de la cadera delantera hacia atrás y hacia abajo."
                ,"Sitúate de pie recto, y estira la espalda. Separa los pies y eleva los brazos estirándolos. Da un gran paso al frente con la pierna derecha, dejando quieta la izquierda, e inclínate sobre la derecha, que formará un ángulo cercano a los 90 grados. La pierna izquierda está en tensión, y con la derecha se soporta el peso. "
                ,"Sitúate de pie recto, y estira la espalda. Separa los pies y eleva los brazos estirándolos. Da un gran paso al frente con la pierna izquierda, dejando quieta la derecha, e inclínate sobre la izquierda, que formará un ángulo cercano a los 90 grados. La pierna derecha está en tensión, y con la derecha se soporta el peso. "
                ,"Debemos comenzar con las rodillas dobladas. Caminaremos con los pies hacia atrás. Apretaremos con nuestros antebrazos contra el suelo, al igual que los codos. Deberemos apretar los omóplatos contra la espalda y extender la columna. Apretaremos los muslos y estiramos los talones hacia arriba. Miraremos directamente hacia el suelo. Debemos tratar mantener la respiración a medida que realizamos el ejercicio. "
                ,"Recuéstate sobre tu estomago con la cara hacia abajo, los brazos a los lados y las palmas hacia arriba. Inspira a la vez que levantas la cabeza, el pecho y las piernas del suelo. Levanta los brazos paralelos al suelo. Espira al bajar las extremidades."
                ,"Empieza sentado con las rodillas flexionadas y los pies en el piso, suavemente inclínate hacia atrás. Una vez que te encuentres cómodo, junta los pies y separa las rodillas y permite que los brazos se relajen a los costados. En este punto toma por lo menos cinco respiraciones profundas. "
                ,"Tiéndete en la esterilla boca arriba, coloca los brazos a ambos lados del cuerpo. Mantén las palmas hacia arriba y procura que tus dedos estén en una posición cómoda. Deja las piernas relativamente abiertas de manera que te quede cómodo y los pies más o menos a unos 30 centímetros de distancia cada uno. ");
        referenciaMarcas.child(nombre6).setValue(yogaAux6);



        final String nombre7 = "Tonificarse principiantes";

        YogaAux yogaAux7 = new YogaAux(
                "Giro espinal con piernas cruzadas izquierda"
                ,"Giro espinal con piernas cruzadas derecha"
                ,"Sentado simple apertura de pecho"
                ,"Estiramiento de pierna sentado derecha"
                , "Estiramiento de pierna sentado izquierda"
                ,"Rey medio de los peces izquierda"
                ,"Rey medio de los peces derecha"
                ,"Niño con brazos extendidos"
                ,nombre7,tiempoTotal,tiempoPose
                ,"Siéntate con las piernas cruzadas y los tobillos debajo de las rodillas. Pon las manos en el piso y presiona el suelo, girando a la izquierda, usando la columna, y exhala para seguir girando. Mantén esta posición manteniendo la columna recta para que el cuello y la cabeza estén alineados sobre las caderas y luego regresa a la posición inicial."
                ,"Siéntate con las piernas cruzadas y los tobillos debajo de las rodillas. Pon las manos en el piso y presiona el suelo, girando a la derecha, usando la columna, y exhala para seguir girando. Mantén esta posición manteniendo la columna recta para que el cuello y la cabeza estén alineados sobre las caderas y luego regresa a la posición inicial"
                ,"Arrodíllate sobre el suelo, con las rodillas abiertas al ancho de tus caderas. Estira las caderas hacia delante, eleva el pecho hacia el cielo, lleva los hombros hacia atrás y apoya tus manos en los talones, llevando la cabeza hacia atrás. "
                ,"Siéntate con la pierna derecha extendida y la espalda recta. Flexiona la pierna izquierda de forma que la planta del pie se apoye contra la parte media del muslo. Trata de alcanzar el tobillo. Mantén la rodilla, el cuello y la espalda en posición recta. Siente el estiramiento en la parte posterior del muslo."
                ,"Siéntate con la pierna izquierda extendida y la espalda recta. Flexiona la pierna derecha de forma que la planta del pie se apoye contra la parte media del muslo. Trata de alcanzar el tobillo. Mantén la rodilla, el cuello y la espalda en posición recta. Siente el estiramiento en la parte posterior del muslo"
                ,"Siéntate y dobla la pierna izquierda y la colocas de bajo de la pierna derecha, mientras vas posicionando el pie derecho frente de la rodilla izquierda. Estira el torso y comienza a inspirar mientras giras a la derecha.Con el brazo izquierdo aférrate a la pierna derecha y con el brazo derecho dóblalo a tu espalda para que sostengas tu muslo izquierdo"
                ,"Siéntate y dobla la pierna derecha y la colocas de bajo de la pierna izquierda, mientras vas posicionando el pie izquierdo frente de la rodilla derecha. Estira el torso y comienza a inspirar mientras giras a la izquierda Con el brazo derecho aférrate a la pierna izquierda y con el brazo izquierdo dóblalo a tu espalda para que sostengas tu muslo derecho."
                ,"Siéntate sobre las rodillas. Las piernas tienen que formar una V, estira los brazos por encima de la cabeza, flexiona el tronco hacia delante y presiona el suelo con las manos. Estira el cuerpo, desde las caderas hasta las axilas hasta la punta de los dedos. Permite que la frente descanse sobre el suelo.");

        referenciaMarcas.child(nombre7).setValue(yogaAux7);


        final String nombre8 = "Tonificarse intermedios";

        YogaAux yogaAux8 = new YogaAux(
                "Pose de la diosa reclinada"
                ,"Pose del saltamontes"
                ,"Pose del gato"
                ,"Pose del barco"
                , "Respiración en pose del rayo"
                ,"Pose de la silla"
                ,"De pie de flexión hacia abajo"
                ,"Posición de montaña"
                ,nombre8,tiempoTotal2,tiempoPose2
                ,"Empieza sentado con las rodillas flexionadas y los pies en el piso, suavemente inclínate hacia atrás. Una vez que te encuentres cómodo, junta los pies y separa las rodillas y permite que los brazos se relajen a los costados. En este punto toma por lo menos cinco respiraciones profundas. "
                ,"Tiéndete en la esterilla boca arriba, coloca los brazos a ambos lados del cuerpo. Mantén las palmas hacia arriba y procura que tus dedos estén en una posición cómoda. Deja las piernas relativamente abiertas de manera que te quede cómodo y los pies más o menos a unos 30 centímetros de distancia cada uno. "
                ,"Sitúate en posición cuadrúpeda. Las muñecas tienen que estar justo debajo de los hombros, y tan separadas entre sí como las rodillas. La cabeza tiene que estar mirando hacia abajo. Vacía tus pulmones.  Inspira profundamente mientras elevas la espalda, arqueándola, sin despegar las manos del piso, agachas la cabeza, y metes el abdomen hacia dentro. Necesitarás estirar los brazos."
                ,"Comienza a sentarte, dobla las rodillas, reclínate hacia atrás y levanta los pies hasta que tus espinillas estén paralelas al piso. Si te sientes cómoda con esa posición, extiende tus brazos hacia adelante. Estira tus piernas para que tu cuerpo esté en forma de V. Mantén esa postura por 8 o 10 respiraciones."
                ,"Siéntate con la espalda recta en una postura sentada. Ponte en posición cuadrúpeda, con las muñecas justo debajo de los hombros y las rodillas debajo de las caderas. Junta las piernas y lleva el tronco hacia atrás para ponerte de rodillas, con la espalda recta. Siéntate sobre tus talones manteniendo la espalda recta. Pon las manos sobre tus rodillas."
                ,"Partimos con los brazos a ambos lados del cuerpo y los pies separados. Elevamos nuestros brazos hacia el techo. Al soltar el aire flexionamos ligeramente las rodillas, intentando que estas queden prácticamente a la misma altura que los tobillos. "
                ,"Flexiona las rodillas ligeramente, el sacro se está hundiendo en la parte de atrás de tu pelvis y acerca el coxis al pubis. Luego empuja la parte superior de los muslos hacia atrás y los talones hacia abajo y pon rectas las rodillas nuevamente, puedes presionar las manos contra la parte de atrás de cada rodilla para ofrecer cierta resistencia"
                ,"Párate con los dedos pulgares tocándose entre ellos y la parte externa de los pies paralelos. El peso debe estar distribuido uniformemente y las manos a los lados del cuerpo con las palmas mirando hacia arriba en gesto de apertura. Mantén el cuello estirado, la nuca elevada.");
        referenciaMarcas.child(nombre8).setValue(yogaAux8);

        final String nombre9 = "Tonificarse avanzados";

        YogaAux yogaAux9 = new YogaAux(
                "Pose del gato"
                ,"Pose del barco"
                ,"Sentado giro y curva lateral derecha"
                ,"Sentado giro y curva lateral izquierda"
                , "Supino giro izquierda"
                ,"Supino giro derecha"
                ,"Respiración en pose del rayo"
                ,"Pose del muerto"
                ,nombre9,tiempoTotal3,tiempoPose3
                ,"Sitúate en posición cuadrúpeda. Las muñecas tienen que estar justo debajo de los hombros, y tan separadas entre sí como las rodillas. La cabeza tiene que estar mirando hacia abajo. Vacía tus pulmones.  Inspira profundamente mientras elevas la espalda, arqueándola, sin despegar las manos del piso, agachas la cabeza, y metes el abdomen hacia dentro. Necesitarás estirar los brazos."
                ,"Comienza a sentarte, dobla las rodillas, reclínate hacia atrás y levanta los pies hasta que tus espinillas estén paralelas al piso. Si te sientes cómoda con esa posición, extiende tus brazos hacia adelante. Estira tus piernas para que tu cuerpo esté en forma de V. Mantén esa postura por 8 o 10 respiraciones."
                ,"Comienza sentado y piernas estiradas. Dobla lentamente y con la pierna derecha de modo que el pie se encuentre frente al perineo y la planta del pie esta justo debajo del muslo izquierdo.Respira mientras alzas las manos y las juntas con las palmas al frente y al exhala todo el aire, inclina el cuerpo hacia delante y sin separar las manos del todo sujétate a los dedos del pie."
                ,"Comienza sentado y piernas estiradas. Dobla lentamente y con la pierna izquierda de modo que el pie se encuentre frente al perineo y la planta del pie esta justo debajo del muslo derecho.Respira mientras alzas las manos y las juntas con las palmas al frente y al exhala todo el aire, inclina el cuerpo hacia delante y sin separar las manos del todo sujétate a los dedos del pie."
                ,"Acuéstate sobre el suelo boca arriba con las rodillas contra el pecho. Esta es la posición inicial. Estira la pierna derecha y cruza la rodilla izquierda hacia el lado contrario manteniendo los omóplatos pegados al suelo. Estira el brazo y gira la cabeza hacia el lado contrario del que estás girando. Mantén la otra mano sujetando la rodilla. "
                ,"Acuéstate sobre el suelo boca arriba con las rodillas contra el pecho. Esta es la posición inicial. Estira la pierna izquierda y cruza la rodilla derecha hacia el lado contrario manteniendo los omóplatos pegados al suelo. Estira el brazo y gira la cabeza hacia el lado contrario del que estás girando. Mantén la otra mano sujetando la rodilla. "
                ,"Siéntate con la espalda recta en una postura sentada. Ponte en posición cuadrúpeda, con las muñecas justo debajo de los hombros y las rodillas debajo de las caderas. Junta las piernas y lleva el tronco hacia atrás para ponerte de rodillas, con la espalda recta. Siéntate sobre tus talones manteniendo la espalda recta. Pon las manos sobre tus rodillas."
                ,"Tiéndete en la esterilla boca arriba, coloca los brazos a ambos lados del cuerpo. Mantén las palmas hacia arriba y procura que tus dedos estén en una posición cómoda. Deja las piernas relativamente abiertas de manera que te quede cómodo y los pies más o menos a unos 30 centímetros de distancia cada uno. ");
        referenciaMarcas.child(nombre9).setValue(yogaAux9);

        final String nombre10 = "Espalda principiantes";

        YogaAux yogaAux10 = new YogaAux(
                "Pose del gato"
                ,"Pose del barco"
                ,"Sentado giro y curva lateral derecha"
                ,"Sentado giro y curva lateral izquierda"
                , "Supino giro izquierda"
                ,"Supino giro derecha"
                ,"Respiración en pose del rayo"
                ,"Pose del muerto"
                ,nombre10,tiempoTotal,tiempoPose
                ,"Sitúate en posición cuadrúpeda. Las muñecas tienen que estar justo debajo de los hombros, y tan separadas entre sí como las rodillas. La cabeza tiene que estar mirando hacia abajo. Vacía tus pulmones.  Inspira profundamente mientras elevas la espalda, arqueándola, sin despegar las manos del piso, agachas la cabeza, y metes el abdomen hacia dentro. Necesitarás estirar los brazos."
                ,"Comienza a sentarte, dobla las rodillas, reclínate hacia atrás y levanta los pies hasta que tus espinillas estén paralelas al piso. Si te sientes cómoda con esa posición, extiende tus brazos hacia adelante. Estira tus piernas para que tu cuerpo esté en forma de V. Mantén esa postura por 8 o 10 respiraciones."
                ,"Comienza sentado y piernas estiradas. Dobla lentamente y con la pierna derecha de modo que el pie se encuentre frente al perineo y la planta del pie esta justo debajo del muslo izquierdo.Respira mientras alzas las manos y las juntas con las palmas al frente y al exhala todo el aire, inclina el cuerpo hacia delante y sin separar las manos del todo sujétate a los dedos del pie."
                ,"Acuéstate sobre el suelo boca arriba con las rodillas contra el pecho. Esta es la posición inicial. Estira la pierna derecha y cruza la rodilla izquierda hacia el lado contrario manteniendo los omóplatos pegados al suelo. Estira el brazo y gira la cabeza hacia el lado contrario del que estás girando. Mantén la otra mano sujetando la rodilla. "
                ,"Acuéstate sobre el suelo boca arriba con las rodillas contra el pecho. Esta es la posición inicial. Estira la pierna derecha y cruza la rodilla izquierda hacia el lado contrario manteniendo los omóplatos pegados al suelo. Estira el brazo y gira la cabeza hacia el lado contrario del que estás girando. Mantén la otra mano sujetando la rodilla."
                ,"Acuéstate sobre el suelo boca arriba con las rodillas contra el pecho. Esta es la posición inicial. Estira la pierna izquierda y cruza la rodilla derecha hacia el lado contrario manteniendo los omóplatos pegados al suelo. Estira el brazo y gira la cabeza hacia el lado contrario del que estás girando. Mantén la otra mano sujetando la rodilla. "
                ,"Siéntate con la espalda recta en una postura sentada. Ponte en posición cuadrúpeda, con las muñecas justo debajo de los hombros y las rodillas debajo de las caderas. Junta las piernas y lleva el tronco hacia atrás para ponerte de rodillas, con la espalda recta. Siéntate sobre tus talones manteniendo la espalda recta. Pon las manos sobre tus rodillas."
                ,"Tiéndete en la esterilla boca arriba, coloca los brazos a ambos lados del cuerpo. Mantén las palmas hacia arriba y procura que tus dedos estén en una posición cómoda. Deja las piernas relativamente abiertas de manera que te quede cómodo y los pies más o menos a unos 30 centímetros de distancia cada uno. ");

        referenciaMarcas.child(nombre10).setValue(yogaAux10);

        final String nombre11 = "Espalda intermedios";

        YogaAux yogaAux11 = new YogaAux(
                "De pie doblando al lado derecho"
                ,"De pie doblando al lado izquierdo"
                ,"Pose del barco"
                ,"Pose del tigre derecha"
                , "Pose del tigre izquierda"
                ,"Pose del saltamones"
                ,"Respiración en pose del rayo"
                ,"Pose del muerto"
                ,nombre11,tiempoTotal2,tiempoPose2
                ,"Separar las piernas a la altura de los hombros, girar hacia dentro el pie izquierdo, y 90º hacia afuera el pie derecho. Flexiónate lateralmente sobre la pierna derecha, agarrándote la espinilla. Estira hacia arriba el brazo izquierdo con la palma de la mano vuelta hacia delante. Gira el tronco hacia arriba moviendo el lado izquierdo del tronco hacia atrás. "
                ,"Separar las piernas a la altura de los hombros, girar hacia dentro el pie derecho, y 90º hacia afuera el pie izquierdo. Flexiónate lateralmente sobre la pierna izquierdo, agarrándote la espinilla. Estira hacia arriba el brazo derecho con la palma de la mano vuelta hacia delante. Gira el tronco hacia arriba moviendo el lado izquierdo del tronco hacia atrás. "
                ,"Comienza a sentarte, dobla las rodillas, reclínate hacia atrás y levanta los pies hasta que tus espinillas estén paralelas al piso. Si te sientes cómoda con esa posición, extiende tus brazos hacia adelante. Estira tus piernas para que tu cuerpo esté en forma de V."
                ,"Empieza con las manos y las rodillas sobre el tapete o piso. La espalda plana y de manera neutral. Extiende la pierda derecha, y esfuerza para que el estiramiento se siente hasta el talón. Al mismo tiempo, extiende el brazo izquierdo, De manera que sientas que el lado del cuerpo se está estirando hasta las yemas de los dedos."
                ,"Empieza con las manos y las rodillas sobre el tapete o piso. La espalda plana y de manera neutral. Extiende la pierda izquierda, y esfuerza para que el estiramiento se siente hasta el talón. Al mismo tiempo, extiende el brazo derecho, De manera que sientas que el lado del cuerpo se está estirando hasta las yemas de los dedos."
                ,"Recuéstate sobre tu estomago con la cara hacia abajo, los brazos a los lados y las palmas hacia arriba. Inspira a la vez que levantas la cabeza, el pecho y las piernas del suelo. Levanta los brazos paralelos al suelo. Espira al bajar las extremidades."
                ,"Siéntate con la espalda recta en una postura sentada. Ponte en posición cuadrúpeda, con las muñecas justo debajo de los hombros y las rodillas debajo de las caderas. Junta las piernas y lleva el tronco hacia atrás para ponerte de rodillas, con la espalda recta. Siéntate sobre tus talones manteniendo la espalda recta. Pon las manos sobre tus rodillas."
                ,"Tiéndete en la esterilla boca arriba, coloca los brazos a ambos lados del cuerpo. Mantén las palmas hacia arriba y procura que tus dedos estén en una posición cómoda. Deja las piernas relativamente abiertas de manera que te quede cómodo y los pies más o menos a unos 30 centímetros de distancia cada uno. ");
        referenciaMarcas.child(nombre11).setValue(yogaAux11);


        final String nombre12 = "Espalda avanzados";
        YogaAux yogaAux12 = new YogaAux(
                "Pose elevada dinámica"
                ,"Elevación subiendo talones"
                ,"Elevación estirando los hombros"
                ,"Estiramiento de cuello"
                ,"Sentadillas en pose de silla"
                ,"Pose del gato"
                ,"Circulos en pose silla"
                ,"Pose del muerto"
                ,nombre12,tiempoTotal3,tiempoPose3
                ,"Empieza acostado boca arriba en el piso. Flexiona las rodillas y coloca los pies en el piso separados por el ancho de la cadera y con los brazos a los costados extendidos hacia los talones. Los lados externos de los pies están paralelos. Presiona sobre los pies, extiéndete con el coxis y levanta las caderas."
                ,"Sitúate en pie delante de un escalón, párate con el cuerpo bien recto e intenta involucrar los músculos del torso retrayendo las costillas superiores. Asegúrate de que las puntas de los pies estén plantadas en el borde del escalón. Los talones deben permanecer en el borde. Levanta los talones hasta que estés aguantándote con las puntas de los pies. "
                ,"Nos colocamos frente a una pared y vamos deslizándonos con los dedos de las manos hacia arriba hasta llegar lo más alto posible. Descender lentamente hasta la posición inicial."
                ,"Estando de pie, párate derecho con la espalda recta, intenta alejar los hombros lo más que puedas de las orejas. Inclina la cabeza hacia un lado mirando al frente y cuenta hasta veinte. Si no sientes el estiramiento, ayúdate suavemente con la mano empujando la cabeza hacia el costado. Repite el movimiento hacia el otro lado."
                ,"Partiremos con los brazos a ambos lados del cuerpo y los pies separados aproximadamente a la anchura de la cadera. Elevamos nuestros brazos hacia el techo, y hasta que los llevamos aproximadamente a la altura de las orejas. Al soltar el aire flexionamos las rodillas, intentando que estas queden prácticamente a la misma altura que los tobillos "
                ,"Sitúate en posición cuadrúpeda. Las muñecas tienen que estar justo debajo de los hombros, y tan separadas entre sí como las rodillas. La cabeza tiene que estar mirando hacia abajo. Vacía tus pulmones.  Inspira profundamente mientras elevas la espalda, arqueándola, sin despegar las manos del piso, agachas la cabeza, y metes el abdomen hacia dentro. Necesitarás estirar los brazos. "
                ,"Siéntate con los pies separados a la altura de las caderas y las manos apoyadas en las rodillas. Inhala y empieza a girar el torso en el sentido de las agujas del reloj, asegurándote de iniciar el movimiento desde la base de la columna vertebral. "
                ,"Tiéndete en la esterilla boca arriba, coloca los brazos a ambos lados del cuerpo. Mantén las palmas hacia arriba y procura que tus dedos estén en una posición cómoda. Deja las piernas relativamente abiertas de manera que te quede cómodo y los pies más o menos a unos 30 centímetros de distancia cada uno. ");
        referenciaMarcas.child(nombre12).setValue(yogaAux12);



        referencia = FirebaseDatabase.getInstance().getReference("Yoga");

        rutina1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Yoga para fuerza principiante");
                            rutina.put("Duracion", "3 a 7 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nYogas").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nYogas").setValue(consecutivo);
                            baseDatos.child("HistorialYoga").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Query checkYoga = referencia.orderByChild("nombre").equalTo(nombre1);
                checkYoga.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            //Toast.makeText(Yoga.this, ":llegue", Toast.LENGTH_SHORT).show();
                            final String cant1,cant2,cant3,cant4,cant5,cant6,cant7,cant8,cant9,cant10;
                            cant1 = dataSnapshot.child(nombre1).child("pose1").getValue(String.class);
                            cant2 = dataSnapshot.child(nombre1).child("pose2").getValue(String.class);
                            cant3 = dataSnapshot.child(nombre1).child("pose3").getValue(String.class);
                            cant4 = dataSnapshot.child(nombre1).child("pose4").getValue(String.class);
                            cant5 = dataSnapshot.child(nombre1).child("pose5").getValue(String.class);
                            cant6 = dataSnapshot.child(nombre1).child("pose6").getValue(String.class);
                            cant7 = dataSnapshot.child(nombre1).child("pose7").getValue(String.class);
                            cant8 = dataSnapshot.child(nombre1).child("pose8").getValue(String.class);
                            cant9 = dataSnapshot.child(nombre1).child("tiempoTotal").getValue(String.class);
                            cant10 = dataSnapshot.child(nombre1).child("tiempoPose").getValue(String.class);
                            final String descYoga1,descYoga2,descYoga3,descYoga4,descYoga5,descYoga6,descYoga7,descYoga8;
                            descYoga1 = dataSnapshot.child(nombre1).child("descripcion1").getValue(String.class);
                            descYoga2 = dataSnapshot.child(nombre1).child("descripcion2").getValue(String.class);
                            descYoga3 = dataSnapshot.child(nombre1).child("descripcion3").getValue(String.class);
                            descYoga4 = dataSnapshot.child(nombre1).child("descripcion4").getValue(String.class);
                            descYoga5 = dataSnapshot.child(nombre1).child("descripcion5").getValue(String.class);
                            descYoga6 = dataSnapshot.child(nombre1).child("descripcion6").getValue(String.class);
                            descYoga7 = dataSnapshot.child(nombre1).child("descripcion7").getValue(String.class);
                            descYoga8 = dataSnapshot.child(nombre1).child("descripcion8").getValue(String.class);


                            Intent RutinaYoga1 = new Intent(Yoga.this,RutinasYoga.class);
                            RutinaYoga1.putExtra("yoga1",cant1);
                            RutinaYoga1.putExtra("imgYoga1",R.drawable.pose_elevada_dinamica);
                            RutinaYoga1.putExtra("imgYoga3",R.drawable.elevacion_estirando_hombros);
                            RutinaYoga1.putExtra("imgYoga2",R.drawable.elevacion_subiendo_talones);
                            RutinaYoga1.putExtra("imgYoga4",R.drawable.estiramiento_de_cuello);
                            RutinaYoga1.putExtra("imgYoga5",R.drawable.sentadilla_pose_silla);
                            RutinaYoga1.putExtra("imgYoga6",R.drawable.pose_gato);
                            RutinaYoga1.putExtra("imgYoga7",R.drawable.circulos_pose_silla);
                            RutinaYoga1.putExtra("imgYoga8",R.drawable.pose_del_muerto);
                            RutinaYoga1.putExtra("yoga2",cant2);
                            RutinaYoga1.putExtra("yoga3",cant3);
                            RutinaYoga1.putExtra("yoga4",cant4);
                            RutinaYoga1.putExtra("yoga5",cant5);
                            RutinaYoga1.putExtra("yoga6",cant6);
                            RutinaYoga1.putExtra("yoga7",cant7);
                            RutinaYoga1.putExtra("yoga8",cant8);
                            RutinaYoga1.putExtra("descYoga1",descYoga1);
                            RutinaYoga1.putExtra("descYoga2",descYoga2);
                            RutinaYoga1.putExtra("descYoga3",descYoga3);
                            RutinaYoga1.putExtra("descYoga4",descYoga4);
                            RutinaYoga1.putExtra("descYoga5",descYoga5);
                            RutinaYoga1.putExtra("descYoga6",descYoga6);
                            RutinaYoga1.putExtra("descYoga7",descYoga7);
                            RutinaYoga1.putExtra("descYoga8",descYoga8);

                            RutinaYoga1.putExtra("usuario",usuarios);
                            RutinaYoga1.putExtra("email",correos);
                            RutinaYoga1.putExtra("clave",claves);
                            RutinaYoga1.putExtra("nombre",nombres);
                            RutinaYoga1.putExtra("yoga10","YOGA PARA FUERZA");
                            RutinaYoga1.putExtra("yoga9",1);
                            RutinaYoga1.putExtra("tiempoTotalYoga",cant9);
                            RutinaYoga1.putExtra("tiempoPose",cant10);
                            //RutinaYoga1.putExtra("tipoYoga1","Hola");
                            startActivity(RutinaYoga1);
                        }

                        else{
                            Toast.makeText(Yoga.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        rutina2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Yoga para fuerza intermedio");
                            rutina.put("Duracion", "6 a 10 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nYogas").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nYogas").setValue(consecutivo);
                            baseDatos.child("HistorialYoga").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);

                Query checkYoga2 = referencia.orderByChild("nombre").equalTo(nombre2);
                checkYoga2.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            //Toast.makeText(Yoga.this, ":llegue", Toast.LENGTH_SHORT).show();
                            final String cant1,cant2,cant3,cant4,cant5,cant6,cant7,cant8,cant9,cant10;
                            cant1 = dataSnapshot.child(nombre2).child("pose1").getValue(String.class);
                            cant2 = dataSnapshot.child(nombre2).child("pose2").getValue(String.class);
                            cant3 = dataSnapshot.child(nombre2).child("pose3").getValue(String.class);
                            cant4 = dataSnapshot.child(nombre2).child("pose4").getValue(String.class);
                            cant5 = dataSnapshot.child(nombre2).child("pose5").getValue(String.class);
                            cant6 = dataSnapshot.child(nombre2).child("pose6").getValue(String.class);
                            cant7 = dataSnapshot.child(nombre2).child("pose7").getValue(String.class);
                            cant8 = dataSnapshot.child(nombre2).child("pose8").getValue(String.class);
                            cant9 = dataSnapshot.child(nombre2).child("tiempoTotal").getValue(String.class);
                            cant10 = dataSnapshot.child(nombre2).child("tiempoPose").getValue(String.class);
                            //Toast.makeText(Yoga.this, ":"+cant1, Toast.LENGTH_SHORT).show();

                            final String descYoga1,descYoga2,descYoga3,descYoga4,descYoga5,descYoga6,descYoga7,descYoga8;
                            descYoga1 = dataSnapshot.child(nombre2).child("descripcion1").getValue(String.class);
                            descYoga2 = dataSnapshot.child(nombre2).child("descripcion2").getValue(String.class);
                            descYoga3 = dataSnapshot.child(nombre2).child("descripcion3").getValue(String.class);
                            descYoga4 = dataSnapshot.child(nombre2).child("descripcion4").getValue(String.class);
                            descYoga5 = dataSnapshot.child(nombre2).child("descripcion5").getValue(String.class);
                            descYoga6 = dataSnapshot.child(nombre2).child("descripcion6").getValue(String.class);
                            descYoga7 = dataSnapshot.child(nombre2).child("descripcion7").getValue(String.class);
                            descYoga8 = dataSnapshot.child(nombre2).child("descripcion8").getValue(String.class);



                            Intent RutinaYoga2 = new Intent(Yoga.this,RutinasYoga.class);
                            RutinaYoga2.putExtra("yoga1",cant1);
                            RutinaYoga2.putExtra("yoga2",cant2);
                            RutinaYoga2.putExtra("yoga3",cant3);
                            RutinaYoga2.putExtra("yoga4",cant4);
                            RutinaYoga2.putExtra("yoga5",cant5);
                            RutinaYoga2.putExtra("yoga6",cant6);
                            RutinaYoga2.putExtra("yoga7",cant7);
                            RutinaYoga2.putExtra("yoga8",cant8);
                            RutinaYoga2.putExtra("imgYoga1",R.drawable.de_pie_doblando_al_lado_derecho);
                            RutinaYoga2.putExtra("imgYoga2",R.drawable.de_pie_doblando_izquierdo);
                            RutinaYoga2.putExtra("imgYoga3",R.drawable.pose_barco);
                            RutinaYoga2.putExtra("imgYoga4",R.drawable.pose_del_tigre_derecha);
                            RutinaYoga2.putExtra("imgYoga5",R.drawable.pose_tigre_izq);
                            RutinaYoga2.putExtra("imgYoga6",R.drawable.pose_saltamontes);
                            RutinaYoga2.putExtra("imgYoga7",R.drawable.pose_del_rayo);
                            RutinaYoga2.putExtra("imgYoga8",R.drawable.pose_del_muerto);
                            RutinaYoga2.putExtra("yoga10","YOGA PARA FUERZA");
                            RutinaYoga2.putExtra("yoga9",2);
                            RutinaYoga2.putExtra("tiempoTotalYoga",cant9);
                            RutinaYoga2.putExtra("tiempoPose",cant10);
                            RutinaYoga2.putExtra("descYoga1",descYoga1);
                            RutinaYoga2.putExtra("descYoga2",descYoga2);
                            RutinaYoga2.putExtra("descYoga3",descYoga3);
                            RutinaYoga2.putExtra("descYoga4",descYoga4);
                            RutinaYoga2.putExtra("descYoga5",descYoga5);
                            RutinaYoga2.putExtra("descYoga6",descYoga6);
                            RutinaYoga2.putExtra("descYoga7",descYoga7);
                            RutinaYoga2.putExtra("descYoga8",descYoga8);

                            RutinaYoga2.putExtra("usuario",usuarios);
                            RutinaYoga2.putExtra("email",correos);
                            RutinaYoga2.putExtra("clave",claves);
                            RutinaYoga2.putExtra("nombre",nombres);
                            //RutinaYoga1.putExtra("tipoYoga1","Hola");
                            startActivity(RutinaYoga2);
                        }

                        else{
                            Toast.makeText(Yoga.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        rutina3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Yoga para fuerza avanzado");
                            rutina.put("Duracion", "8 a 12 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nYogas").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nYogas").setValue(consecutivo);
                            baseDatos.child("HistorialYoga").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Query checkYoga3 = referencia.orderByChild("nombre").equalTo(nombre3);
                checkYoga3.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            //Toast.makeText(Yoga.this, ":llegue", Toast.LENGTH_SHORT).show();
                            final String cant1,cant2,cant3,cant4,cant5,cant6,cant7,cant8,cant9,cant10;
                            cant1 = dataSnapshot.child(nombre3).child("pose1").getValue(String.class);
                            cant2 = dataSnapshot.child(nombre3).child("pose2").getValue(String.class);
                            cant3 = dataSnapshot.child(nombre3).child("pose3").getValue(String.class);
                            cant4 = dataSnapshot.child(nombre3).child("pose4").getValue(String.class);
                            cant5 = dataSnapshot.child(nombre3).child("pose5").getValue(String.class);
                            cant6 = dataSnapshot.child(nombre3).child("pose6").getValue(String.class);
                            cant7 = dataSnapshot.child(nombre3).child("pose7").getValue(String.class);
                            cant8 = dataSnapshot.child(nombre3).child("pose8").getValue(String.class);
                            cant9 = dataSnapshot.child(nombre3).child("tiempoTotal").getValue(String.class);
                            cant10 = dataSnapshot.child(nombre3).child("tiempoPose").getValue(String.class);
                            //Toast.makeText(Yoga.this, ":"+cant1, Toast.LENGTH_SHORT).show();

                            final String descYoga1,descYoga2,descYoga3,descYoga4,descYoga5,descYoga6,descYoga7,descYoga8;
                            descYoga1 = dataSnapshot.child(nombre3).child("descripcion1").getValue(String.class);
                            descYoga2 = dataSnapshot.child(nombre3).child("descripcion2").getValue(String.class);
                            descYoga3 = dataSnapshot.child(nombre3).child("descripcion3").getValue(String.class);
                            descYoga4 = dataSnapshot.child(nombre3).child("descripcion4").getValue(String.class);
                            descYoga5 = dataSnapshot.child(nombre3).child("descripcion5").getValue(String.class);
                            descYoga6 = dataSnapshot.child(nombre3).child("descripcion6").getValue(String.class);
                            descYoga7 = dataSnapshot.child(nombre3).child("descripcion7").getValue(String.class);
                            descYoga8 = dataSnapshot.child(nombre3).child("descripcion8").getValue(String.class);


                            Intent RutinaYoga2 = new Intent(Yoga.this,RutinasYoga.class);
                            RutinaYoga2.putExtra("yoga1",cant1);
                            RutinaYoga2.putExtra("yoga2",cant2);
                            RutinaYoga2.putExtra("yoga3",cant3);
                            RutinaYoga2.putExtra("yoga4",cant4);
                            RutinaYoga2.putExtra("yoga5",cant5);
                            RutinaYoga2.putExtra("yoga6",cant6);
                            RutinaYoga2.putExtra("yoga7",cant7);
                            RutinaYoga2.putExtra("yoga8",cant8);
                            RutinaYoga2.putExtra("imgYoga1",R.drawable.pose_sauce_lateral_derecha);
                            RutinaYoga2.putExtra("imgYoga2",R.drawable.pose_sauce_lateral_izq);
                            RutinaYoga2.putExtra("imgYoga3",R.drawable.pose_zapatero);
                            RutinaYoga2.putExtra("imgYoga4",R.drawable.supino_giro_derecha);
                            RutinaYoga2.putExtra("imgYoga5",R.drawable.supino_giro_izq);
                            RutinaYoga2.putExtra("imgYoga6",R.drawable.supino_estiramiento_dinamico_pierna_derecha);
                            RutinaYoga2.putExtra("imgYoga7",R.drawable.supino_estiramiento_dinamico_pierna_izq);
                            RutinaYoga2.putExtra("imgYoga8",R.drawable.pose_del_muerto);
                            RutinaYoga2.putExtra("yoga10","YOGA PARA FUERZA");
                            RutinaYoga2.putExtra("yoga9",3);
                            RutinaYoga2.putExtra("tiempoTotalYoga",cant9);
                            RutinaYoga2.putExtra("tiempoPose",cant10);
                            RutinaYoga2.putExtra("descYoga1",descYoga1);
                            RutinaYoga2.putExtra("descYoga2",descYoga2);
                            RutinaYoga2.putExtra("descYoga3",descYoga3);
                            RutinaYoga2.putExtra("descYoga4",descYoga4);
                            RutinaYoga2.putExtra("descYoga5",descYoga5);
                            RutinaYoga2.putExtra("descYoga6",descYoga6);
                            RutinaYoga2.putExtra("descYoga7",descYoga7);
                            RutinaYoga2.putExtra("descYoga8",descYoga8);

                            RutinaYoga2.putExtra("usuario",usuarios);
                            RutinaYoga2.putExtra("email",correos);
                            RutinaYoga2.putExtra("clave",claves);
                            RutinaYoga2.putExtra("nombre",nombres);
                            //RutinaYoga1.putExtra("tipoYoga1","Hola");
                            startActivity(RutinaYoga2);
                        }

                        else{
                            Toast.makeText(Yoga.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        rutina4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Yoga para flexibilidad principiante");
                            rutina.put("Duracion", "3 a 7 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nYogas").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nYogas").setValue(consecutivo);
                            baseDatos.child("HistorialYoga").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Query checkYoga4 = referencia.orderByChild("nombre").equalTo(nombre4);
                checkYoga4.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            //Toast.makeText(Yoga.this, ":llegue", Toast.LENGTH_SHORT).show();
                            final String cant1,cant2,cant3,cant4,cant5,cant6,cant7,cant8,cant9,cant10;
                            cant1 = dataSnapshot.child(nombre4).child("pose1").getValue(String.class);
                            cant2 = dataSnapshot.child(nombre4).child("pose2").getValue(String.class);
                            cant3 = dataSnapshot.child(nombre4).child("pose3").getValue(String.class);
                            cant4 = dataSnapshot.child(nombre4).child("pose4").getValue(String.class);
                            cant5 = dataSnapshot.child(nombre4).child("pose5").getValue(String.class);
                            cant6 = dataSnapshot.child(nombre4).child("pose6").getValue(String.class);
                            cant7 = dataSnapshot.child(nombre4).child("pose7").getValue(String.class);
                            cant8 = dataSnapshot.child(nombre4).child("pose8").getValue(String.class);
                            cant9 = dataSnapshot.child(nombre4).child("tiempoTotal").getValue(String.class);
                            cant10 = dataSnapshot.child(nombre4).child("tiempoPose").getValue(String.class);
                            //Toast.makeText(Yoga.this, ":"+cant1, Toast.LENGTH_SHORT).show();

                            final String descYoga1,descYoga2,descYoga3,descYoga4,descYoga5,descYoga6,descYoga7,descYoga8;
                            descYoga1 = dataSnapshot.child(nombre4).child("descripcion1").getValue(String.class);
                            descYoga2 = dataSnapshot.child(nombre4).child("descripcion2").getValue(String.class);
                            descYoga3 = dataSnapshot.child(nombre4).child("descripcion3").getValue(String.class);
                            descYoga4 = dataSnapshot.child(nombre4).child("descripcion4").getValue(String.class);
                            descYoga5 = dataSnapshot.child(nombre4).child("descripcion5").getValue(String.class);
                            descYoga6 = dataSnapshot.child(nombre4).child("descripcion6").getValue(String.class);
                            descYoga7 = dataSnapshot.child(nombre4).child("descripcion7").getValue(String.class);
                            descYoga8 = dataSnapshot.child(nombre4).child("descripcion8").getValue(String.class);



                            Intent RutinaYoga2 = new Intent(Yoga.this,RutinasYoga.class);
                            RutinaYoga2.putExtra("yoga1",cant1);
                            RutinaYoga2.putExtra("yoga2",cant2);
                            RutinaYoga2.putExtra("yoga3",cant3);
                            RutinaYoga2.putExtra("yoga4",cant4);
                            RutinaYoga2.putExtra("yoga5",cant5);
                            RutinaYoga2.putExtra("yoga6",cant6);
                            RutinaYoga2.putExtra("yoga7",cant7);
                            RutinaYoga2.putExtra("yoga8",cant8);
                            RutinaYoga2.putExtra("imgYoga1",R.drawable.pose_gato);
                            RutinaYoga2.putExtra("imgYoga2",R.drawable.pose_barco);
                            RutinaYoga2.putExtra("imgYoga3",R.drawable.sentado_giro_curva_lateral_dere);
                            RutinaYoga2.putExtra("imgYoga4",R.drawable.sentado_giro_curva_lateral_izq);
                            RutinaYoga2.putExtra("imgYoga5",R.drawable.supino_giro_izq);
                            RutinaYoga2.putExtra("imgYoga6",R.drawable.supino_giro_derecha);
                            RutinaYoga2.putExtra("imgYoga7",R.drawable.pose_del_rayo);
                            RutinaYoga2.putExtra("imgYoga8",R.drawable.pose_del_muerto);
                            RutinaYoga2.putExtra("yoga10","YOGA PARA FLEXIBILIDAD");
                            RutinaYoga2.putExtra("yoga9",1);
                            RutinaYoga2.putExtra("tiempoTotalYoga",cant9);
                            RutinaYoga2.putExtra("tiempoPose",cant10);
                            RutinaYoga2.putExtra("descYoga1",descYoga1);
                            RutinaYoga2.putExtra("descYoga2",descYoga2);
                            RutinaYoga2.putExtra("descYoga3",descYoga3);
                            RutinaYoga2.putExtra("descYoga4",descYoga4);
                            RutinaYoga2.putExtra("descYoga5",descYoga5);
                            RutinaYoga2.putExtra("descYoga6",descYoga6);
                            RutinaYoga2.putExtra("descYoga7",descYoga7);
                            RutinaYoga2.putExtra("descYoga8",descYoga8);

                            RutinaYoga2.putExtra("usuario",usuarios);
                            RutinaYoga2.putExtra("email",correos);
                            RutinaYoga2.putExtra("clave",claves);
                            RutinaYoga2.putExtra("nombre",nombres);
                            //RutinaYoga1.putExtra("tipoYoga1","Hola");
                            startActivity(RutinaYoga2);
                        }

                        else{
                            Toast.makeText(Yoga.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        rutina5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Yoga para flexibilidad intermedio");
                            rutina.put("Duracion", "6 a 10 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nYogas").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nYogas").setValue(consecutivo);
                            baseDatos.child("HistorialYoga").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Query checkYoga5 = referencia.orderByChild("nombre").equalTo(nombre5);
                checkYoga5.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            //Toast.makeText(Yoga.this, ":llegue", Toast.LENGTH_SHORT).show();
                            final String cant1,cant2,cant3,cant4,cant5,cant6,cant7,cant8,cant9,cant10;
                            cant1 = dataSnapshot.child(nombre5).child("pose1").getValue(String.class);
                            cant2 = dataSnapshot.child(nombre5).child("pose2").getValue(String.class);
                            cant3 = dataSnapshot.child(nombre5).child("pose3").getValue(String.class);
                            cant4 = dataSnapshot.child(nombre5).child("pose4").getValue(String.class);
                            cant5 = dataSnapshot.child(nombre5).child("pose5").getValue(String.class);
                            cant6 = dataSnapshot.child(nombre5).child("pose6").getValue(String.class);
                            cant7 = dataSnapshot.child(nombre5).child("pose7").getValue(String.class);
                            cant8 = dataSnapshot.child(nombre5).child("pose8").getValue(String.class);
                            cant9 = dataSnapshot.child(nombre5).child("tiempoTotal").getValue(String.class);
                            cant10 = dataSnapshot.child(nombre5).child("tiempoPose").getValue(String.class);
                            //Toast.makeText(Yoga.this, ":"+cant1, Toast.LENGTH_SHORT).show();

                            final String descYoga1,descYoga2,descYoga3,descYoga4,descYoga5,descYoga6,descYoga7,descYoga8;
                            descYoga1 = dataSnapshot.child(nombre5).child("descripcion1").getValue(String.class);
                            descYoga2 = dataSnapshot.child(nombre5).child("descripcion2").getValue(String.class);
                            descYoga3 = dataSnapshot.child(nombre5).child("descripcion3").getValue(String.class);
                            descYoga4 = dataSnapshot.child(nombre5).child("descripcion4").getValue(String.class);
                            descYoga5 = dataSnapshot.child(nombre5).child("descripcion5").getValue(String.class);
                            descYoga6 = dataSnapshot.child(nombre5).child("descripcion6").getValue(String.class);
                            descYoga7 = dataSnapshot.child(nombre5).child("descripcion7").getValue(String.class);
                            descYoga8 = dataSnapshot.child(nombre5).child("descripcion8").getValue(String.class);

                            Intent RutinaYoga2 = new Intent(Yoga.this,RutinasYoga.class);
                            RutinaYoga2.putExtra("yoga1",cant1);
                            RutinaYoga2.putExtra("yoga2",cant2);
                            RutinaYoga2.putExtra("yoga3",cant3);
                            RutinaYoga2.putExtra("yoga4",cant4);
                            RutinaYoga2.putExtra("yoga5",cant5);
                            RutinaYoga2.putExtra("yoga6",cant6);
                            RutinaYoga2.putExtra("yoga7",cant7);
                            RutinaYoga2.putExtra("yoga8",cant8);
                            RutinaYoga2.putExtra("imgYoga1",R.drawable.pose_gato);
                            RutinaYoga2.putExtra("imgYoga2",R.drawable.pose_barco);
                            RutinaYoga2.putExtra("imgYoga3",R.drawable.sentado_giro_curva_lateral_dere);
                            RutinaYoga2.putExtra("imgYoga4",R.drawable.sentado_giro_curva_lateral_izq);
                            RutinaYoga2.putExtra("imgYoga5",R.drawable.supino_giro_izq);
                            RutinaYoga2.putExtra("imgYoga6",R.drawable.supino_giro_derecha);
                            RutinaYoga2.putExtra("imgYoga7",R.drawable.pose_del_rayo);
                            RutinaYoga2.putExtra("imgYoga8",R.drawable.pose_del_muerto);
                            RutinaYoga2.putExtra("yoga10","YOGA PARA FLEXIBILIDAD");
                            RutinaYoga2.putExtra("yoga9",2);
                            RutinaYoga2.putExtra("tiempoTotalYoga",cant9);
                            RutinaYoga2.putExtra("tiempoPose",cant10);
                            RutinaYoga2.putExtra("descYoga1",descYoga1);
                            RutinaYoga2.putExtra("descYoga2",descYoga2);
                            RutinaYoga2.putExtra("descYoga3",descYoga3);
                            RutinaYoga2.putExtra("descYoga4",descYoga4);
                            RutinaYoga2.putExtra("descYoga5",descYoga5);
                            RutinaYoga2.putExtra("descYoga6",descYoga6);
                            RutinaYoga2.putExtra("descYoga7",descYoga7);
                            RutinaYoga2.putExtra("descYoga8",descYoga8);

                            RutinaYoga2.putExtra("usuario",usuarios);
                            RutinaYoga2.putExtra("email",correos);
                            RutinaYoga2.putExtra("clave",claves);
                            RutinaYoga2.putExtra("nombre",nombres);
                            //RutinaYoga1.putExtra("tipoYoga1","Hola");
                            startActivity(RutinaYoga2);
                        }

                        else{
                            Toast.makeText(Yoga.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        rutina6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Yoga para flexibilidad avanzado");
                            rutina.put("Duracion", "8 a 12 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nYogas").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nYogas").setValue(consecutivo);
                            baseDatos.child("HistorialYoga").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Query checkYoga6 = referencia.orderByChild("nombre").equalTo(nombre6);
                checkYoga6.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            //Toast.makeText(Yoga.this, ":llegue", Toast.LENGTH_SHORT).show();
                            final String cant1,cant2,cant3,cant4,cant5,cant6,cant7,cant8,cant9,cant10;
                            cant1 = dataSnapshot.child(nombre6).child("pose1").getValue(String.class);
                            cant2 = dataSnapshot.child(nombre6).child("pose2").getValue(String.class);
                            cant3 = dataSnapshot.child(nombre6).child("pose3").getValue(String.class);
                            cant4 = dataSnapshot.child(nombre6).child("pose4").getValue(String.class);
                            cant5 = dataSnapshot.child(nombre6).child("pose5").getValue(String.class);
                            cant6 = dataSnapshot.child(nombre6).child("pose6").getValue(String.class);
                            cant7 = dataSnapshot.child(nombre6).child("pose7").getValue(String.class);
                            cant8 = dataSnapshot.child(nombre6).child("pose8").getValue(String.class);
                            cant9 = dataSnapshot.child(nombre6).child("tiempoTotal").getValue(String.class);
                            cant10 = dataSnapshot.child(nombre6).child("tiempoPose").getValue(String.class);
                            //Toast.makeText(Yoga.this, ":"+cant1, Toast.LENGTH_SHORT).show();

                            final String descYoga1,descYoga2,descYoga3,descYoga4,descYoga5,descYoga6,descYoga7,descYoga8;
                            descYoga1 = dataSnapshot.child(nombre6).child("descripcion1").getValue(String.class);
                            descYoga2 = dataSnapshot.child(nombre6).child("descripcion2").getValue(String.class);
                            descYoga3 = dataSnapshot.child(nombre6).child("descripcion3").getValue(String.class);
                            descYoga4 = dataSnapshot.child(nombre6).child("descripcion4").getValue(String.class);
                            descYoga5 = dataSnapshot.child(nombre6).child("descripcion5").getValue(String.class);
                            descYoga6 = dataSnapshot.child(nombre6).child("descripcion6").getValue(String.class);
                            descYoga7 = dataSnapshot.child(nombre6).child("descripcion7").getValue(String.class);
                            descYoga8 = dataSnapshot.child(nombre6).child("descripcion8").getValue(String.class);



                            Intent RutinaYoga2 = new Intent(Yoga.this,RutinasYoga.class);
                            RutinaYoga2.putExtra("yoga1",cant1);
                            RutinaYoga2.putExtra("yoga2",cant2);
                            RutinaYoga2.putExtra("yoga3",cant3);
                            RutinaYoga2.putExtra("yoga4",cant4);
                            RutinaYoga2.putExtra("yoga5",cant5);
                            RutinaYoga2.putExtra("yoga6",cant6);
                            RutinaYoga2.putExtra("yoga7",cant7);
                            RutinaYoga2.putExtra("yoga8",cant8);
                            RutinaYoga2.putExtra("imgYoga1",R.drawable.giro_superior_cuerpo);
                            RutinaYoga2.putExtra("imgYoga2",R.drawable.de_pie_doblando_lateralmente);
                            RutinaYoga2.putExtra("imgYoga3",R.drawable.guerrero_dinamico_dere);
                            RutinaYoga2.putExtra("imgYoga4",R.drawable.guerrero_dinamico_izq);
                            RutinaYoga2.putExtra("imgYoga5",R.drawable.plancha_pose_delfin);
                            RutinaYoga2.putExtra("imgYoga6",R.drawable.pose_saltamontes);
                            RutinaYoga2.putExtra("imgYoga7",R.drawable.pose_diosa_reclinada);
                            RutinaYoga2.putExtra("imgYoga8",R.drawable.pose_del_muerto);
                            RutinaYoga2.putExtra("yoga10","YOGA PARA FLEXIBILIDAD");
                            RutinaYoga2.putExtra("yoga9",3);
                            //RutinaYoga1.putExtra("tipoYoga1","Hola");
                            RutinaYoga2.putExtra("tiempoTotalYoga",cant9);
                            RutinaYoga2.putExtra("tiempoPose",cant10);
                            RutinaYoga2.putExtra("descYoga1",descYoga1);
                            RutinaYoga2.putExtra("descYoga2",descYoga2);
                            RutinaYoga2.putExtra("descYoga3",descYoga3);
                            RutinaYoga2.putExtra("descYoga4",descYoga4);
                            RutinaYoga2.putExtra("descYoga5",descYoga5);
                            RutinaYoga2.putExtra("descYoga6",descYoga6);
                            RutinaYoga2.putExtra("descYoga7",descYoga7);
                            RutinaYoga2.putExtra("descYoga8",descYoga8);

                            RutinaYoga2.putExtra("usuario",usuarios);
                            RutinaYoga2.putExtra("email",correos);
                            RutinaYoga2.putExtra("clave",claves);
                            RutinaYoga2.putExtra("nombre",nombres);
                            startActivity(RutinaYoga2);
                        }

                        else{
                            Toast.makeText(Yoga.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        rutina7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Yoga para tonificarse principiante");
                            rutina.put("Duracion", "3 a 7 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nYogas").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nYogas").setValue(consecutivo);
                            baseDatos.child("HistorialYoga").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Query checkYoga7 = referencia.orderByChild("nombre").equalTo(nombre7);
                checkYoga7.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            //Toast.makeText(Yoga.this, ":llegue", Toast.LENGTH_SHORT).show();
                            final String cant1,cant2,cant3,cant4,cant5,cant6,cant7,cant8,cant9,cant10;
                            cant1 = dataSnapshot.child(nombre7).child("pose1").getValue(String.class);
                            cant2 = dataSnapshot.child(nombre7).child("pose2").getValue(String.class);
                            cant3 = dataSnapshot.child(nombre7).child("pose3").getValue(String.class);
                            cant4 = dataSnapshot.child(nombre7).child("pose4").getValue(String.class);
                            cant5 = dataSnapshot.child(nombre7).child("pose5").getValue(String.class);
                            cant6 = dataSnapshot.child(nombre7).child("pose6").getValue(String.class);
                            cant7 = dataSnapshot.child(nombre7).child("pose7").getValue(String.class);
                            cant8 = dataSnapshot.child(nombre7).child("pose8").getValue(String.class);
                            cant9 = dataSnapshot.child(nombre7).child("tiempoTotal").getValue(String.class);
                            cant10 = dataSnapshot.child(nombre7).child("tiempoPose").getValue(String.class);
                            //Toast.makeText(Yoga.this, ":"+cant1, Toast.LENGTH_SHORT).show();

                            final String descYoga1,descYoga2,descYoga3,descYoga4,descYoga5,descYoga6,descYoga7,descYoga8;
                            descYoga1 = dataSnapshot.child(nombre7).child("descripcion1").getValue(String.class);
                            descYoga2 = dataSnapshot.child(nombre7).child("descripcion2").getValue(String.class);
                            descYoga3 = dataSnapshot.child(nombre7).child("descripcion3").getValue(String.class);
                            descYoga4 = dataSnapshot.child(nombre7).child("descripcion4").getValue(String.class);
                            descYoga5 = dataSnapshot.child(nombre7).child("descripcion5").getValue(String.class);
                            descYoga6 = dataSnapshot.child(nombre7).child("descripcion6").getValue(String.class);
                            descYoga7 = dataSnapshot.child(nombre7).child("descripcion7").getValue(String.class);
                            descYoga8 = dataSnapshot.child(nombre7).child("descripcion8").getValue(String.class);

                            Intent RutinaYoga2 = new Intent(Yoga.this,RutinasYoga.class);
                            RutinaYoga2.putExtra("yoga1",cant1);
                            RutinaYoga2.putExtra("yoga2",cant2);
                            RutinaYoga2.putExtra("yoga3",cant3);
                            RutinaYoga2.putExtra("yoga4",cant4);
                            RutinaYoga2.putExtra("yoga5",cant5);
                            RutinaYoga2.putExtra("yoga6",cant6);
                            RutinaYoga2.putExtra("yoga7",cant7);
                            RutinaYoga2.putExtra("yoga8",cant8);
                            RutinaYoga2.putExtra("imgYoga1",R.drawable.giro_espinal_piernas_cruzada);
                            RutinaYoga2.putExtra("imgYoga2",R.drawable.giro_espinal_pierna_cruzada_dere);
                            RutinaYoga2.putExtra("imgYoga3",R.drawable.sentado_apertura_pecho);
                            RutinaYoga2.putExtra("imgYoga4",R.drawable.estiramiento_pierna_dere);
                            RutinaYoga2.putExtra("imgYoga5",R.drawable.estiramiento_pierna_izq);
                            RutinaYoga2.putExtra("imgYoga6",R.drawable.rey_medio_pecesizq);
                            RutinaYoga2.putExtra("imgYoga7",R.drawable.rey_medio_peces);
                            RutinaYoga2.putExtra("imgYoga8",R.drawable.ninio_brazos_extend);
                            RutinaYoga2.putExtra("yoga10","YOGA PARA TONIFICARSE");
                            RutinaYoga2.putExtra("yoga9",1);
                            RutinaYoga2.putExtra("tiempoTotalYoga",cant9);
                            RutinaYoga2.putExtra("tiempoPose",cant10);
                            RutinaYoga2.putExtra("descYoga1",descYoga1);
                            RutinaYoga2.putExtra("descYoga2",descYoga2);
                            RutinaYoga2.putExtra("descYoga3",descYoga3);
                            RutinaYoga2.putExtra("descYoga4",descYoga4);
                            RutinaYoga2.putExtra("descYoga5",descYoga5);
                            RutinaYoga2.putExtra("descYoga6",descYoga6);
                            RutinaYoga2.putExtra("descYoga7",descYoga7);
                            RutinaYoga2.putExtra("descYoga8",descYoga8);

                            RutinaYoga2.putExtra("usuario",usuarios);
                            RutinaYoga2.putExtra("email",correos);
                            RutinaYoga2.putExtra("clave",claves);
                            RutinaYoga2.putExtra("nombre",nombres);
                            //RutinaYoga1.putExtra("tipoYoga1","Hola");
                            startActivity(RutinaYoga2);
                        }

                        else{
                            Toast.makeText(Yoga.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        rutina8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Yoga para tonificarse intermedio");
                            rutina.put("Duracion", "6 a 10 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nYogas").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nYogas").setValue(consecutivo);
                            baseDatos.child("HistorialYoga").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Query checkYoga8 = referencia.orderByChild("nombre").equalTo(nombre8);
                checkYoga8.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            //Toast.makeText(Yoga.this, ":llegue", Toast.LENGTH_SHORT).show();
                            final String cant1,cant2,cant3,cant4,cant5,cant6,cant7,cant8,cant9,cant10;
                            cant1 = dataSnapshot.child(nombre8).child("pose1").getValue(String.class);
                            cant2 = dataSnapshot.child(nombre8).child("pose2").getValue(String.class);
                            cant3 = dataSnapshot.child(nombre8).child("pose3").getValue(String.class);
                            cant4 = dataSnapshot.child(nombre8).child("pose4").getValue(String.class);
                            cant5 = dataSnapshot.child(nombre8).child("pose5").getValue(String.class);
                            cant6 = dataSnapshot.child(nombre8).child("pose6").getValue(String.class);
                            cant7 = dataSnapshot.child(nombre8).child("pose7").getValue(String.class);
                            cant8 = dataSnapshot.child(nombre8).child("pose8").getValue(String.class);
                            cant9 = dataSnapshot.child(nombre8).child("tiempoTotal").getValue(String.class);
                            cant10 = dataSnapshot.child(nombre8).child("tiempoPose").getValue(String.class);
                            //Toast.makeText(Yoga.this, ":"+cant1, Toast.LENGTH_SHORT).show();

                            final String descYoga1,descYoga2,descYoga3,descYoga4,descYoga5,descYoga6,descYoga7,descYoga8;
                            descYoga1 = dataSnapshot.child(nombre8).child("descripcion1").getValue(String.class);
                            descYoga2 = dataSnapshot.child(nombre8).child("descripcion2").getValue(String.class);
                            descYoga3 = dataSnapshot.child(nombre8).child("descripcion3").getValue(String.class);
                            descYoga4 = dataSnapshot.child(nombre8).child("descripcion4").getValue(String.class);
                            descYoga5 = dataSnapshot.child(nombre8).child("descripcion5").getValue(String.class);
                            descYoga6 = dataSnapshot.child(nombre8).child("descripcion6").getValue(String.class);
                            descYoga7 = dataSnapshot.child(nombre8).child("descripcion7").getValue(String.class);
                            descYoga8 = dataSnapshot.child(nombre8).child("descripcion8").getValue(String.class);



                            Intent RutinaYoga2 = new Intent(Yoga.this,RutinasYoga.class);
                            RutinaYoga2.putExtra("yoga1",cant1);
                            RutinaYoga2.putExtra("yoga2",cant2);
                            RutinaYoga2.putExtra("yoga3",cant3);
                            RutinaYoga2.putExtra("yoga4",cant4);
                            RutinaYoga2.putExtra("yoga5",cant5);
                            RutinaYoga2.putExtra("yoga6",cant6);
                            RutinaYoga2.putExtra("yoga7",cant7);
                            RutinaYoga2.putExtra("yoga8",cant8);

                            RutinaYoga2.putExtra("imgYoga1",R.drawable.pose_diosa_reclinada);
                            RutinaYoga2.putExtra("imgYoga2",R.drawable.pose_saltamontes);
                            RutinaYoga2.putExtra("imgYoga3",R.drawable.pose_gato);
                            RutinaYoga2.putExtra("imgYoga4",R.drawable.pose_barco);
                            RutinaYoga2.putExtra("imgYoga5",R.drawable.pose_del_rayo);
                            RutinaYoga2.putExtra("imgYoga6",R.drawable.postura_silla);
                            RutinaYoga2.putExtra("imgYoga7",R.drawable.de_pie_flexion_abajo);
                            RutinaYoga2.putExtra("imgYoga8",R.drawable.pose_montania);

                            RutinaYoga2.putExtra("yoga10","YOGA PARA TONIFICARSE");
                            RutinaYoga2.putExtra("yoga9",2);

                            RutinaYoga2.putExtra("tiempoTotalYoga",cant9);
                            RutinaYoga2.putExtra("tiempoPose",cant10);
                            RutinaYoga2.putExtra("descYoga1",descYoga1);
                            RutinaYoga2.putExtra("descYoga2",descYoga2);
                            RutinaYoga2.putExtra("descYoga3",descYoga3);
                            RutinaYoga2.putExtra("descYoga4",descYoga4);
                            RutinaYoga2.putExtra("descYoga5",descYoga5);
                            RutinaYoga2.putExtra("descYoga6",descYoga6);
                            RutinaYoga2.putExtra("descYoga7",descYoga7);
                            RutinaYoga2.putExtra("descYoga8",descYoga8);

                            RutinaYoga2.putExtra("usuario",usuarios);
                            RutinaYoga2.putExtra("email",correos);
                            RutinaYoga2.putExtra("clave",claves);
                            RutinaYoga2.putExtra("nombre",nombres);
                            startActivity(RutinaYoga2);
                        }

                        else{
                            Toast.makeText(Yoga.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        rutina9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Yoga para tonificarse avanzado");
                            rutina.put("Duracion", "8 a 12 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nYogas").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nYogas").setValue(consecutivo);
                            baseDatos.child("HistorialYoga").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Query checkYoga9 = referencia.orderByChild("nombre").equalTo(nombre9);
                checkYoga9.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            //Toast.makeText(Yoga.this, ":llegue", Toast.LENGTH_SHORT).show();
                            final String cant1,cant2,cant3,cant4,cant5,cant6,cant7,cant8,cant9,cant10;
                            cant1 = dataSnapshot.child(nombre9).child("pose1").getValue(String.class);
                            cant2 = dataSnapshot.child(nombre9).child("pose2").getValue(String.class);
                            cant3 = dataSnapshot.child(nombre9).child("pose3").getValue(String.class);
                            cant4 = dataSnapshot.child(nombre9).child("pose4").getValue(String.class);
                            cant5 = dataSnapshot.child(nombre9).child("pose5").getValue(String.class);
                            cant6 = dataSnapshot.child(nombre9).child("pose6").getValue(String.class);
                            cant7 = dataSnapshot.child(nombre9).child("pose7").getValue(String.class);
                            cant8 = dataSnapshot.child(nombre9).child("pose8").getValue(String.class);
                            cant9 = dataSnapshot.child(nombre9).child("tiempoTotal").getValue(String.class);
                            cant10 = dataSnapshot.child(nombre9).child("tiempoPose").getValue(String.class);
                            //Toast.makeText(Yoga.this, ":"+cant1, Toast.LENGTH_SHORT).show();

                            final String descYoga1,descYoga2,descYoga3,descYoga4,descYoga5,descYoga6,descYoga7,descYoga8;
                            descYoga1 = dataSnapshot.child(nombre9).child("descripcion1").getValue(String.class);
                            descYoga2 = dataSnapshot.child(nombre9).child("descripcion2").getValue(String.class);
                            descYoga3 = dataSnapshot.child(nombre9).child("descripcion3").getValue(String.class);
                            descYoga4 = dataSnapshot.child(nombre9).child("descripcion4").getValue(String.class);
                            descYoga5 = dataSnapshot.child(nombre9).child("descripcion5").getValue(String.class);
                            descYoga6 = dataSnapshot.child(nombre9).child("descripcion6").getValue(String.class);
                            descYoga7 = dataSnapshot.child(nombre9).child("descripcion7").getValue(String.class);
                            descYoga8 = dataSnapshot.child(nombre9).child("descripcion8").getValue(String.class);

                            Intent RutinaYoga2 = new Intent(Yoga.this,RutinasYoga.class);
                            RutinaYoga2.putExtra("yoga1",cant1);
                            RutinaYoga2.putExtra("yoga2",cant2);
                            RutinaYoga2.putExtra("yoga3",cant3);
                            RutinaYoga2.putExtra("yoga4",cant4);
                            RutinaYoga2.putExtra("yoga5",cant5);
                            RutinaYoga2.putExtra("yoga6",cant6);
                            RutinaYoga2.putExtra("yoga7",cant7);
                            RutinaYoga2.putExtra("yoga8",cant8);
                            RutinaYoga2.putExtra("imgYoga1",R.drawable.pose_gato);
                            RutinaYoga2.putExtra("imgYoga2",R.drawable.pose_barco);
                            RutinaYoga2.putExtra("imgYoga3",R.drawable.sentado_giro_curva_lateral_dere);
                            RutinaYoga2.putExtra("imgYoga4",R.drawable.sentado_giro_curva_lateral_izq);
                            RutinaYoga2.putExtra("imgYoga5",R.drawable.supino_giro_izq);
                            RutinaYoga2.putExtra("imgYoga6",R.drawable.supino_giro_derecha);
                            RutinaYoga2.putExtra("imgYoga7",R.drawable.pose_del_rayo);
                            RutinaYoga2.putExtra("imgYoga8",R.drawable.pose_del_muerto);
                            RutinaYoga2.putExtra("yoga10","YOGA PARA TONIFICARSE");
                            RutinaYoga2.putExtra("yoga9",3);
                            //RutinaYoga1.putExtra("tipoYoga1","Hola");
                            RutinaYoga2.putExtra("tiempoTotalYoga",cant9);
                            RutinaYoga2.putExtra("tiempoPose",cant10);
                            RutinaYoga2.putExtra("descYoga1",descYoga1);
                            RutinaYoga2.putExtra("descYoga2",descYoga2);
                            RutinaYoga2.putExtra("descYoga3",descYoga3);
                            RutinaYoga2.putExtra("descYoga4",descYoga4);
                            RutinaYoga2.putExtra("descYoga5",descYoga5);
                            RutinaYoga2.putExtra("descYoga6",descYoga6);
                            RutinaYoga2.putExtra("descYoga7",descYoga7);
                            RutinaYoga2.putExtra("descYoga8",descYoga8);

                            RutinaYoga2.putExtra("usuario",usuarios);
                            RutinaYoga2.putExtra("email",correos);
                            RutinaYoga2.putExtra("clave",claves);
                            RutinaYoga2.putExtra("nombre",nombres);
                            startActivity(RutinaYoga2);
                        }

                        else{
                            Toast.makeText(Yoga.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        rutina12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Yoga para espalda avanzado");
                            rutina.put("Duracion", "8 a 12 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nYogas").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nYogas").setValue(consecutivo);
                            baseDatos.child("HistorialYoga").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Query checkYoga = referencia.orderByChild("nombre").equalTo(nombre12);
                checkYoga.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            //Toast.makeText(Yoga.this, ":llegue", Toast.LENGTH_SHORT).show();
                            final String cant1,cant2,cant3,cant4,cant5,cant6,cant7,cant8,cant9,cant10;
                            cant1 = dataSnapshot.child(nombre12).child("pose1").getValue(String.class);
                            cant2 = dataSnapshot.child(nombre12).child("pose2").getValue(String.class);
                            cant3 = dataSnapshot.child(nombre12).child("pose3").getValue(String.class);
                            cant4 = dataSnapshot.child(nombre12).child("pose4").getValue(String.class);
                            cant5 = dataSnapshot.child(nombre12).child("pose5").getValue(String.class);
                            cant6 = dataSnapshot.child(nombre12).child("pose6").getValue(String.class);
                            cant7 = dataSnapshot.child(nombre12).child("pose7").getValue(String.class);
                            cant8 = dataSnapshot.child(nombre12).child("pose8").getValue(String.class);
                            cant9 = dataSnapshot.child(nombre12).child("tiempoTotal").getValue(String.class);
                            cant10 = dataSnapshot.child(nombre12).child("tiempoPose").getValue(String.class);

                            final String descYoga1,descYoga2,descYoga3,descYoga4,descYoga5,descYoga6,descYoga7,descYoga8;
                            descYoga1 = dataSnapshot.child(nombre12).child("descripcion1").getValue(String.class);
                            descYoga2 = dataSnapshot.child(nombre12).child("descripcion2").getValue(String.class);
                            descYoga3 = dataSnapshot.child(nombre12).child("descripcion3").getValue(String.class);
                            descYoga4 = dataSnapshot.child(nombre12).child("descripcion4").getValue(String.class);
                            descYoga5 = dataSnapshot.child(nombre12).child("descripcion5").getValue(String.class);
                            descYoga6 = dataSnapshot.child(nombre12).child("descripcion6").getValue(String.class);
                            descYoga7 = dataSnapshot.child(nombre12).child("descripcion7").getValue(String.class);
                            descYoga8 = dataSnapshot.child(nombre12).child("descripcion8").getValue(String.class);


                            Intent RutinaYoga1 = new Intent(Yoga.this,RutinasYoga.class);
                            RutinaYoga1.putExtra("yoga1",cant1);
                            RutinaYoga1.putExtra("imgYoga1",R.drawable.pose_elevada_dinamica);
                            RutinaYoga1.putExtra("imgYoga3",R.drawable.elevacion_estirando_hombros);
                            RutinaYoga1.putExtra("imgYoga2",R.drawable.elevacion_subiendo_talones);
                            RutinaYoga1.putExtra("imgYoga4",R.drawable.estiramiento_de_cuello);
                            RutinaYoga1.putExtra("imgYoga5",R.drawable.sentadilla_pose_silla);
                            RutinaYoga1.putExtra("imgYoga6",R.drawable.pose_gato);
                            RutinaYoga1.putExtra("imgYoga7",R.drawable.circulos_pose_silla);
                            RutinaYoga1.putExtra("imgYoga8",R.drawable.pose_del_muerto);
                            RutinaYoga1.putExtra("yoga2",cant2);
                            RutinaYoga1.putExtra("yoga3",cant3);
                            RutinaYoga1.putExtra("yoga4",cant4);
                            RutinaYoga1.putExtra("yoga5",cant5);
                            RutinaYoga1.putExtra("yoga6",cant6);
                            RutinaYoga1.putExtra("yoga7",cant7);
                            RutinaYoga1.putExtra("yoga8",cant8);
                            RutinaYoga1.putExtra("yoga10","YOGA PARA ESPALDA");
                            RutinaYoga1.putExtra("yoga9",3);
                            RutinaYoga1.putExtra("tiempoTotalYoga",cant9);
                            RutinaYoga1.putExtra("tiempoPose",cant10);
                            RutinaYoga1.putExtra("descYoga1",descYoga1);
                            RutinaYoga1.putExtra("descYoga2",descYoga2);
                            RutinaYoga1.putExtra("descYoga3",descYoga3);
                            RutinaYoga1.putExtra("descYoga4",descYoga4);
                            RutinaYoga1.putExtra("descYoga5",descYoga5);
                            RutinaYoga1.putExtra("descYoga6",descYoga6);
                            RutinaYoga1.putExtra("descYoga7",descYoga7);
                            RutinaYoga1.putExtra("descYoga8",descYoga8);

                            RutinaYoga1.putExtra("usuario",usuarios);
                            RutinaYoga1.putExtra("email",correos);
                            RutinaYoga1.putExtra("clave",claves);
                            RutinaYoga1.putExtra("nombre",nombres);
                            //RutinaYoga1.putExtra("tipoYoga1","Hola");
                            startActivity(RutinaYoga1);
                        }

                        else{
                            Toast.makeText(Yoga.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });


        rutina10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Yoga para espalda principiante");
                            rutina.put("Duracion", "3 a 7 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nYogas").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nYogas").setValue(consecutivo);
                            baseDatos.child("HistorialYoga").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);
                Query checkYoga5 = referencia.orderByChild("nombre").equalTo(nombre10);
                checkYoga5.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            //Toast.makeText(Yoga.this, ":llegue", Toast.LENGTH_SHORT).show();
                            final String cant1,cant2,cant3,cant4,cant5,cant6,cant7,cant8,cant9,cant10;
                            cant1 = dataSnapshot.child(nombre10).child("pose1").getValue(String.class);
                            cant2 = dataSnapshot.child(nombre10).child("pose2").getValue(String.class);
                            cant3 = dataSnapshot.child(nombre10).child("pose3").getValue(String.class);
                            cant4 = dataSnapshot.child(nombre10).child("pose4").getValue(String.class);
                            cant5 = dataSnapshot.child(nombre10).child("pose5").getValue(String.class);
                            cant6 = dataSnapshot.child(nombre10).child("pose6").getValue(String.class);
                            cant7 = dataSnapshot.child(nombre10).child("pose7").getValue(String.class);
                            cant8 = dataSnapshot.child(nombre10).child("pose8").getValue(String.class);
                            cant9 = dataSnapshot.child(nombre10).child("tiempoTotal").getValue(String.class);
                            cant10 = dataSnapshot.child(nombre10).child("tiempoPose").getValue(String.class);
                            //Toast.makeText(Yoga.this, ":"+cant1, Toast.LENGTH_SHORT).show();

                            final String descYoga1,descYoga2,descYoga3,descYoga4,descYoga5,descYoga6,descYoga7,descYoga8;
                            descYoga1 = dataSnapshot.child(nombre10).child("descripcion1").getValue(String.class);
                            descYoga2 = dataSnapshot.child(nombre10).child("descripcion2").getValue(String.class);
                            descYoga3 = dataSnapshot.child(nombre10).child("descripcion3").getValue(String.class);
                            descYoga4 = dataSnapshot.child(nombre10).child("descripcion4").getValue(String.class);
                            descYoga5 = dataSnapshot.child(nombre10).child("descripcion5").getValue(String.class);
                            descYoga6 = dataSnapshot.child(nombre10).child("descripcion6").getValue(String.class);
                            descYoga7 = dataSnapshot.child(nombre10).child("descripcion7").getValue(String.class);
                            descYoga8 = dataSnapshot.child(nombre10).child("descripcion8").getValue(String.class);

                            Intent RutinaYoga2 = new Intent(Yoga.this,RutinasYoga.class);
                            RutinaYoga2.putExtra("yoga1",cant1);
                            RutinaYoga2.putExtra("yoga2",cant2);
                            RutinaYoga2.putExtra("yoga3",cant3);
                            RutinaYoga2.putExtra("yoga4",cant4);
                            RutinaYoga2.putExtra("yoga5",cant5);
                            RutinaYoga2.putExtra("yoga6",cant6);
                            RutinaYoga2.putExtra("yoga7",cant7);
                            RutinaYoga2.putExtra("yoga8",cant8);
                            RutinaYoga2.putExtra("imgYoga1",R.drawable.pose_gato);
                            RutinaYoga2.putExtra("imgYoga2",R.drawable.pose_barco);
                            RutinaYoga2.putExtra("imgYoga3",R.drawable.sentado_giro_curva_lateral_dere);
                            RutinaYoga2.putExtra("imgYoga4",R.drawable.sentado_giro_curva_lateral_izq);
                            RutinaYoga2.putExtra("imgYoga5",R.drawable.supino_giro_izq);
                            RutinaYoga2.putExtra("imgYoga6",R.drawable.supino_giro_derecha);
                            RutinaYoga2.putExtra("imgYoga7",R.drawable.pose_del_rayo);
                            RutinaYoga2.putExtra("imgYoga8",R.drawable.pose_del_muerto);
                            RutinaYoga2.putExtra("yoga10","YOGA PARA ESPALDA");
                            RutinaYoga2.putExtra("yoga9",1);
                            RutinaYoga2.putExtra("tiempoTotalYoga",cant9);
                            RutinaYoga2.putExtra("tiempoPose",cant10);
                            RutinaYoga2.putExtra("descYoga1",descYoga1);
                            RutinaYoga2.putExtra("descYoga2",descYoga2);
                            RutinaYoga2.putExtra("descYoga3",descYoga3);
                            RutinaYoga2.putExtra("descYoga4",descYoga4);
                            RutinaYoga2.putExtra("descYoga5",descYoga5);
                            RutinaYoga2.putExtra("descYoga6",descYoga6);
                            RutinaYoga2.putExtra("descYoga7",descYoga7);
                            RutinaYoga2.putExtra("descYoga8",descYoga8);

                            RutinaYoga2.putExtra("usuario",usuarios);
                            RutinaYoga2.putExtra("email",correos);
                            RutinaYoga2.putExtra("clave",claves);
                            RutinaYoga2.putExtra("nombre",nombres);
                            //RutinaYoga1.putExtra("tipoYoga1","Hola");
                            startActivity(RutinaYoga2);
                        }

                        else{
                            Toast.makeText(Yoga.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        rutina11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDatos.child("Usuarios").addValueEventListener(new ValueEventListener() {
                    Map<String,Object> rutina = new HashMap<String,Object>();
                    Date fecha = new Date();
                    int flag = 0;
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        if(flag == 0)
                        {
                            rutina.put("Nombre yoga", "Yoga para espalda intermedio");
                            rutina.put("Duracion", "6 a 10 minutos");
                            rutina.put("Fecha de realización", fecha.toString());
                            //se obtiene el numeral de hijos que tiene
                            //i+=1;
                            int consecutivo = 0;
                            consecutivo =  Integer.parseInt(datasnapshot.child(usuarios).child("nYogas").getValue().toString());
                            consecutivo += 1;
                            flag++;
                            baseDatos.child("Usuarios").child(usuarios).child("nYogas").setValue(consecutivo);
                            baseDatos.child("HistorialYoga").child(usuarios).child(String.valueOf(consecutivo)).updateChildren(rutina);
                        }
                        //baseDatos.child("HistorialWorkouts").child(usuarios).child(String.valueOf(i)).updateChildren(rutina);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                progressBar.setVisibility(View.VISIBLE);

                Query checkYoga2 = referencia.orderByChild("nombre").equalTo(nombre11);
                checkYoga2.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            //Toast.makeText(Yoga.this, ":llegue", Toast.LENGTH_SHORT).show();
                            final String cant1,cant2,cant3,cant4,cant5,cant6,cant7,cant8,cant9,cant10;
                            cant1 = dataSnapshot.child(nombre11).child("pose1").getValue(String.class);
                            cant2 = dataSnapshot.child(nombre11).child("pose2").getValue(String.class);
                            cant3 = dataSnapshot.child(nombre11).child("pose3").getValue(String.class);
                            cant4 = dataSnapshot.child(nombre11).child("pose4").getValue(String.class);
                            cant5 = dataSnapshot.child(nombre11).child("pose5").getValue(String.class);
                            cant6 = dataSnapshot.child(nombre11).child("pose6").getValue(String.class);
                            cant7 = dataSnapshot.child(nombre11).child("pose7").getValue(String.class);
                            cant8 = dataSnapshot.child(nombre11).child("pose8").getValue(String.class);
                            cant9 = dataSnapshot.child(nombre11).child("tiempoTotal").getValue(String.class);
                            cant10 = dataSnapshot.child(nombre11).child("tiempoPose").getValue(String.class);
                            //Toast.makeText(Yoga.this, ":"+cant1, Toast.LENGTH_SHORT).show();

                            final String descYoga1,descYoga2,descYoga3,descYoga4,descYoga5,descYoga6,descYoga7,descYoga8;
                            descYoga1 = dataSnapshot.child(nombre11).child("descripcion1").getValue(String.class);
                            descYoga2 = dataSnapshot.child(nombre11).child("descripcion2").getValue(String.class);
                            descYoga3 = dataSnapshot.child(nombre11).child("descripcion3").getValue(String.class);
                            descYoga4 = dataSnapshot.child(nombre11).child("descripcion4").getValue(String.class);
                            descYoga5 = dataSnapshot.child(nombre11).child("descripcion5").getValue(String.class);
                            descYoga6 = dataSnapshot.child(nombre11).child("descripcion6").getValue(String.class);
                            descYoga7 = dataSnapshot.child(nombre11).child("descripcion7").getValue(String.class);
                            descYoga8 = dataSnapshot.child(nombre11).child("descripcion8").getValue(String.class);



                            Intent RutinaYoga2 = new Intent(Yoga.this,RutinasYoga.class);
                            RutinaYoga2.putExtra("yoga1",cant1);
                            RutinaYoga2.putExtra("yoga2",cant2);
                            RutinaYoga2.putExtra("yoga3",cant3);
                            RutinaYoga2.putExtra("yoga4",cant4);
                            RutinaYoga2.putExtra("yoga5",cant5);
                            RutinaYoga2.putExtra("yoga6",cant6);
                            RutinaYoga2.putExtra("yoga7",cant7);
                            RutinaYoga2.putExtra("yoga8",cant8);
                            RutinaYoga2.putExtra("imgYoga1",R.drawable.de_pie_doblando_al_lado_derecho);
                            RutinaYoga2.putExtra("imgYoga2",R.drawable.de_pie_doblando_izquierdo);
                            RutinaYoga2.putExtra("imgYoga3",R.drawable.pose_barco);
                            RutinaYoga2.putExtra("imgYoga4",R.drawable.pose_del_tigre_derecha);
                            RutinaYoga2.putExtra("imgYoga5",R.drawable.pose_tigre_izq);
                            RutinaYoga2.putExtra("imgYoga6",R.drawable.pose_saltamontes);
                            RutinaYoga2.putExtra("imgYoga7",R.drawable.pose_del_rayo);
                            RutinaYoga2.putExtra("imgYoga8",R.drawable.pose_del_muerto);
                            RutinaYoga2.putExtra("yoga10","YOGA PARA ESPALDA");
                            RutinaYoga2.putExtra("yoga9",2);
                            RutinaYoga2.putExtra("tiempoTotalYoga",cant9);
                            RutinaYoga2.putExtra("tiempoPose",cant10);
                            //RutinaYoga1.putExtra("tipoYoga1","Hola");
                            RutinaYoga2.putExtra("descYoga1",descYoga1);
                            RutinaYoga2.putExtra("descYoga2",descYoga2);
                            RutinaYoga2.putExtra("descYoga3",descYoga3);
                            RutinaYoga2.putExtra("descYoga4",descYoga4);
                            RutinaYoga2.putExtra("descYoga5",descYoga5);
                            RutinaYoga2.putExtra("descYoga6",descYoga6);
                            RutinaYoga2.putExtra("descYoga7",descYoga7);
                            RutinaYoga2.putExtra("descYoga8",descYoga8);

                            RutinaYoga2.putExtra("usuario",usuarios);
                            RutinaYoga2.putExtra("email",correos);
                            RutinaYoga2.putExtra("clave",claves);
                            RutinaYoga2.putExtra("nombre",nombres);
                            startActivity(RutinaYoga2);
                        }

                        else{
                            Toast.makeText(Yoga.this,"Se ha producido un error...",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        progressBar.setVisibility(View.GONE);
    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_yoga);
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
                Intent si = new Intent(Yoga.this,Perfil.class);
                si.putExtra("usuario",usuario);
                si.putExtra("nombre",nombre);
                si.putExtra("clave",clave);
                si.putExtra("email",correo);
                startActivity(si);
                break;
            case R.id.nav_home:
                Intent home = new Intent(Yoga.this,Init.class);
                home.putExtra("usuario",usuario);
                home.putExtra("nombre",nombre);
                home.putExtra("clave",clave);
                home.putExtra("email",correo);
                startActivity(home);
                break;
            case R.id.nav_meditacion:
                Intent meditacion = new Intent(Yoga.this,PantallaMeditacion.class);
                meditacion.putExtra("usuario",usuario);
                meditacion.putExtra("nombre",nombre);
                meditacion.putExtra("clave",clave);
                meditacion.putExtra("email",correo);
                startActivity(meditacion);
                break;
            case R.id.nav_marcas_personales:
                Intent marcas = new Intent(Yoga.this,MarcasPersonales.class);
                marcas.putExtra("usuario",usuario);
                marcas.putExtra("nombre",nombre);
                marcas.putExtra("clave",clave);
                marcas.putExtra("email",correo);
                startActivity(marcas);
                break;

            case R.id.nav_dias_meditacion:
                Intent dias = new Intent(Yoga.this,HistorialMeditacionActivity.class);
                dias.putExtra("usuario",usuario);
                dias.putExtra("nombre",nombre);
                dias.putExtra("clave",clave);
                dias.putExtra("email",correo);
                startActivity(dias);
                break;
            case R.id.nav_dias_ejercicio:
                Intent diasEjer = new Intent(Yoga.this,HistorialEjercicioActivity.class);
                diasEjer.putExtra("usuario",usuario);
                diasEjer.putExtra("nombre",nombre);
                diasEjer.putExtra("clave",clave);
                diasEjer.putExtra("email",correo);
                startActivity(diasEjer);
                break;
            case R.id.nav_dias_yoga:
                Intent diasYog = new Intent(Yoga.this,HistorialYogaActivity.class);
                diasYog.putExtra("usuario",usuario);
                diasYog.putExtra("nombre",nombre);
                diasYog.putExtra("clave",clave);
                diasYog.putExtra("email",correo);
                startActivity(diasYog);
                break;
            case R.id.nav_mis_rutinas:
                Intent misRutinas = new Intent(Yoga.this,Rutinas.class);
                misRutinas.putExtra("usuario",usuario);
                misRutinas.putExtra("nombre",nombre);
                misRutinas.putExtra("clave",clave);
                misRutinas.putExtra("email",correo);
                startActivity(misRutinas);
                break;
            case R.id.nav_peso_y_medidas:
                Intent misMedidas = new Intent(Yoga.this,Probando.class);
                misMedidas.putExtra("usuario",usuario);
                misMedidas.putExtra("nombre",nombre);
                misMedidas.putExtra("clave",clave);
                misMedidas.putExtra("email",correo);
                startActivity(misMedidas);
                break;
            case R.id.nav_recordatorio:
                Intent recordatorio = new Intent(Yoga.this,MyDoes.class);
                recordatorio.putExtra("usuario",usuario);
                recordatorio.putExtra("nombre",nombre);
                recordatorio.putExtra("clave",clave);
                recordatorio.putExtra("email",correo);
                startActivity(recordatorio);
                break;

            case R.id.nav_logout:
                Intent logout = new Intent(Yoga.this, Login.class);
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