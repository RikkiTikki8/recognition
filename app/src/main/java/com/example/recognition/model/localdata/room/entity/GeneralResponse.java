package com.example.recognition.model.localdata.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.recognition.types.GeneralDataType;

import org.jetbrains.annotations.NotNull;
@Entity
public class GeneralResponse {
    @PrimaryKey
    @NotNull
    protected String image;
    protected GeneralDataType data;
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public GeneralDataType getData() {
        return data;
    }
    public void setData(GeneralDataType data) {
        this.data = data;
    }
}
