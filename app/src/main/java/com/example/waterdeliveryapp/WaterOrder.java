package com.example.waterdeliveryapp;

public class WaterOrder {

    final String title;
    final String imageUrl;
    final double price;
    final double quantity;

    final double rating;

    public WaterOrder(String title, String imageUrl, double price, double quantity, double rating) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.price = price;
        this.quantity = quantity;
        this.rating = rating;
    }
}
