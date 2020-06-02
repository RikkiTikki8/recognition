package com.example.recognition.types.response;

import com.example.recognition.types.data.ColorDara;

public class ColorResponse {
    protected String imageUri;
    protected ColorDara data;
    protected String model;
    public String getImage() {
        return imageUri;
    }
    public void setImage(String image) {
        imageUri = image;
    }
    public ColorDara getData() {
        return data;
    }
    public void setData(ColorDara data) {
        this.data = data;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
}
