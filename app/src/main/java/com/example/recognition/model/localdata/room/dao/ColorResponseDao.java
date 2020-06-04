package com.example.recognition.model.localdata.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.recognition.model.localdata.room.entity.ColorResponse;

import java.util.List;

@Dao
public interface ColorResponseDao {
    @Query("SELECT * FROM ColorResponse")
    LiveData<List<ColorResponse>> getFavorites();
    @Query("SELECT * FROM ColorResponse WHERE image = :image")
    LiveData<ColorResponse> getFavorite(String image);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addResponse(ColorResponse response);
    @Query("DELETE FROM ColorResponse WHERE image = :image")
    void removeResponse(String image);
}
