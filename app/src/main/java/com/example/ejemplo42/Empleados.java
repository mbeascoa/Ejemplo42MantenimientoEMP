package com.example.ejemplo42;

public class Empleados {

    private String nombre, apellido;
    private int codigo;

    public  Empleados() {

    }

    public  Empleados(int codigo, String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
