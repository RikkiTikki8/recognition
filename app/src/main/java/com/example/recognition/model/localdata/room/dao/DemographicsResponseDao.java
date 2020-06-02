package com.example.recognition.model.localdata.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.recognition.types.response.DemographicsResponseType;

import java.util.List;

@Dao
public interface DemographicsResponseDao {
    @Query("SELECT * FROM DemographicsResponseEntity")
    LiveData<List<DemographicsResponseType>> getFavorites();
    @Query("SELECT * FROM DemographicsResponseEntity WHERE image = :image")
    LiveData<DemographicsResponseType> getFavorite(String image);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addResponse(DemographicsResponseType response);
    @Delete
    void removeResponse(DemographicsResponseType response);
}
