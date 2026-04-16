package com.gruppe8.wishlist.repository;

import com.gruppe8.wishlist.model.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper<Item> {

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
