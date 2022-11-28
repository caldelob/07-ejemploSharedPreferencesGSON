package com.example.a07_ejemplosharedpreferencesgson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.internal.PropertyReference0Impl;

public class MainActivity extends AppCompatActivity {
    private TextView lblCantidad;
    private Button btnCargar;
    private Button btnGuardar;

    private List<ContactoMatricula> contactos;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos= new ArrayList<>();

        sharedPreferences = getSharedPreferences(Constantes.DATOS, MODE_PRIVATE); //solo puedo insertar Strings
        btnCargar = findViewById(R.id.btnCargarMain);
        btnGuardar = findViewById(R.id.btnGuardarMain);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contactosString = new Gson().toJson(contactos);
                Log.d("JSON", contactosString);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Constantes.CONTACTOS, contactosString);
                editor.apply();
            }
        });

        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sharedPreferences.contains(Constantes.CONTACTOS) && !sharedPreferences.getString(Constantes.CONTACTOS, "").isEmpty()){
                    String contactosString = sharedPreferences.getString(Constantes.CONTACTOS, ""); //LAS COMILLAS SIGNIFICAN que si no hay tag, se pone eso (o sea, nada)


                    //Con esta clase, java se encarga de definir los atributos:
                    Type tipo = new TypeToken<ArrayList<ContactoMatricula>>(){}.getType();

                    List<ContactoMatricula> temp = new Gson().fromJson(contactosString, tipo);
                    contactos.clear();
                    contactos.addAll(temp);
                    Toast.makeText(MainActivity.this, "Elementos Cargados", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if(!sharedPreferences.contains(Constantes.CONTACTOS)){
            crearContactos();
        }

        lblCantidad = findViewById(R.id.lblCantidad);
        lblCantidad.setText("Tenemos "+contactos.size()+" matriculas");
    }

    private void crearContactos() {

        for (int i = 0; i < 10; i++) {
            contactos.add(new ContactoMatricula("Nombre "+i, "Ciclo "+i, "Email "+i, "Telefono "+i) );

        }
    }
}