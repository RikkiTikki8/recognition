package com.example.recognition.types.response;

import com.example.recognition.types.data.ColorDataType;

public class ColorResponseType {
    protected String imageUri;
    protected ColorDataType data;
    public String getImage() {
        return imageUri;
    }
    public void setImage(String image) {
        imageUri = image;
    }
    public ColorDataType getData() {
        return data;
    }
    public void setData(ColorDataType data) {
        this.data = data;
    }
}
