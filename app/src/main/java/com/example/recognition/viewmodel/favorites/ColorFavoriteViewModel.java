package com.example.recognition.viewmodel.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.types.response.ColorResponseType;

public class ColorFavoriteViewModel extends ViewModel {
    private MediatorLiveData<ColorResponseType> response = new MediatorLiveData<>();
    private Repository repository;
    public ColorFavoriteViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<ColorResponseType> getFavorite(String image) {
        if (null == response.getValue()) {
            response.addSource(repository.getColorFavorite(image), new Observer<ColorResponseType>() {
                @Override
                public void onChanged(ColorResponseType responseType) {
                    response.setValue(responseType);
                }
            });
        }
        return response;
    }

}
