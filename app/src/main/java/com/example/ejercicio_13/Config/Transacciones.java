package com.example.ejercicio_13.Config;

public class Transacciones
{
    public static final String NameDatabase="DBEjercio1_3";

    public static final String TablaPersonas="Personas";

    public static final String id="id";
    public static final String Nombres="Nombres";
    public static final String Apellidos="Apellidos";
    public static final String Edad="Edad";
    public static final String Correo="Correo";
    public static final String Direccion="Direccion";

    public static final String CreateTablePersonas = "CREATE TABLE Personas (id INTEGER PRIMARY KEY AUTOINCREMENT," + "Nombres TEXT, Apellidos TEXT, Edad TEXT, Correo TEXT, Direccion TEXT)";

    public static final String DROPTablePersonas ="DROP TABLE IF EXISTS Personas";
}
