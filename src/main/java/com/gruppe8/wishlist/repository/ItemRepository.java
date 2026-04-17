package com.gruppe8.wishlist.repository;

import com.gruppe8.wishlist.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public ItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Item> getAllItems() {
        String sql = "SELECT id, name, description, price, link FROM wishlist_item";
        return jdbcTemplate.query(sql, new ItemRowMapper());
    }


    public int addItem(Item item) {
        String sql = "INSERT INTO wishlist_item (name, description, price, link) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, item.getName(), item.getDescription(), item.getPrice(), item.getLink());
    }

    public int updateItem (Item item){
        String sql = "UPDATE wishlist_item SET name = ?, description = ?, price = ?, link = ? WHERE id = ?";
        return jdbcTemplate.update(sql, item.getId(), item.getName(), item.getDescription(), item.getPrice(), item.getLink());
    }

    public int deleteItem (int id){
        String sql = "DELETE FROM wishlist_item WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}

