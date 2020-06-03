package com.example.recognition.model.localdata.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.recognition.model.localdata.room.dao.ColorResponseDao;
import com.example.recognition.model.localdata.room.dao.DemographicResponseDao;
import com.example.recognition.model.localdata.room.dao.GeneralResponseDao;
import com.example.recognition.model.localdata.room.dao.ModelsDao;
import com.example.recognition.model.localdata.room.entity.ModelEntity;
import com.example.recognition.model.localdata.room.entity.GeneralResponseEntity;

@TypeConverters({ResponseConverter.class})
@Database(entities = {
        ModelEntity.class,
        GeneralResponseEntity.class,
        DemographicResponseDao.class,
        ColorResponseDao.class},
        version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract ModelsDao modelsDao();
    public abstract GeneralResponseDao generalResponseDao();
    public abstract DemographicResponseDao demographicsResponseDao();
    public abstract ColorResponseDao colorResponseDao();
}
