package com.gruppe8.wishlist.model;

import java.util.List;

public class WishList {

    private int id;
    private String title;
    private int userId;

    public WishList() {
    }

    public WishList(int id, String title, int userId) {
        this.id = id;
        this.title = title;
        this.userId = userId;
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

