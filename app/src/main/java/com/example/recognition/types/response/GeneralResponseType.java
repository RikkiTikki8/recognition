package com.example.recognition.types.response;

import com.example.recognition.types.data.GeneralDataType;

public class GeneralResponseType {
    protected String imageUri;
    protected GeneralDataType data;
    public String getImage() {
        return imageUri;
    }
    public void setImage(String image) {
        imageUri = image;
    }
    public GeneralDataType getData() {
        return data;
    }
    public void setData(GeneralDataType data) {
        this.data = data;
    }
}
