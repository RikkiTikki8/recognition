package com.example.recognition.types.response;

import com.example.recognition.types.data.DemographicData;

public class DemographicsResponse {
    protected String imageUri;
    protected DemographicData data;
    protected String model;
    public String getImage() {
        return imageUri;
    }
    public void setImage(String image) {
        imageUri = image;
    }
    public DemographicData getData() {
        return data;
    }
    public void setData(DemographicData data) {
        this.data = data;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
}
