package com.example.ejemplo42;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class VentanaConsEmp extends AppCompatActivity {

    private RecyclerView miRecicler;
    private RecyclerView.Adapter miAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_cons_emp);

        miRecicler = (RecyclerView) findViewById(R.id.RV1);
        miRecicler.setHasFixedSize(true);

        miRecicler.setLayoutManager(new LinearLayoutManager(this));
        //Especificamos el adaptador con la lista a visualizar
        miAdapter = new Adaptador(DatosEmpleados());
        miRecicler.setAdapter(miAdapter);

    }

    public List<Empleados> DatosEmpleados() {

        String cnombre = "", capellido = "";
        int codigo;
        List<Empleados> Lista = new ArrayList<>();

        BaseDatosHelper usdbh = new BaseDatosHelper(this, "Hospital", null, 1);

        SQLiteDatabase db = usdbh.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT codigo, nombre, apellido FROM emp", null);

        if (c.moveToFirst()) {
            do {
                codigo = c.getInt(0);
                cnombre = c.getString(1);
                capellido = c.getString(2);
                Lista.add(new Empleados(codigo, cnombre, capellido));

            } while(c.moveToNext());
        }


        return Lista;
    }


}