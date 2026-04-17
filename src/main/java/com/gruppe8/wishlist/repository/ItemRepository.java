package com.gruppe8.wishlist.repository;

import com.gruppe8.wishlist.model.Item;
import com.gruppe8.wishlist.service.ItemService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public ItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static class ItemRowMapper implements RowMapper<Item> {

        @Override
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Item(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getString("link")
            );
        }
    }

    public List<Item> getAllItems() {
        String sql = "SELECT id, name, description, price, link FROM wishlist_item";
        return jdbcTemplate.query(sql, new ItemRowMapper());
    }

    public Item getItemById(int id){
        String sql = "SELECT id, name, description, price, link FROM wishlist_item WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new ItemRowMapper(), id);
    }


    public int addItem(Item item) {
        String sql = "INSERT INTO wishlist_item (name, description, price, link) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, item.getName(), item.getDescription(), item.getPrice(), item.getLink());
    }

    public int updateItem (Item item){
        String sql = "UPDATE wishlist_item SET name = ?, description = ?, price = ?, link = ? WHERE id = ?";
        return jdbcTemplate.update(sql, item.getName(), item.getDescription(), item.getPrice(), item.getLink(), item.getId());
    }

    public int deleteItem (int id){
        String sql = "DELETE FROM wishlist_item WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}

