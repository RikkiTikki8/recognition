package com.example.recognition.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;

public class FavoriteViewModel extends ViewModel {
    private Repository repository;
    public FavoriteViewModel(Repository repository) {
        this.repository = repository;
    }
}