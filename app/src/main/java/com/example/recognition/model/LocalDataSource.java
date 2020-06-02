package com.example.recognition.model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.clarifai.grpc.auth.scope.S;
import com.example.recognition.model.localdata.SharedPreferencesHelper;
import com.example.recognition.model.localdata.room.DataBase;
import com.example.recognition.types.response.GeneralResponseType;
import com.example.recognition.types.OptionsType;

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
    public LiveData<List<String>> getModels() {
        return dataBase.modelsDao().getModels();
    }
    public void setModels(List<String> models) {
        dataBase.modelsDao().addModels(models);
    }
//    public void addResponse(GeneralResponseType generalResponse) {
//        dataBase.responseDao().addResponse(generalResponse);
//    }
//    public LiveData<GeneralResponseType> getLastResponse() {
//        return dataBase.responseDao().getLastResponse();
//    }
//    public LiveData<GeneralResponseType> getFavorite(String image, String model) {
//        return dataBase.responseDao().getFavorite(image, model);
//    }
//    public LiveData<List<GeneralResponseType>> getFavorites() {
//        return dataBase.responseDao().getFavorites();
//    }
//    public void addLastToFavorite() {
//        dataBase.responseDao().addLastToFavorite();
//    }
    public LiveData<OptionsType> getOptions() {
        return helper.getOptions();
    }
    public void setOptions(OptionsType options) {
        helper.setOptions(options);
    }
}
