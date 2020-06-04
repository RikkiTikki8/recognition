package com.example.recognition.viewmodel.request_response;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.model.localdata.room.entity.DemographicResponse;

public class DemographicViewModel extends ViewModel {
    private MutableLiveData<String> image = new MutableLiveData<>();
    private MediatorLiveData<DemographicResponse> data = new MediatorLiveData<>();
    private Repository repository;
    public DemographicViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<DemographicResponse> getData(String image) {
        if (null == data.getValue()) {
            data.addSource(repository.getDemographicResponse(image), new Observer<DemographicResponse>() {
                @Override
                public void onChanged(DemographicResponse response) {
                    data.setValue(response);
                }
            });
        }
        return data;
    }
    public void addToFavorite() {
        repository.addLastDemographicToFavorites();
    }
}
