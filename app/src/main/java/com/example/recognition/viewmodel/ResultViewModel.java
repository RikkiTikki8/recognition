package com.example.recognition.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;

public class ResultViewModel extends ViewModel {
    private Repository repository;
    public ResultViewModel(Repository repository) {
        this.repository = repository;
    }
}
