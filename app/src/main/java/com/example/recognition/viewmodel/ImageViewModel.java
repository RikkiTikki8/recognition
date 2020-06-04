package com.example.recognition.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ImageViewModel extends ViewModel {
    MutableLiveData<String> image = new MutableLiveData<>();
    public void setImage(String image) {
        this.image.setValue(image);
    }
    public LiveData<String> getImage() {
        return image;
    }
}
