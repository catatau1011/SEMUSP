package com.example.semusp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.semusp.R;
import com.example.semusp.Telas.DefesaCivil;
import com.example.semusp.Telas.Semma;
import com.example.semusp.informativo.InfromativoActivity;

public class SelecaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao);

        getSupportActionBar().hide();
    }
    public void selecaoDfCicil(View v){
        Intent intent = new Intent(SelecaoActivity.this, DefesaCivil.class);
        startActivity(intent);
    }
    public void selecaoSemma(View v){
        Intent intent = new Intent(SelecaoActivity.this, Semma.class);
        startActivity(intent);
    }

    public void informativo(View v){
        Intent intent = new Intent(SelecaoActivity.this, InfromativoActivity.class);
        startActivity(intent);
    }
}