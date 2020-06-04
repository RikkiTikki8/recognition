package com.example.recognition.model.localdata.room;

import androidx.room.TypeConverter;

import com.example.recognition.model.localdata.room.entity.ColorResponseEntity;
import com.example.recognition.model.localdata.room.entity.DemographicResponseEntity;
import com.example.recognition.model.localdata.room.entity.GeneralResponseEntity;
import com.example.recognition.types.data.ColorDataType;
import com.example.recognition.types.data.DemographicDataType;
import com.example.recognition.types.data.GeneralDataType;
import com.example.recognition.types.response.ColorResponseType;
import com.example.recognition.types.response.DemographicResponseType;
import com.example.recognition.types.response.GeneralResponseType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ResponseConverter {
    @TypeConverter
    ColorResponseEntity getColorResponseEntity (ColorResponseType colorResponse) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        ColorResponseEntity responseEntity = new ColorResponseEntity();
        responseEntity.setImage(colorResponse.getImage());
        responseEntity.setData(gson.toJson(colorResponse.getData()));
        return responseEntity;
    }
    @TypeConverter
    DemographicResponseEntity getDemographicResponseEntity (DemographicResponseType demographicsResponse) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        DemographicResponseEntity responseEntity = new DemographicResponseEntity();
        responseEntity.setImage(demographicsResponse.getImage());
        responseEntity.setData(gson.toJson(demographicsResponse.getData()));
        return responseEntity;
    }
    @TypeConverter
    GeneralResponseEntity getGeneralResponseEntity (GeneralResponseType generalResponse) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        GeneralResponseEntity responseEntity = new GeneralResponseEntity();
        responseEntity.setImage(generalResponse.getImage());
        responseEntity.setData(gson.toJson(generalResponse.getData()));
        return responseEntity;
    }
    @TypeConverter
    ColorResponseType getColorResponseType (ColorResponseEntity colorResponse) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        ColorResponseType response = new ColorResponseType();
        response.setImage(colorResponse.getImage());
        response.setData(gson.fromJson(colorResponse.getData(), ColorDataType.class));
        return response;
    }
    @TypeConverter
    DemographicResponseType getDemographicResponseType (DemographicResponseEntity demographicsResponse) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        DemographicResponseType response = new DemographicResponseType();
        response.setImage(demographicsResponse.getImage());
        response.setData(gson.fromJson(demographicsResponse.getData(), DemographicDataType.class));
        return response;
    }
    @TypeConverter
    GeneralResponseType getGeneralResponseType (GeneralResponseEntity generalResponse) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        GeneralResponseType response = new GeneralResponseType();
        response.setImage(generalResponse.getImage());
        response.setData(gson.fromJson(generalResponse.getData(), GeneralDataType.class));
        return response;
    }
}
