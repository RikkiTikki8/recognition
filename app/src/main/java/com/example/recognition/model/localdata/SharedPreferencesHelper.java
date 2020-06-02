package com.example.recognition.model.localdata;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recognition.types.Options;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SharedPreferencesHelper {
    private final static String OPTIONS_KEY = "OPTIONS_KEY";
    public static final String LAST_RESPONSE_KEY = "LAST_RESPONSE_KEY";
    private MutableLiveData<Options> optionsData = new MutableLiveData<>();
    private SharedPreferences sharedPreferences;
    private Gson gson;
    private String fileName;
    public SharedPreferencesHelper(Context context, String fileName) {
        sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }
    public LiveData<Options> getOptions() {
        String json = sharedPreferences.getString(OPTIONS_KEY, gson.toJson(new Options()));
        optionsData.setValue(gson.fromJson(json, Options.class));
        return optionsData;
    }
    public void setOptions(Options options) {
        String json = gson.toJson(options);
        sharedPreferences.edit().putString(OPTIONS_KEY, json).apply();
        optionsData.setValue(options);
    }
}
