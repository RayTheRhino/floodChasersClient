package com.example.floodchasers.Objects;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {
    @SerializedName("Id")
    public String id;
//    @SerializedName("imageData")
//    private ImageData imageData;
    @SerializedName("Body")
    public String body;
    @SerializedName("Title")
    public String title;
    @SerializedName("TimeCreated")
    public String timeCreated ;
    @SerializedName("CommentsIds")
    public List<String> commentsIds;

    public Post(String id, String body, String title, String timeCreated, List<String> commentsIds) {
        this.id = id;
        this.body = body;
        this.title = title;
        this.timeCreated = timeCreated;
        this.commentsIds = commentsIds;
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

    public List<String> getCommentsIds() {
        return commentsIds;
    }

    public void setCommentsIds(List<String> commentsIds) {
        this.commentsIds = commentsIds;
    }
}
