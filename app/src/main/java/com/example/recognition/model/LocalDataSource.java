package com.example.recognition.model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.recognition.model.localdata.SharedPreferencesHelper;
import com.example.recognition.model.localdata.room.DataBase;
import com.example.recognition.types.GeneralResponse;
import com.example.recognition.types.Options;
<<<<<<< HEAD
import com.example.recognition.types.response.Response;
=======
>>>>>>> 71d1eea35b61b0fd5a5c1c21c92c58fbec7baef8

import java.util.List;

public class LocalDataSource {
    private static String SHARED_PREFERENCES_FILE = "Options";
    private static String DATA_BASE_FILE = "MyDB";
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
    public void addResponse(GeneralResponse generalResponse) {
        dataBase.responseDao().addResponse(generalResponse);
    }
    public LiveData<GeneralResponse> getLastResponse() {
        return dataBase.responseDao().getLastResponse();
    }
    public LiveData<GeneralResponse> getFavorite(String image, String model) {
        return dataBase.responseDao().getFavorite(image, model);
    }
    public LiveData<List<GeneralResponse>> getFavorites() {
        return dataBase.responseDao().getFavorites();
    }
    public void addLastToFavorite() {
        dataBase.responseDao().addLastToFavorite();
    }
    public void removeLastFromLocalData() {
        dataBase.responseDao().removeLastResponse();
    }
    public LiveData<Options> getOptions() {
        return helper.getOptions();
    }
    public void setOptions(Options options) {
        helper.setOptions(options);
    }
}
