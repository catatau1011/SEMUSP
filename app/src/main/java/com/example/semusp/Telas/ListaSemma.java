package com.example.semusp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.semusp.R;

public class ListaSemma extends AppCompatActivity {

    TextView txtRecebe1,txtRecebe2,txtRecebe3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_semma);

        txtRecebe1 = findViewById(R.id.txtRecebe1);
        txtRecebe2 = findViewById(R.id.txtRecebe2);
        txtRecebe3 = findViewById(R.id.txtRecebe3);

        String valor1 = getIntent().getStringExtra("Chave");
        txtRecebe1.setText(valor1);
        String valor2 = getIntent().getStringExtra("Chave1");
        txtRecebe2.setText(valor2);
        String valor3 = getIntent().getStringExtra("Chave2");
        txtRecebe3.setText(valor3);



    }
}