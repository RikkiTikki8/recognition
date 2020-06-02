package com.example.recognition.model.localdata.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.recognition.types.response.ColorResponseType;

import java.util.List;

@Dao
public interface ColorResponseDao {
    @Query("SELECT * FROM ColorResponseEntity")
    LiveData<List<ColorResponseType>> getFavorites();
    @Query("SELECT * FROM ColorResponseEntity WHERE image = :image")
    LiveData<ColorResponseType> getFavorite(String image);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addResponse(ColorResponseType response);
    @Delete
    void removeResponse(ColorResponseType response);
}
