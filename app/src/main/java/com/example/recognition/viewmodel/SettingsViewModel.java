package com.example.recognition.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.example.recognition.model.Repository;
import com.example.recognition.types.SettingsType;

public class SettingsViewModel extends ViewModel {
    private MediatorLiveData<SettingsType> settings = new MediatorLiveData<>();
    private Repository repository;

    public SettingsViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<SettingsType> getSettings() {
        if (null == settings.getValue()) {
            settings.addSource(repository.getSettings(), new Observer<SettingsType>() {
                @Override
                public void onChanged(SettingsType settingsType) {
                    settings.setValue(settingsType);
                }
            });
        }
        return settings;
    }
    public void setThreshold(int threshold) {
        repository.setThreshold(threshold);
    }
}