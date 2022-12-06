package com.example.semusp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.example.semusp.Denucias.CadastrodaDenuncia_Semma;
import com.example.semusp.R;
import com.example.semusp.config.ConfiguraçãoFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

public class MainActivity extends IntroActivity {
    private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setButtonBackVisible(false);
        setButtonNextVisible(false);
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_1)
                .build());
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_2)
                .canGoForward(false)//apartir desse slide não fecha
                .build());
        /*addSlide( new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_cadastro)
                .canGoForward(false)//apartir desse slide não fecha
                .build());*/

    }

    @Override
    protected void onStart() {
        super.onStart();
        verificarUsuarioLogado();// com essa  função o usuario precisa logar só uma vez
    }

    public void btEntrar(View v) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void btCadastrar(View v) {
        startActivity(new Intent(this, CadastroActivity.class));
    }
    public void btConvidado(View v) {
        startActivity(new Intent(this, CadastrodaDenuncia_Semma.class));
        Toast.makeText(MainActivity.this,
                "Realize o cadastro da sua denuncia!\n Convidado",Toast.LENGTH_SHORT).show();
    }
    //Aqui é onde manda o usuario pra tela principal

    public void verificarUsuarioLogado() {
        autenticacao = ConfiguraçãoFirebase.getFirebaseAutenticacao();
        if (autenticacao.getCurrentUser() != null) {
            abrirOpcoes();
        }
    }

    public void abrirOpcoes() {
        Intent intent = new Intent(MainActivity.this, SelecaoActivity.class);
        startActivity(intent);
        finish();

    }
}