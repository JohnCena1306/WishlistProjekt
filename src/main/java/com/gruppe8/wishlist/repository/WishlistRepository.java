package com.gruppe8.wishlist.repository;


import com.gruppe8.wishlist.model.WishList;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class WishlistRepository {

    private final JdbcTemplate jdbcTemplate;

    public WishlistRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class WishListRowMapper implements RowMapper<WishList> {

        @Override
        public WishList mapRow(ResultSet rs, int rowNum) throws SQLException {

            return new WishList(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getInt("user_id")
            );
        }
    }

    public void addWishlist(WishList wishlist) {

        String insertSql = "INSERT into wishlist(user_id, title) VALUES(?, ?)";
        jdbcTemplate.update(insertSql, wishlist.getUserId(), wishlist.getTitle());
    }

    public List<WishList> findAll() {
        String selectSql = "SELECT id, title, user_id FROM wishlist";
        return jdbcTemplate.query(selectSql, new WishListRowMapper());
    }

    public void deleteWishListByTitle(int id){
        String sql = "DELETE from wishlist where id = ?";
        jdbcTemplate.update(sql, id);
    }
}