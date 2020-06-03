package com.example.recognition.types.response;

import com.example.recognition.types.data.DemographicDataType;

public class DemographicResponseType {
    protected String imageUri;
    protected DemographicDataType data;
    public String getImage() {
        return imageUri;
    }
    public void setImage(String image) {
        imageUri = image;
    }
    public DemographicDataType getData() {
        return data;
    }
    public void setData(DemographicDataType data) {
        this.data = data;
    }
}
