package com.example.recognition.types;

import com.example.recognition.types.data.GeneralData;

public class GeneralResponse {
    protected String imageUri;
    protected GeneralData data;
    public String getImage() {
        return imageUri;
    }
    public void setImage(String image) {
        imageUri = image;
    }
    public GeneralData getData() {
        return data;
    }
    public void setData(GeneralData data) {
        this.data = data;
    }
}
