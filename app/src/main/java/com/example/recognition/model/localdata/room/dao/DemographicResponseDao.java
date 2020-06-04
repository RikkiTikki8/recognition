package com.example.recognition.model.localdata.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.recognition.model.localdata.room.entity.DemographicResponse;

import java.util.List;

@Dao
public interface DemographicResponseDao {
    @Query("SELECT * FROM DemographicResponse")
    LiveData<List<DemographicResponse>> getFavorites();
    @Query("SELECT * FROM DemographicResponse WHERE image = :image")
    LiveData<DemographicResponse> getFavorite(String image);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addResponse(DemographicResponse response);
    @Query("DELETE FROM DemographicResponse WHERE image = :image")
    void removeResponse(String image);
}
