package com.example.recognition.types.data;

public class GeneralDataType{

    public static class Property {
        private String name;
        private double value;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public double getValue() {
            return value;
        }
        public void setValue(double value) {
            this.value = value;
        }
    }
    private Property[] properties;
    public Property[] getProperties() {
        return properties;
    }
    public void setProperties(Property[] properties) {
        this.properties = properties;
    }
}
