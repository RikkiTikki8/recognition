package com.example.recognition.model.localdata.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.recognition.model.localdata.room.entity.GeneralResponse;

import java.util.List;

@Dao
public interface GeneralResponseDao {
    @Query("SELECT * FROM GeneralResponse")
    LiveData<List<GeneralResponse>> getFavorites();
    @Query("SELECT * FROM GeneralResponse WHERE image = :image")
    LiveData<GeneralResponse> getFavorite(String image);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addResponse(GeneralResponse response);
    @Query("DELETE FROM GeneralResponse WHERE image = :image")
    void removeResponse(String image);
}
