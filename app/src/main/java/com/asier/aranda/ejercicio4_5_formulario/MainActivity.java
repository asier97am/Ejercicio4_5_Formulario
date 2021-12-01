package com.asier.aranda.ejercicio4_5_formulario;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public Button enviarDatos;
    public EditText nombre,apellido;
    public RadioButton radio_Soltero,radio_Casado,radio_Divorciado,radio_Viudo;
    public CheckBox familia,videojuegos,arte,educacion,carreras,deportes;
    private TextView mostrarDatos;


    String datosNombre="";
    String datosApellido="";
    String datosEstadoCivil="";
    String datosPreferencias="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button
        enviarDatos      = (Button) findViewById(R.id.enviarDatos);//puente de comunicacion entre parte logica y grafica
        //editText
        nombre           = (EditText) findViewById(R.id.nombre);
        apellido         = (EditText)findViewById(R.id.apellido);
        //radioButton
        radio_Soltero    = (RadioButton) findViewById(R.id.radio_Soltero);
        radio_Casado     = (RadioButton) findViewById(R.id.radio_Casado);
        radio_Divorciado = (RadioButton) findViewById(R.id.radio_Divorciado);
        radio_Viudo      = (RadioButton) findViewById(R.id.radio_Viudo);
        //Checkbox
        familia         = (CheckBox) findViewById(R.id.familia);
        videojuegos     = (CheckBox) findViewById(R.id.videojuegos);
        arte            = (CheckBox) findViewById(R.id.arte);
        educacion       = (CheckBox) findViewById(R.id.educacion);
        carreras        = (CheckBox) findViewById(R.id.carreras);
        deportes        = (CheckBox) findViewById(R.id.deportes);

        mostrarDatos  = (TextView) findViewById(R.id.mostrarDatos);

    }
    //radiobutton control
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        String str = "";// variable donde se almacenara el dato del radioButton
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_Soltero:
                if (checked)
                    str = "Soltero";
                break;
            case R.id.radio_Casado:
                if (checked)
                    str = "Casado";
                break;
            case R.id.radio_Divorciado:
                if (checked)
                    str = "Divorciado";
                break;
            case R.id.radio_Viudo:
                if (checked)
                    str = "Viudo";
                break;
        }
        datosEstadoCivil=str;
    }


    public void enviarDatos(View view) {
        String prefe="";
        if(deportes.isChecked()) {
            datosPreferencias +=" "+deportes.getText();
        }
        if(carreras.isChecked()){
            datosPreferencias +=" "+carreras.getText();
        }
        if(educacion.isChecked()){
            datosPreferencias +=" "+educacion.getText();
        }
        if(arte.isChecked())  {
            datosPreferencias +=" "+arte.getText();
        }
        if(videojuegos.isChecked()){
            datosPreferencias +=" "+videojuegos.getText();
        }
        if(familia.isChecked()){
            datosPreferencias +=" "+familia.getText();
        }

        datosNombre=nombre.getText().toString();
        datosApellido=apellido.getText().toString();
        //datosPreferencias=prefe;


        mostrarDatos.setText("Nombre: "+datosNombre +"\n" +
                " Apellido: "+datosApellido+"\n" +
                " Preferencias: "+datosPreferencias +"\n"+
                " Estado Civil: "+datosEstadoCivil);

        datosNombre="";
        datosApellido="";
        datosPreferencias="";
        datosEstadoCivil="";

    }



}