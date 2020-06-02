package com.example.recognition.model.localdata;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recognition.types.OptionsType;
import com.example.recognition.types.data.ColorDataType;
import com.example.recognition.types.data.DemographicsDataType;
import com.example.recognition.types.data.GeneralDataType;
import com.example.recognition.types.response.ColorResponseType;
import com.example.recognition.types.response.DemographicsResponseType;
import com.example.recognition.types.response.GeneralResponseType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SharedPreferencesHelper {
    private final static String OPTIONS_KEY = "OPTIONS_KEY";
    public static final String LAST_RESPONSE_KEY = "LAST_RESPONSE_KEY";
    private MutableLiveData<OptionsType> optionsData = new MutableLiveData<>();
    private MutableLiveData<GeneralDataType> generalResponse = new MutableLiveData<>();
    private MutableLiveData<DemographicsDataType> demographicsResponse = new MutableLiveData<>();
    private MutableLiveData<ColorDataType> colorResponse = new MutableLiveData<>();
    private SharedPreferences sharedPreferences;
    private Gson gson;
    private String fileName;
    public SharedPreferencesHelper(Context context, String fileName) {
        sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }
    public LiveData<OptionsType> getOptions() {
        String json = sharedPreferences.getString(OPTIONS_KEY, gson.toJson(new OptionsType()));
        optionsData.setValue(gson.fromJson(json, OptionsType.class));
        return optionsData;
    }
    public void setOptions(OptionsType options) {
        String json = gson.toJson(options);
        sharedPreferences.edit().putString(OPTIONS_KEY, json).apply();
        optionsData.setValue(options);
    }
    public GeneralResponseType getLastGeneralResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+GeneralResponseType.class.getName(),
                gson.toJson(new GeneralResponseType())
        );
        return gson.fromJson(json, GeneralResponseType.class);
    }
    public LiveData<GeneralDataType> getLastGeneralData() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+GeneralResponseType.class.getName(),
                gson.toJson(new GeneralResponseType())
        );
        GeneralResponseType responseType = gson.fromJson(json, GeneralResponseType.class);
        generalResponse.setValue(responseType.getData());
        return generalResponse;
    }
    public void setLastGeneralResponse(GeneralResponseType response) {
        generalResponse.setValue(response.getData());
        sharedPreferences.edit().putString(
                LAST_RESPONSE_KEY+GeneralResponseType.class.getName(),
                gson.toJson(response)
        ).apply();
    }
    public DemographicsResponseType getLastDemographicsResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+DemographicsResponseType.class.getName(),
                gson.toJson(new DemographicsResponseType())
        );
        return gson.fromJson(json, DemographicsResponseType.class);
    }
    public LiveData<DemographicsDataType> getLastDemographicsData() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+DemographicsResponseType.class.getName(),
                gson.toJson(new DemographicsResponseType())
        );
        DemographicsResponseType responseType = gson.fromJson(json, DemographicsResponseType.class);
        demographicsResponse.setValue(responseType.getData());
        return demographicsResponse;
    }
    public void setLastDemographicsResponse(DemographicsResponseType response) {
        demographicsResponse.setValue(response.getData());
        sharedPreferences.edit().putString(
                LAST_RESPONSE_KEY+DemographicsResponseType.class.getName(),
                gson.toJson(response)
        ).apply();
    }
    public ColorResponseType getLastColorResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+ColorResponseType.class.getName(),
                gson.toJson(new ColorResponseType())
        );
        return gson.fromJson(json, ColorResponseType.class);
    }
    public LiveData<ColorDataType> getLastColorData() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+ColorResponseType.class.getName(),
                gson.toJson(new ColorResponseType())
        );
        ColorResponseType responseType = gson.fromJson(json, ColorResponseType.class);
        colorResponse.setValue(responseType.getData());
        return colorResponse;
    }
    public void setLastColorResponse(ColorResponseType response) {
        colorResponse.setValue(response.getData());
        sharedPreferences.edit().putString(
                LAST_RESPONSE_KEY+ColorResponseType.class.getName(),
                gson.toJson(response)
        ).apply();
    }
}
