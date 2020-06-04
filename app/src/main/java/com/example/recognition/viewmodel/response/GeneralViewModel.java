package com.example.recognition.viewmodel.response;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;

public class GeneralViewModel extends ViewModel {
    private MutableLiveData<String> image = new MutableLiveData<>();
    private MediatorLiveData<GeneralResponse> data = new MediatorLiveData<>();
    private Repository repository;
    public GeneralViewModel(Repository repository) {
        this.repository = repository;
    }
    public void setImage(String image) {
        this.image.setValue(image);
    }
    public LiveData<String> getImage() {
        return image;
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
