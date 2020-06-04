package com.example.recognition.viewmodel.request_response;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.types.data.DemographicDataType;
import com.example.recognition.types.response.DemographicResponseType;

public class DemographicViewModel extends ViewModel {
    private MutableLiveData<String> image = new MutableLiveData<>();
    private MediatorLiveData<DemographicResponseType> data = new MediatorLiveData<>();
    private Repository repository;
    public DemographicViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<DemographicResponseType> getData() {
        if (null == data.getValue()) {
            data.addSource(repository.getDemographicResponse(image.getValue()), new Observer<DemographicResponseType>() {
                @Override
                public void onChanged(DemographicResponseType response) {
                    data.setValue(response);
                }
            });
        }
        return data;
    }
    public void addToFavorite() {
        repository.addLastDemographicToFavorites();
    }
    public void setImage(String image) {
        if (this.image.getValue() != image) {
            data.setValue(null);
            this.image.setValue(image);
        }
    }
    public LiveData<String> getImage() {
        return image;
    }
}
