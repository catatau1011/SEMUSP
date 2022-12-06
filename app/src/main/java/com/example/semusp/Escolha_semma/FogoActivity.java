package com.example.semusp.Escolha_semma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.semusp.Denucias.CadastrodaDenuncia_Semma;
import com.example.semusp.R;

public class FogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fogo);
        getSupportActionBar().hide();
    }

    public void Queimadas(View v) {
        Intent intent = new Intent(FogoActivity.this, CadastrodaDenuncia_Semma.class);
        intent.putExtra("key",     "QUEIMADAS");
        startActivity(intent);

    }
}
