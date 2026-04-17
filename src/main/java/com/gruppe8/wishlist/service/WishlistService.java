package com.gruppe8.wishlist.service;

import com.gruppe8.wishlist.model.WishList;
import com.gruppe8.wishlist.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private WishlistRepository wishlistRepository;


    public  WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public void saveWishList(WishList wishList) {
        wishlistRepository.addWishlist(wishList);
    }
    public List<WishList> findAllWishlists() {
        return wishlistRepository.findAll();
    }
}