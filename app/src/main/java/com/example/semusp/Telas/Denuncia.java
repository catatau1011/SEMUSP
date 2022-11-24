package com.example.semusp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.semusp.Escolha.AguaActivity;
import com.example.semusp.Escolha.ArActivity;
import com.example.semusp.Escolha.FaunaActivity;
import com.example.semusp.Escolha.FloraActivity;
import com.example.semusp.Escolha.FogoActivity;
import com.example.semusp.Escolha.RuidoActivity;
import com.example.semusp.Escolha.SoloActivity;
import com.example.semusp.R;

public class Denuncia extends AppCompatActivity {

    private Button btAgua,btAr,btFauna,btFlora,btFogo,btRuido,btSolo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncia);
        getSupportActionBar().hide();


        btAgua = findViewById(R.id.btAgua);
        btAr = findViewById(R.id.btAr);
        btFauna = findViewById(R.id.btFauna);
        btFlora = findViewById(R.id.btFlora);
        btFogo = findViewById(R.id.btFogo);
        btRuido = findViewById(R.id.btRuido);
        btSolo = findViewById(R.id.btSolo);

        btAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Denuncia.this, AguaActivity.class));
            }
        });
        btAr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Denuncia.this, ArActivity.class));
            }
        });
        btFauna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Denuncia.this, FaunaActivity.class));
            }
        });
        btFlora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Denuncia.this, FloraActivity.class));
            }
        });
        btFogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Denuncia.this, FogoActivity.class));
            }
        });
        btRuido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Denuncia.this, RuidoActivity.class));
            }
        });
        btSolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Denuncia.this, SoloActivity.class));
            }
        });

    }
}