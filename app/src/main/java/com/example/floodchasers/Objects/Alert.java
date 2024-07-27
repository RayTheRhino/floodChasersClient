package com.example.floodchasers.Objects;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Alert {
    @SerializedName("id")
    private String id;
    @SerializedName("headline")
    private String headline;
    @SerializedName("description")
    private String description;
    @SerializedName("timeCreated")
    private Date timeCreated;
    @SerializedName("timeUpdated")
    private Date timeUpdated;
    @SerializedName("areas")
    private String areas;
    @SerializedName("severity")
    private String severity;
    @SerializedName("lat")
    private double lat;
    @SerializedName("lang")
    private double lang;

    public Alert() {
    }

    public Alert(String id, String headline, String description, Date timeCreated, Date timeUpdated, String areas, String severity, double lat, double lang) {
        this.id = id;
        this.headline = headline;
        this.description = description;
        this.timeCreated = timeCreated;
        this.timeUpdated = timeUpdated;
        this.areas = areas;
        this.severity = severity;
        this.lat = lat;
        this.lang = lang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Date timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLang() {
        return lang;
    }

    public void setLang(double lang) {
        this.lang = lang;
    }
}

