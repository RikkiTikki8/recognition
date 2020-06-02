package com.example.recognition.model.localdata.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.recognition.model.localdata.room.dao.ModelsDao;
<<<<<<< HEAD
import com.example.recognition.model.localdata.room.dao.ResponseGeneralDao;
=======
import com.example.recognition.model.localdata.room.dao.GeneralResponseDao;
>>>>>>> 71d1eea35b61b0fd5a5c1c21c92c58fbec7baef8
import com.example.recognition.model.localdata.room.entity.Model;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;
@Database(entities = {Model.class, GeneralResponse.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract ModelsDao modelsDao();
<<<<<<< HEAD
    public abstract ResponseGeneralDao responseDao();
=======
    public abstract GeneralResponseDao responseDao();
>>>>>>> 71d1eea35b61b0fd5a5c1c21c92c58fbec7baef8
}
