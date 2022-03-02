package com.example.waterdeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {
Button btnSignIn,btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        btnSignIn=findViewById(R.id.btn_signin);
        btnSignUp=findViewById(R.id.btn_signup);



    }
}