package com.example.recognition.aplication;

import android.app.Application;

import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.R;
import com.example.recognition.model.LocalDataSource;
import com.example.recognition.model.RemoteDataSource;
import com.example.recognition.model.Repository;
import com.example.recognition.viewmodel.ViewModelFactory;

public class App extends Application {
    private Repository repository;
    private ViewModelProvider.Factory factory;
    @Override
    public void onCreate() {
        super.onCreate();
        repository = new Repository(new LocalDataSource(this), new RemoteDataSource(this, getString(R.string.API_KEY)));
        factory = new ViewModelFactory(repository);
    }
    public ViewModelProvider.Factory getViewModeFactory(){
        return factory;
    }
}
