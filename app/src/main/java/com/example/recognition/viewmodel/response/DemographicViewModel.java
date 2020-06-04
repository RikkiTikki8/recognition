package com.example.recognition.viewmodel.response;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.example.recognition.model.Repository;
import com.example.recognition.model.localdata.room.entity.DemographicResponse;
import com.example.recognition.types.SettingsType;

public class DemographicViewModel extends ViewModel {
    private MediatorLiveData<SettingsType> settings = new MediatorLiveData<>();
    private MediatorLiveData<DemographicResponse> data = new MediatorLiveData<>();
    private Repository repository;
    public DemographicViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<DemographicResponse> getData(String image) {
        if (null == data.getValue()) {
            data.addSource(repository.getDemographicResponse(image), new Observer<DemographicResponse>() {
                @Override
                public void onChanged(DemographicResponse response) {
                    data.setValue(response);
                }
            });
        }
        return data;
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
        repository.addLastDemographicToFavorites();
    }
}
