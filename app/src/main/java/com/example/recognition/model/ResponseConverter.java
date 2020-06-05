package com.example.recognition.model;

import android.util.Log;

import com.example.recognition.model.localdata.room.entity.ColorResponse;
import com.example.recognition.model.remoutdata.ColorResponsePojo;
import com.example.recognition.model.remoutdata.DemographicResponsePojo;
import com.example.recognition.model.remoutdata.DemographicResponsePojo.Output.Data.Region.RegionInfo.BoundingBox;
import com.example.recognition.model.remoutdata.GeneralResponsePojo;
import com.example.recognition.model.remoutdata.GeneralResponsePojo.Results.Outputs;
import com.example.recognition.model.remoutdata.GeneralResponsePojo.Results.Outputs.Data.Concept;
import com.example.recognition.types.ColorDataType;
import com.example.recognition.types.ColorDataType.Color;
import com.example.recognition.types.DemographicDataType;
import com.example.recognition.types.DemographicDataType.Face.AgeAppearance;
import com.example.recognition.types.DemographicDataType.Face.Frame;
import com.example.recognition.types.DemographicDataType.Face.GenderAppearance;
import com.example.recognition.types.DemographicDataType.Face.MulticulturalAppearance;
import com.example.recognition.types.GeneralDataType;
import com.example.recognition.types.GeneralDataType.Property;
import com.example.recognition.model.localdata.room.entity.DemographicResponse;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

import static com.example.recognition.model.remoutdata.ColorResponsePojo.Output.*;
import static com.example.recognition.model.remoutdata.DemographicResponsePojo.*;
import static com.example.recognition.model.remoutdata.GeneralResponsePojo.*;
import static com.example.recognition.types.DemographicDataType.*;

public class ResponseConverter {
    public static GeneralResponse convertGeneral (String image, Response<GeneralResponsePojo> retrofitResponse) {
        if (retrofitResponse.isSuccessful()) {
            GeneralResponsePojo response = retrofitResponse.body();
            GeneralResponse responseType = new GeneralResponse();
            responseType.setImage(image);
            GeneralDataType dataType;
            if (10000 == response.getStatus().getCode()) {
                dataType = new GeneralDataType();
                List<Property> propertyList = new ArrayList<>();
                Property property;
                for (Results result : response.getResults()) {
                    for (Outputs output : result.getOutputs()) {
                        for (Concept concept : output.getData().getConcepts()) {
                            property = new Property();
                            property.setValue(concept.getValue());
                            property.setName(concept.getName());
                            propertyList.add(property);
                        }
                    }
                }
                dataType.setProperties((Property[]) propertyList.toArray());
            } else {
                dataType = DataMapper.getGeneralDataMap();
            }
            responseType.setData(dataType);
            return responseType;
        } else {
            return DataMapper.getGeneralResponseMap();
        }
    }
    public static DemographicResponse convertDemographic (String image, Response<DemographicResponsePojo> retrofitResponse) {
        if (retrofitResponse.isSuccessful()) {
            DemographicResponsePojo response = retrofitResponse.body();
            DemographicResponse responseType = new DemographicResponse();
            responseType.setImage(image);
            DemographicDataType dataType;
            if (10000 == response.getStatus().getCode()) {
                dataType = new DemographicDataType();
                List<Face> faces = new ArrayList<>();
                Face face;
                for (Output output : response.getOutputs()) {
                    for (Output.Data.Region region : output.getData().getRegions()) {
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
        } else {
            return DataMapper.getDemographicResponseMap();
        }
    }
    public static ColorResponse convertColor (String image, Response<ColorResponsePojo> retrofitResponse) {
        //Log.d("Response", retrofitResponse.message());
        //Log.d("Response", retrofitResponse.headers().toString());
        if (retrofitResponse.isSuccessful()) {
            ColorResponsePojo response = retrofitResponse.body();
            ColorResponse responseType = new ColorResponse();
            responseType.setImage(image);
            ColorDataType dataType;
            if (10000 == response.getStatus().getCode()) {
                dataType = new ColorDataType();
                List<Color> colorList = new ArrayList<>();
                for (ColorResponsePojo.Output output : response.getOutputs()) {
                    for (Data.Color color : output.getData().getColors()) {
                        colorList.add(
                                new Color(color.getW3c().getHex(), color.getW3c().getName(), color.getValue()*100)
                        );
                    }
                }
//                for (ColorResponsePojo.Output output : response.getOutputs()) {
//                    for (ColorResponsePojo.Color color : output.getData().getColors()) {
//                        colorList.add(
//                                new Color(color.getW3c().getHex(), color.getW3c().getName(), String.valueOf((int)(color.getValue()*100)) + "%")
//                        );
//                    }
//                }
                dataType.setColors((Color[]) colorList.toArray());
            } else {
                dataType = DataMapper.getColorDataMap();
            }
            responseType.setData(dataType);
            return responseType;
        } else {
            return DataMapper.getColorResponseMap();
        }
    }
}
