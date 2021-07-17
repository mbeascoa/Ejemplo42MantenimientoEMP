package com.example.ejemplo42;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void crearBd(View view) {
        BaseDatosHelper usdbh = new BaseDatosHelper(this, "Hospital", null, 1);
    }

    public void consultaEmp(View view) {

        Intent i = new Intent(this, VentanaConsEmp.class );
        startActivity(i);

    }

    public void altaEmp(View view) {

        Intent i = new Intent(this, VentanaAltaEmp.class );
        startActivity(i);

    }
}