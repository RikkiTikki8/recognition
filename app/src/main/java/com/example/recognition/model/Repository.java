package com.example.recognition.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recognition.model.localdata.room.entity.DemographicResponse;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;
import com.example.recognition.types.SettingsType;
import com.example.recognition.model.localdata.room.entity.ColorResponse;

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
    public void setThreshold(final int threshold) {
        executorIO.execute(new Runnable() {
            @Override
            public void run() {
                localDataSource.setThreshold(threshold);
            }
        });
    }
    public LiveData<GeneralResponse> getGeneralResponse(final String image) {
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
    public LiveData<List<GeneralResponse>> getGeneralFavorites() {
        return localDataSource.getGeneralFavorites();
    }
    public void addLastGeneralToFavorites() {
        executorIO.execute(new Runnable() {
            @Override
            public void run() {
                localDataSource.addLastGeneralResponseToFavorite();
            }
        });
    }
    public LiveData<GeneralResponse> getGeneralFavorite(String image) {
        return localDataSource.getGeneralFavorite(image);
    }
    public void removeGeneralFavorite(final String image) {
        executorIO.execute(new Runnable() {
               @Override
               public void run() {
                   localDataSource.removeGeneralFavoriteResponse(image);
               }
           }
        );
    }
    public LiveData<DemographicResponse> getDemographicResponse(final String image) {
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
    public LiveData<List<DemographicResponse>> getDemographicFavorites() {
        return localDataSource.getDemographicFavorites();
    }
    public void addLastDemographicToFavorites() {
        executorIO.execute(new Runnable() {
            @Override
            public void run() {
                localDataSource.addLastDemographicResponseToFavorite();
            }
        });
    }
    public LiveData<DemographicResponse> getDemographicFavorite (String image) {
        return localDataSource.getDemographicFavorite(image);
    }
    public void removeDemographicFavorite(final String image) {
        executorIO.execute(new Runnable() {
               @Override
               public void run() {
                   localDataSource.removeDemographicFavoriteResponse(image);
               }
           }
        );
    }
    public LiveData<ColorResponse> getColorResponse(final String image) {
        loadStatus.setValue(true);
        executorIO.execute(new Runnable() {
            @Override
            public void run() {
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
    public LiveData<List<ColorResponse>> getColorFavorites() {
        return localDataSource.getColorFavorites();
    }
    public void addLastColorToFavorites() {
        executorIO.execute(new Runnable() {
            @Override
            public void run() {
                localDataSource.addLastColorResponseToFavorite();
            }
        });
    }
    public LiveData<ColorResponse> getColorFavorite(String image) {
        return localDataSource.getColorFavorite(image);
    }
    public void removeColorFavorite(final String image) {
        executorIO.execute(new Runnable() {
            @Override
            public void run() {
                localDataSource.removeColorFavoriteResponse(image);
            }
        });
    }
    public LiveData<Boolean> getLoadStatus() {
        return loadStatus;
    }
}
