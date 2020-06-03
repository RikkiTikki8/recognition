package com.example.recognition.types;

public class SettingsType {
    protected int threshold;
    public SettingsType(int threshold) {
        this.threshold = threshold;
    }
    public SettingsType(){

    }
    int getThreshold() {
        return threshold;
    }
    void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}
