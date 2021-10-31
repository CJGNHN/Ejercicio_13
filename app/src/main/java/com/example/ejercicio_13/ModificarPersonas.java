package com.example.ejercicio_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicio_13.Config.SQLiteConexion;
import com.example.ejercicio_13.Config.Transacciones;

public class ModificarPersonas extends AppCompatActivity {

    SQLiteConexion conexion;
    EditText Id, Nombre, Apellidos, Edad, Correo, Direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_personas);

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);

        Button btnbuscar = (Button) findViewById(R.id.btnBuscar);
        Button btneliminar = (Button) findViewById(R.id.btnEliminar);
        Button btnactualizar = (Button) findViewById(R.id.btnActualizar);

        Id = ( EditText) findViewById(R.id.txtcid);
        Nombre = ( EditText) findViewById(R.id.txtcnombres);
        Apellidos = ( EditText) findViewById(R.id.txtcapellidos);
        Edad = (EditText) findViewById(R.id.txtcedad);
        Correo = (EditText) findViewById(R.id.txtccorreo);
        Direccion = (EditText) findViewById(R.id.txtcdireccion);

        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Buscar();}
        });

        btneliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Elimimar();}
        });

        btnactualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Actualizar();}
        });


    }

    private void Buscar() 
    {
        SQLiteDatabase db = conexion.getWritableDatabase();
        
        String [] params ={Id.getText().toString()};
        String [] fields = {Transacciones.Nombres, Transacciones.Apellidos, Transacciones.Edad, Transacciones.Correo, Transacciones.Direccion};
        String wherecond = Transacciones.id + "=?";
        
        try {
            Cursor cdata = db.query(Transacciones.TablaPersonas, fields, wherecond, params, null, null, null);
            cdata.moveToFirst();

            Nombre.setText(cdata.getInt(0));
            Apellidos.setText(cdata.getString(1));
            Edad.setText(cdata.getInt(2));
            Correo.setText(cdata.getString(3));
            Direccion.setText(cdata.getString(4));

            Toast.makeText(getApplicationContext(),"consulta realizada", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex)
        {
            ClearScreen();
            Toast.makeText(getApplicationContext(),"Dato Encontrado", Toast.LENGTH_LONG).show();
        }
    }

    private void Elimimar()
    {
        SQLiteDatabase db = conexion.getWritableDatabase();

        String [] params = {Id.getText().toString()};
        String wherecond = Transacciones.id + "=?";
        db.delete(Transacciones.TablaPersonas, wherecond, params);
        Toast.makeText(getApplicationContext(),"Dato Eliminado",Toast.LENGTH_LONG).show();
        ClearScreen();
    }

    private void Actualizar()
    {
        SQLiteDatabase db = conexion.getWritableDatabase();

        String [] params = {Id.getText().toString()};

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.Nombres, Nombre.getText().toString());
        valores.put(Transacciones.Apellidos, Apellidos.getText().toString());
        valores.put(Transacciones.Edad, Edad.getText().toString());
        valores.put(Transacciones.Correo, Correo.getText().toString());
        valores.put(Transacciones.Direccion, Direccion.getText().toString());

        db.update(Transacciones.TablaPersonas, valores, Transacciones.id+ "=?", params);
        Toast.makeText(getApplicationContext(),"Contacto Actualizado",Toast.LENGTH_LONG).show();
        ClearScreen();
    }

    private void ClearScreen()
    {
        Nombre.setText("");
        Apellidos.setText("");
        Edad.setText("");
        Correo.setText("");
        Direccion.setText("");

    }
}