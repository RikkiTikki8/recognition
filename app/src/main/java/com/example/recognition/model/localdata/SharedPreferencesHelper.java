package com.example.recognition.model.localdata;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recognition.model.DataMapper;
import com.example.recognition.model.localdata.room.entity.ColorResponse;
import com.example.recognition.model.localdata.room.entity.DemographicResponse;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;
import com.example.recognition.types.SettingsType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SharedPreferencesHelper {
    private final static String SETTINGS_KEY = "SETTINGS_KEY";
    private MutableLiveData<SettingsType> optionsData = new MutableLiveData<>();
    private MutableLiveData<GeneralResponse> generalResponse = new MutableLiveData<>();
    private MutableLiveData<DemographicResponse> demographicsResponse = new MutableLiveData<>();
    private MutableLiveData<ColorResponse> colorResponse = new MutableLiveData<>();
    private SharedPreferences sharedPreferences;
    private Gson gson;
    private String fileName;
    public SharedPreferencesHelper(Context context, String fileName) {
        sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }
    public LiveData<SettingsType> getSetting() {
        String json = sharedPreferences.getString(SETTINGS_KEY, gson.toJson(DataMapper.getSettingMap()));
        optionsData.setValue(gson.fromJson(json, SettingsType.class));
        return optionsData;
    }
    public void setThreshold(int threshold) {
        String loadedSettings = sharedPreferences.getString(SETTINGS_KEY, gson.toJson(DataMapper.getSettingMap()));
        SettingsType settings = gson.fromJson(loadedSettings, SettingsType.class);
        settings.setThreshold(threshold);
        String uploadedSettings = gson.toJson(settings);
        sharedPreferences.edit().putString(SETTINGS_KEY, uploadedSettings).apply();
        optionsData.setValue(settings);
    }
    public GeneralResponse getGeneralResponse() {
        return generalResponse.getValue();
    }
    public LiveData<GeneralResponse> getLiveDataGeneralResponse() {
        return generalResponse;
    }
    public void setGeneralResponse(GeneralResponse response) {
        generalResponse.postValue(response);
    }
    public DemographicResponse getDemographicsResponse() {
        return demographicsResponse.getValue();
    }
    public LiveData<DemographicResponse> getLiveDataDemographicResponse() {
        return demographicsResponse;
    }
    public void setDemographicsResponse(DemographicResponse response) {
        demographicsResponse.postValue(response);
    }
    public ColorResponse getColorResponse() {
        return colorResponse.getValue();
    }
    public LiveData<ColorResponse> getLiveDataColorResponse() {
        return colorResponse;
    }
    public void setColorResponse(ColorResponse response) {
        colorResponse.postValue(response);
    }
}
