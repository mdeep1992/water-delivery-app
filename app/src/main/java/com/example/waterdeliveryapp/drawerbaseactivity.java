package com.example.waterdeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class drawerbaseactivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    @Override
    public void setContentView(View view) {
        drawerLayout=(DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawerbaseactivity,null);
        FrameLayout container=drawerLayout.findViewById(R.id.activitycontainer);
        container.addView(view);
        super.setContentView(drawerLayout);
        toolbar=drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView=drawerLayout.findViewById(R.id.navi_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle
                (this,drawerLayout,toolbar,R.string.menu_drawer_open,R.string.menu_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.nav_order:
                startActivity(new Intent(this, order.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.nav_contactus:
                startActivity(new Intent(this, contactactivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.nav_feedback:
                composeEmail();
                break;
            case R.id.nav_logout:
                finish();
                startActivity(new Intent(this, signinactivity.class));
                overridePendingTransition(0, 0);
                break;
        }
        return false;
    }
    protected void allocateactivitytitle(String titleString){
        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle(titleString);
        }else{
            Log.d("TAG", "allocateactivitytitle: NO acgion bar");
        }
    }
   public void composeEmail() {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "mdeep1992@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "SEND UR FEEDBACK");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        //else{
         //   Toast.makeText(this, "mail", Toast.LENGTH_LONG).show();
      //  }
    }


    }

