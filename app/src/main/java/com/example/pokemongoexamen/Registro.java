package com.example.pokemongoexamen;

import static com.example.pokemongoexamen.MainActivity.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Principal;

public class Registro extends AppCompatActivity {

    EditText txtUsuario;
    EditText txtContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtUsuario = (EditText) findViewById(R.id.txtNombre);
        txtContraseña = (EditText) findViewById(R.id.txtContra);
    }

    public void registrarse(View view){
        String usuario = txtUsuario.getText().toString();
        Cursor c = db.rawQuery("SELECT * FROM usuario where nombre='"+usuario+"'", null);
        if(c.getCount()<1) {
            db.execSQL("INSERT INTO usuario VALUES('" + usuario + "','" + txtContraseña.getText().toString() + "')");

            SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("user", usuario);
            editor.commit();
            Intent intent = new Intent(getApplicationContext(), pantPrincipal.class);
            startActivity(intent);
        }else{
            Toast toast1 = Toast.makeText(this, "Este usuario ya está registrado", Toast.LENGTH_LONG);
            toast1.show();
            txtUsuario.setText("");
            txtContraseña.setText("");
        }
    }
    public void limpiar(View view){
        txtUsuario.setText("");
        txtContraseña.setText("");
    }
}