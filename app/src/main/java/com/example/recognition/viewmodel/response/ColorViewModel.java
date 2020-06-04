package com.example.recognition.viewmodel.response;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.example.recognition.model.Repository;
import com.example.recognition.model.localdata.room.entity.ColorResponse;
import com.example.recognition.types.SettingsType;

public class ColorViewModel extends ViewModel {
    private MediatorLiveData<String> message = new MediatorLiveData<>();
    private MediatorLiveData<SettingsType> settings = new MediatorLiveData<>();
    private MediatorLiveData<ColorResponse> data = new MediatorLiveData<>();
    private Repository repository;
    public ColorViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<ColorResponse> getData(String image) {
        if (null == data.getValue()) {
            data.addSource(repository.getColorResponse(image), new Observer<ColorResponse>() {
                @Override
                public void onChanged(ColorResponse response) {
                    data.setValue(response);
                }
            });
        }
        return data;
    }
    public LiveData<String> getMassage() {
        if (null == message.getValue()) {
            message.addSource(repository.getMessage(), new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    message.setValue(s);
                }
            });
        }
        return message;
    }
    public LiveData<SettingsType> getSettings() {
        if (null == settings.getValue()) {
            settings.addSource(repository.getSettings(), new Observer<SettingsType>() {
                @Override
                public void onChanged(SettingsType options) {
                    settings.setValue(options);
                }
            });
        }
        return settings;
    }
    public void addToFavorite() {
        repository.addLastColorToFavorites();
    }
}
