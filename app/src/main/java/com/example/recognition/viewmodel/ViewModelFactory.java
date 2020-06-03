package com.example.recognition.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.model.Repository;
import com.example.recognition.viewmodel.request_response.ColorViewModel;
import com.example.recognition.viewmodel.request_response.DemographicViewModel;
import com.example.recognition.viewmodel.request_response.GeneralViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {
    protected Repository repository;
    public ViewModelFactory(Repository repository) {
        this.repository = repository;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.getName().equals("SettingViewModel")){
            return (T)(new SettingsViewModel(repository));
        } else if(modelClass.getName().equals("FavoriteViewModel")){
            return (T)(new FavoriteViewModel(repository));
        } else if(modelClass.getName().equals("GeneralViewModel")){
            return (T)(new GeneralViewModel(repository));
        } else if(modelClass.getName().equals("DemographicViewModel")){
            return (T)(new DemographicViewModel(repository));
        } else if(modelClass.getName().equals("ColorViewModel")) {
            return (T) (new ColorViewModel(repository));
        }
        return null;
    }
}
