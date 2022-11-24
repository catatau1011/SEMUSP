package com.example.semusp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.semusp.R;

public class Semma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semma);
        getSupportActionBar().hide();
    }
    public void EntrarDenuncia(View view){
        Intent intent = new Intent(Semma.this,Denuncia.class);
        startActivity(intent);
    }
}