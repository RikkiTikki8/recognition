package com.example.recognition.model.localdata.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ColorResponse {
    @PrimaryKey
    private String image;
    private String data;
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}
