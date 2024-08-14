package com.example.floodchasers.Objects;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("userName")
    String username;
    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;
    @SerializedName("id")
    String  id;

    public User() {
    }
    public User(String username, String email, String password, String id) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
//    String ImageUsrl ??

}
