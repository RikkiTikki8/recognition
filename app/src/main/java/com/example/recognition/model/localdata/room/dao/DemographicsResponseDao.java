package com.example.recognition.model.localdata.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;

import com.example.recognition.model.localdata.room.ResponseConverter;
import com.example.recognition.types.GeneralResponse;
import com.example.recognition.types.response.DemographicsResponse;
import java.util.List;

@Dao
@TypeConverters({ResponseConverter.class})
public interface DemographicsResponseDao {
    @Query("SELECT * FROM demographicsresponse")
    LiveData<List<DemographicsResponse>> getFavorites();
    @Query("SELECT * FROM demographicsresponse WHERE image = :image")
    LiveData<DemographicsResponse> getFavorite(String image);
    @Insert
    void addResponse(GeneralResponse generalResponse);
    @Delete
    void removeResponse(GeneralResponse generalResponse);
}
