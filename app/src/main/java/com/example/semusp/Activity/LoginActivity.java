package com.example.semusp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.semusp.R;
import com.example.semusp.config.ConfiguraçãoFirebase;
import com.example.semusp.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class LoginActivity extends AppCompatActivity {

    private EditText campoEmail,campoSenha;
    private Button botaoentrar,botaoConvidado;
    private Usuario usuario;
    private FirebaseAuth autenticacao;
    private TextView recuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //função pra olcutar a toolbar;
        getSupportActionBar().hide();

        campoEmail = findViewById(R.id.editEmail1);
        campoSenha = findViewById(R.id.editSenha1);
        botaoentrar = findViewById(R.id.btnEntrar);
        //autenticacao = FirebaseAuth.getInstance();

        recuperar = findViewById(R.id.recuparar);
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,recuperarActivity.class));
            }
        });

        botaoentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                if (!textoEmail.isEmpty()){
                    if (!textoSenha.isEmpty()){
                        startActivity(new Intent(LoginActivity.this,SelecaoActivity.class));
                        Toast.makeText(LoginActivity.this,
                                "Login feito com sucesso!\n Aproveite o App",Toast.LENGTH_SHORT).show();
                        /*usuario = new Usuario();
                        usuario.setEmail(textoEmail);
                        usuario.setSenha(textoSenha);
                        validarLogin();*/
                    }else{
                        Toast.makeText(LoginActivity.this,
                                "Digite sua senha",
                                Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this,
                            "Digite seu email",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void validarLogin(){
        autenticacao = ConfiguraçãoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    abrirOpcoes();
                }else {
                    String excecao = "";
                    try{
                        throw task.getException();
                    }catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = "Email e senha não correspodem ao usuario cadastrado ";
                    }catch (FirebaseAuthInvalidUserException e){
                        excecao = "Usuario não esta cadastrado";

                    }catch (Exception e){
                        excecao = " Erro ao cadastrar usuario"+e.getMessage() ;
                        e.printStackTrace();
                    }
                    Toast.makeText(LoginActivity.this,
                            excecao,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void abrirOpcoes(){
        Intent intent = new Intent(LoginActivity.this,SelecaoActivity.class);
        startActivity(intent);
        finish();
    }

    public void convidado(View v){

    }

}