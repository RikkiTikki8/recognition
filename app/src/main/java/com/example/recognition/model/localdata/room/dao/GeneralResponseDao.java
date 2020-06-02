package com.example.recognition.model.localdata.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.recognition.types.response.GeneralResponseType;

import java.util.List;

@Dao
public interface GeneralResponseDao {
    @Query("SELECT * FROM GeneralResponseEntity")
    LiveData<List<GeneralResponseType>> getFavorites();
    @Query("SELECT * FROM GeneralResponseEntity WHERE image = :image")
    LiveData<GeneralResponseType> getFavorite(String image);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addResponse(GeneralResponseType response);
    @Delete
    void removeResponse(GeneralResponseType response);
}
