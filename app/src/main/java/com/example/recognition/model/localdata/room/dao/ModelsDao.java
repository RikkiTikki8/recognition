package com.example.recognition.model.localdata.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverters;

import com.example.recognition.model.localdata.room.ModelConverter;
import java.util.List;

@Dao
@TypeConverters({ModelConverter.class})
public interface ModelsDao {
    @Query("SELECT * FROM ModelEntity")
    LiveData<List<String>> getModels();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addModel(String model);
    @Insert
    void addModels(List<String> models);
    @Delete
    void removeModel(String model);
}
