package com.example.floodchasers.Boundaries;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Comment {
    @SerializedName("id")
    public String id;

    @SerializedName("title")
    public String title;

    @SerializedName("body")
    public String body;

    @SerializedName("timeCreated")
    public String timeCreated;
    @SerializedName("comments")
    public List<Comment> commentBoundaries;

    public Comment() {
    }

    public Comment(String id, String title, String body, String timeCreated, List<Comment> commentBoundaries) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.timeCreated = timeCreated;
        this.commentBoundaries = commentBoundaries;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public List<Comment> getComments() {
        return commentBoundaries;
    }

    public void setComments(List<Comment> commentBoundaries) {
        this.commentBoundaries = commentBoundaries;
    }
}
