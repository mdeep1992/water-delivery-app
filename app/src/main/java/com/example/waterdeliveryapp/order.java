package com.example.waterdeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.waterdeliveryapp.databinding.ActivityOrderBinding;

public class order extends drawerbaseactivity {
    ActivityOrderBinding activityOrderBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOrderBinding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(activityOrderBinding.getRoot());
        allocateactivitytitle("Orders");
    }
}