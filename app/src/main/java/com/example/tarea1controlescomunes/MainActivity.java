package com.example.tarea1controlescomunes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
//Importo librerias de expresiones regulares
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity {
   //Esto permite estableceer el formato para validar la fecha
    private static final String DATE_PATTERN = "\\d{2}/\\d{2}/\\d{4}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    RadioButton generoRDB;
    RadioButton generoRDBC;
    EditText cedula;
    EditText nombre;
    EditText fnacimiento;
    EditText ciudad;
    EditText correo;
    EditText telefono;
    public void Enviar(View view){

        //
        cedula = (EditText) findViewById(R.id.txtNumberCedula);
        nombre = (EditText) findViewById(R.id.txtName);
        fnacimiento = (EditText) findViewById(R.id.txtDateF);
         ciudad = (EditText) findViewById(R.id.txtCity);
         generoRDB = (RadioButton) findViewById(R.id.rdbMan);
         generoRDBC = (RadioButton) findViewById(R.id.rdbFem);
         correo = (EditText) findViewById(R.id.txtEmail);
         telefono = (EditText) findViewById(R.id.txtNumberPhone);

        String Cedula = cedula.getText().toString();
        String Nombres = nombre.getText().toString();
        String Fnacimiento = fnacimiento.getText().toString();
        String Ciudad = ciudad.getText().toString();
        String Correo = correo.getText().toString();
        String Telefono = telefono.getText().toString();


        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(Fnacimiento);
        if(Cedula.isEmpty()){
            cedula.setError("Introduce una cédula");
            cedula.requestFocus();
        }else if (Nombres.isEmpty()){
            cedula.setError("Introduce tus nombres");
            cedula.requestFocus();
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(Correo.trim()).matches()) {
            correo.setError("Introduce un correo electrónico válido");
            correo.requestFocus();
        }
        else if (!matcher.matches() || Fnacimiento.isEmpty()) {
            fnacimiento.setError("Introduce una fecha válida");
            fnacimiento.requestFocus();
        }
        else if (Ciudad.isEmpty()){
            fnacimiento.setError("Introduce una ciudad");
            fnacimiento.requestFocus();
        }
        else if(!generoRDB.isChecked() && !generoRDBC.isChecked()){
            Toast.makeText(this.getApplicationContext(),"Elija un género", Toast.LENGTH_LONG).show();
        }
        else if (!Patterns.PHONE.matcher(Telefono.trim()).matches() || Telefono.isEmpty()) {
            telefono.setError("Introduce un telefóno válido");
            telefono.requestFocus();
        }else {
            String Genero = generoRDB.isChecked()?"Masculino":"Femenino";
            Intent intent = new Intent(MainActivity.this, MainActivityRecibeDatosFormulario.class);
            Bundle b = new Bundle();
            b.putString("Cedula",Cedula);
            b.putString("Nombres",Nombres);
            b.putString("FNacimiento",Fnacimiento);
            b.putString("Genero",Genero);
            b.putString("Correo",Correo);
            b.putString("Telefono",Telefono);
            intent.putExtras(b);
            startActivity(intent);
        }


    }

    public void Limpiar(View view){
        generoRDB = (RadioButton) findViewById(R.id.rdbMan);
        generoRDBC = (RadioButton) findViewById(R.id.rdbFem);
        generoRDB.setChecked(false);
        generoRDBC.setChecked(false);

        cedula.setText("");
        nombre.setText("");
        fnacimiento.setText("");
        ciudad.setText("");
        correo.setText("");
        telefono.setText("");

    }
}