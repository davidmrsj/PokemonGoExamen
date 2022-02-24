package com.example.pokemongoexamen;

import static com.example.pokemongoexamen.MainActivity.db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistroPokemon extends AppCompatActivity {

    Spinner stipo;
    EditText nombre;
    SeekBar barra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_pokemon);

        barra = (SeekBar) findViewById(R.id.seekBar);
        nombre = (EditText) findViewById(R.id.txtPokemon);

        String [] elementos = {"Agua", "Fuego", "planta"};
        stipo = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, elementos);
        stipo.setAdapter(adp);
    }

    public void registrarPokemon(View view){
        String nPokemon = nombre.getText().toString();
        String tipo = stipo.getSelectedItem().toString();
        int nivel = barra.getProgress();
        db.execSQL("INSERT INTO pokemon VALUES('" + nombre + "','" + tipo + "', "+nivel+")");

        Toast tost = Toast.makeText(getApplicationContext(), "Pokemon guardado", Toast.LENGTH_LONG);
        tost.show();
    }


}