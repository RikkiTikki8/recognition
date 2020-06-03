package com.example.recognition.viewmodel.request_response;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.types.data.ColorDataType;

public class ColorViewModel extends ViewModel {
    private MutableLiveData<String> image;
    private MediatorLiveData<ColorDataType> data;
    private Repository repository;
    public ColorViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<ColorDataType> getData() {
        if (null == data.getValue()) {
            data.addSource(repository.getColorData(image.getValue()), new Observer<ColorDataType>() {
                @Override
                public void onChanged(ColorDataType colorDataType) {
                    data.setValue(colorDataType);
                }
            });
        }
        return data;
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
