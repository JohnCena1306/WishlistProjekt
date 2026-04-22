package com.gruppe8.wishlist.service;

import com.gruppe8.wishlist.model.Item;
import com.gruppe8.wishlist.model.User;
import com.gruppe8.wishlist.repository.ItemRepository;
import com.gruppe8.wishlist.repository.UserRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService (UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser (User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.addUser(user);
    }

}
