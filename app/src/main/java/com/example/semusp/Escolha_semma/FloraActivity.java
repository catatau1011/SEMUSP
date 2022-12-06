package com.example.semusp.Escolha_semma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.semusp.Denucias.CadastrodaDenuncia_Semma;
import com.example.semusp.R;

public class FloraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flora);
        getSupportActionBar().hide();
    }

    public void AnimaisCativeiro(View v){
        Intent intent = new Intent(FloraActivity.this, CadastrodaDenuncia_Semma.class);
        intent.putExtra("key",     "ANIMAIS SILVESTRES EM CARIVEIRO");
        startActivity(intent);

    }
    public void ComercioIlegal(View v){
        Intent intent = new Intent(FloraActivity.this, CadastrodaDenuncia_Semma.class);
        intent.putExtra("key",     "COMERCIO ILEGAL DE ANIMAIS SILVESTRES");
        startActivity(intent);

    }
    public void CacaIlegal(View v){
        Intent intent = new Intent(FloraActivity.this, CadastrodaDenuncia_Semma.class);
        intent.putExtra("key",     "CAÇA DE ANIMAIS SILVESTRES");
        startActivity(intent);

    }
}