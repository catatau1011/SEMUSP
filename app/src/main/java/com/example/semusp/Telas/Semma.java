package com.example.semusp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.semusp.AcompanharOcorrencia.Acompanhar_semma;
import com.example.semusp.R;

public class Semma extends AppCompatActivity {
    private Button buttonSemma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semma);
        getSupportActionBar().hide();


        buttonSemma = findViewById(R.id.defesaCivil14);
        buttonSemma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Semma.this, Acompanhar_semma.class);
                startActivity(intent);
            }
        });
    }
    public void EntrarDenuncia(View view){
        Intent intent = new Intent(Semma.this, Denuncia_Semma.class);
        startActivity(intent);
    }
}