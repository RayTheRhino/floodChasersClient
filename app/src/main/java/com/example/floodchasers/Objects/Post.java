package com.example.floodchasers.Objects;

import java.util.List;

public class Post {
    public String body;
    public String title;
    public String timeCreated ;
    public List<String> commentsIds;

    public String getBody() {
        return body;
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
