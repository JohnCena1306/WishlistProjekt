package com.gruppe8.wishlist.controller;

import com.gruppe8.wishlist.model.Item;
import com.gruppe8.wishlist.repository.ItemRepository;
import com.gruppe8.wishlist.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ItemController {

    private final ItemService itemService;

    public ItemController (ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping ("/items")
    public String showItems (Model model){
        model.addAttribute("items", itemService.getAllItems());
        return "item";
    }

    @GetMapping ("/showAddItem/{id}")
    public String showAddItem (@PathVariable int id, Model model){
        Item item = new Item();
        item.setWishlistId(id);
        model.addAttribute("item", item);
        return "saveItem";
    }
    @GetMapping("/wishlist/{id}/items")
    public String showItemsByWishlist(@PathVariable int id, Model model) {
    model.addAttribute("items", itemService.findItemsByWishlistId((id)));
    model.addAttribute("wishlistId", id);
    return "item";

    }

    @GetMapping ("/items/updateItem/{id}")
    public String updateItem(@PathVariable int id, Model model){
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "saveItem";
    }

    @PostMapping ("/saveItem")
    public String saveAddItem(@ModelAttribute Item item) {
        if (item.getId() == 0){
            itemService.addItem(item);
        }
            else{
            itemService.updateItem(item);
        }
        return "redirect:/wishlist/" + item.getWishlistId() + "/items";
    }

    @GetMapping ("/items/deleteItem/{id}")
    public String deleteItem(@PathVariable int id){
        itemService.deleteItemById(id);
        return "redirect:/items";
    }

    @GetMapping("/wishlist/{id}")
    public String showWishList(@PathVariable int id, Model model) {

        List<Item> items = itemService.findItemsByWishlistId(id);

        model.addAttribute("items", items);

        return "wishlist-items";

    }

}
