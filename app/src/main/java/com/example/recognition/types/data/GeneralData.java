package com.example.recognition.types.data;

<<<<<<< HEAD
import com.example.recognition.types.response.Response;

public class GeneralData extends Response {
    public static class Field {
        private String name;
        private double value;
        public Field(String name, double value) {
            this.name = name;
            this.value = value;
        }
        public String getName() {
            return name;
        }
        public double getValue() {
            return value;
        }
    }
    protected Field[] fields;
    public Field[] getFields() {
        return fields;
=======
public class GeneralData {
    protected String[] properties;
    public String[] getProperties() {
        return properties;
>>>>>>> 71d1eea35b61b0fd5a5c1c21c92c58fbec7baef8
    }
    public void setProperties(String[] properties) {
        this.properties = properties;
    }
}
