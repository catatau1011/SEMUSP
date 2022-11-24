package com.example.semusp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.semusp.config.ConfiguraçãoFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

// Retrofit2
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.converter.gson.GsonConverterFactory;

// MUI
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends IntroActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private FirebaseAuth autenticacao;

    // Base url RestAPI
    // https://mockapi.io/docs
    private String BASE_URL = "https://637fab2b8efcfcedacf4b096.mockapi.io/api/v1/";

    public MainActivity() throws IOException {
    }

//
//    Objeto para decode (desserialização do Json)
    //https://github.com/ThangSuperMan/Android-app-restfull-api-with-nodejs/blob/master/android-java-app/app/src/main/java/com/sinhvien/myapplication/LoginResult.java
    public static class Ocorrencia {
        public int usuario_id;
        public int tipo_denuncia_id;
        public String data_ocorrencia_autuacao;

        public Ocorrencia(int usuario_id, int tipo_denuncia_id, String data_ocorrencia_autuacao) {
            this.usuario_id = usuario_id;
            this.tipo_denuncia_id = tipo_denuncia_id;
            this.data_ocorrencia_autuacao = data_ocorrencia_autuacao;
        }
    }

    // Endpoint Interface com retorno de lista de Objetos (Ocorrencia)
    //https://github.com/ThangSuperMan/Android-app-restfull-api-with-nodejs/blob/master/android-java-app/app/src/main/java/com/sinhvien/myapplication/RetrofitInterface.java
    public interface Ocorrencias {
        @GET("/ocorrencia")
        Call<List<Ocorrencia>> Ocorrencia();
    }

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


        // https://github.com/ThangSuperMan/Android-app-restfull-api-with-nodejs/blob/master/android-java-app/app/src/main/java/com/sinhvien/myapplication/MainActivity.java

        // Instanciando Objeto conector com RestAPI
        Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        // Criando conexão com o endpoint
        Ocorrencias ocorrencias = retrofit.create(Ocorrencias.class);
        // Preparando chamada do endpoint
        Call<List<Ocorrencia>> call = ocorrencias.Ocorrencia();


        // Colocando em fila callback (request de chamada para endpoint)
        //https://github.com/square/retrofit/blob/master/samples/src/main/java/com/example/retrofit/SimpleService.java
        //https://github.com/ThangSuperMan/Android-app-restfull-api-with-nodejs/blob/master/android-java-app/app/src/main/java/com/sinhvien/myapplication/MainActivity.java
        call.enqueue(new Callback<List<Ocorrencia>>() {
            @Override
            public void onResponse(Call<List<Ocorrencia>> call, Response<List<Ocorrencia>> response) {
                if (response.code() == 200) {
                    List<Ocorrencia> result = response.body();
                    Log.d(TAG, String.valueOf(result.get(0).data_ocorrencia_autuacao));

                } else if (response.code() == 400) {
                    Toast.makeText(MainActivity.this, "Wrong Credentials",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Ocorrencia>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });


        verificarUsuarioLogado();// com essa  função o usuario precisa logar só uma vez
    }

    public void btEntrar(View v) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void btCadastrar(View v) {
        startActivity(new Intent(this, CadastroActivity.class));
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