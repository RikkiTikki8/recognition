package com.example.recognition.viewmodel.request_response;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.model.localdata.room.entity.ColorResponse;

public class ColorViewModel extends ViewModel {
    private MutableLiveData<String> image = new MutableLiveData<>();
    private MediatorLiveData<ColorResponse> data = new MediatorLiveData<>();
    private Repository repository;
    public ColorViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<ColorResponse> getData() {
        if (null == data.getValue()) {
            data.addSource(repository.getColorResponse(image.getValue()), new Observer<ColorResponse>() {
                @Override
                public void onChanged(ColorResponse response) {
                    data.setValue(response);
                }
            });
        }
        return data;
    }
    public void addToFavorite() {
        repository.addLastColorToFavorites();
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
