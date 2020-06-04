package com.example.recognition.model.localdata.room;

import androidx.room.TypeConverter;

import com.example.recognition.types.ColorDataType;
import com.example.recognition.types.DemographicDataType;
import com.example.recognition.types.GeneralDataType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DataConverter {
    private Gson gson;
    public DataConverter() {
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }
    @TypeConverter
    public String setColorData (ColorDataType colorData) {
        return gson.toJson(colorData);
    }
    @TypeConverter
    public String setDemographicData (DemographicDataType demographicsData) {
        return gson.toJson(demographicsData);
    }
    @TypeConverter
    public String setGeneralData (GeneralDataType generalData) {
        return gson.toJson(generalData);
    }
    @TypeConverter
    public GeneralDataType getGeneralData (String generalData) {
        return gson.fromJson(generalData, GeneralDataType.class);
    }
    @TypeConverter
    public DemographicDataType getDemographicData (String demographicsData) {
        return gson.fromJson(demographicsData, DemographicDataType.class);
    }
    @TypeConverter
    public ColorDataType getColorData (String colorData) {
        return gson.fromJson(colorData, ColorDataType.class);
    }
}
