package com.gruppe8.wishlist.model;

import org.apache.catalina.User;

import java.time.LocalDate;

public class UserModel {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;

    public UserModel() {
    }

    public UserModel(String firstName, String lastName, LocalDate birthDate, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}
