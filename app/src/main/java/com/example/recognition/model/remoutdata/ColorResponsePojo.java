package com.example.recognition.model.remoutdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColorResponsePojo {

    public class Color {

        private String rawHex;
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

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Data {

        private Image image;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public Image getImage() {
            return image;
        }

        public void setImage(Image image) {
            this.image = image;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Data_ {

        private List<Color> colors = null;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public List<Color> getColors() {
            return colors;
        }

        public void setColors(List<Color> colors) {
            this.colors = colors;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Example {

        private Status status;
        private List<Output> outputs = null;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Image {

        private String url;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Input {

        private String id;
        private Data data;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Model {

        private String name;
        private String id;
        private String createdAt;
        private Object appId;
        private OutputInfo outputInfo;
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

    public class ModelVersion {

        private String id;
        private String createdAt;
        private Status status;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Output {

        private String id;
        private Status status;
        private String createdAt;
        private Model model;
        private Input input;
        private Data_ data;
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

        public Data_ getData() {
            return data;
        }

        public void setData(Data_ data) {
            this.data = data;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class OutputInfo {

        private String message;
        private String type;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Status {

        private Integer code;
        private String description;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class W3c {

        private String hex;
        private String name;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

}
