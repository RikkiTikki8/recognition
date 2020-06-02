package com.example.recognition.model.localdata.room;

import androidx.room.TypeConverter;

import com.example.recognition.model.localdata.room.entity.ModelEntity;


public class ModelConverter {
    @TypeConverter
    public ModelEntity toModel(String model) {
        return new ModelEntity(model);
    }
    @TypeConverter
    public String toString(ModelEntity model) {
        return model.getModel();
    }
}
