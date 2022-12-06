package com.example.semusp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.semusp.AcompanharOcorrencia.Acompanhar_defesa_civil;
import com.example.semusp.R;

public class DefesaCivil extends AppCompatActivity {

    Button defesa,defesaCivil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defesa_civil);
        getSupportActionBar().hide();

        defesa = findViewById(R.id.btOcorencia);
        defesaCivil = findViewById(R.id.defesaCivil14);

        defesaCivil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DefesaCivil.this, Acompanhar_defesa_civil.class);
                startActivity(intent);
            }
        });

        defesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DefesaCivil.this,Denuncia_defesa_civil.class);
                startActivity(intent);
            }
        });

    }



    }
