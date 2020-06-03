package com.example.recognition.model.localdata.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.recognition.types.data.DemographicDataType;
import com.example.recognition.types.response.DemographicResponseType;
import java.util.List;

@Dao
public interface DemographicResponseDao {
    @Query("SELECT * FROM DemographicResponseEntity")
    LiveData<List<DemographicResponseType>> getFavorites();
    @Query("SELECT * FROM DemographicResponseEntity WHERE image = :image")
    LiveData<DemographicDataType> getFavorite(String image);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addResponse(DemographicResponseType response);
    @Query("DELETE FROM ColorResponseEntity WHERE image = :image")
    void removeResponse(String image);
}
