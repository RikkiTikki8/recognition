package com.example.recognition.model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.recognition.model.localdata.SharedPreferencesHelper;
import com.example.recognition.model.localdata.room.DataBase;
import com.example.recognition.types.data.ColorDataType;
import com.example.recognition.types.data.DemographicDataType;
import com.example.recognition.types.data.GeneralDataType;
import com.example.recognition.types.SettingsType;
import com.example.recognition.types.response.ColorResponseType;
import com.example.recognition.types.response.DemographicResponseType;
import com.example.recognition.types.response.GeneralResponseType;

import java.util.List;

public class LocalDataSource {
    private static String SHARED_PREFERENCES_FILE = "SHARED_PREFERENCES";
    private static String DATA_BASE_FILE = "MY_DATA_BASE";
    private DataBase dataBase;
    private SharedPreferencesHelper helper;
    public LocalDataSource(Context context) {
        dataBase = Room.databaseBuilder(context, DataBase.class, DATA_BASE_FILE).build();
        helper = new SharedPreferencesHelper(context, SHARED_PREFERENCES_FILE);
    }
    public LiveData<GeneralDataType> getLastGeneralData() {
        return helper.getLastGeneralData();
    }
    public LiveData<DemographicDataType> getLastDemographicData() {
        return helper.getLastDemographicData();
    }
    public LiveData<ColorDataType> getLastColorData() {
        return helper.getLastColorData();
    }
    public void setLastGeneralResponse(GeneralResponseType response) {
        helper.setLastGeneralResponse(response);
    }
    public void setLastDemographicResponse(DemographicResponseType response) {
        helper.setLastDemographicsResponse(response);
    }
    public void setLastColorResponse(ColorResponseType response) {
        helper.setLastColorResponse(response);
    }
    public void addLastGeneralResponseToFavorite() {
        dataBase.generalResponseDao()
                .addResponse(
                        helper.getLastGeneralResponse()
                );
    }
    public void addLastDemographicResponseToFavorite() {
        dataBase.demographicsResponseDao()
                .addResponse(
                        helper.getLastDemographicsResponse()
                );
    }
    public void addLastColorResponseToFavorite() {
        dataBase.colorResponseDao()
                .addResponse(
                        helper.getLastColorResponse()
                );
    }
    public LiveData<List<GeneralResponseType>> getGeneralFavorites() {
        return dataBase.generalResponseDao().getFavorites();
    }
    public LiveData<List<DemographicResponseType>> getDemographicFavorites() {
        return dataBase.demographicsResponseDao().getFavorites();
    }
    public LiveData<List<ColorResponseType>> getColorFavorites() {
        return dataBase.colorResponseDao().getFavorites();
    }
    public void removeGeneralFavoriteResponse(String image) {
        dataBase.generalResponseDao().removeResponse(image);
    }
    public void removeDemographicFavoriteResponse(String image) {
        dataBase.demographicsResponseDao().removeResponse(image);
    }
    public void removeColorFavoriteResponse(String image) {
        dataBase.colorResponseDao().removeResponse(image);
    }
    public LiveData<SettingsType> getOptions() {
        return helper.getOptions();
    }
    public void setOptions(SettingsType options) {
        helper.setOptions(options);
    }
}
