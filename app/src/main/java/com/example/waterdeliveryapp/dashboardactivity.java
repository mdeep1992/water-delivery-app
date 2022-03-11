package com.example.waterdeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.waterdeliveryapp.databinding.ActivityDashboardactivityBinding;
import com.google.android.material.navigation.NavigationView;

public class dashboardactivity extends drawerbaseactivity {
    ActivityDashboardactivityBinding activityDashboardactivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardactivityBinding=ActivityDashboardactivityBinding.inflate(getLayoutInflater());
        setContentView(activityDashboardactivityBinding.getRoot());
        allocateactivitytitle("Dashboard");
    }
}