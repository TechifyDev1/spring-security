package com.qudus.springsec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// This class represents a user entity with fields for id, username, and password.
// It can be used to store user information in a database or other data source.
// The class can be annotated with JPA annotations to map it to a database table.
@Entity
public class Users {

    @Id
    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
}
