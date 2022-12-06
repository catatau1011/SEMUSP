package com.example.semusp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.semusp.Denucias.CadastrodaDenuncia_Semma;
import com.example.semusp.R;
import com.example.semusp.config.ConfiguraçãoFirebase;
import com.example.semusp.model.Usuario;
import com.example.semusp.termodeuso;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroActivity extends AppCompatActivity {

    private EditText campoNome,campoEmail,campoTelefone,campoEndereco,campoCpf,campoSenha;
    private Button buttonCadastrar,buttonConvidado;
    private FirebaseAuth autenticacao;
    private Usuario usuario;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();
        campoNome = findViewById(R.id.editAutor);
        campoEmail = findViewById(R.id.editEmail);
        campoTelefone = findViewById(R.id.editTelefone);
        campoEndereco = findViewById(R.id.editEndereco);
        campoCpf = findViewById(R.id.editCpf);
        campoSenha = findViewById(R.id.editSenha);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);


        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoNome = campoNome.getText().toString();
                String textoEmail = campoEmail.getText().toString();
                String textoTelefone = campoTelefone.getText().toString();
                String textoEndereco = campoEndereco.getText().toString();
                String textoCpf = campoCpf.getText().toString();
                String textoSenha = campoSenha.getText().toString();


                //Validar se os campos foram preencidos e tratamento de exceção
                if (!textoNome.isEmpty()){
                    if (!textoEmail.isEmpty()){
                        if (!textoTelefone.isEmpty()){
                            if (!textoEndereco.isEmpty()){
                                if (!textoCpf.isEmpty()){
                                    if (!textoSenha.isEmpty()){
                                        startActivity(new Intent(CadastroActivity.this,LoginActivity.class));
                                        Toast.makeText(CadastroActivity.this,
                                                "Cadastro feito Com sucesso!",
                                                Toast.LENGTH_SHORT).show();
                                            /*usuario = new Usuario();
                                            usuario.setNome(textoNome);
                                            usuario.setEmail(textoEmail);
                                            usuario.setTelefone(textoTelefone);
                                            usuario.setEndereco(textoEndereco);
                                            usuario.setCPF(textoCpf);
                                            usuario.setSenha(textoSenha);
                                            cadastrarUsuario();*/
                                    }else{
                                        Toast.makeText(CadastroActivity.this,
                                                "Preencha sua senha",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }else{
                                    Toast.makeText(CadastroActivity.this,
                                            "Preencha seu CPF",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(CadastroActivity.this,
                                        "Preencha seu Endereço",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(CadastroActivity.this,
                                    "Preencha seu Telefone",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(CadastroActivity.this,
                                "Preencha seu Email",
                                Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(CadastroActivity.this,
                            "Preencha seu nome",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void cadastrarUsuario(){
        autenticacao = ConfiguraçãoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
          usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    database = FirebaseDatabase.getInstance();
                    reference = database.getReference("usuarios");

                    String textoNome = campoNome.getText().toString();
                    String textoEmail = campoEmail.getText().toString();
                    String textoTelefone = campoTelefone.getText().toString();
                    String textoEndereco = campoEndereco.getText().toString();
                    String textoCpf = campoCpf.getText().toString();
                    String textoSenha = campoSenha.getText().toString();

                    Usuario usuario =new Usuario(textoNome,textoEmail,textoTelefone,textoEndereco,textoCpf,textoSenha);
                    reference.child(textoNome).setValue(usuario);

                    Toast.makeText(CadastroActivity.this,
                            "Sucesso ao cadastrar Usuario",
                            Toast.LENGTH_SHORT).show();
                    finish();
                    //abrirOpcoes();
                }else{
                    String excecao = "";
                     try{
                         throw task.getException();
                     }catch (FirebaseAuthWeakPasswordException e){
                            excecao = "Digite uma senha mais forte";
                     }catch (FirebaseAuthInvalidCredentialsException e){
                            excecao = "Por favor digite um email válido";
                     }catch (FirebaseAuthUserCollisionException e){
                            excecao = "Essa conta já foi cadastrada";
                     }catch (Exception e){
                            excecao = " Erro ao cadastrar usuario"+e.getMessage() ;
                            e.printStackTrace();
                     }
                    Toast.makeText(CadastroActivity.this,
                            excecao,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void termodeuso(View v){
        Intent intent = new Intent(CadastroActivity.this, termodeuso.class);
        startActivity(intent);
    }
    public void abrirOpcoes(){
        Intent intent = new Intent(CadastroActivity.this,SelecaoActivity.class);
        startActivity(intent);
        finish();
    }



}