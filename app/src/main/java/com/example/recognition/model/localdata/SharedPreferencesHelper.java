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
    public static final String LAST_RESPONSE_KEY = "LAST_RESPONSE_KEY";
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
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+ GeneralResponse.class.getName(),
                gson.toJson(DataMapper.getGeneralResponseMap())
        );
        return gson.fromJson(json, GeneralResponse.class);
    }
    public LiveData<GeneralResponse> getLiveDataGeneralResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+ GeneralResponse.class.getName(),
                gson.toJson(DataMapper.getGeneralDataMap())
        );
        generalResponse.setValue(gson.fromJson(json, GeneralResponse.class));
        return generalResponse;
    }
    public void setGeneralResponse(GeneralResponse response) {
        generalResponse.setValue(response);
        sharedPreferences.edit().putString(
                LAST_RESPONSE_KEY+ GeneralResponse.class.getName(),
                gson.toJson(response)
        ).apply();
    }
    public DemographicResponse getDemographicsResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+ DemographicResponse.class.getName(),
                gson.toJson(DataMapper.getDemographicResponseMap())
        );
        return gson.fromJson(json, DemographicResponse.class);
    }
    public LiveData<DemographicResponse> getLiveDataDemographicResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+ DemographicResponse.class.getName(),
                gson.toJson(DataMapper.getDemographicDataMap())
        );
        demographicsResponse.setValue(gson.fromJson(json, DemographicResponse.class));
        return demographicsResponse;
    }
    public void setDemographicsResponse(DemographicResponse response) {
        demographicsResponse.setValue(response);
        sharedPreferences.edit().putString(
                LAST_RESPONSE_KEY+ DemographicResponse.class.getName(),
                gson.toJson(response)
        ).apply();
    }
    public ColorResponse getColorResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+ ColorResponse.class.getName(),
                gson.toJson(DataMapper.getColorResponseMap())
        );
        return gson.fromJson(json, ColorResponse.class);
    }
    public LiveData<ColorResponse> getLiveDataColorResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+ ColorResponse.class.getName(),
                gson.toJson(DataMapper.getColorDataMap())
        );
        colorResponse.setValue(gson.fromJson(json, ColorResponse.class));
        return colorResponse;
    }
    public void setColorResponse(ColorResponse response) {
        colorResponse.setValue(response);
        sharedPreferences.edit().putString(
                LAST_RESPONSE_KEY+ ColorResponse.class.getName(),
                gson.toJson(response)
        ).apply();
    }
}
