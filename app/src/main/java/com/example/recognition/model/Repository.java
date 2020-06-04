package com.example.recognition.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recognition.model.remoutdata.ColorResponsePojo;
import com.example.recognition.model.remoutdata.DemographicResponsePojo;
import com.example.recognition.model.remoutdata.GeneralResponsePojo;
import com.example.recognition.types.SettingsType;
import com.example.recognition.types.data.ColorDataType;
import com.example.recognition.types.data.DemographicDataType;
import com.example.recognition.types.data.GeneralDataType;
import com.example.recognition.types.response.ColorResponseType;
import com.example.recognition.types.response.DemographicResponseType;
import com.example.recognition.types.response.GeneralResponseType;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Repository {
    private Executor executorIO = Executors.newSingleThreadExecutor();
    private MutableLiveData<Boolean> loadStatus = new MutableLiveData<>();
    private LocalDataSource localDataSource;
    private RemoteDataSource remoteDataSource;
    public Repository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }
    public LiveData<SettingsType> getSettings() {
        return localDataSource.getSettings();
    }
    public void setThreshold(int threshold) {
        localDataSource.setThreshold(threshold);
    }
    public LiveData<GeneralResponseType> getGeneralResponse(final String image) {
        executorIO.execute(new Runnable() {
            @Override
            public void run() {
                loadStatus.setValue(true);
                try {
                    localDataSource.setLastGeneralResponse(
                            ResponseConverter.convertGeneral(
                                image, remoteDataSource.fetchGeneralData(image)
                            )
                    );
                } catch (IOException e) {

                }
                loadStatus.setValue(false);
            }
        });
        return localDataSource.getLastGeneralData();
    }
    public LiveData<List<GeneralResponseType>> getGeneralFavorites() {
        return localDataSource.getGeneralFavorites();
    }
    public void addLastGeneralToFavorites() {
        localDataSource.addLastGeneralResponseToFavorite();
    }
    public LiveData<GeneralResponseType> getGeneralFavorite(String image) {
        return localDataSource.getGeneralFavorite(image);
    }
    public void removeGeneralFavorite(String image) {
        localDataSource.removeGeneralFavoriteResponse(image);
    }
    public LiveData<DemographicResponseType> getDemographicResponse(final String image) {
        executorIO.execute(new Runnable() {
            @Override
            public void run() {
                loadStatus.setValue(true);
                try {
                    localDataSource.setLastDemographicResponse(
                            ResponseConverter.convertDemographic(
                                    image, remoteDataSource.fetchDemographicData(image)
                            )
                    );
                } catch (IOException e) {

                }
                loadStatus.setValue(false);
            }
        });
        return localDataSource.getLastDemographicData();
    }
    public LiveData<List<DemographicResponseType>> getDemographicFavorites() {
        return localDataSource.getDemographicFavorites();
    }
    public void addLastDemographicToFavorites() {
        localDataSource.addLastDemographicResponseToFavorite();
    }
    public LiveData<DemographicResponseType> getDemographicFavorite (String image) {
        return localDataSource.getDemographicFavorite(image);
    }
    public void removeDemographicFavorite(String image) {
        localDataSource.removeDemographicFavoriteResponse(image);
    }
    public LiveData<ColorResponseType> getColorResponse(final String image) {
        executorIO.execute(new Runnable() {
            @Override
            public void run() {
                loadStatus.setValue(true);
                try {
                    localDataSource.setLastColorResponse(
                            ResponseConverter.convertColor(
                                    image, remoteDataSource.fetchColorData(image)
                            )
                    );
                } catch (IOException e) {

                }
                loadStatus.setValue(false);
            }
        });
        return localDataSource.getLastColorData();
    }
    public LiveData<List<ColorResponseType>> getColorFavorites() {
        return localDataSource.getColorFavorites();
    }
    public void addLastColorToFavorites() {
        localDataSource.addLastColorResponseToFavorite();
    }
    public LiveData<ColorResponseType> getColorFavorite(String image) {
        return localDataSource.getColorFavorite(image);
    }
    public void removeColorFavorite(String image) {
        localDataSource.removeColorFavoriteResponse(image);
    }
    public LiveData<Boolean> getLoadStatus() {
        return loadStatus;
    }
}
