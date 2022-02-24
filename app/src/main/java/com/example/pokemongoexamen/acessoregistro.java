package com.example.pokemongoexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class acessoregistro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acessoregistro);
    }

    public void pantregistro(View view){
        Intent intent = new Intent(getApplicationContext(), Registro.class);
        startActivity(intent);
    }

    public void pantAcceso(View view){
        Intent intent = new Intent(getApplicationContext(), Acceder.class);
        startActivity(intent);
    }
}