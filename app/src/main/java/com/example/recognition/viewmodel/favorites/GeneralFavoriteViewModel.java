package com.example.recognition.viewmodel.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.example.recognition.model.Repository;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;
import com.example.recognition.types.SettingsType;
import java.util.List;

public class GeneralFavoriteViewModel extends ViewModel {
    private MutableLiveData<String> image = new MutableLiveData<>();
    private MediatorLiveData<SettingsType> settings = new MediatorLiveData<>();
    private MediatorLiveData<List<GeneralResponse>> generalFavorites = new MediatorLiveData<>();
    private MediatorLiveData<GeneralResponse> response = new MediatorLiveData<>();
    private Repository repository;
    public GeneralFavoriteViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<List<GeneralResponse>> getGeneralFavorites() {
        if (null == generalFavorites.getValue()) {
            generalFavorites.addSource(repository.getGeneralFavorites(), new Observer<List<GeneralResponse>>() {
                @Override
                public void onChanged(List<GeneralResponse> response) {
                    generalFavorites.setValue(response);
                }
            });
        }
        return generalFavorites;
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
    public LiveData<GeneralResponse> getFavorite(String image) {
        if (null == response.getValue()) {
            response.addSource(repository.getGeneralFavorite(image), new Observer<GeneralResponse>() {
                @Override
                public void onChanged(GeneralResponse dataType) {
                    response.setValue(dataType);
                }
            });
        }
        return response;
    }
    public void removeFromFavorite(String image) {
        repository.removeGeneralFavorite(image);
    }
    public void setImage(String image) {
        this.image.setValue(image);
    }
    public LiveData<String> getImage() {
        return image;
    }
}
