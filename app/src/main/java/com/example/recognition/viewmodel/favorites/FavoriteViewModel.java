package com.example.recognition.viewmodel.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.example.recognition.model.Repository;
import com.example.recognition.types.response.ColorResponseType;
import com.example.recognition.types.response.DemographicResponseType;
import com.example.recognition.types.response.GeneralResponseType;
import java.util.List;

public class FavoriteViewModel extends ViewModel {
    private Repository repository;
    private MediatorLiveData<List<GeneralResponseType>> generalFavorites = new MediatorLiveData<>();
    private MediatorLiveData<List<DemographicResponseType>> demographicFavorites = new MediatorLiveData<>();
    private MediatorLiveData<List<ColorResponseType>> colorFavorites = new MediatorLiveData<>();

    public FavoriteViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<List<GeneralResponseType>> getGeneralFavorites() {
        if (null == generalFavorites.getValue()) {
            generalFavorites.addSource(repository.getGeneralFavorites(), new Observer<List<GeneralResponseType>>() {
                @Override
                public void onChanged(List<GeneralResponseType> response) {
                    generalFavorites.setValue(response);
                }
            });
        }
        return generalFavorites;
    }
    public LiveData<List<DemographicResponseType>> getDemographicFavorites() {
        if (null == demographicFavorites.getValue()) {
            demographicFavorites.addSource(repository.getDemographicFavorites(), new Observer<List<DemographicResponseType>>() {
                @Override
                public void onChanged(List<DemographicResponseType> response) {
                    demographicFavorites.setValue(response);
                }
            });
        }
        return demographicFavorites;
    }
    public LiveData<List<ColorResponseType>> getColorFavorites() {
        if (null == colorFavorites.getValue()) {
            colorFavorites.addSource(repository.getColorFavorites(), new Observer<List<ColorResponseType>>() {
                @Override
                public void onChanged(List<ColorResponseType> response) {
                    colorFavorites.setValue(response);
                }
            });
        }
        return colorFavorites;
    }
}