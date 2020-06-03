package com.example.recognition.viewmodel.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.types.data.ColorDataType;

public class ColorFavoriteViewModel extends ViewModel {
    private MediatorLiveData<ColorDataType> response = new MediatorLiveData<>();
    private Repository repository;
    public ColorFavoriteViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<ColorDataType> getFavorite(String image) {
        if (null == response.getValue()) {
            response.addSource(repository.getColorFavorite(image), new Observer<ColorDataType>() {
                @Override
                public void onChanged(ColorDataType dataType) {
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
