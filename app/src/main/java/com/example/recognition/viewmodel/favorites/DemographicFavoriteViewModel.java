package com.example.recognition.viewmodel.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.model.localdata.room.entity.DemographicResponse;

public class DemographicFavoriteViewModel extends ViewModel {
    private MediatorLiveData<DemographicResponse> response = new MediatorLiveData<>();
    private Repository repository;
    public DemographicFavoriteViewModel(Repository repository) {
        this.repository = repository;
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
}
