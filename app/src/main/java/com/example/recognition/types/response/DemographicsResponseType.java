package com.example.recognition.types.response;

import com.example.recognition.types.data.DemographicsDataType;

public class DemographicsResponseType {
    protected String imageUri;
    protected DemographicsDataType data;
    public String getImage() {
        return imageUri;
    }
    public void setImage(String image) {
        imageUri = image;
    }
    public DemographicsDataType getData() {
        return data;
    }
    public void setData(DemographicsDataType data) {
        this.data = data;
    }
}
