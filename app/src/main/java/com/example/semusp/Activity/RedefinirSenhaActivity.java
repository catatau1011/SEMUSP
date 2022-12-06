package com.example.semusp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.semusp.R;

public class RedefinirSenhaActivity extends AppCompatActivity {
    private EditText editCodigo,editNovaSenha,editRepitaSenha;
    private Button novaSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redefinir_senha);
        getSupportActionBar().hide();

        editCodigo = findViewById(R.id.editCodigo);
        editNovaSenha = findViewById(R.id.editNovaSenha);
        editRepitaSenha = findViewById(R.id.editRepitaSenha);

        novaSenha =findViewById(R.id.btnNovaSenha);

        novaSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Codigo = editCodigo.getText().toString();
                String SenhaNova = editNovaSenha.getText().toString();
                String ReputaSenha = editRepitaSenha.getText().toString();

                if (!Codigo.isEmpty() && !SenhaNova.isEmpty() && !ReputaSenha.isEmpty()){
                    Toast.makeText(RedefinirSenhaActivity.this,"Senha reedefinida com sucesso",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RedefinirSenhaActivity.this,LoginActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(RedefinirSenhaActivity.this,"Prencha Todos os campos",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}