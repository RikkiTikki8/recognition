package com.example.recognition.model.localdata.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Model {
    @PrimaryKey
    private String model;
    public Model(String model) {
        this.model = model;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
}
