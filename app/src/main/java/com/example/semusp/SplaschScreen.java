package com.example.semusp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.window.SplashScreen;

public class SplaschScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splasch_screen);
        getSupportActionBar().hide();


        Thread thread = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(3000);
                    startActivity(new Intent(SplaschScreen.this,MainActivity.class));
                    finish();
                }catch (Exception e){

                }
            }
        };thread.start();
    }
    }
