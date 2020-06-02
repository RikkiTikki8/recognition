package com.example.recognition.model;

import com.example.recognition.model.remoutdata.ColorResponsePojo;
import com.example.recognition.model.remoutdata.DemographicsResponsePojo;
import com.example.recognition.model.remoutdata.GeneralResponsePojo;
import com.example.recognition.types.data.ColorDataType;
import com.example.recognition.types.data.DemographicDataType;
import com.example.recognition.types.data.GeneralDataType;
import com.example.recognition.types.response.ColorResponseType;
import com.example.recognition.types.response.DemographicsResponseType;
import com.example.recognition.types.response.GeneralResponseType;

public class ResponseConverter {
    public static GeneralResponseType convert (String image, GeneralResponsePojo response) {
        GeneralResponseType responseType = new GeneralResponseType();
        responseType.setImage(image);
        GeneralDataType dataType = new GeneralDataType();
        // TO_DO
        responseType.setData(dataType);
        return responseType;
    }
    public static DemographicsResponseType convert (String image, DemographicsResponsePojo response) {
        DemographicsResponseType responseType = new DemographicsResponseType();
        responseType.setImage(image);
        DemographicDataType dataType = new DemographicDataType();
        // TO_DO
        responseType.setData(dataType);
        return responseType;
    }
    public static ColorResponseType convert (String image, ColorResponsePojo response) {
        ColorResponseType responseType = new ColorResponseType();
        responseType.setImage(image);
        ColorDataType dataType = new ColorDataType();
        // TO_DO
        responseType.setData(dataType);
        return responseType;
    }
}
