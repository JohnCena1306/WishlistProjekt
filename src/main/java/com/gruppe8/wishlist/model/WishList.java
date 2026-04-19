package com.gruppe8.wishlist.model;

import java.util.List;

public class WishList {

    private String title;
    private int userId;
    private int id;


    public WishList(int id, String title, int userId) {
        this.title = title;
        this.userId = userId;
        this.id = id;
    }


    public WishList(String title, int userId) {
        this.title = title;
        this.userId = userId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public WishList() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}

