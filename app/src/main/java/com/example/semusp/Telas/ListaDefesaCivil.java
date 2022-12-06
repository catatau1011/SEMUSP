package com.example.semusp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.semusp.R;

public class ListaDefesaCivil extends AppCompatActivity {
    TextView Recebe1,Recebe2,Recebe3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_defesa_civil);
        getSupportActionBar().hide();

        Recebe1 = findViewById(R.id.Recebe1);
        Recebe2 = findViewById(R.id.Recebe2);
        Recebe3 = findViewById(R.id.Recebe3);

        String valor1 = getIntent().getStringExtra("Chave");
        Recebe1.setText(valor1);
        String valor2 = getIntent().getStringExtra("Chave1");
        Recebe2.setText(valor2);
        String valor3 = getIntent().getStringExtra("Chave2");
        Recebe3.setText(valor3);



    }
}