package com.example.recognition.types;

public class SettingsType {
    protected int threshold;
    public SettingsType(int threshold) {
        this.threshold = threshold;
    }
    public SettingsType(){

    }
    public int getThreshold() {
        return threshold;
    }
    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}
