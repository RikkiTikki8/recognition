package com.example.recognition.types.data;

public class DemographicsData {
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
    public Frame getFrame() {
        return frame;
    }
    public void setFrame(Frame frame) {
        this.frame = frame;
    }
}
