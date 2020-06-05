package com.example.recognition.viewmodel.response;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.example.recognition.model.Repository;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;
import com.example.recognition.types.SettingsType;

public class GeneralViewModel extends ViewModel {
    private MediatorLiveData<String> message = new MediatorLiveData<>();
    private MutableLiveData<Boolean> isFavorite = new MutableLiveData<>();
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
        isFavorite.setValue(true);
    }
    public void removeFromFavorite() {
        isFavorite.setValue(false);
    }
    public LiveData<Boolean> isFavorite() {
        if (null == isFavorite) {
            isFavorite.setValue(true);
        }
        return isFavorite;
    }
    @Override
    protected void onCleared() {
        if (isFavorite.getValue()) {
            repository.addLastGeneralToFavorites();
        }
        super.onCleared();
    }
}
