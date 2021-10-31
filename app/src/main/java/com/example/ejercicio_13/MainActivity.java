package com.example.ejercicio_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicio_13.Config.SQLiteConexion;
import com.example.ejercicio_13.Config.Transacciones;

public class MainActivity extends AppCompatActivity {

    SQLiteConexion conexion;
    EditText Nombre, Apellidos, Edad, Correo, Direccion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre = ( EditText) findViewById(R.id.IDNombre);
        Apellidos = ( EditText) findViewById(R.id.IDApellido);
        Edad = (EditText) findViewById(R.id.IDedad);
        Correo = (EditText) findViewById(R.id.IDCorreo);
        Direccion = (EditText) findViewById(R.id.IDDireccion);


        Button btnSalvar = (Button) findViewById(R.id.btnSalvarContacto);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { AgregarPersonas();}
        });

    }

    private void AgregarPersonas()
    {
        SQLiteConexion conexion = new SQLiteConexion(  this, Transacciones.NameDatabase,null,1 );
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.Nombres, Nombre.getText().toString());
        valores.put(Transacciones.Apellidos, Apellidos.getText().toString());
        valores.put(Transacciones.Edad, Edad.getText().toString());
        valores.put(Transacciones.Correo, Correo.getText().toString());
        valores.put(Transacciones.Direccion, Direccion.getText().toString());

        if(Nombre.getText().toString().isEmpty() | Apellidos.getText().toString().isEmpty() | Edad.getText().toString().isEmpty() | Correo.getText().toString().isEmpty()| Direccion.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Favor no dejar campos vacios",Toast.LENGTH_LONG).show();
        }else{

            Long contactoingresado = db.insert(Transacciones.TablaPersonas, Transacciones.id, valores);
            Toast.makeText(getApplicationContext(), "Registro INGRESADO : Codigo :" + contactoingresado.toString(), Toast.LENGTH_LONG).show();

            db.close();
        }
        LimpiarPantalla();
    }


    private void LimpiarPantalla()
    {
        Nombre.setText("");
        Apellidos.setText("");
        Edad.setText("");
        Correo.setText("");
        Direccion.setText("");

    }

}