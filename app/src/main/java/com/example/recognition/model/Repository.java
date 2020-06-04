package com.example.recognition.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recognition.model.localdata.room.entity.DemographicResponse;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;
import com.example.recognition.model.remoutdata.ColorResponsePojo;
import com.example.recognition.model.remoutdata.DemographicResponsePojo;
import com.example.recognition.model.remoutdata.GeneralResponsePojo;
import com.example.recognition.types.SettingsType;
import com.example.recognition.model.localdata.room.entity.ColorResponse;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Response;

public class Repository {
    private final String ERROR = "Ooops, something going wrong";
    private final String NETWORK_ERROR = "Please, check your internet connection";
    private Executor executorIO = Executors.newSingleThreadExecutor();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
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
                try {
                    Response<GeneralResponsePojo> responsePojo = remoteDataSource.fetchGeneralData(image);
                    if (!responsePojo.isSuccessful()) {
                        errorMessage.postValue(NETWORK_ERROR);
                    }
                    GeneralResponse response = ResponseConverter.convertGeneral(image, responsePojo);
                    localDataSource.setLastGeneralResponse(response);
                } catch (IOException e) {
                    errorMessage.postValue(ERROR);
                }
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
            public void run() { localDataSource.addLastGeneralResponseToFavorite();
            }
        });
    }
    public LiveData<GeneralResponse> getGeneralFavorite(String image) {
        return localDataSource.getGeneralFavorite(image);
    }
    public void removeGeneralFavorite(final String image) {
        executorIO.execute(new Runnable() {
               @Override
               public void run() { localDataSource.removeGeneralFavoriteResponse(image);
               }
           }
        );
    }
    public LiveData<DemographicResponse> getDemographicResponse(final String image) {
        executorIO.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<DemographicResponsePojo> responsePojo = remoteDataSource.fetchDemographicData(image);
                    if (!responsePojo.isSuccessful()) {
                        errorMessage.postValue(NETWORK_ERROR);
                    }
                    DemographicResponse response = ResponseConverter.convertDemographic(image, responsePojo);
                    localDataSource.setLastDemographicResponse(response);
                } catch (IOException e) {
                    errorMessage.postValue(ERROR);
                }
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
        executorIO.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<ColorResponsePojo> responsePojo = remoteDataSource.fetchColorData(image);
                    if (!responsePojo.isSuccessful()) {
                        errorMessage.postValue(NETWORK_ERROR);
                    }
                    ColorResponse response = ResponseConverter.convertColor(image, responsePojo);
                    localDataSource.setLastColorResponse(response);
                } catch (IOException e) {
                    errorMessage.postValue(ERROR);
                }
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
}
