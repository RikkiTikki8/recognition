package com.example.recognition.types.response;
import com.example.recognition.types.data.ColorData;

public class ColorResponse {
    protected String imageUri;
    protected ColorData data;
    protected String model;
    public String getImage() {
        return imageUri;
    }
    public void setImage(String image) {
        imageUri = image;
    }
    public ColorData getData() {
        return data;
    }
    public void setData(ColorData data) {
        this.data = data;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
}
