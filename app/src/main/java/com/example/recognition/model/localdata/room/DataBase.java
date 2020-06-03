package com.example.recognition.model.localdata.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.example.recognition.model.localdata.room.dao.ColorResponseDao;
import com.example.recognition.model.localdata.room.dao.DemographicResponseDao;
import com.example.recognition.model.localdata.room.dao.GeneralResponseDao;
import com.example.recognition.model.localdata.room.entity.GeneralResponseEntity;

@TypeConverters({ResponseConverter.class})
@Database(entities = {
        GeneralResponseEntity.class,
        DemographicResponseDao.class,
        ColorResponseDao.class},
        version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract GeneralResponseDao generalResponseDao();
    public abstract DemographicResponseDao demographicsResponseDao();
    public abstract ColorResponseDao colorResponseDao();
}
