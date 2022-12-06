package com.example.semusp.Escolha_semma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.semusp.Denucias.CadastrodaDenuncia_Semma;
import com.example.semusp.R;

public class FaunaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fauna);
        getSupportActionBar().hide();
    }
    public void desmatamento(View v){
        startActivity(new Intent(FaunaActivity.this, CadastrodaDenuncia_Semma.class));
    }
    public void transporteIlegal(View v){
        startActivity(new Intent(FaunaActivity.this, CadastrodaDenuncia_Semma.class));
    }
}