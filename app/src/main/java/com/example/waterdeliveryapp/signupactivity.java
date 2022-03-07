package com.example.waterdeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import io.github.muddz.styleabletoast.StyleableToast;

public class signupactivity extends AppCompatActivity {
    EditText editTextUserName;
    EditText editTextPassword;
    EditText editTextphoneno;
    EditText editTextEmail;
    Button btnregister;
    private FirebaseAuth mAuth;
    ProgressBar progressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        editTextUserName=(EditText) findViewById(R.id.editTextUserName);
        editTextPassword=(EditText) findViewById(R.id.editTextPassword);
        editTextphoneno=(EditText) findViewById(R.id.editTextPhoneno);
        editTextEmail=(EditText) findViewById(R.id.editTextEmail);
        btnregister=findViewById(R.id.btnregister);
        progressbar=findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();

btnregister.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        String txtUsername=editTextUserName.getText().toString().trim();
        String txtpassword=editTextPassword.getText().toString().trim();
        String txtEmail=editTextEmail.getText().toString().trim();
        String txtphoneno=editTextphoneno.getText().toString().trim();


        if(txtUsername.isEmpty()){
            editTextUserName.setError("pls enter username");
            editTextUserName.requestFocus();
        } else  if (txtEmail.isEmpty()){
            editTextEmail.setError("pls enter the email address");
            editTextEmail.requestFocus();
        }
         else if (txtphoneno.length()!=10){
            editTextphoneno.setError("pls enter the mobilenumber");
            editTextphoneno.requestFocus();
        }
         else if (txtpassword.length()<6){
            editTextPassword.setError("pls enter the password containing atleast six digits");
            editTextPassword.requestFocus();
        }
     else {
            progressbar.setVisibility(view.VISIBLE);
            mAuth.createUserWithEmailAndPassword(txtEmail, txtpassword)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                user user = new user(txtUsername, txtpassword,  txtphoneno,txtEmail);
                                FirebaseDatabase.getInstance().getReference("user").child(FirebaseAuth.getInstance().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            StyleableToast.makeText(signupactivity.this,"user registered successfully",R.style.mytoast).show();
                                            progressbar.setVisibility(View.GONE);
                                        } else {
                                            StyleableToast.makeText(signupactivity.this,"registerion failed",R.style.mytoast).show();
                                        }
                                        progressbar.setVisibility(View.GONE);
                                    }
                                });
                            } else {
                                StyleableToast.makeText(signupactivity.this,"registerion failed",R.style.mytoast).show();
                                progressbar.setVisibility(View.GONE);
                            }
                        }
                    });
        }

    }
});
    }
}