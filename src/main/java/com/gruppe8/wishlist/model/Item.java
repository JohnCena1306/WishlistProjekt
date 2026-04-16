package com.gruppe8.wishlist.model;

public class Item {

    private String name;
    private String description;
    private double price;
    private String link;

    public Item(String name, String description, double price, String link){
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
