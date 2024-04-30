package com.example.floodchasers.Boundaries;

import com.google.gson.annotations.SerializedName;

public class LearnBoundary {
    @SerializedName("urlToImage")
    public String UrlToImage;
    @SerializedName("content")
    public String Content ;
    @SerializedName("title")
    public String Title;
    @SerializedName("author")
    public String Author;
    @SerializedName("publishedAt")
    public String PublishedAt;
    @SerializedName("url")
    public String Url;

    public String getUrlToImage() {
        return UrlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        UrlToImage = urlToImage;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublishedAt() {
        return PublishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        PublishedAt = publishedAt;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
