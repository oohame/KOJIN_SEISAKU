package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "saves", schema = "fusion_db")
public class saveData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDは自動的に増加します
    private long id;

    private String title;
    private String face_save;
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
