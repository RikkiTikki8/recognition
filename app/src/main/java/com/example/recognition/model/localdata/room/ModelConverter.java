package com.example.recognition.model.localdata.room;

import androidx.room.TypeConverter;

import com.example.recognition.model.localdata.room.entity.Model;


public class ModelConverter {
    @TypeConverter
    public Model toModel(String model) {
        return new Model(model);
    }

}
