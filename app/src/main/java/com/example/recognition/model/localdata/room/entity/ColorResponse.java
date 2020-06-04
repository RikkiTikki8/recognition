package com.example.recognition.model.localdata.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.recognition.types.ColorDataType;
import org.jetbrains.annotations.NotNull;
@Entity
public class ColorResponse {
    @PrimaryKey
    @NotNull
    protected String image;
    protected static ColorDataType data;
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public static ColorDataType getData() {
        return data;
    }
    public void setData(ColorDataType data) {
        this.data = data;
    }
}
