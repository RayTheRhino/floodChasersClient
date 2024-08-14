package com.example.floodchasers.Objects;

import com.example.floodchasers.Boundaries.Comment;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {
    @SerializedName("id")
    public String id;
//    @SerializedName("imageData")
//    private ImageData imageData;
    @SerializedName("body")
    public String body;
    @SerializedName("title")
    public String title;
    @SerializedName("timeCreated")
    public String timeCreated ;
    @SerializedName("comments")
    public List<Comment> comments;

    public Post(String id, String body, String title, String timeCreated, List<Comment> comments) {
        this.id = id;
        this.body = body;
        this.title = title;
        this.timeCreated = timeCreated;
        this.comments= comments;
    }

    public Post() {
    }

    public String getBody() {
        return body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setCommentsIds(List<Comment> commentsIds) {
        this.comments = commentsIds;
    }
}
