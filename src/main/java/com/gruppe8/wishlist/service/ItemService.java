package com.gruppe8.wishlist.service;

import com.gruppe8.wishlist.model.Item;
import com.gruppe8.wishlist.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService (ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems (){
        return itemRepository.getAllItems();
    }
    public List<Item> findItemsByWishlistId(int wishlistId) {
        return itemRepository.findItemsByWishlistId(wishlistId);
    }

    public Item getItemById(int id){
        return itemRepository.getItemById(id);
    }

    public void addItem(Item item){
        itemRepository.addItem(item);
    }

    public void updateItem (Item item){
        itemRepository.updateItem(item);
    }

    public void deleteItemById(int id){
        itemRepository.deleteItem(id);
    }
}
