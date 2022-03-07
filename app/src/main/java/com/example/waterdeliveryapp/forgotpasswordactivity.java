package com.example.waterdeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;

import io.github.muddz.styleabletoast.StyleableToast;

public class forgotpasswordactivity extends AppCompatActivity {
    EditText edittextemail;
    Button btnresetpasswoed;
    FirebaseAuth mAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpasswordactivity);
        edittextemail=findViewById(R.id.editTextforgotpasswordemail);
        btnresetpasswoed=findViewById(R.id.btnresetpassword);
        mAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.forgotprogressBar);

        btnresetpasswoed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetpassword();

            }
            public void resetpassword(){
                String email=edittextemail.getText().toString().trim();
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    edittextemail.setError("pls enter the valid email");
                    edittextemail.requestFocus();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            StyleableToast.makeText(forgotpasswordactivity.this,"pls check ur email for reset link",R.style.mytoast).show();
                            Intent intent=new Intent(forgotpasswordactivity.this,signinactivity.class);
                            startActivity(intent);
                            progressBar.setVisibility(View.GONE);
                        }else {
                            StyleableToast.makeText(forgotpasswordactivity.this,"failed to reset",R.style.mytoast).show();
                        }
                    }
                });

            }
        });
    }
}