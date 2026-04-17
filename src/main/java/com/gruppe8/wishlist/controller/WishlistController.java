package com.gruppe8.wishlist.controller;


import com.gruppe8.wishlist.model.WishList;
import com.gruppe8.wishlist.repository.WishlistRepository;
import com.gruppe8.wishlist.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class WishlistController {

    private final WishlistService wishlistService;
    private final WishlistRepository wishlistRepository;

    public WishlistController(WishlistRepository wishlistRepository, WishlistService wishlistService) {

        this.wishlistRepository = wishlistRepository;
        this.wishlistService = wishlistService;

    }



    @GetMapping("/showwishlists")
    public String showWishLists(Model model) {
        model.addAttribute("Wishlist", wishlistRepository.findAll());
        return "wishlist";
    }


    @PostMapping("/add")
    public String saveWishList(@ModelAttribute("form") WishList form) {

        WishList wishList = new WishList(
                form.getTitle(),
                form.getUserId());

        wishlistService.saveWishList(wishList);
        return "redirect:/showwishlists";
    }


}
