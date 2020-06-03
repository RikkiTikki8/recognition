package com.example.recognition.model;

import com.example.recognition.types.SettingsType;
import com.example.recognition.types.data.ColorDataType;
import com.example.recognition.types.data.DemographicDataType;
import com.example.recognition.types.data.GeneralDataType;
import com.example.recognition.types.response.ColorResponseType;
import com.example.recognition.types.response.DemographicResponseType;
import com.example.recognition.types.response.GeneralResponseType;

public class DataMapper {
    public static SettingsType getSettingMap() {
        return new SettingsType(0);
    }
    public static GeneralResponseType getGeneralResponseMap() {
        GeneralResponseType mapData = new GeneralResponseType();
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
    public static DemographicResponseType getDemographicResponseMap() {
        DemographicResponseType mapData = new DemographicResponseType();
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
    public static ColorResponseType getColorResponseMap() {
        ColorResponseType mapData = new ColorResponseType();
        mapData.setImage("");
        mapData.setData(getColorDataMap());
        return mapData;
    }
    public static ColorDataType getColorDataMap() {
        ColorDataType mapData = new ColorDataType();
        ColorDataType.Color mapColor = new ColorDataType.Color("", "", 0);
        mapData.setColors(new ColorDataType.Color[]{mapColor});
        return mapData;
    }
}
