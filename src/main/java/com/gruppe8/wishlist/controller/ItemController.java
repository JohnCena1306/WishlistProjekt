package com.gruppe8.wishlist.controller;

import com.gruppe8.wishlist.model.Item;
import com.gruppe8.wishlist.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping ("/saveItem")
    public String showAddItem (Model model){
        model.addAttribute("item", new Item());
        return "saveItem";
    }




}
