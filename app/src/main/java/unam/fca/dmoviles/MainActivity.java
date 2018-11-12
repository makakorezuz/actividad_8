package unam.fca.dmoviles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static int IMAGE_WIDTH = 400;
    private final static String TEXT_VIEW_KEY = "TEXT_VIEW_KEY";

    EditText Field1;
    EditText Field2;
    TextView tv;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Actividad 8 Creacion de una calculadora de porcentajes
        //En esta actividad crearas una aplicacion que calcule la diferencia relativa en porcentaje entre dos numeros.


        // El archivo del layout de la actividad se encuentra en la carpeta
        // res/layout/activity_main.xml
        setContentView(R.layout.activity_main);

        // Se establece la comunicación con en la parte lógica.
        Field1 = (EditText)findViewById(R.id.editText);
        Field2 = (EditText)findViewById(R.id.editText2);
        tv = (TextView)findViewById(R.id.textViewResult);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Se está procesando", Toast.LENGTH_LONG).show();

                //recuperar los valores de editField y de editField1
                String valor1 = Field1.getText().toString();
                String valor2 = Field2.getText().toString();

                //convertir los valores a tipo entero
                float v1 = Float.parseFloat(valor1);
                float v2 = Float.parseFloat(valor2);

                //calcular con la ecuación ? = (( V2 - V1 ) / abs(V1)) * 100
                float division = (float)(v2-v1)/Math.abs(v1);
                float res1 = division*100;

                //asignamos el resultad con setText

                if (res1 > 0){
                    tv.setText( Math.abs(res1) + " % increase");
                } else {
                    tv.setText( Math.abs(res1) + " % decrease ");
                }

            }
        });

        //Actividades
        //a) Ejecuta la aplicacion y familiarizate con el layout definido en R.layout.activity_main
        //b) Crea la logica para calcular la diferencia relativa en porcentaje entre dos numeros
        //c) La formula para calcular la diferencia relativa en porcentaje esta en: https://www.calculatorsoup.com/calculators/algebra/percent-change-calculator.php
        //d) La aplicacion debe calcular la diferencia relativa en porcentaje de los valores contenidos en "editText" y "editText2"
        //e) Al hacer click en el boton "button", la aplicacion debera calcular dicha diferencia y poner el resultado en el campo "textViewResult"
        //f) La aplicacion debera manejar adecuadamente el cambio de rotacion para el resultado y los campos de texto
        //e) Anota tus respuestas y las capturas de pantalla en un documento en Word
        //f) Sube tu codigo al repositorio.
        //g) Sube el documento Word a la plataforma Moodle. Incluye la liga a tu repositorio

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        final TextView tv = findViewById(R.id.textViewResult);
        tv.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        final TextView tv = findViewById(R.id.textViewResult);
        outState.putString(TEXT_VIEW_KEY, tv.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
