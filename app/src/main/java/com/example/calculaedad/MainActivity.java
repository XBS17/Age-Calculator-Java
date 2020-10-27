package com.example.calculaedad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombre, nacimiento;
    Button calcula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=(EditText)findViewById(R.id.nombre);
        nacimiento=(EditText)findViewById(R.id.nacimiento);

        nombre.setHint("Escribe tu nombre");
        nacimiento.setHint("ej. 17/03/1997");

        calcula=(Button)findViewById(R.id.calcula);
        calcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(comprueba())
                    cambia_actividad();
                else
                    Toast.makeText(getBaseContext(), "Comprueba que los datos estén bien",Toast.LENGTH_LONG).show();

            }
        });

    }
    private boolean comprueba(){
        if(nombre.getText().toString().trim().equals("") || nacimiento.getText().toString().trim().equals(""))
            return false;
        else
            return true;
    }

    private void cambia_actividad(){
        Intent intent=new Intent(this, MuestraEdad.class);
        intent.putExtra("nombre",nombre.getText().toString());
        intent.putExtra("nacimiento",nacimiento.getText().toString());
        startActivity(intent);
    }
}