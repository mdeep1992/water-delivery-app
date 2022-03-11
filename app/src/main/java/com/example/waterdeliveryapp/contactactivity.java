package com.example.waterdeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.waterdeliveryapp.databinding.ActivityContactactivityBinding;

public class contactactivity extends drawerbaseactivity {
    ActivityContactactivityBinding activityContactactivityBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityContactactivityBinding=ActivityContactactivityBinding.inflate(getLayoutInflater());
        setContentView(activityContactactivityBinding.getRoot());
        allocateactivitytitle("Contact us");
    }
}