package com.example.semusp.Escolha_semma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.semusp.Denucias.CadastrodaDenuncia_Semma;
import com.example.semusp.R;

public class SoloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo);
        getSupportActionBar().hide();
    }
    public void Aterro(View v){
        Intent intent = new Intent(SoloActivity.this, CadastrodaDenuncia_Semma.class);
        intent.putExtra("key",     "ATERRO SANITÁRIO OU LIXÃO");
        startActivity(intent);
    }
    public void Descarte(View v){
        Intent intent = new Intent(SoloActivity.this, CadastrodaDenuncia_Semma.class);
        intent.putExtra("key",     "DESGASTES IRREGULAR DE ENTULHO");
        startActivity(intent);
    }
}