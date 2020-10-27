package com.example.calculaedad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MuestraEdad extends AppCompatActivity {

    TextView nombre, edad;
    Button volver;
    Bundle datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_edad);

        datos=this.getIntent().getExtras();

        nombre=(TextView)findViewById(R.id.nombre);
        edad=(TextView)findViewById(R.id.edad);

        nombre.setText("¡Hola "+datos.getString("nombre")+"!");
        edad.setText("Tienes "+calcula_edad()+" años");

        volver=(Button)findViewById(R.id.volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private String calcula_edad() {
        int iedad;
        String[] fecha=datos.getString("nacimiento").split("/");
        iedad=Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()))-Integer.parseInt(fecha[2]);
        if(Integer.parseInt(new SimpleDateFormat("MM").format(new Date()))<Integer.parseInt(fecha[1]))
            iedad--;
        if(Integer.parseInt(new SimpleDateFormat("MM").format(new Date()))==Integer.parseInt(fecha[1]) && Integer.parseInt(new SimpleDateFormat("dd").format(new Date()))<Integer.parseInt(fecha[0]))
            iedad--;

        return String.valueOf(iedad);

    }
}