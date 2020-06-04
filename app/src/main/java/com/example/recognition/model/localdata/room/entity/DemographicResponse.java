package com.example.recognition.model.localdata.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.recognition.types.DemographicDataType;

import org.jetbrains.annotations.NotNull;
@Entity
public class DemographicResponse {
    @PrimaryKey
    @NotNull
    protected String image;
    protected DemographicDataType data;
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public DemographicDataType getData() {
        return data;
    }
    public void setData(DemographicDataType data) {
        this.data = data;
    }
}
