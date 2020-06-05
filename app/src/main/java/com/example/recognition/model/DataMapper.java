package com.example.recognition.model;

import com.example.recognition.model.localdata.room.entity.ColorResponse;
import com.example.recognition.model.localdata.room.entity.DemographicResponse;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;
import com.example.recognition.types.SettingsType;
import com.example.recognition.types.ColorDataType;
import com.example.recognition.types.DemographicDataType;
import com.example.recognition.types.GeneralDataType;

public class DataMapper {
    public static SettingsType getSettingMap() {
        return new SettingsType(0);
    }
    public static GeneralResponse getGeneralResponseMap() {
        GeneralResponse mapData = new GeneralResponse();
        mapData.setImage("");
        mapData.setData(getGeneralDataMap());
        return mapData;
    }
    public static GeneralDataType getGeneralDataMap() {
        GeneralDataType mapData = new GeneralDataType();
        GeneralDataType.Property mapProperty = new GeneralDataType.Property();
        mapProperty.setName("");
        mapProperty.setValue(0);
        mapData.setProperties(new GeneralDataType.Property[]{mapProperty});
        return mapData;
    }
    public static DemographicResponse getDemographicResponseMap() {
        DemographicResponse mapData = new DemographicResponse();
        mapData.setImage("");
        mapData.setData(getDemographicDataMap());
        return mapData;
    }
    public static DemographicDataType getDemographicDataMap() {
        DemographicDataType mapData = new DemographicDataType();
        DemographicDataType.Face mapFace = new DemographicDataType.Face();
        mapFace.setFrame(new DemographicDataType.Face.Frame(0, 0, 0, 0));
        DemographicDataType.Face.AgeAppearance mapAgeAppearance
                = new DemographicDataType.Face.AgeAppearance("", 0);
        mapFace.setAgesAppearance(new DemographicDataType.Face.AgeAppearance[]{mapAgeAppearance});
        DemographicDataType.Face.GenderAppearance mapGenderAppearance
                = new DemographicDataType.Face.GenderAppearance("", 0);
        mapFace.setGendersAppearance(new DemographicDataType.Face.GenderAppearance[]{mapGenderAppearance});
        DemographicDataType.Face.MulticulturalAppearance mapMulticulturalAppearance
                = new DemographicDataType.Face.MulticulturalAppearance("",0);
        mapFace.setMulticulturalAppearances(new DemographicDataType.Face.MulticulturalAppearance[]{mapMulticulturalAppearance});
        mapData.setFaces(new DemographicDataType.Face[]{mapFace});
        return mapData;
    }
    public static ColorResponse getColorResponseMap() {
        ColorResponse mapData = new ColorResponse();
        mapData.setImage("");
        mapData.setData(getColorDataMap());
        return mapData;
    }
    public static ColorDataType getColorDataMap() {
        ColorDataType mapData = new ColorDataType();
        ColorDataType.Color mapColor = new ColorDataType.Color("#FFFFFF", "", 0);
        mapData.setColors(new ColorDataType.Color[]{mapColor});
        return mapData;
    }
}
