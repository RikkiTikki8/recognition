package com.example.recognition.viewmodel.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.types.response.DemographicResponseType;

public class DemographicFavoriteViewModel extends ViewModel {
    private MediatorLiveData<DemographicResponseType> response = new MediatorLiveData<>();
    private Repository repository;
    public DemographicFavoriteViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<DemographicResponseType> getFavorite(String image) {
        if (null == response.getValue()) {
            response.addSource(repository.getDemographicFavorite(image), new Observer<DemographicResponseType>() {
                @Override
                public void onChanged(DemographicResponseType responseType) {
                    response.setValue(responseType);
                }
            });
        }
        return response;
    }
}
