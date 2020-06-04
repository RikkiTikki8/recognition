package com.example.recognition.viewmodel.request_response;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.types.response.GeneralResponseType;

public class GeneralViewModel extends ViewModel {
    private MutableLiveData<String> image = new MutableLiveData<>();
    private MediatorLiveData<GeneralResponseType> data = new MediatorLiveData<>();
    private Repository repository;
    public GeneralViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<GeneralResponseType> getData() {
        if (null == data.getValue()) {
            data.addSource(repository.getGeneralResponse(image.getValue()), new Observer<GeneralResponseType>() {
                @Override
                public void onChanged(GeneralResponseType response) {
                    data.setValue(response);
                }
            });
        }
        return data;
    }
    public void addToFavorite() {
        repository.addLastGeneralToFavorites();
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
