package com.example.semusp.Escolha_semma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.semusp.Denucias.CadastrodaDenuncia_Semma;
import com.example.semusp.R;

public class ArActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);
        getSupportActionBar().hide();
    }

    public void poeiraIndustrial(View v){
        Intent intent = new Intent(ArActivity.this, CadastrodaDenuncia_Semma.class);
        intent.putExtra("key",     "POEIRA INDUSTRIAL");
        startActivity(intent);

    }
    public void FumacaIndustrial(View v){
        Intent intent = new Intent(ArActivity.this, CadastrodaDenuncia_Semma.class);
        intent.putExtra("key",     "FUMAÇA INDUSTRIAL");
        startActivity(intent);

    }
}