package com.example.recognition.viewmodel.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.example.recognition.model.Repository;
import com.example.recognition.model.localdata.room.entity.ColorResponse;
import com.example.recognition.types.SettingsType;
import java.util.List;

public class ColorFavoriteViewModel extends ViewModel {
    private MutableLiveData<String> image = new MutableLiveData<>();

    public MutableLiveData<Boolean> getIsFavorite() {
        return isFavorite;
    }
    public void setIsFavorite(MutableLiveData<Boolean> isFavorite) {
        this.isFavorite = isFavorite;
    }

    private MutableLiveData<Boolean> isFavorite = new MutableLiveData<>();
    private MediatorLiveData<SettingsType> settings = new MediatorLiveData<>();
    private MediatorLiveData<List<ColorResponse>> colorFavorites = new MediatorLiveData<>();
    private MediatorLiveData<ColorResponse> response = new MediatorLiveData<>();
    private Repository repository;
    public ColorFavoriteViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<List<ColorResponse>> getColorFavorites() {
        if (null == colorFavorites.getValue()) {
            colorFavorites.addSource(repository.getColorFavorites(), new Observer<List<ColorResponse>>() {
                @Override
                public void onChanged(List<ColorResponse> response) {
                    colorFavorites.setValue(response);
                }
            });
        }
        return colorFavorites;
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
    public LiveData<ColorResponse> getFavorite(String image) {
        if (null == response.getValue()) {
            response.addSource(repository.getColorFavorite(image), new Observer<ColorResponse>() {
                @Override
                public void onChanged(ColorResponse dataType) {
                    response.setValue(dataType);
                }
            });
        }
        return response;
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
    public void setImage(String image) {
        this.image.setValue(image);
    }
    public LiveData<String> getImage() {
        return image;
    }

    @Override
    protected void onCleared() {
        if (!isFavorite.getValue()) {
            repository.removeColorFavorite(image.getValue());
        }
        super.onCleared();
    }
}
