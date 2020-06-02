package com.example.recognition.model.localdata.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;

import com.example.recognition.model.localdata.room.ResponseConverter;
import com.example.recognition.model.localdata.room.entity.ColorResponse;

import java.util.List;

@Dao
@TypeConverters({ResponseConverter.class})
public interface ResponseColorDao {
    @Query("SELECT * FROM ColorResponse")
    LiveData<List<ColorResponse>> getFavorites();
    @Query("SELECT * FROM ColorResponse WHERE image = :image")
    LiveData<ColorResponse> getFavorite(String image);
    @Insert
    void addResponse(ColorResponse response);
    @Delete
    void removeResponse(ColorResponse response);
}
