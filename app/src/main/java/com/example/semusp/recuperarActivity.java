package com.example.semusp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.semusp.config.ConfiguraçãoFirebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;

public class recuperarActivity extends AppCompatActivity {
        EditText emailEditext;
        Button resetPassowd;
        FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);

        emailEditext = findViewById(R.id.editEmail3);
        resetPassowd = findViewById(R.id.resetPassoword);

        auth = ConfiguraçãoFirebase.getFirebaseAutenticacao();

        resetPassowd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resestPassord();
            }
        });
    }

    private void resestPassord() {
        String email = emailEditext.getText().toString().trim();

        if (email.isEmpty()){
            emailEditext.setError("e-mail é obrigatório");
            emailEditext.requestFocus();
            return;
        }

        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditext.setError("Forneça um email valido!");
            emailEditext.requestFocus();
            return;
        }

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(recuperarActivity.this,"Verifique seu email para redefinir sua senha",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(recuperarActivity.this,"tente novamente algo de errado aconteceu",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}