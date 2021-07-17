package com.example.ejemplo42;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class VentanaAltaEmp extends AppCompatActivity {

    private EditText nombre, apellido, oficio, direccion, fecha, salario, comision, deptno ;

    SQLiteDatabase db=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_alta_emp);

        this.nombre = (EditText) findViewById(R.id.edtNombre);
        this.apellido = (EditText) findViewById(R.id.edtApellido);
        this.oficio = (EditText) findViewById(R.id.edtOficio);
        this.direccion = (EditText) findViewById(R.id.edtDireccion);
        this.fecha = (EditText) findViewById(R.id.edtFechaAlta);
        this.salario = (EditText) findViewById(R.id.edtSalario);
        this.comision = (EditText) findViewById(R.id.edtComision);
        this.deptno = (EditText) findViewById(R.id.edtDepNo);

    }
    public void Alta(View view) {

        BaseDatosHelper usdbh = new BaseDatosHelper(this, "Hospital", null, 1);
        db= usdbh.getWritableDatabase();


        ContentValues nuevoRegistro = new ContentValues();

        nuevoRegistro.put("nombre", nombre.getText().toString());
        nuevoRegistro.put("apellido",apellido.getText().toString());
        nuevoRegistro.put("oficio",oficio.getText().toString());
        nuevoRegistro.put("direccion",direccion.getText().toString());
        nuevoRegistro.put("falta",fecha.getText().toString());
        nuevoRegistro.put("salario",Integer.parseInt(salario.getText().toString()));
        nuevoRegistro.put("comision",Integer.parseInt(comision.getText().toString()));
        nuevoRegistro.put("deptno",deptno.getText().toString());

        db.insert("emp", null, nuevoRegistro);

    }
}