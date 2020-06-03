package com.example.recognition.model.localdata;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recognition.model.DataMapper;
import com.example.recognition.types.SettingsType;
import com.example.recognition.types.data.ColorDataType;
import com.example.recognition.types.data.DemographicDataType;
import com.example.recognition.types.data.GeneralDataType;
import com.example.recognition.types.response.ColorResponseType;
import com.example.recognition.types.response.DemographicResponseType;
import com.example.recognition.types.response.GeneralResponseType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SharedPreferencesHelper {
    private final static String OPTIONS_KEY = "OPTIONS_KEY";
    public static final String LAST_RESPONSE_KEY = "LAST_RESPONSE_KEY";
    private MutableLiveData<SettingsType> optionsData = new MutableLiveData<>();
    private MutableLiveData<GeneralDataType> generalResponse = new MutableLiveData<>();
    private MutableLiveData<DemographicDataType> demographicsResponse = new MutableLiveData<>();
    private MutableLiveData<ColorDataType> colorResponse = new MutableLiveData<>();
    private SharedPreferences sharedPreferences;
    private Gson gson;
    private String fileName;
    public SharedPreferencesHelper(Context context, String fileName) {
        sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }
    public LiveData<SettingsType> getOptions() {
        String json = sharedPreferences.getString(OPTIONS_KEY, gson.toJson(DataMapper.getOptionsMap()));
        optionsData.setValue(gson.fromJson(json, SettingsType.class));
        return optionsData;
    }
    public void setOptions(SettingsType options) {
        String json = gson.toJson(options);
        sharedPreferences.edit().putString(OPTIONS_KEY, json).apply();
        optionsData.setValue(options);
    }
    public GeneralResponseType getLastGeneralResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+GeneralResponseType.class.getName(),
                gson.toJson(DataMapper.getGeneralResponseMap())
        );
        return gson.fromJson(json, GeneralResponseType.class);
    }
    public LiveData<GeneralDataType> getLastGeneralData() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+GeneralResponseType.class.getName(),
                gson.toJson(DataMapper.getGeneralDataMap())
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
    public DemographicResponseType getLastDemographicsResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+ DemographicResponseType.class.getName(),
                gson.toJson(DataMapper.getDemographicResponseMap())
        );
        return gson.fromJson(json, DemographicResponseType.class);
    }
    public LiveData<DemographicDataType> getLastDemographicData() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+ DemographicResponseType.class.getName(),
                gson.toJson(DataMapper.getDemographicDataMap())
        );
        DemographicResponseType responseType = gson.fromJson(json, DemographicResponseType.class);
        demographicsResponse.setValue(responseType.getData());
        return demographicsResponse;
    }
    public void setLastDemographicsResponse(DemographicResponseType response) {
        demographicsResponse.setValue(response.getData());
        sharedPreferences.edit().putString(
                LAST_RESPONSE_KEY+ DemographicResponseType.class.getName(),
                gson.toJson(response)
        ).apply();
    }
    public ColorResponseType getLastColorResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+ColorResponseType.class.getName(),
                gson.toJson(DataMapper.getColorResponseMap())
        );
        return gson.fromJson(json, ColorResponseType.class);
    }
    public LiveData<ColorDataType> getLastColorData() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+ColorResponseType.class.getName(),
                gson.toJson(DataMapper.getColorDataMap())
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
