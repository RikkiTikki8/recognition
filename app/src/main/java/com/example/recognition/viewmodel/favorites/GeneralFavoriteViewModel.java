package com.example.recognition.viewmodel.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;

public class GeneralFavoriteViewModel extends ViewModel {
    private MediatorLiveData<GeneralResponse> response = new MediatorLiveData<>();
    private Repository repository;
    public GeneralFavoriteViewModel(Repository repository) {
        this.repository = repository;
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
}
