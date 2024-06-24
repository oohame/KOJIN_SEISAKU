package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mens", schema = "fusion_db")
public class menBody {
    @Id
    private long id;

    private String men_image;
 

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getMen_image() {
        return men_image;
    }
    public void setMen_image(String men_image) {
        this.men_image = men_image;
    }

}
