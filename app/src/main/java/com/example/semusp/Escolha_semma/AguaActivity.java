package com.example.semusp.Escolha_semma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.semusp.Denucias.CadastrodaDenuncia_Semma;
import com.example.semusp.R;

public class AguaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agua);
        getSupportActionBar().hide();

    }

    public void residuosSolidos(View v){
        Intent intent = new Intent(AguaActivity.this, CadastrodaDenuncia_Semma.class);
        intent.putExtra("key",     "DESCARTE DE RESIDUOS SOLIDOS");
        startActivity(intent);



    }
    public void residuosLiquidos(View v){
        Intent intent = new Intent(AguaActivity.this, CadastrodaDenuncia_Semma.class);
        intent.putExtra("key",     "DESCARTE DE RESIDUOS LIQUIDOS");
        startActivity(intent);
    }

}