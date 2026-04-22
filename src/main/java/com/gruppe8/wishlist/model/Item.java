package com.gruppe8.wishlist.model;

public class Item {

    private int id;
    private String name;
    private String description;
    private double price;
    private String link;
    private Integer wishlistId;

    public Item(int id, String name, String description, double price, String link, Integer wishlistId){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;
        this.wishlistId = wishlistId;
    }

    public Item(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public Integer getWishlistId() {
        return wishlistId;
    }
    public void setWishlistId(Integer wishlistId) {

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }
}
