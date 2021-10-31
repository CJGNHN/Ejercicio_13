package com.example.ejercicio_13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.example.ejercicio_13.Config.SQLiteConexion;
import com.example.ejercicio_13.Config.Transacciones;
import com.example.ejercicio_13.Tablas.Personas;

import java.util.ArrayList;

public class ListadoPersonas extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listapersonas;

    ArrayList<String> ArregloPersonas;
    ArrayList<Personas> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_personas);

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        listapersonas = (ListView) findViewById(R.id.ListaPersonas);
        
        ObtenerListaPersonas();


    }

    private void ObtenerListaPersonas() {
    }
}