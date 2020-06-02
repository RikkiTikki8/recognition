package com.example.recognition.model.localdata.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;

import com.example.recognition.model.localdata.room.ResponseConverter;
<<<<<<< HEAD:app/src/main/java/com/example/recognition/model/localdata/room/dao/ResponseGeneralDao.java
import com.example.recognition.model.localdata.room.entity.GeneralResponse;
=======
import com.example.recognition.types.GeneralResponse;
>>>>>>> 71d1eea35b61b0fd5a5c1c21c92c58fbec7baef8:app/src/main/java/com/example/recognition/model/localdata/room/dao/GeneralResponseDao.java

import java.util.List;

@Dao
@TypeConverters({ResponseConverter.class})
<<<<<<< HEAD:app/src/main/java/com/example/recognition/model/localdata/room/dao/ResponseGeneralDao.java
public interface ResponseGeneralDao {
=======
public interface GeneralResponseDao {
>>>>>>> 71d1eea35b61b0fd5a5c1c21c92c58fbec7baef8:app/src/main/java/com/example/recognition/model/localdata/room/dao/GeneralResponseDao.java
    @Query("SELECT * FROM GeneralResponse")
    LiveData<List<GeneralResponse>> getFavorites();
    @Query("SELECT * FROM GeneralResponse WHERE image = :image")
    LiveData<GeneralResponse> getFavorite(String image);
    @Insert
<<<<<<< HEAD:app/src/main/java/com/example/recognition/model/localdata/room/dao/ResponseGeneralDao.java
    void addResponse(GeneralResponse response);
    @Delete
    void removeResponse(GeneralResponse response);
=======
    void addResponse(GeneralResponse generalResponse);
    @Delete
    void removeResponse(GeneralResponse generalResponse);
>>>>>>> 71d1eea35b61b0fd5a5c1c21c92c58fbec7baef8:app/src/main/java/com/example/recognition/model/localdata/room/dao/GeneralResponseDao.java
}
