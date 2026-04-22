package com.gruppe8.wishlist.model;

public class Inspiration {

    private String brand;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private String tag;

    public Inspiration(String brand, String name, String description, double price, String imageUrl, String tag) {
        this.brand = brand;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.tag = tag;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTag() {
        return tag;
    }
}