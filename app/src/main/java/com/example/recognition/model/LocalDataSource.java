package com.example.recognition.model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
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
    private MutableLiveData<GeneralResponse> generalResponse = new MutableLiveData<>();
    private MutableLiveData<DemographicResponse> demographicsResponse = new MutableLiveData<>();
    private MutableLiveData<ColorResponse> colorResponse = new MutableLiveData<>();
    private DataBase dataBase;
    private SharedPreferencesHelper helper;
    public LocalDataSource(Context context) {
        dataBase = Room.databaseBuilder(context, DataBase.class, DATA_BASE_FILE).build();
        helper = new SharedPreferencesHelper(context, SHARED_PREFERENCES_FILE);
    }
    public LiveData<GeneralResponse> getLastGeneralData() {
        return generalResponse;
    }
    public LiveData<DemographicResponse> getLastDemographicData() {
        return demographicsResponse;
    }
    public LiveData<ColorResponse> getLastColorData() {
        return colorResponse;
    }
    public void setLastGeneralResponse(GeneralResponse response) {
        generalResponse.postValue(response);
    }
    public void setLastDemographicResponse(DemographicResponse response) {
        demographicsResponse.postValue(response);
    }
    public void setLastColorResponse(ColorResponse response) {
        colorResponse.postValue(response);
    }
    public void addLastGeneralResponseToFavorite() {
        dataBase.generalResponseDao()
                .addResponse(
                        generalResponse.getValue()
                );
    }
    public void addLastDemographicResponseToFavorite() {
        dataBase.demographicsResponseDao()
                .addResponse(
                        demographicsResponse.getValue()
                );
    }
    public void addLastColorResponseToFavorite() {
        dataBase.colorResponseDao()
                .addResponse(
                        colorResponse.getValue()
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
