package com.example.waterdeliveryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class splashactivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);
        getSupportActionBar().hide();
     TextView textview=findViewById(R.id.splashtext);
        Animation anim = new AlphaAnimation(0.0f, 1.5f);
        anim.setDuration(1000); //You can manage the blinking time with this parameter
        anim.setStartOffset(3500);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        textview.startAnimation(anim);
Thread thread=new Thread() {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Intent intent = new Intent(splashactivity.this, WelcomeActivity.class);
            startActivity(intent);
            finish();

        }
    }

};
thread.start();
    }
}