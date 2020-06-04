package com.example.recognition.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NavModelViewModel extends ViewModel {
    MutableLiveData<Integer> model = new MutableLiveData<>();
    public void setNavModel(int model) {
        this.model.setValue(model);
    }
    public LiveData<Integer> getModelLayout() {
        return model;
    }
}
