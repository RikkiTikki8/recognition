package com.example.recognition.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.recognition.model.Repository;

public class OptionsViewModel extends ViewModel {
    private Repository repository;
    public OptionsViewModel(Repository repository) {
        this.repository = repository;
    }
}
