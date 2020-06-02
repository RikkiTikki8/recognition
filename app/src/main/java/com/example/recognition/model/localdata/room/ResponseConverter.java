package com.example.recognition.model.localdata.room;

import androidx.room.TypeConverter;

import com.example.recognition.model.localdata.room.entity.ColorResponse;
import com.example.recognition.model.localdata.room.entity.DemographicsResponse;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;
<<<<<<< HEAD
=======
import com.example.recognition.types.data.DemographicData;
import com.example.recognition.types.data.GeneralData;
>>>>>>> 71d1eea35b61b0fd5a5c1c21c92c58fbec7baef8
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ResponseConverter {
    @TypeConverter
    ColorResponse getColorResponseEntity
            (com.example.recognition.types.response.ColorResponse colorResponse) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        ColorResponse responseEntity = new ColorResponse();
        responseEntity.setImage(colorResponse.getImage());
        responseEntity.getData(gson.toJson(colorResponse.getData()));
        return responseEntity;
    }
    @TypeConverter
    DemographicsResponse getColorResponseEntity
            (com.example.recognition.types.response.DemographicsResponse demographicsResponse) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        DemographicsResponse responseEntity = new DemographicsResponse();
        responseEntity.setImage(demographicsResponse.getImage());
        responseEntity.getData(gson.toJson(demographicsResponse.getData()));
        return responseEntity;
    }
    @TypeConverter
    GeneralResponse getColorResponseEntity
            (com.example.recognition.types.response.GeneralResponse generalResponse) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        GeneralResponse responseEntity = new GeneralResponse();
        responseEntity.setImage(generalResponse.getImage());
        responseEntity.getData(gson.toJson(generalResponse.getData()));
        return responseEntity;
    }
    @TypeConverter
    com.example.recognition.types.response.ColorResponse getColorResponseEntity
            (ColorResponse colorResponse) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        com.example.recognition.types.response.ColorResponse response =
                new com.example.recognition.types.response.ColorResponse();
        response.setImage(colorResponse.getImage());
        response.getData(gson.fromJson(colorResponse.getData(), ColorData.class));
        return response;
    }
    @TypeConverter
    com.example.recognition.types.response.DemographicsResponse getColorResponseEntity
            (DemographicsResponse demographicsResponse) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        com.example.recognition.types.response.DemographicsResponse response =
                new com.example.recognition.types.response.DemographicsResponse();
        response.setImage(demographicsResponse.getImage());
        response.getData(gson.fromJson(demographicsResponse.getData(), DemographicData.class));
        return response;
    }
    @TypeConverter
    com.example.recognition.types.response.GeneralResponse getColorResponseEntity
            (GeneralResponse generalResponse) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        com.example.recognition.types.response.GeneralResponse response =
                new com.example.recognition.types.response.GeneralResponse();
        response.setImage(generalResponse.getImage());
        response.getData(gson.fromJson(generalResponse.getData(), GeneralData.class));
        return response;
    }
}
