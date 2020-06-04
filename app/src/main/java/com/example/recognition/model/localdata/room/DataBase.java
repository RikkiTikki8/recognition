package com.example.recognition.model.localdata.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.example.recognition.model.localdata.room.dao.ColorResponseDao;
import com.example.recognition.model.localdata.room.dao.DemographicResponseDao;
import com.example.recognition.model.localdata.room.dao.GeneralResponseDao;
import com.example.recognition.model.localdata.room.entity.ColorResponse;
import com.example.recognition.model.localdata.room.entity.DemographicResponse;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;

@Database(entities = {
        GeneralResponse.class,
        DemographicResponse.class,
        ColorResponse.class},
        version = 1)
@TypeConverters({DataConverter.class})
public abstract class DataBase extends RoomDatabase {
    public abstract GeneralResponseDao generalResponseDao();
    public abstract DemographicResponseDao demographicsResponseDao();
    public abstract ColorResponseDao colorResponseDao();
}
