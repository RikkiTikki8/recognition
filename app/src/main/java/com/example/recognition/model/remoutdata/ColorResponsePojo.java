package com.example.recognition.model.remoutdata;

import com.example.recognition.types.ColorDataType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColorResponsePojo {
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
                private GeneralResponsePojo.Results.Input.Data.Image image;
                public void setImage(GeneralResponsePojo.Results.Input.Data.Image image){
                    this.image = image;
                }
                public GeneralResponsePojo.Results.Input.Data.Image getImage(){
                    return this.image;
                }
            }
            private GeneralResponsePojo.Results.Input.Data data;
            public void setId(String id){
                this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setData(GeneralResponsePojo.Results.Input.Data data){
                this.data = data;
            }
            public GeneralResponsePojo.Results.Input.Data getData(){
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
        private ColorResponsePojo.Status status;
        public static class Output {
            private String id;
            private ColorResponsePojo.Status status;
            private String createdAt;
            public static class Model {
                private String name;
                private String id;
                private String createdAt;
                private Object appId;
                public static class OutputInfo {
                    private String message;
                    private String type;

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
                }
                private OutputInfo outputInfo;
                public static class ModelVersion {
                    private String id;
                    private String createdAt;
                    private ColorResponsePojo.Status status;

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
                    public ColorResponsePojo.Status getStatus() {
                        return status;
                    }
                    public void setStatus(ColorResponsePojo.Status status) {
                        this.status = status;
                    }
                }
                private ModelVersion modelVersion;
                private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
                public Map<String, Object> getAdditionalProperties() {
                    return this.additionalProperties;
                }
                public void setAdditionalProperty(String name, Object value) {
                    this.additionalProperties.put(name, value);
                }
            }
            private Model model;
            public static class Input {
                private String id;
                public static class Data {
                    public static class Image {
                        private String url;

                        public String getUrl() {
                            return url;
                        }
                        public void setUrl(String url) {
                            this.url = url;
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
                public static class Color {
                    private String rawHex;
                    public static class W3c {
                        private String hex;
                        private String name;

                        public String getHex() {
                            return hex;
                        }
                        public void setHex(String hex) {
                            this.hex = hex;
                        }
                        public String getName() {
                            return name;
                        }
                        public void setName(String name) {
                            this.name = name;
                        }
                    }
                    private W3c w3c;
                    private Double value;
                    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                    public String getRawHex() {
                        return rawHex;
                    }
                    public void setRawHex(String rawHex) {
                        this.rawHex = rawHex;
                    }
                    public W3c getW3c() {
                        return w3c;
                    }
                    public void setW3c(W3c w3c) {
                        this.w3c = w3c;
                    }
                    public Double getValue() {
                        return value;
                    }
                    public void setValue(Double value) {
                        this.value = value;
                    }

                }
                private List<Color> colors;

                public List<Color> getColors() {
                    return colors;
                }
                public void setColors(List<Color> colors) {
                    this.colors = colors;
                }
            }
            private Data data;

            public String getId() {
                return id;
            }
            public void setId(String id) {
                this.id = id;
            }
            public ColorResponsePojo.Status getStatus() {
                return status;
            }
            public void setStatus(ColorResponsePojo.Status status) {
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
        }
        private List<Output> outputs;
        public ColorResponsePojo.Status getStatus() {
            return status;
        }
        public void setStatus(ColorResponsePojo.Status status) {
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
//
//public class ColorResponsePojo {
//
//    private Status status;
//    private List<Output> outputs = null;
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
//
//    public List<Output> getOutputs() {
//        return outputs;
//    }
//
//    public void setOutputs(List<Output> outputs) {
//        this.outputs = outputs;
//    }
//
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }
//
//    public class Color {
//
//        private String rawHex;
//        private W3c w3c;
//        private Double value;
//        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//        public String getRawHex() {
//            return rawHex;
//        }
//
//        public void setRawHex(String rawHex) {
//            this.rawHex = rawHex;
//        }
//
//        public W3c getW3c() {
//            return w3c;
//        }
//
//        public void setW3c(W3c w3c) {
//            this.w3c = w3c;
//        }
//
//        public Double getValue() {
//            return value;
//        }
//
//        public void setValue(Double value) {
//            this.value = value;
//        }
//
//        public Map<String, Object> getAdditionalProperties() {
//            return this.additionalProperties;
//        }
//
//        public void setAdditionalProperty(String name, Object value) {
//            this.additionalProperties.put(name, value);
//        }
//
//    }
//
//    public class Data {
//
//        private Image image;
//        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//        public Image getImage() {
//            return image;
//        }
//
//        public void setImage(Image image) {
//            this.image = image;
//        }
//
//        public Map<String, Object> getAdditionalProperties() {
//            return this.additionalProperties;
//        }
//
//        public void setAdditionalProperty(String name, Object value) {
//            this.additionalProperties.put(name, value);
//        }
//
//    }
//
//    public class Data_ {
//
//        private List<Color> colors = null;
//        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//        public List<Color> getColors() {
//            return colors;
//        }
//
//        public void setColors(List<Color> colors) {
//            this.colors = colors;
//        }
//
//        public Map<String, Object> getAdditionalProperties() {
//            return this.additionalProperties;
//        }
//
//        public void setAdditionalProperty(String name, Object value) {
//            this.additionalProperties.put(name, value);
//        }
//
//    }
//
//    public class Example {
//
//        private ColorResponsePojo colorResponsePojo;
//        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//        public ColorResponsePojo getColorResponsePojo() {
//            return colorResponsePojo;
//        }
//
//        public void setColorResponsePojo(ColorResponsePojo colorResponsePojo) {
//            this.colorResponsePojo = colorResponsePojo;
//        }
//
//        public Map<String, Object> getAdditionalProperties() {
//            return this.additionalProperties;
//        }
//
//        public void setAdditionalProperty(String name, Object value) {
//            this.additionalProperties.put(name, value);
//        }
//
//    }
//
//    public class Image {
//
//        private String url;
//        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//        public String getUrl() {
//            return url;
//        }
//
//        public void setUrl(String url) {
//            this.url = url;
//        }
//
//        public Map<String, Object> getAdditionalProperties() {
//            return this.additionalProperties;
//        }
//
//        public void setAdditionalProperty(String name, Object value) {
//            this.additionalProperties.put(name, value);
//        }
//
//    }
//
//    public class Input {
//
//        private String id;
//        private Data data;
//        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public Data getData() {
//            return data;
//        }
//
//        public void setData(Data data) {
//            this.data = data;
//        }
//
//        public Map<String, Object> getAdditionalProperties() {
//            return this.additionalProperties;
//        }
//
//        public void setAdditionalProperty(String name, Object value) {
//            this.additionalProperties.put(name, value);
//        }
//
//    }
//
//    public class Model {
//
//        private String name;
//        private String id;
//        private String createdAt;
//        private Object appId;
//        private OutputInfo outputInfo;
//        private ModelVersion modelVersion;
//        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getCreatedAt() {
//            return createdAt;
//        }
//
//        public void setCreatedAt(String createdAt) {
//            this.createdAt = createdAt;
//        }
//
//        public Object getAppId() {
//            return appId;
//        }
//
//        public void setAppId(Object appId) {
//            this.appId = appId;
//        }
//
//        public OutputInfo getOutputInfo() {
//            return outputInfo;
//        }
//
//        public void setOutputInfo(OutputInfo outputInfo) {
//            this.outputInfo = outputInfo;
//        }
//
//        public ModelVersion getModelVersion() {
//            return modelVersion;
//        }
//
//        public void setModelVersion(ModelVersion modelVersion) {
//            this.modelVersion = modelVersion;
//        }
//
//        public Map<String, Object> getAdditionalProperties() {
//            return this.additionalProperties;
//        }
//
//        public void setAdditionalProperty(String name, Object value) {
//            this.additionalProperties.put(name, value);
//        }
//
//    }
//
//    public class ModelVersion {
//
//        private String id;
//        private String createdAt;
//        private Status__ status;
//        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getCreatedAt() {
//            return createdAt;
//        }
//
//        public void setCreatedAt(String createdAt) {
//            this.createdAt = createdAt;
//        }
//
//        public Status__ getStatus() {
//            return status;
//        }
//
//        public void setStatus(Status__ status) {
//            this.status = status;
//        }
//
//        public Map<String, Object> getAdditionalProperties() {
//            return this.additionalProperties;
//        }
//
//        public void setAdditionalProperty(String name, Object value) {
//            this.additionalProperties.put(name, value);
//        }
//
//    }
//
//    public class Output {
//
//        private String id;
//        private Status_ status;
//        private String createdAt;
//        private Model model;
//        private Input input;
//        private Data_ data;
//        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public Status_ getStatus() {
//            return status;
//        }
//
//        public void setStatus(Status_ status) {
//            this.status = status;
//        }
//
//        public String getCreatedAt() {
//            return createdAt;
//        }
//
//        public void setCreatedAt(String createdAt) {
//            this.createdAt = createdAt;
//        }
//
//        public Model getModel() {
//            return model;
//        }
//
//        public void setModel(Model model) {
//            this.model = model;
//        }
//
//        public Input getInput() {
//            return input;
//        }
//
//        public void setInput(Input input) {
//            this.input = input;
//        }
//
//        public Data_ getData() {
//            return data;
//        }
//
//        public void setData(Data_ data) {
//            this.data = data;
//        }
//
//        public Map<String, Object> getAdditionalProperties() {
//            return this.additionalProperties;
//        }
//
//        public void setAdditionalProperty(String name, Object value) {
//            this.additionalProperties.put(name, value);
//        }
//    }
//
//    public class OutputInfo {
//
//        private String message;
//        private String type;
//        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//        public String getMessage() {
//            return message;
//        }
//
//        public void setMessage(String message) {
//            this.message = message;
//        }
//
//        public String getType() {
//            return type;
//        }
//
//        public void setType(String type) {
//            this.type = type;
//        }
//
//        public Map<String, Object> getAdditionalProperties() {
//            return this.additionalProperties;
//        }
//
//        public void setAdditionalProperty(String name, Object value) {
//            this.additionalProperties.put(name, value);
//        }
//
//    }
//
//    public class Status {
//
//        private Integer code;
//        private String description;
//        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//        public Integer getCode() {
//            return code;
//        }
//
//        public void setCode(Integer code) {
//            this.code = code;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }
//
//        public Map<String, Object> getAdditionalProperties() {
//            return this.additionalProperties;
//        }
//
//        public void setAdditionalProperty(String name, Object value) {
//            this.additionalProperties.put(name, value);
//        }
//
//    }
//
//    public class Status_ {
//
//        private Integer code;
//        private String description;
//        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//        public Integer getCode() {
//            return code;
//        }
//
//        public void setCode(Integer code) {
//            this.code = code;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }
//
//        public Map<String, Object> getAdditionalProperties() {
//            return this.additionalProperties;
//        }
//
//        public void setAdditionalProperty(String name, Object value) {
//            this.additionalProperties.put(name, value);
//        }
//
//    }
//
//    public class Status__ {
//
//        private Integer code;
//        private String description;
//        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//        public Integer getCode() {
//            return code;
//        }
//
//        public void setCode(Integer code) {
//            this.code = code;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }
//
//        public Map<String, Object> getAdditionalProperties() {
//            return this.additionalProperties;
//        }
//
//        public void setAdditionalProperty(String name, Object value) {
//            this.additionalProperties.put(name, value);
//        }
//
//    }
//
//    public class W3c {
//
//        private String hex;
//        private String name;
//        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//        public String getHex() {
//            return hex;
//        }
//
//        public void setHex(String hex) {
//            this.hex = hex;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public Map<String, Object> getAdditionalProperties() {
//            return this.additionalProperties;
//        }
//
//        public void setAdditionalProperty(String name, Object value) {
//            this.additionalProperties.put(name, value);
//        }
//
//    }
//}