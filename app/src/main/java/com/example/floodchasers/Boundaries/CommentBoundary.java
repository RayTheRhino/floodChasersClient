package com.example.floodchasers.Boundaries;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class CommentBoundary {
    @SerializedName("Id")
    public String id;

    @SerializedName("Title")
    public String title;

    @SerializedName("Body")
    public String body;

    @SerializedName("TimeCreated")
    public Date timeCreated;
    @SerializedName("Comments")
    public List<CommentBoundary> commentBoundaries;

    public CommentBoundary() {
    }

    public CommentBoundary(String id, String title, String body, Date timeCreated, List<CommentBoundary> commentBoundaries) {
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

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public List<CommentBoundary> getComments() {
        return commentBoundaries;
    }

    public void setComments(List<CommentBoundary> commentBoundaries) {
        this.commentBoundaries = commentBoundaries;
    }
}
