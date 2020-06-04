package com.example.recognition.types;

public class ColorDataType {
    public static class Color {

        private String color;
        private String nameColor;
        private String percent;

        public Color(String color, String nameColor, String percent) {
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
        public String getPercent() {
            return percent;
        }
        public void setPercent(String percent) {
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
