package com.example.recognition.types.data;

public class DemographicDataType {
    public static class Face {
        public static class AgeAppearance {
            private String name;
            private double value;
            public AgeAppearance() {

            }
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
        private AgeAppearance[] agesAppearance;
        public static class GenderAppearance {
            private String name;
            private double value;
            public GenderAppearance() {

            }
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
        private GenderAppearance[] GendersAppearance;
        public GenderAppearance[] getGendersAppearance() {
            return GendersAppearance;
        }
        public static class MulticulturalAppearance {
            private String name;
            private double value;
            public MulticulturalAppearance() {

            }
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
        private MulticulturalAppearance[] MulticulturalAppearances;
        public MulticulturalAppearance[] getMulticulturalAppearances() {
            return MulticulturalAppearances;
        }
        public static class Frame {
            private double top;
            private double left;
            private double bottom;
            private double right;

            public Frame() {

            }
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
        private Frame frame;

        public AgeAppearance[] getAgesAppearance() {
            return agesAppearance;
        }
        public void setAgesAppearance(AgeAppearance[] agesAppearance) {
            this.agesAppearance = agesAppearance;
        }
        public void setGendersAppearance(GenderAppearance[] gendersAppearance) {
            GendersAppearance = gendersAppearance;
        }
        public void setMulticulturalAppearances(MulticulturalAppearance[] multiculturalAppearances) {
            MulticulturalAppearances = multiculturalAppearances;
        }
        public Frame getFrame() {
            return frame;
        }
        public void setFrame(Frame frame) {
            this.frame = frame;
        }
    }
    private Face[] faces;

    public Face[] getFaces() {
        return faces;
    }
    public void setFaces(Face[] faces) {
        this.faces = faces;
    }
}
