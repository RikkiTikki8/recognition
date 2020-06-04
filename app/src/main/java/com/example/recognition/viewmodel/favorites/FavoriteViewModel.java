package com.example.recognition.viewmodel.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.example.recognition.model.Repository;
import com.example.recognition.model.localdata.room.entity.ColorResponse;
import com.example.recognition.model.localdata.room.entity.DemographicResponse;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;

import java.util.List;

public class FavoriteViewModel extends ViewModel {
    private Repository repository;
    private MediatorLiveData<List<GeneralResponse>> generalFavorites = new MediatorLiveData<>();
    private MediatorLiveData<List<DemographicResponse>> demographicFavorites = new MediatorLiveData<>();
    private MediatorLiveData<List<ColorResponse>> colorFavorites = new MediatorLiveData<>();

    public FavoriteViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<List<GeneralResponse>> getGeneralFavorites() {
        if (null == generalFavorites.getValue()) {
            generalFavorites.addSource(repository.getGeneralFavorites(), new Observer<List<GeneralResponse>>() {
                @Override
                public void onChanged(List<GeneralResponse> response) {
                    generalFavorites.setValue(response);
                }
            });
        }
        return generalFavorites;
    }
    public LiveData<List<DemographicResponse>> getDemographicFavorites() {
        if (null == demographicFavorites.getValue()) {
            demographicFavorites.addSource(repository.getDemographicFavorites(), new Observer<List<DemographicResponse>>() {
                @Override
                public void onChanged(List<DemographicResponse> response) {
                    demographicFavorites.setValue(response);
                }
            });
        }
        return demographicFavorites;
    }
    public LiveData<List<ColorResponse>> getColorFavorites() {
        if (null == colorFavorites.getValue()) {
            colorFavorites.addSource(repository.getColorFavorites(), new Observer<List<ColorResponse>>() {
                @Override
                public void onChanged(List<ColorResponse> response) {
                    colorFavorites.setValue(response);
                }
            });
        }
        return colorFavorites;
    }
}