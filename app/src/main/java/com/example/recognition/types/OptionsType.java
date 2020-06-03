package com.example.recognition.types;

public class OptionsType {
    protected int threshold;
    public OptionsType(int threshold) {
        this.threshold = threshold;
    }
    public OptionsType(){

    }
    int getThreshold() {
        return threshold;
    }
    void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}
