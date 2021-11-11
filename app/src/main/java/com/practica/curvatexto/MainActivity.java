package com.practica.curvatexto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //creamos una Activity y le asociamos un objeto View, creado en el constructor de la
        //clase DibujaCirculo
        setContentView(new CirculoConTexto(this));
    }

    //clase que hereda de View
    public class CirculoConTexto extends View {

        //constructor. Establece la vista mediante el contexto recibido de la actividad
        //que lo invoca
        public CirculoConTexto(Context context) {
            super(context);
        }

        //sobreescribimos el método onDraw de la clase View, que será el responsable de
        //dibujar la vista mediante un objeto de la clase Canvas que recibe como parámetro
        @Override
        protected void onDraw(Canvas canvas) {
            //instanciamos el trazo
            Path trazo = new Path();

            //movemos el trazo a las coordenadas indicadas
            trazo.moveTo(50, 100);

//            Luego introduce una curva cúbica o Bézier hasta la coordenada (200,110).
//            Una curva Bézier introduce dos puntos de control, el primero (60,70) permite controlar
//            cómo arranca la dirección del comienzo de la curva y el segundo (150,90) la dirección
//            del final de la curva. Funciona de la siguiente manera, si trazas una recta desde
//            el comienzo de la curva (50,100) hasta el primer punto de control (60,70) la curva se
//            trazará tangencialmente a esta recta.
            trazo.cubicTo(60, 70, 150, 90, 200, 110);

            // Finalmente, se añade una línea desde las coordenadas (200,110) hasta (300,200).
            trazo.lineTo(300, 200);

            Paint pincel = new Paint();
            pincel.setColor(Color.BLUE);
            pincel.setStrokeWidth(8);
            pincel.setStyle(Style.STROKE);

            canvas.drawPath(trazo, pincel);

            pincel.setStrokeWidth(1);
            pincel.setStyle(Style.FILL);
            pincel.setTextSize(20);
            pincel.setTypeface(Typeface.SANS_SERIF);

            canvas.drawTextOnPath("David Andrés Otero", trazo, 10, -40, pincel);
        }
    }
}









