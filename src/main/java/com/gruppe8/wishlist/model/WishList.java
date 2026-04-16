package com.gruppe8.wishlist.model;

import java.util.List;

public class WishList {

    private String title;
    private int userId;


    public WishList(String title, int userId) {
        this.title = title;
        this.userId = userId;
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

