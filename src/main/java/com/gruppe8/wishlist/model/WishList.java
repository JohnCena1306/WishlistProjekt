package com.gruppe8.wishlist.model;

public class WishList {

    private int id;
    private String title;
    private int userId;

    public WishList( int id , String title , int userId ) { //for data der kommer fra databasen (repository)
        this.id = id;
        this.title = title;
        this.userId = userId;

    }
    public WishList(String title, int userId) { //for oprettelse af ny wishlist
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

