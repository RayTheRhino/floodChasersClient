package com.example.floodchasers.Boundaries;

import com.example.floodchasers.Objects.Post;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Forum {
    @SerializedName("Id")
    public  String id;
    @SerializedName("Name")
    public String name;
    @SerializedName("Posts")
    public List<Post> posts;

    public Forum() {
    }

    public Forum(String id, String name, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.posts = posts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
