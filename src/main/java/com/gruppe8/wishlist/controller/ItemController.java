package com.gruppe8.wishlist.controller;

import com.gruppe8.wishlist.model.Item;
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

    @GetMapping ("/showAddItem")
    public String showAddItem (Model model){
        model.addAttribute("item", new Item());
        return "saveItem";
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
            itemService.saveItem(item);
        }
            else{
            itemService.updateItem(item);
        }
        return "redirect:/items";
    }

    @GetMapping ("/items/deleteItem/{id}")
    public String deleteItem(@PathVariable int id){
        itemService.deleteItemById(id);
        return "redirect:/items";
    }

}
