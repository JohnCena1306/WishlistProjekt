package com.gruppe8.wishlist.controller;

import com.gruppe8.wishlist.model.Item;
import com.gruppe8.wishlist.service.ItemService;
import com.gruppe8.wishlist.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ItemController {

    private final ItemService itemService;
    private final WishlistService wishlistService;

    public ItemController( ItemService itemService , WishlistService wishlistService) {
        this.itemService = itemService;
        this.wishlistService = wishlistService;
    }

    @GetMapping ( "/items" )
    public String showItems( Model model ) {
        model.addAttribute("items" , itemService.getAllItems());
        return "item";
    }

    @GetMapping ( "/showAddItem" )
    public String showAddItem(
            @RequestParam(required = false) Integer wishlistId,
            @RequestParam(required = false) String name ,
            @RequestParam(required = false) String description ,
            @RequestParam(required = false) Double price ,
            Model model ) {

        Item item = new Item();

        if (wishlistId != null) {
            item.setWishlistId(wishlistId);
        }

        if (name != null) {
            item.setName(name);
        }
        if (description != null) {
            item.setDescription(description);
        }
        if (price != null) {
            item.setPrice(price);
        }
        model.addAttribute("item" , item);
        model.addAttribute("wishlists", wishlistService.findAllWishlists());
        return "saveItem";
    }

    @GetMapping ( "/wishlist/{id}/items" )
    public String showItemsByWishlist( @PathVariable int id , Model model ) {
        model.addAttribute("items" , itemService.findItemsByWishlistId(( id )));
        model.addAttribute("wishlistId" , id);
        return "item";

    }

    @GetMapping ( "/items/updateItem/{id}" )
    public String updateItem( @PathVariable int id , Model model ) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item" , item);
        model.addAttribute("wishlists", wishlistService.findAllWishlists());
        return "saveItem";
    }

    @PostMapping ( "/saveItem" )
    public String saveAddItem( @ModelAttribute Item item ) {

        System.out.println("WishlistId: " + item.getWishlistId());

        if (item.getId() == 0) {
            itemService.addItem(item);
        } else {
            itemService.updateItem(item);
        }
        return "redirect:/wishlist/" + item.getWishlistId() + "/items";
    }

    @GetMapping ( "/items/deleteItem/{id}" )
    public String deleteItem( @PathVariable int id ) {
        itemService.deleteItemById(id);
        return "redirect:/items";
    }

}
