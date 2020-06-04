package com.example.recognition.viewmodel.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.example.recognition.model.Repository;
import com.example.recognition.model.localdata.room.entity.DemographicResponse;
import com.example.recognition.types.SettingsType;
import java.util.List;

public class DemographicFavoriteViewModel extends ViewModel {
    private MutableLiveData<String> image = new MutableLiveData<>();
    private MediatorLiveData<SettingsType> settings = new MediatorLiveData<>();
    private MediatorLiveData<List<DemographicResponse>> demographicFavorites = new MediatorLiveData<>();
    private MediatorLiveData<DemographicResponse> response = new MediatorLiveData<>();
    private Repository repository;
    public DemographicFavoriteViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<List<DemographicResponse>> getDemographicFavorites() {
        if (null == demographicFavorites.getValue()) {
            demographicFavorites.addSource(repository.getDemographicFavorites(), new Observer<List<DemographicResponse>>() {
                @Override
                public void onChanged(List<DemographicResponse> response) {
                    demographicFavorites.setValue(response);
                }
            });
        }
        return demographicFavorites;
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
    public LiveData<DemographicResponse> getFavorite(String image) {
        if (null == response.getValue()) {
            response.addSource(repository.getDemographicFavorite(image), new Observer<DemographicResponse>() {
                @Override
                public void onChanged(DemographicResponse dataType) {
                    response.setValue(dataType);
                }
            });
        }
        return response;
    }
    public void removeFromFavorite(String image) {
        repository.removeDemographicFavorite(image);
    }
    public void setImage(String image) {
        this.image.setValue(image);
    }
    public LiveData<String> getImage() {
        return image;
    }
}
