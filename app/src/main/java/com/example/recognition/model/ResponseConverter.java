package com.example.recognition.model;

import com.example.recognition.model.remoutdata.ColorResponsePojo;
import com.example.recognition.model.remoutdata.DemographicResponsePojo;
import com.example.recognition.model.remoutdata.DemographicResponsePojo.Output.Data.Region.RegionInfo.BoundingBox;
import com.example.recognition.model.remoutdata.GeneralResponsePojo;
import com.example.recognition.model.remoutdata.GeneralResponsePojo.Results.Outputs;
import com.example.recognition.model.remoutdata.GeneralResponsePojo.Results.Outputs.Data.Concepts;
import com.example.recognition.types.data.ColorDataType;
import com.example.recognition.types.data.ColorDataType.Color;
import com.example.recognition.types.data.DemographicDataType;
import com.example.recognition.types.data.DemographicDataType.Face.AgeAppearance;
import com.example.recognition.types.data.DemographicDataType.Face.Frame;
import com.example.recognition.types.data.DemographicDataType.Face.GenderAppearance;
import com.example.recognition.types.data.DemographicDataType.Face.MulticulturalAppearance;
import com.example.recognition.types.data.GeneralDataType;
import com.example.recognition.types.data.GeneralDataType.Property;
import com.example.recognition.types.response.ColorResponseType;
import com.example.recognition.types.response.DemographicResponseType;
import com.example.recognition.types.response.GeneralResponseType;

import java.util.ArrayList;
import java.util.List;

import static com.example.recognition.model.remoutdata.ColorResponsePojo.Output.*;
import static com.example.recognition.model.remoutdata.DemographicResponsePojo.*;
import static com.example.recognition.model.remoutdata.GeneralResponsePojo.*;
import static com.example.recognition.types.data.DemographicDataType.*;

public class ResponseConverter {
    public static GeneralResponseType convert (String image, GeneralResponsePojo response) {
        GeneralResponseType responseType = new GeneralResponseType();
        responseType.setImage(image);
        GeneralDataType dataType;
        if (10000 == response.getStatus().getCode()) {
            dataType = new GeneralDataType();
            List<Property> propertyList = new ArrayList<>();
            Property property;
            for (Results result : response.getResults()) {
                for (Outputs output : result.getOutputs()) {
                    for (Concepts concept : output.getData().getConcepts()) {
                        property = new Property();
                        property.setValue(concept.getValue());
                        property.setName(concept.getName());
                        propertyList.add(property);
;                    }
                }
            }
            dataType.setProperties((Property[]) propertyList.toArray());
        } else {
            dataType = DataMapper.getGeneralDataMap();
        }
        responseType.setData(dataType);
        return responseType;
    }
    public static DemographicResponseType convert (String image, DemographicResponsePojo response) {
        DemographicResponseType responseType = new DemographicResponseType();
        responseType.setImage(image);
        DemographicDataType dataType;
        if (10000 == response.getStatus().getCode()) {
            dataType = new DemographicDataType();
            List<Face> faces = new ArrayList<>();
            Face face;
            for (Output output: response.getOutputs()) {
                for (Output.Data.Region region: output.getData().getRegions()) {
                    face = new Face();
                    BoundingBox box = region.getRegionInfo().getBoundingBox();
                    Frame frame = new Frame();
                    frame.setTop(box.getTopRow());
                    frame.setLeft(box.getLeftCol());
                    frame.setBottom(box.getBottomRow());
                    frame.setRight(box.getRightCol());
                    face.setFrame(frame);
                    List<AgeAppearance> ageAppearanceList = new ArrayList<>();
                    for (Output.Data.Region.RegionData.Face.Concept concept :
                            region.getData().getFace().getAgeAppearance().getConcepts()) {
                        ageAppearanceList.add(new AgeAppearance(concept.getName(), concept.getValue()));
                    }
                    face.setAgesAppearance((AgeAppearance[]) ageAppearanceList.toArray());
                    List<GenderAppearance> genderAppearanceList = new ArrayList<>();
                    for (Output.Data.Region.RegionData.Face.Concept concept :
                            region.getData().getFace().getGenderAppearance().getConcepts()) {
                        genderAppearanceList.add(new GenderAppearance(concept.getName(), concept.getValue()));
                    }
                    face.setGendersAppearance((GenderAppearance[]) genderAppearanceList.toArray());
                    List<MulticulturalAppearance> multiculturalAppearanceList = new ArrayList<>();
                    for (Output.Data.Region.RegionData.Face.Concept concept :
                            region.getData().getFace().getMulticulturalAppearance().getConcepts()) {
                        multiculturalAppearanceList.add(new MulticulturalAppearance(concept.getName(), concept.getValue()));
                    }
                    face.setMulticulturalAppearances((MulticulturalAppearance[]) multiculturalAppearanceList.toArray());
                    faces.add(face);
                }
            }
            dataType.setFaces((Face[]) faces.toArray());
        } else {
            dataType = DataMapper.getDemographicDataMap();
        }
        responseType.setData(dataType);
        return responseType;
    }
    public static ColorResponseType convert (String image, ColorResponsePojo response) {
        ColorResponseType responseType = new ColorResponseType();
        responseType.setImage(image);
        ColorDataType dataType;
        if (10000 == response.getStatus().getCode()) {
            dataType = new ColorDataType();
            List<Color> colorList = new ArrayList<>();
            for (ColorResponsePojo.Output output :response.getOutputs()) {
                for (Data.Color color: output.getData().getColors()) {
                    colorList.add(
                            new Color(color.getW3c().getHex(), color.getW3c().getName(), color.getValue())
                    );
                }
            }
            dataType.setColors((Color[]) colorList.toArray());
        } else {
            dataType = DataMapper.getColorDataMap();
        }
        responseType.setData(dataType);
        return responseType;
    }
}
