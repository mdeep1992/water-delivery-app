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
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

import io.github.muddz.styleabletoast.StyleableToast;

public class signinactivity extends AppCompatActivity {
    EditText edittextusername,edittextpassword;
    TextView textviewforgotpassword,textViewregister;
    Button btnsignin1;
    ProgressBar progressBar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinactivity);
        edittextusername=findViewById(R.id.edittextsigninusername);
        edittextpassword=findViewById(R.id.edittextsigninPassword);
        textviewforgotpassword=findViewById(R.id.txtsigninforgotpassword);
        textViewregister=findViewById(R.id.txtsigninregister);
        btnsignin1=findViewById(R.id.btnsignin1);
        progressBar=findViewById(R.id.signinprogressBar);
        mAuth=FirebaseAuth.getInstance();

    textviewforgotpassword.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
Intent intent=new Intent(signinactivity.this,forgotpasswordactivity.class);
startActivity(intent);
        }
    });

    textViewregister.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(signinactivity.this,signupactivity.class);
startActivity(intent);
        }
    });
        btnsignin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edittextusername.getText().toString().trim();
                String password=edittextpassword.getText().toString().trim();
                if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()){
                    edittextusername.setError("enter the valid email");
                    edittextusername.requestFocus();
                }
else if (edittextpassword.length()<6){
    edittextpassword.setError("pls enter the password containing atleast 6 characters");
    edittextpassword.requestFocus();
}else {
                    progressBar.setVisibility(view.VISIBLE);
                    mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                progressBar.setVisibility(View.GONE);
                                StyleableToast.makeText(signinactivity.this, "successfully signed", R.style.mytoast).show();
                            } else {
                                progressBar.setVisibility(View.GONE);
                                StyleableToast.makeText(signinactivity.this, " signin failure", R.style.mytoast).show();
                            }
                        }
                    });
                }
            }
        });
    }




}