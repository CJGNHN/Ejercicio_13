package com.example.ejercicio_13.Tablas;

public class Personas {
    private Integer Id;
    private String Nombre;
    private String Apellidos;
    private Integer Edad;
    private String Correo;
    private String Direccion;

    public Personas (Integer id, String nombres, String apellidos, Integer edad, String correo, String direccion)
    {
        this.Id = id;
        this.Nombre = nombres;
        this.Apellidos = apellidos;
        this.Edad = edad;
        this.Correo = correo;
        this.Direccion = direccion;


    }

    public Personas() {

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer edad) {
        Edad = edad;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }


}
