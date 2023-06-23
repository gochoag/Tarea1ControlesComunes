package com.example.tarea1controlescomunes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivityRecibeDatosFormulario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recibe_datos_formulario);

        TextView txtSaludo = (TextView)findViewById(R.id.txtDatos);
        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();
        //Construimos el mensaje a mostrar
        txtSaludo.setText("Hola!, Bienvenido \n " +
                bundle.getString("Nombres")+
                "\n" +
                bundle.getString("Cedula")+
                "\n " +
                bundle.getString("FNacimiento")+
                "\n " +
                bundle.getString("Genero")+
                "\n " +
                bundle.getString("Correo")+
                "\n " +
                bundle.getString("Telefono")




        );

    }
}