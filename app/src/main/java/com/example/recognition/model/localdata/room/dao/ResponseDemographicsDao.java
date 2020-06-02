package com.example.recognition.model.localdata.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;

import com.example.recognition.model.localdata.room.ResponseConverter;
import com.example.recognition.model.localdata.room.entity.DemographicsResponse;

import java.util.List;

@Dao
@TypeConverters({ResponseConverter.class})
public interface ResponseDemographicsDao {
    @Query("SELECT * FROM DemographicsResponse")
    LiveData<List<DemographicsResponse>> getFavorites();
    @Query("SELECT * FROM DemographicsResponse WHERE image = :image")
    LiveData<DemographicsResponse> getFavorite(String image);
    @Insert
    void addResponse(DemographicsResponse response);
    @Delete
    void removeResponse(DemographicsResponse response);
}
