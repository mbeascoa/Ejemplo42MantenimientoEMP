package com.example.ejemplo42;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class VentanaDetalle extends AppCompatActivity {

    private TextView codigo, nombre, apellido, oficio ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        String cnombre = "", capellido = "", coficio = "";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_detalle);

        Bundle bundle=getIntent().getExtras();
        int ccodigo = bundle.getInt("codigo");

        this.codigo = (TextView) findViewById(R.id.txtCodigo);
        this.nombre = (TextView) findViewById(R.id.txtNombre);
        this.apellido = (TextView) findViewById(R.id.txtApellido);
        this.oficio = (TextView) findViewById(R.id.txtOficios);



        BaseDatosHelper usdbh = new BaseDatosHelper(this, "Hospital", null, 1);

        SQLiteDatabase db = usdbh.getReadableDatabase();
        String[] arg = new String[]{String.valueOf(ccodigo)};
        Cursor c = db.rawQuery("SELECT codigo, nombre, apellido, oficio FROM emp WHERE codigo = ?", arg);

        if (c.moveToFirst()) {

            ccodigo = c.getInt(0);
            cnombre = c.getString(1);
            capellido = c.getString(2);
            coficio = c.getString(3);

            this.codigo.setText(String.valueOf(ccodigo));
            this.nombre.setText(cnombre);
            this.apellido.setText(capellido);
            this.oficio.setText(coficio);


        }

    }
}