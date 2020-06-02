package com.example.recognition.model.remoutdata;

import java.util.List;

public class Request {
    public static class Inputs {
        public static class Data {
            public static class Image {
                public Image(String base64) {
                    this.base64 = base64;
                }
                private String base64;
                public void setBase64(String base64){
                    this.base64 = base64;
                }
                public String getBase64(){
                    return this.base64;
                }
            }
            public Data(Image image) {
                this.image = image;
            }
            private Image image;
            public void setImage(Image image){
                this.image = image;
            }
            public Image getImage(){
                return this.image;
            }
        }
        public Inputs(Data data) {
            this.data = data;
        }
        private Data data;
        public void setData(Data data){
            this.data = data;
        }
        public Data getData(){
            return this.data;
        }
    }
    public Request(List<Inputs> inputs) {
        this.inputs = inputs;
    }
    private List<Inputs> inputs;
    public void setInputs(List<Inputs> inputs){
        this.inputs = inputs;
    }
    public List<Inputs> getInputs(){
        return this.inputs;
    }
}