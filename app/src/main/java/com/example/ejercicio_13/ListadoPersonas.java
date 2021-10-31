package com.example.ejercicio_13;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ArregloPersonas);
        listapersonas.setAdapter(adp);

    }

    private void ObtenerListaPersonas()
    {

        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas list_personas = null;
        lista = new ArrayList<Personas>();


        Cursor cursor = db.rawQuery("SELECT * FROM " + Transacciones.TablaPersonas, null);

        while (cursor.moveToNext()) {
            list_personas = new Personas();
            list_personas.setId(cursor.getInt(0));
            list_personas.setNombre(cursor.getString(1));
            list_personas.setApellidos(cursor.getString(2));
            list_personas.setEdad(cursor.getInt(3));
            list_personas.setCorreo(cursor.getString(4));
            list_personas.setDireccion(cursor.getString(5));


            lista.add(list_personas);
        }
        cursor.close();

        filllibreta();
    }

    private void filllibreta() {
        ArregloPersonas = new ArrayList<String>();
        for (int i = 0; i < lista.size(); i++) {
            ArregloPersonas.add(lista.get(i).getId() + "|" + lista.get(i).getNombre() +"|" + lista.get(i).getApellidos() + "|" + lista.get(i).getEdad()+ "|" + lista.get(i).getCorreo()+ "|" + lista.get(i).getDireccion());
        }
    }

}