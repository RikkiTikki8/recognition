package com.example.recognition.viewmodel.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.types.data.GeneralDataType;

public class GeneralFavoriteViewModel extends ViewModel {
    private MediatorLiveData<GeneralDataType> response = new MediatorLiveData<>();
    private Repository repository;
    public GeneralFavoriteViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<GeneralDataType> getFavorite(String image) {
        if (null == response.getValue()) {
            response.addSource(repository.getGeneralFavorite(image), new Observer<GeneralDataType>() {
                @Override
                public void onChanged(GeneralDataType dataType) {
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
