package com.example.recognition.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.model.Repository;

public class ViewModelFactory implements ViewModelProvider.Factory {
    protected Repository repository;
    public ViewModelFactory(Repository repository) {
        this.repository = repository;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.getName() == "RequestViewModel"){
            return (T)(new RequestViewModel(repository));
        } else if(modelClass.getName().equals("ResultViewModel")){
            return (T)(new RequestViewModel(repository));
        } else if(modelClass.getName().equals("FavoriteViewModel")){
            return (T)(new RequestViewModel(repository));
        } else if(modelClass.getName().equals("OptionsViewModel")){
            return (T)(new RequestViewModel(repository));
        }
        return null;
    }
}
