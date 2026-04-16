package com.gruppe8.wishlist.model;

import java.util.List;

public class WishlistModel {

    private String name;
    private List<ItemModel> item;

public WishlistModel(String name, List<ItemModel> item){
    this.name = name;
    this.item = item;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemModel> getItem() {
        return item;
    }

    public void setItem(List<ItemModel> item) {
        this.item = item;
    }
}
