package com.example.demo.model;

import jakarta.validation.constraints.NotEmpty;

public class saveDto {

    private long id;

    private String title;
    private String face_save;

    @NotEmpty(message = "身体を選択してください")
    private String body_save;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFace_save() {
        return face_save;
    }
    public void setFace_save(String face_save) {
        this.face_save = face_save;
    }

    public String getBody_save() {
        return body_save;
    }
    public void setBody_save(String body_save) {
        this.body_save = body_save;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
