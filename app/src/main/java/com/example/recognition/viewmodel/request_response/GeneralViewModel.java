package com.example.recognition.viewmodel.request_response;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;
import com.example.recognition.types.data.GeneralDataType;

public class GeneralViewModel extends ViewModel {
    private MutableLiveData<String> image;
    private MediatorLiveData<GeneralDataType> data;
    private Repository repository;
    public GeneralViewModel(Repository repository) {
        this.repository = repository;
    }
    public LiveData<GeneralDataType> getData() {
        if (null == data.getValue()) {
            data.addSource(repository.getGeneralData(image.getValue()), new Observer<GeneralDataType>() {
                @Override
                public void onChanged(GeneralDataType generalDataType) {
                    data.setValue(generalDataType);
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
