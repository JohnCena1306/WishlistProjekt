package com.gruppe8.wishlist.service;

import com.gruppe8.wishlist.model.WishList;
import com.gruppe8.wishlist.repository.ItemRepository;
import com.gruppe8.wishlist.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private final ItemRepository itemRepository;
    private WishlistRepository wishlistRepository;


    public WishlistService(WishlistRepository wishlistRepository, ItemRepository itemRepository) {
        this.wishlistRepository = wishlistRepository;
        this.itemRepository = itemRepository;
    }

    public void saveWishList(WishList wishList) {

        wishlistRepository.addWishlist(wishList);
    }

    public void deleteWishListByTitle(int id) {

        wishlistRepository.deleteWishListByTitle(id);
    }
    public List<WishList> findAllWishlists() {
        return wishlistRepository.findAll();
    }

    public void deleteWishListByTitle(int id) {

        itemRepository.deleteByWishListId(id);
        wishlistRepository.deleteWishList(id);
    }


}