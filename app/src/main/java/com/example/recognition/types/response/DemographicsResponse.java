package com.example.recognition.types.response;

import com.example.recognition.types.data.DemographicsData;

public class DemographicsResponse {
    protected String imageUri;
    protected DemographicsData data;
    protected String model;
    public String getImage() {
        return imageUri;
    }
    public void setImage(String image) {
        imageUri = image;
    }
    public DemographicsData getData() {
        return data;
    }
    public void setData(DemographicsData data) {
        this.data = data;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
}
