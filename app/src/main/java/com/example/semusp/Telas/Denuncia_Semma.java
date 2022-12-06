package com.example.semusp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.semusp.Escolha_semma.AguaActivity;
import com.example.semusp.Escolha_semma.ArActivity;
import com.example.semusp.Escolha_semma.FaunaActivity;
import com.example.semusp.Escolha_semma.FloraActivity;
import com.example.semusp.Escolha_semma.FogoActivity;
import com.example.semusp.Escolha_semma.RuidoActivity;
import com.example.semusp.Escolha_semma.SoloActivity;
import com.example.semusp.R;

public class Denuncia_Semma extends AppCompatActivity {

    private Button btAgua,btAr,btFauna,btFlora,btFogo,btRuido,btSolo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncia);
        getSupportActionBar().hide();


        btAgua = findViewById(R.id.btDeslizamento);
        btAr = findViewById(R.id.btInundacao);
        btFauna = findViewById(R.id.btEnchurrdas);
        btFlora = findViewById(R.id.btErosaaaaa);
        btFogo = findViewById(R.id.btColapso);
        btRuido = findViewById(R.id.btAlagamento);
        btSolo = findViewById(R.id.btVendaval);

        btAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Denuncia_Semma.this, AguaActivity.class));
            }
        });
        btAr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Denuncia_Semma.this, ArActivity.class));
            }
        });
        btFauna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Denuncia_Semma.this, FaunaActivity.class));
            }
        });
        btFlora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Denuncia_Semma.this, FloraActivity.class));
            }
        });
        btFogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Denuncia_Semma.this, FogoActivity.class));
            }
        });
        btRuido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Denuncia_Semma.this, RuidoActivity.class));
            }
        });
        btSolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Denuncia_Semma.this, SoloActivity.class));
            }
        });

    }
}