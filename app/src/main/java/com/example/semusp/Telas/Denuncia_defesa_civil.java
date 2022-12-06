package com.example.semusp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.semusp.Denucias.CadastroDenuncia_Defesa_Civil;
import com.example.semusp.R;

public class Denuncia_defesa_civil extends AppCompatActivity {
    private Button Vendaval,Alagamento,Inundação,Colapso,Deslizamento,Erosao,Enxurrada;
    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1001;
    TextView textView;
    ImageView imageView;
    Button mCapturebtn;
    Uri image_uri;
    EditText Data,Autor,Descrição;
    Button Resgistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncia_defesa_civil);
        getSupportActionBar().hide();

        Vendaval = findViewById(R.id.btVendaval);
        Alagamento = findViewById(R.id.btAlagamento);
        Inundação = findViewById(R.id.btInundacao);
        Colapso = findViewById(R.id.btColapso);
        Deslizamento = findViewById(R.id.btDeslizamento);
        Erosao = findViewById(R.id.btErosaaaaa);
        Enxurrada = findViewById(R.id.btEnchurrdas);
        //////////////////////////////////////////////
        Data = findViewById(R.id.editDescricao);
        Autor = findViewById(R.id.editAutor1);
        Descrição = findViewById(R.id.editDataOcorrido);
        textView = findViewById(R.id.txtrresultado);

        Vendaval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Denuncia_defesa_civil.this, CadastroDenuncia_Defesa_Civil.class);
                intent.putExtra("key",     "DESCARTE DE RESIDUOS SOLIDOS");
                startActivity(intent);
            }
        });

        Alagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Denuncia_defesa_civil.this, CadastroDenuncia_Defesa_Civil.class);
                startActivity(intent);
            }
        });
        Inundação.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Denuncia_defesa_civil.this, CadastroDenuncia_Defesa_Civil.class);
                startActivity(intent);
            }
        });
        Colapso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Denuncia_defesa_civil.this, CadastroDenuncia_Defesa_Civil.class);
                startActivity(intent);
            }
        });
        Erosao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Denuncia_defesa_civil.this, CadastroDenuncia_Defesa_Civil.class);
                startActivity(intent);
            }
        });
        Enxurrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Denuncia_defesa_civil.this, CadastroDenuncia_Defesa_Civil.class);
                startActivity(intent);
            }
        });
        Vendaval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Denuncia_defesa_civil.this, CadastroDenuncia_Defesa_Civil.class);
                startActivity(intent);
            }
        });
    }
}