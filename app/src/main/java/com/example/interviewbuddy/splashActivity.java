package com.example.interviewbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class splashActivity extends AppCompatActivity {
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        SharedPreferences sharedPreferences=getSharedPreferences("SharedPref",MODE_PRIVATE);
        name=sharedPreferences.getString("name","");

        if(name.equals(""))
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i=new Intent(splashActivity.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            },1000);
        }
        else
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent in=new Intent(splashActivity.this,HomeActivity.class);
                    startActivity(in);
                    finish();
                }
            },1000);
        }

    }
}
