package com.example.recognition.viewmodel.response;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.example.recognition.model.Repository;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;
import com.example.recognition.types.SettingsType;

public class GeneralViewModel extends ViewModel {
    private MediatorLiveData<String> message = new MediatorLiveData<>();
    private MediatorLiveData<SettingsType> settings = new MediatorLiveData<>();
    private MediatorLiveData<GeneralResponse> data = new MediatorLiveData<>();
    private Repository repository;
    public GeneralViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<GeneralResponse> getData(String image) {
        if (null == data.getValue()) {
            data.addSource(repository.getGeneralResponse(image), new Observer<GeneralResponse>() {
                @Override
                public void onChanged(GeneralResponse response) {
                    data.setValue(response);
                }
            });
        }
        return data;
    }
    public LiveData<String> getErrorMassage() {
        if (null == message.getValue()) {
            message.addSource(repository.getErrorMessage(), new Observer<String>() {
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
        repository.addLastGeneralToFavorites();
    }
}
