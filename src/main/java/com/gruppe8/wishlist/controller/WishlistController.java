package com.gruppe8.wishlist.controller;


import com.gruppe8.wishlist.model.Item;
import com.gruppe8.wishlist.model.WishList;
import com.gruppe8.wishlist.repository.ItemRepository;
import com.gruppe8.wishlist.repository.WishlistRepository;
import com.gruppe8.wishlist.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.gruppe8.wishlist.repository.ItemRepository;
import com.gruppe8.wishlist.service.ItemService;


import java.util.List;

@Controller
public class WishlistController {

    private final WishlistService wishlistService;
    private final WishlistRepository wishlistRepository;

    public WishlistController(WishlistRepository wishlistRepository, WishlistService wishlistService) {

        this.wishlistRepository = wishlistRepository;
        this.wishlistService = wishlistService;

    }


    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/show")
    public String showWishLists(Model model) {

        model.addAttribute("wishlists", wishlistRepository.findAll());
        return "wishlist";
    }


    @PostMapping("/save")
    public String saveWishList(@ModelAttribute("form") WishList form) {

        WishList wishList = new WishList(
                form.getTitle(),
                1);

        wishlistService.saveWishList(wishList);
        return "redirect:/show";
    }

    @GetMapping("/add")
    public String addWishList(Model model) {
        model.addAttribute("form" , new WishList());
        //model.addAttribute("allTags", service.getTags());
        return "addwishlist";

    }

    @GetMapping ("/wishlist/deletewishlist/{id}")
    public String deleteItem(@PathVariable int id) {
        wishlistService.deleteWishListByTitle(id);
        return "redirect:/show";
    }






}
