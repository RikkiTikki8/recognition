package com.example.recognition.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.model.Repository;
import com.example.recognition.viewmodel.favorites.ColorFavoriteViewModel;
import com.example.recognition.viewmodel.favorites.DemographicFavoriteViewModel;
import com.example.recognition.viewmodel.favorites.GeneralFavoriteViewModel;
import com.example.recognition.viewmodel.response.ColorViewModel;
import com.example.recognition.viewmodel.response.DemographicViewModel;
import com.example.recognition.viewmodel.response.GeneralViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {
    protected Repository repository;
    public ViewModelFactory(Repository repository) {
        this.repository = repository;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.getSimpleName().equals("SettingViewModel")){
            return (T)(new SettingsViewModel(repository));
        } else if(modelClass.getSimpleName().equals("GeneralViewModel")){
            return (T)(new GeneralViewModel(repository));
        } else if(modelClass.getSimpleName().equals("DemographicViewModel")){
            return (T)(new DemographicViewModel(repository));
        } else if(modelClass.getSimpleName().equals("ColorViewModel")) {
            return (T) (new ColorViewModel(repository));
        } else if(modelClass.getSimpleName().equals("GeneralFavoriteViewModel")){
            return (T)(new GeneralFavoriteViewModel(repository));
        } else if(modelClass.getSimpleName().equals("DemographicFavoriteViewModel")){
            return (T)(new DemographicFavoriteViewModel(repository));
        } else if(modelClass.getSimpleName().equals("ColorFavoriteViewModel")) {
            return (T) (new ColorFavoriteViewModel(repository));
        } else if(modelClass.getSimpleName().equals("SettingsViewModel")) {
            return (T) (new SettingsViewModel(repository));
        }else if(modelClass.getSimpleName().equals("NavModelViewModel")) {
            return (T) (new NavModelViewModel());
        } else if(modelClass.getSimpleName().equals("ImageViewModel")) {
            return (T) (new ImageViewModel());
        }
        return null;
    }
}
