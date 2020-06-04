package com.example.recognition.viewmodel.response;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;

public class GeneralViewModel extends ViewModel {
    private MediatorLiveData<GeneralResponse> data = new MediatorLiveData<>();
    private Repository repository;
    public GeneralViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<GeneralResponse> getData(String image) {
        if (null == data.getValue()) {
            data.addSource(repository.getGeneralResponse(image), new Observer<GeneralResponse>() {
                @Override
                public void onChanged(GeneralResponse response) {
                    data.setValue(response);
                }
            });
        }
        return data;
    }
    public void addToFavorite() {
        repository.addLastGeneralToFavorites();
    }
}
