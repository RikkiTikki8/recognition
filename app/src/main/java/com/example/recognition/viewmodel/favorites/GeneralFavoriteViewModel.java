package com.example.recognition.viewmodel.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.types.response.GeneralResponseType;

public class GeneralFavoriteViewModel extends ViewModel {
    private MediatorLiveData<GeneralResponseType> response = new MediatorLiveData<>();
    private Repository repository;
    public GeneralFavoriteViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<GeneralResponseType> getFavorite(String image) {
        if (null == response.getValue()) {
            response.addSource(repository.getGeneralFavorite(image), new Observer<GeneralResponseType>() {
                @Override
                public void onChanged(GeneralResponseType responseType) {
                    response.setValue(responseType);
                }
            });
        }
        return response;
    }
}
