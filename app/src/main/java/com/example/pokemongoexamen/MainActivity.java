package com.example.pokemongoexamen;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("Pokemon", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS usuario(nombre varchar, contraseña varchar)");
        db.execSQL("CREATE TABLE IF NOT EXISTS pokemon(nombre varchar, tipo varchar, nivel int)");

        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String user=preferences.getString("user","");
        Toast tost = Toast.makeText(getApplicationContext(), user, Toast.LENGTH_LONG);
        tost.show();
        if(user!=""){
            Intent intent = new Intent(getApplicationContext(), pantPrincipal.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.acercade){
            Toast tost = Toast.makeText(getApplicationContext(), "David Martinez", Toast.LENGTH_LONG);
            tost.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void botonPokemon(View view){

        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String user=preferences.getString("user","");
        Toast tost = Toast.makeText(getApplicationContext(), user, Toast.LENGTH_LONG);
        tost.show();

        if(user==""){
            Intent intent = new Intent(getApplicationContext(), acessoregistro.class);
            startActivity(intent);
        }
    }

}