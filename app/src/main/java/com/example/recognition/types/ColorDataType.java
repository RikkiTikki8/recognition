package com.example.recognition.types;

public class ColorDataType {
    public static class Color {

        private String color;
        private String name_color;
        private double value;

        public Color(String color, String name_color, double value) {
            this.color = color;
            this.name_color = name_color;
            this.value = value;
        }

        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }
        public String getName_color() {
            return name_color;
        }
        public void setName_color(String name_color) {
            this.name_color = name_color;
        }
        public double getValue() {
            return value;
        }
        public void setValue(double value) {
            this.value = value;
        }
    }
    private Color[] Colors;
    public Color[] getColors() {
        return Colors;
    }
    public void setColors(Color[] colors) {
        Colors = colors;
    }
}
