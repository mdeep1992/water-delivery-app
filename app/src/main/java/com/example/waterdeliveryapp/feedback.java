package com.example.waterdeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.waterdeliveryapp.databinding.ActivityFeedbackBinding;

public class feedback extends drawerbaseactivity{
    ActivityFeedbackBinding activityFeedbackBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFeedbackBinding=ActivityFeedbackBinding.inflate(getLayoutInflater());
        setContentView(activityFeedbackBinding.getRoot());
        allocateactivitytitle("Feedback");
    }
}