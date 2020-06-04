package com.example.recognition.model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.recognition.model.localdata.SharedPreferencesHelper;
import com.example.recognition.model.localdata.room.DataBase;
import com.example.recognition.model.localdata.room.entity.ColorResponse;
import com.example.recognition.model.localdata.room.entity.DemographicResponse;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;
import com.example.recognition.types.SettingsType;

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
    public LiveData<GeneralResponse> getLastGeneralData() {
        return helper.getLiveDataGeneralResponse();
    }
    public LiveData<DemographicResponse> getLastDemographicData() {
        return helper.getLiveDataDemographicResponse();
    }
    public LiveData<ColorResponse> getLastColorData() {
        return helper.getLiveDataColorResponse();
    }
    public void setLastGeneralResponse(GeneralResponse response) {
        helper.setGeneralResponse(response);
    }
    public void setLastDemographicResponse(DemographicResponse response) {
        helper.setDemographicsResponse(response);
    }
    public void setLastColorResponse(ColorResponse response) {
        helper.setColorResponse(response);
    }
    public void addLastGeneralResponseToFavorite() {
        dataBase.generalResponseDao()
                .addResponse(
                        helper.getGeneralResponse()
                );
    }
    public void addLastDemographicResponseToFavorite() {
        dataBase.demographicsResponseDao()
                .addResponse(
                        helper.getDemographicsResponse()
                );
    }
    public void addLastColorResponseToFavorite() {
        dataBase.colorResponseDao()
                .addResponse(
                        helper.getColorResponse()
                );
    }
    public LiveData<List<GeneralResponse>> getGeneralFavorites() {
        return dataBase.generalResponseDao().getFavorites();
    }
    public LiveData<List<DemographicResponse>> getDemographicFavorites() {
        return dataBase.demographicsResponseDao().getFavorites();
    }
    public LiveData<List<ColorResponse>> getColorFavorites() {
        return dataBase.colorResponseDao().getFavorites();
    }
    public LiveData<GeneralResponse> getGeneralFavorite(String image) {
        return dataBase.generalResponseDao().getFavorite(image);
    }
    public LiveData<DemographicResponse> getDemographicFavorite(String image) {
        return dataBase.demographicsResponseDao().getFavorite(image);
    }
    public LiveData<ColorResponse> getColorFavorite(String image) {
        return dataBase.colorResponseDao().getFavorite(image);
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
    public LiveData<SettingsType> getSettings() {
        return helper.getSetting();
    }
    public void setThreshold(int threshold) {
        helper.setThreshold(threshold);
    }
}
