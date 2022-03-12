package com.example.waterdeliveryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

class WaterAdapter extends RecyclerView.Adapter<WaterAdapter.ViewHolder> {

    private List<WaterOrder> mData;
    private LayoutInflater mInflater;
    private Context context;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    WaterAdapter(Context context, List<WaterOrder> data) {
        this.mInflater = LayoutInflater.from(context);
        this.context=context;
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_order, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WaterOrder waterOrder = mData.get(position);
        holder.txtTitle.setText(waterOrder.title);
        holder.txtPrice.setText("Rs "+waterOrder.price);
        holder.txtQuantity.setText(waterOrder.quantity+" Litre");
        holder.ratingBar.setRating((float) waterOrder.rating);
        Glide.with(context).load(waterOrder.imageUrl).into(holder.img);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtTitle;
        TextView txtPrice;
        TextView txtQuantity;
        RatingBar ratingBar;
        ImageView img;
        Button btnOrder;


        ViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtPrice =itemView.findViewById(R.id.txt_price);
            txtQuantity =itemView.findViewById(R.id.txt_quantity);
            ratingBar =itemView.findViewById(R.id.ratingbar);
            img =itemView.findViewById(R.id.image_logo);
            btnOrder =itemView.findViewById(R.id.btn_order);

           btnOrder.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    WaterOrder getItem(int id) {
        return mData.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

