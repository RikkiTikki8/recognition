package com.example.recognition.model.remoutdata;

import java.util.List;

public class Request {
    public static class Input {
        public static class Data {
            public static class Image {
                public Image(String url) {
                    this.url = url;
                }
                private String url;
                public void setUrl(String url){
                    this.url = url;
                }
                public String getUrl(){
                    return this.url;
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
        public Input(Data data) {
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
    public Request(Input[] inputs) {
        this.inputs = inputs;
    }
    private Input[] inputs;
    public void setInputs(Input[] inputs){
        this.inputs = inputs;
    }
    public Input[] getInputs(){
        return this.inputs;
    }
}