package com.example.recognition.viewmodel.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.model.localdata.room.entity.ColorResponse;

public class ColorFavoriteViewModel extends ViewModel {
    private MediatorLiveData<ColorResponse> response = new MediatorLiveData<>();
    private Repository repository;
    public ColorFavoriteViewModel(Repository repository) {
        this.repository = repository;
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
    public void removeFromFavorite(String image) {
        repository.removeColorFavorite(image);
    }
}
