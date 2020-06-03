package com.example.recognition.viewmodel.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.types.data.DemographicDataType;

public class DemographicFavoriteViewModel extends ViewModel {
    private MediatorLiveData<DemographicDataType> response = new MediatorLiveData<>();
    private Repository repository;
    public DemographicFavoriteViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<DemographicDataType> getFavorite(String image) {
        if (null == response.getValue()) {
            response.addSource(repository.getDemographicFavorite(image), new Observer<DemographicDataType>() {
                @Override
                public void onChanged(DemographicDataType dataType) {
                    response.setValue(dataType);
                }
            });
        }
        return response;
    }
}
