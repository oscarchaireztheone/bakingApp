package com.example.android.bakingapp.model;

public class Step {
    private String id;
    private String sDescription;
    private String description;
    private String videoURL;
    private String ThumbNailURL;

    public Step(String id, String sDescription, String description, String thumbNailURL) {
        this.id = id;
        this.sDescription = sDescription;
        this.description = description;
        ThumbNailURL = thumbNailURL;
    }

    public Step(String id, String sDescription, String description, String videoURL, String thumbNailURL) {
        this.id = id;
        this.sDescription = sDescription;
        this.description = description;
        this.videoURL = videoURL;
        ThumbNailURL = thumbNailURL;
    }

    public Step() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getThumbNailURL() {
        return ThumbNailURL;
    }

    public void setThumbNailURL(String thumbNailURL) {
        ThumbNailURL = thumbNailURL;
    }
}
