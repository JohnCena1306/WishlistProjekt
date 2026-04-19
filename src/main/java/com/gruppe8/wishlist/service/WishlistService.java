package com.gruppe8.wishlist.service;

import com.gruppe8.wishlist.model.WishList;
import com.gruppe8.wishlist.repository.WishlistRepository;
import org.springframework.stereotype.Service;

@Service
public class WishlistService {

    private WishlistRepository wishlistRepository;


    public  WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public void saveWishList(WishList wishList){

        wishlistRepository.addWishlist(wishList);

    }

    public void deleteWishListByTitle(int id){

        wishlistRepository.deleteWishListByTitle(id);
    }



}