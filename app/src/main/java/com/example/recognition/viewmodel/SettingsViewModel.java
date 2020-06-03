package com.example.recognition.viewmodel;

import android.provider.Settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;

public class SettingsViewModel extends ViewModel {
    private Repository repository;
    public SettingsViewModel(Repository repository) {
        this.repository = repository;
    }
}