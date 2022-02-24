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

public class Acceder extends AppCompatActivity {
    private EditText txtusuario;
    private EditText txtContra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceder);
        txtusuario = (EditText) findViewById(R.id.txtUsuario);
        txtContra = (EditText) findViewById(R.id.txtContrasena);
    }

    public void limpiar(View view){
        txtusuario.setText("");
        txtContra.setText("");
    }

    public void acceso(View view){
        String usuario = txtusuario.getText().toString();
        String contra = txtContra.getText().toString();
        Cursor cursor = db.rawQuery("SELECT * FROM usuario;", null);

        while(cursor.moveToNext()){
            String usur = cursor.getString(0);
            if(usur.equals(usuario)){
                Cursor cursor1 = db.rawQuery("SELECT * FROM usuario where nombre='"+usuario+"'", null);
                while(cursor1.moveToNext()){
                    String contr = cursor1.getString(1);
                    if(contr.equals(contra)){
                        Toast.makeText(getApplicationContext(), "Inicio de sesion correcto", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), pantPrincipal.class);

                        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("user", usuario);
                        editor.commit();

                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    }
                }
            }else{
                Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();
            }
        }
    }
}