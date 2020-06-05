package com.example.recognition.types;

public class ColorDataType {
    public static class Color {

        private String color;
        private String nameColor;
        private double percent;

        public Color(String color, String nameColor, double percent) {
            this.color = color;
            this.nameColor = nameColor;
            this.percent = percent;
        }

        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }
        public String getNameColor() {
            return nameColor;
        }
        public void setNameColor(String nameColor) {
            this.nameColor = nameColor;
        }
        public double getPercent() {
            return percent;
        }
        public void setPercent(double percent) {
            this.percent = percent;
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
