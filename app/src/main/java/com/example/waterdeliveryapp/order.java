package com.example.waterdeliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.waterdeliveryapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;
import java.util.List;

import io.github.muddz.styleabletoast.StyleableToast;

public class order extends drawerbaseactivity implements WaterAdapter.ItemClickListener {
    ActivityOrderBinding activityOrderBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOrderBinding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(activityOrderBinding.getRoot());
        allocateactivitytitle("Orders");

        RecyclerView recyclerView = findViewById(R.id.list_orders);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        WaterAdapter adapter = new WaterAdapter(this, getDummyList());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    List<WaterOrder> getDummyList(){
        List<WaterOrder> list= new ArrayList<>();
        list.add(new WaterOrder("Bisleri","https://www.greatbuyz.com/blog/wp-content/uploads/2018/12/bisleri-mineral-water.png",100,1,5.0));
        list.add(new WaterOrder("Aqua fina","https://www.greatbuyz.com/blog/wp-content/uploads/2018/12/aquafina-mineral-water.png",100,1,4.5));
        list.add(new WaterOrder("Kinley","https://www.greatbuyz.com/blog/wp-content/uploads/2018/12/kinley-mineral-water.png",80,1,4.5));
        list.add(new WaterOrder("Bailley","https://www.greatbuyz.com/blog/wp-content/uploads/2018/12/bailley-mineral-water.png",70,1,4.0));
        list.add(new WaterOrder("Oxyrich","https://www.greatbuyz.com/blog/wp-content/uploads/2018/12/oxyrich-mineral-water.png",60,1,3.5));
        list.add(new WaterOrder("Kingfisher","https://www.greatbuyz.com/blog/wp-content/uploads/2018/12/kingfisher-mineral-water.png",20,1,4.5));
        list.add(new WaterOrder("Vedica","https://www.greatbuyz.com/blog/wp-content/uploads/2018/12/vedica-mineral-water.png",60,1,4.0));
        list.add(new WaterOrder("Tata waterplus","https://www.greatbuyz.com/blog/wp-content/uploads/2018/12/tata-mineral-water-300x169.png",20,1,4.5));
        list.add(new WaterOrder("Qua","https://www.greatbuyz.com/blog/wp-content/uploads/2018/12/qua-mineral-water.png",100,1,4.5));
        list.add(new WaterOrder("Himalayan","https://www.greatbuyz.com/blog/wp-content/uploads/2018/12/himalayan-mineral-water.png",80,1,4.5));
        return list;
    }

    @Override
    public void onItemClick(View view, int position) {

        StyleableToast.makeText(this,"order placed successfully",R.style.mytoast).show();
    }
}