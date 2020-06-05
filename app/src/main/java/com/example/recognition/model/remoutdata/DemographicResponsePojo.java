package com.example.recognition.model.remoutdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemographicResponsePojo {
    public static class Status {
        private int code;
        private String description;
        public void setCode(int code){
            this.code = code;
        }
        public int getCode(){
            return this.code;
        }
        public void setDescription(String description){
            this.description = description;
        }
        public String getDescription(){
            return this.description;
        }
    }
    private Status status;
    public static class Workflow {
        private String id;
        private String app_id;
        private String created_at;
        public void setId(String id){
            this.id = id;
        }
        public String getId(){
            return this.id;
        }
        public void setApp_id(String app_id){
            this.app_id = app_id;
        }
        public String getApp_id(){
            return this.app_id;
        }
        public void setCreated_at(String created_at){
            this.created_at = created_at;
        }
        public String getCreated_at(){
            return this.created_at;
        }
    }
    private Workflow workflow;
    public static class Results {
        public static class Input {
            private String id;
            public static class Data {
                public static class Image {
                    private String base64;
                    public void setBase64(String base64){
                        this.base64 = base64;
                    }
                    public String getBase64(){
                        return this.base64;
                    }
                }
                private Image image;
                public void setImage(Image image){
                    this.image = image;
                }
                public Image getImage(){
                    return this.image;
                }
            }
            private Data data;
            public void setId(String id){
                this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setData(Data data){
                this.data = data;
            }
            public Data getData(){
                return this.data;
            }
        }
        private Input input;
        public static class Status {
            private Integer code;
            private String description;

            public Integer getCode() {
                return code;
            }
            public void setCode(Integer code) {
                this.code = code;
            }
            public String getDescription() {
                return description;
            }
            public void setDescription(String description) {
                this.description = description;
            }
        }
        private Status status;
        public static class Output {
            private String id;
            private Status status;
            private String createdAt;
            public static class Model {
                private String name;
                private String id;
                private String createdAt;
                private Object appId;
                public static class OutputInfo {
                    private String message;
                    private String type;
                    private String typeExt;

                    public String getMessage() {
                        return message;
                    }
                    public void setMessage(String message) {
                        this.message = message;
                    }
                    public String getType() {
                        return type;
                    }
                    public void setType(String type) {
                        this.type = type;
                    }
                    public String getTypeExt() {
                        return typeExt;
                    }
                    public void setTypeExt(String typeExt) {
                        this.typeExt = typeExt;
                    }
                }
                private OutputInfo outputInfo;
                public static class ModelVersion {

                    private String id;
                    private String createdAt;
                    private DemographicResponsePojo.Status status;

                    public String getId() {
                        return id;
                    }
                    public void setId(String id) {
                        this.id = id;
                    }
                    public String getCreatedAt() {
                        return createdAt;
                    }
                    public void setCreatedAt(String createdAt) {
                        this.createdAt = createdAt;
                    }
                    public DemographicResponsePojo.Status getStatus() {
                        return status;
                    }
                    public void setStatus(DemographicResponsePojo.Status status) {
                        this.status = status;
                    }
                }
                private ModelVersion modelVersion;

                public String getName() {
                    return name;
                }
                public void setName(String name) {
                    this.name = name;
                }
                public String getId() {
                    return id;
                }
                public void setId(String id) {
                    this.id = id;
                }
                public String getCreatedAt() {
                    return createdAt;
                }
                public void setCreatedAt(String createdAt) {
                    this.createdAt = createdAt;
                }
                public Object getAppId() {
                    return appId;
                }
                public void setAppId(Object appId) {
                    this.appId = appId;
                }
                public OutputInfo getOutputInfo() {
                    return outputInfo;
                }
                public void setOutputInfo(OutputInfo outputInfo) {
                    this.outputInfo = outputInfo;
                }
                public ModelVersion getModelVersion() {
                    return modelVersion;
                }
                public void setModelVersion(ModelVersion modelVersion) {
                    this.modelVersion = modelVersion;
                }
            }
            private Model model;
            public static class Input {
                private String id;
                public static class Data {
                    public static class Image {
                        private String base64;

                        public String getBase64() {
                            return base64;
                        }
                        public void setBase64(String base64) {
                            this.base64 = base64;
                        }
                    }
                    private Image image;

                    public Image getImage() {
                        return image;
                    }
                    public void setImage(Image image) {
                        this.image = image;
                    }
                }
                private Data data;

                public String getId() {
                    return id;
                }
                public void setId(String id) {
                    this.id = id;
                }
                public Data getData() {
                    return data;
                }
                public void setData(Data data) {
                    this.data = data;
                }
            }
            private Input input;
            public static class Data {
                public static class Region {
                    public static class RegionInfo {
                        public static class BoundingBox {
                            private Double topRow;
                            private Double leftCol;
                            private Double bottomRow;
                            private Double rightCol;

                            public Double getTopRow() {
                                return topRow;
                            }
                            public void setTopRow(Double topRow) {
                                this.topRow = topRow;
                            }
                            public Double getLeftCol() {
                                return leftCol;
                            }
                            public void setLeftCol(Double leftCol) {
                                this.leftCol = leftCol;
                            }
                            public Double getBottomRow() {
                                return bottomRow;
                            }
                            public void setBottomRow(Double bottomRow) {
                                this.bottomRow = bottomRow;
                            }
                            public Double getRightCol() {
                                return rightCol;
                            }
                            public void setRightCol(Double rightCol) {
                                this.rightCol = rightCol;
                            }
                        }
                        private BoundingBox boundingBox;

                        public BoundingBox getBoundingBox() {
                            return boundingBox;
                        }
                        public void setBoundingBox(BoundingBox boundingBox) {
                            this.boundingBox = boundingBox;
                        }
                    }
                    private RegionInfo regionInfo;
                    public static class RegionData {
                        public static class Face {
                            public static class Concept {
                                private String id;
                                private String name;
                                private Object appId;
                                private Double value;

                                public String getId() {
                                    return id;
                                }
                                public void setId(String id) {
                                    this.id = id;
                                }
                                public String getName() {
                                    return name;
                                }
                                public void setName(String name) {
                                    this.name = name;
                                }
                                public Object getAppId() {
                                    return appId;
                                }
                                public void setAppId(Object appId) {
                                    this.appId = appId;
                                }
                                public Double getValue() {
                                    return value;
                                }
                                public void setValue(Double value) {
                                    this.value = value;
                                }
                            }
                            public static class AgeAppearance {
                                private List<Concept> concepts;

                                public List<Concept> getConcepts() {
                                    return concepts;
                                }
                                public void setConcepts(List<Concept> concepts) {
                                    this.concepts = concepts;
                                }
                            }
                            private AgeAppearance ageAppearance;
                            public static class GenderAppearance {
                                private List<Concept> concepts;

                                public List<Concept> getConcepts() {
                                    return concepts;
                                }
                                public void setConcepts(List<Concept> concepts) {
                                    this.concepts = concepts;
                                }
                            }
                            private GenderAppearance genderAppearance;
                            public static class MulticulturalAppearance {
                                private List<Concept> concepts;

                                public List<Concept> getConcepts() {
                                    return concepts;
                                }
                                public void setConcepts(List<Concept> concepts) {
                                    this.concepts = concepts;
                                }
                            }
                            private MulticulturalAppearance multiculturalAppearance;

                            public AgeAppearance getAgeAppearance() {
                                return ageAppearance;
                            }
                            public void setAgeAppearance(AgeAppearance ageAppearance) {
                                this.ageAppearance = ageAppearance;
                            }
                            public GenderAppearance getGenderAppearance() {
                                return genderAppearance;
                            }
                            public void setGenderAppearance(GenderAppearance genderAppearance) {
                                this.genderAppearance = genderAppearance;
                            }
                            public MulticulturalAppearance getMulticulturalAppearance() {
                                return multiculturalAppearance;
                            }
                            public void setMulticulturalAppearance(MulticulturalAppearance multiculturalAppearance) {
                                this.multiculturalAppearance = multiculturalAppearance;
                            }
                        }
                        private Face face;

                        public Face getFace() {
                            return face;
                        }
                        public void setFace(Face face) {
                            this.face = face;
                        }
                    }
                    private RegionData Data;
                    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                    public RegionInfo getRegionInfo() {
                        return regionInfo;
                    }
                    public void setRegionInfo(RegionInfo regionInfo) {
                        this.regionInfo = regionInfo;
                    }
                    public RegionData getData() {
                        return Data;
                    }
                    public void setData(RegionData data) {
                        this.Data = data;
                    }
                    public Map<String, Object> getAdditionalProperties() {
                        return this.additionalProperties;
                    }
                    public void setAdditionalProperty(String name, Object value) {
                        this.additionalProperties.put(name, value);
                    }
                }
                private List<Region> regions;

                public List<Region> getRegions() {
                    return regions;
                }
                public void setRegions(List<Region> regions) {
                    this.regions = regions;
                }
            }
            private Data data;
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();

            public String getId() {
                return id;
            }
            public void setId(String id) {
                this.id = id;
            }
            public Status getStatus() {
                return status;
            }
            public void setStatus(Status status) {
                this.status = status;
            }
            public String getCreatedAt() {
                return createdAt;
            }
            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }
            public Model getModel() {
                return model;
            }
            public void setModel(Model model) {
                this.model = model;
            }
            public Input getInput() {
                return input;
            }
            public void setInput(Input input) {
                this.input = input;
            }
            public Data getData() {
                return data;
            }
            public void setData(Data data) {
                this.data = data;
            }
            public Map<String, Object> getAdditionalProperties() {
                return this.additionalProperties;
            }
            public void setAdditionalProperty(String name, Object value) {
                this.additionalProperties.put(name, value);
            }
        }
        private List<Output> outputs;

        public Status getStatus() {
            return status;
        }
        public void setStatus(Status status) {
            this.status = status;
        }
        public List<Output> getOutputs() {
            return outputs;
        }
        public void setOutputs(List<Output> outputs) {
            this.outputs = outputs;
        }
        public void setInput(Input input){
            this.input = input;
        }
        public Input getInput(){
            return this.input;
        }

    }
    private List<Results> results;

    public void setStatus(Status status){
        this.status = status;
    }
    public Status getStatus(){
        return this.status;
    }
    public void setWorkflow(Workflow workflow){
        this.workflow = workflow;
    }
    public Workflow getWorkflow(){
        return this.workflow;
    }
    public void setResults(List<Results> results){
        this.results = results;
    }
    public List<Results> getResults(){
        return this.results;
    }
}
