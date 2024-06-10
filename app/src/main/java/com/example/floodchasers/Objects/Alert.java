package com.example.floodchasers.Objects;
public class Alert {
    private String location;
    private String description;
    private String date;
    private String time;
    private String severity;
    private String tags;
    private String lat;
    private String Long;

    // Constructor, getters, and setters
    public Alert(String location, String description, String date, String time, String severity, String tags) {
        this.location = location;
        this.description = description;
        this.date = date;
        this.time = time;
        this.severity = severity;
        this.tags = tags;
        this.lat = "";
        this.Long = "";
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getLat() { return lat; }
    public String getLong() { return Long; }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getSeverity() {
        return severity;
    }

    public String getTags() {
        return tags;
    }
}
