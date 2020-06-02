package com.example.recognition.types.data;

public class DemographicDataType {
    public static class AgeAppearance {
        private String name;
        private double value;

        public AgeAppearance(String name, double value) {
            this.name = name;
            this.value = value;
        }

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
    protected AgeAppearance[] agesAppearance;
    public AgeAppearance[] getAgesAppearance() {
        return agesAppearance;
    }
    public void setAgesAppearance(AgeAppearance[] agesAppearance) {
        this.agesAppearance = agesAppearance;
    }
    public static class GenderAppearance {
        private String name;
        private double value;

        public GenderAppearance(String name, double value) {
            this.name = name;
            this.value = value;
        }

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
    protected GenderAppearance[] GendersAppearance;
    public GenderAppearance[] getGendersAppearance() {
        return GendersAppearance;
    }
    public void setGendersAppearance(GenderAppearance[] gendersAppearance) {
        GendersAppearance = gendersAppearance;
    }
    public static class MulticulturalAppearance {
        private String name;
        private double value;

        public MulticulturalAppearance(String name, double value) {
            this.name = name;
            this.value = value;
        }

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
    protected MulticulturalAppearance[] MulticulturalAppearances;
    public MulticulturalAppearance[] getMulticulturalAppearances() {
        return MulticulturalAppearances;
    }
    public void setMulticulturalAppearances(MulticulturalAppearance[] multiculturalAppearances) {
        MulticulturalAppearances = multiculturalAppearances;
    }
    public static class Frame {
        private double top;
        private double left;
        private double bottom;
        private double right;

        public Frame(double top, double left, double bottom, double right) {
            this.top = top;
            this.left = left;
            this.bottom = bottom;
            this.right = right;
        }
        public double getTop() {
            return top;
        }
        public void setTop(double top) {
            this.top = top;
        }
        public double getLeft() {
            return left;
        }
        public void setLeft(double left) {
            this.left = left;
        }
        public double getBottom() {
            return bottom;
        }
        public void setBottom(double bottom) {
            this.bottom = bottom;
        }
        public double getRight() {
            return right;
        }
        public void setRight(double right) {
            this.right = right;
        }
    }
    protected Frame frame;
    public Frame getFrame() {
        return frame;
    }
    public void setFrame(Frame frame) {
        this.frame = frame;
    }
}
