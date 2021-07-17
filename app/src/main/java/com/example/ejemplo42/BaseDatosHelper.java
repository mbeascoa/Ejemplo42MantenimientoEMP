package com.example.ejemplo42;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatosHelper extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE emp (codigo INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellido TEXT, oficio TEXT," +
            "direccion TEXT, falta TEXT, salario INTEGER, comision INTEGER, deptno TEXT )";

    public BaseDatosHelper(Context contexto, String nombre, CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {

        db.execSQL("DROP TABLE IF EXISTS emp");
        db.execSQL(sqlCreate);
    }
}