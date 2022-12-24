package com.example.foodfly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Spalshscreen1 extends AppCompatActivity {

    private  static int Splash_timeout= Integer.parseInt("250");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalshscreen1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash=new Intent(Spalshscreen1.this,MainActivity2.class);
                startActivity(splash);
                finish();
            }
        },Splash_timeout);
    }
}