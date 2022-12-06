package com.example.semusp.Escolha_semma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.semusp.Denucias.CadastrodaDenuncia_Semma;
import com.example.semusp.R;

public class RuidoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruido);
        getSupportActionBar().hide();
    }

    public void SomAlto(View v) {
        Intent intent = new Intent(RuidoActivity.this, CadastrodaDenuncia_Semma.class);
        intent.putExtra("key",     "SOM ALTO");
        startActivity(intent);

    }
}