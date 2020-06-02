package com.example.recognition.types;

public class OptionsType {
    protected int threshold;
    OptionsType(int threshold) {
        this.threshold = threshold;
    }
    public OptionsType() {
        threshold = 0;
    }
    int getThreshold() {
        return threshold;
    }
    void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}
