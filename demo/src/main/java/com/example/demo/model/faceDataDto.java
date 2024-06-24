package com.example.demo.model;

public class faceDataDto {
    private long id;

    private String username;
    private String phonetic;
    private String face_image;
    private String skin_image;
 

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPhonetic() {
        return phonetic;
    }
    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }
    public String getFace_image() {
        return face_image;
    }
    public void setFace_image(String face_image) {
        this.face_image = face_image;
    }

    public String getSkin_image() {
        return skin_image;
    }
    public void setSkin_image(String skin_image) {
        this.skin_image = skin_image;
    }
}
