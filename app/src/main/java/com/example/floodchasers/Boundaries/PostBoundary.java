package com.example.floodchasers.Boundaries;

import com.example.floodchasers.Objects.Post;

import java.util.List;

public class PostBoundary {
    public String id;
    public List<Post> posts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
