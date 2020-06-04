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
    private final static String SETTINGS_KEY = "SETTINGS_KEY";
    public static final String LAST_RESPONSE_KEY = "LAST_RESPONSE_KEY";
    private MutableLiveData<SettingsType> optionsData = new MutableLiveData<>();
    private MutableLiveData<GeneralResponseType> generalResponse = new MutableLiveData<>();
    private MutableLiveData<DemographicResponseType> demographicsResponse = new MutableLiveData<>();
    private MutableLiveData<ColorResponseType> colorResponse = new MutableLiveData<>();
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
    public GeneralResponseType getGeneralResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+GeneralResponseType.class.getName(),
                gson.toJson(DataMapper.getGeneralResponseMap())
        );
        return gson.fromJson(json, GeneralResponseType.class);
    }
    public LiveData<GeneralResponseType> getLiveDataGeneralResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+GeneralResponseType.class.getName(),
                gson.toJson(DataMapper.getGeneralDataMap())
        );
        generalResponse.setValue(gson.fromJson(json, GeneralResponseType.class));
        return generalResponse;
    }
    public void setGeneralResponse(GeneralResponseType response) {
        generalResponse.setValue(response);
        sharedPreferences.edit().putString(
                LAST_RESPONSE_KEY+GeneralResponseType.class.getName(),
                gson.toJson(response)
        ).apply();
    }
    public DemographicResponseType getDemographicsResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+ DemographicResponseType.class.getName(),
                gson.toJson(DataMapper.getDemographicResponseMap())
        );
        return gson.fromJson(json, DemographicResponseType.class);
    }
    public LiveData<DemographicResponseType> getLiveDataDemographicResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+ DemographicResponseType.class.getName(),
                gson.toJson(DataMapper.getDemographicDataMap())
        );
        demographicsResponse.setValue(gson.fromJson(json, DemographicResponseType.class));
        return demographicsResponse;
    }
    public void setDemographicsResponse(DemographicResponseType response) {
        demographicsResponse.setValue(response);
        sharedPreferences.edit().putString(
                LAST_RESPONSE_KEY+ DemographicResponseType.class.getName(),
                gson.toJson(response)
        ).apply();
    }
    public ColorResponseType getColorResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+ColorResponseType.class.getName(),
                gson.toJson(DataMapper.getColorResponseMap())
        );
        return gson.fromJson(json, ColorResponseType.class);
    }
    public LiveData<ColorResponseType> getLiveDataColorResponse() {
        String json = sharedPreferences.getString(
                LAST_RESPONSE_KEY+ColorResponseType.class.getName(),
                gson.toJson(DataMapper.getColorDataMap())
        );
        colorResponse.setValue(gson.fromJson(json, ColorResponseType.class));
        return colorResponse;
    }
    public void setColorResponse(ColorResponseType response) {
        colorResponse.setValue(response);
        sharedPreferences.edit().putString(
                LAST_RESPONSE_KEY+ColorResponseType.class.getName(),
                gson.toJson(response)
        ).apply();
    }
}
