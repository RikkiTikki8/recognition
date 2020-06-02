package com.example.recognition.model.remoutdata;

import java.util.List;

public class GeneralResponse {
    public static class Status {
        private int code;
        private String description;
        public void setCode(int code){
            this.code = code;
        }
        public int getCode(){
            return this.code;
        }
        public void setDescription(String description){
            this.description = description;
        }
        public String getDescription(){
            return this.description;
        }
    }
    private Status status;
    public static class Workflow {
        private String id;
        private String app_id;
        private String created_at;
        public void setId(String id){
            this.id = id;
        }
        public String getId(){
            return this.id;
        }
        public void setApp_id(String app_id){
            this.app_id = app_id;
        }
        public String getApp_id(){
            return this.app_id;
        }
        public void setCreated_at(String created_at){
            this.created_at = created_at;
        }
        public String getCreated_at(){
            return this.created_at;
        }
    }
    private Workflow workflow;
    public static class Results {
        public static class Status {
            private int code;
            private String description;
            public void setCode(int code){
                this.code = code;
            }
            public int getCode(){
                return this.code;
            }
            public void setDescription(String description){
                this.description = description;
            }
            public String getDescription(){
                return this.description;
            }
        }
        private Status status;
        public static class Input {
            private String id;
            public static class Data {
                public static class Image {
                    private String base64;
                    public void setBase64(String base64){
                        this.base64 = base64;
                    }
                    public String getBase64(){
                        return this.base64;
                    }
                }
                private Image image;
                public void setImage(Image image){
                    this.image = image;
                }
                public Image getImage(){
                    return this.image;
                }
            }
            private Data data;
            public void setId(String id){
                this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setData(Data data){
                this.data = data;
            }
            public Data getData(){
                return this.data;
            }
        }
        private Input input;
        public static class Outputs {
            private String id;
            private Status status;
            private String created_at;
            public static class Model {
                private String id;
                private String name;
                private String created_at;
                private String app_id;
                public static class Output_info {
                    private String message;
                    private String type;
                    private String type_ext;
                    public void setMessage(String message){
                        this.message = message;
                    }
                    public String getMessage(){
                        return this.message;
                    }
                    public void setType(String type){
                        this.type = type;
                    }
                    public String getType(){
                        return this.type;
                    }
                    public void setType_ext(String type_ext){
                        this.type_ext = type_ext;
                    }
                    public String getType_ext(){
                        return this.type_ext;
                    }
                }
                private Output_info output_info;
                public static class Model_version {
                    private String id;
                    private String created_at;
                    private Status status;
                    public void setId(String id){
                        this.id = id;
                    }
                    public String getId(){
                        return this.id;
                    }
                    public void setCreated_at(String created_at){
                        this.created_at = created_at;
                    }
                    public String getCreated_at(){
                        return this.created_at;
                    }
                    public void setStatus(Status status){
                        this.status = status;
                    }
                    public Status getStatus(){
                        return this.status;
                    }
                }
                private Model_version model_version;
                public void setId(String id){
                    this.id = id;
                }
                public String getId(){
                    return this.id;
                }
                public void setName(String name){
                    this.name = name;
                }
                public String getName(){
                    return this.name;
                }
                public void setCreated_at(String created_at){
                    this.created_at = created_at;
                }
                public String getCreated_at(){
                    return this.created_at;
                }
                public void setApp_id(String app_id){
                    this.app_id = app_id;
                }
                public String getApp_id(){
                    return this.app_id;
                }
                public void setOutput_info(Output_info output_info){
                    this.output_info = output_info;
                }
                public Output_info getOutput_info(){
                    return this.output_info;
                }
                public void setModel_version(Model_version model_version){
                    this.model_version = model_version;
                }
                public Model_version getModel_version(){
                    return this.model_version;
                }
            }
            private Model model;
            public static class Data {
                public static class Concepts {
                    private String id;
                    private String name;
                    private double value;
                    private String app_id;
                    public void setId(String id){
                        this.id = id;
                    }
                    public String getId(){
                        return this.id;
                    }
                    public void setName(String name){
                        this.name = name;
                    }
                    public String getName(){
                        return this.name;
                    }
                    public void setValue(double value){
                        this.value = value;
                    }
                    public double getValue(){
                        return this.value;
                    }
                    public void setApp_id(String app_id){
                        this.app_id = app_id;
                    }
                    public String getApp_id(){
                        return this.app_id;
                    }
                }
                private List<Concepts> concepts;
                public void setConcepts(List<Concepts> concepts){
                    this.concepts = concepts;
                }
                public List<Concepts> getConcepts(){
                    return this.concepts;
                }
            }
            private Data data;
            public void setId(String id){
                this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setStatus(Status status){
                this.status = status;
            }
            public Status getStatus(){
                return this.status;
            }
            public void setCreated_at(String created_at){
                this.created_at = created_at;
            }
            public String getCreated_at(){
                return this.created_at;
            }
            public void setModel(Model model){
                this.model = model;
            }
            public Model getModel(){
                return this.model;
            }
            public void setData(Data data){
                this.data = data;
            }
            public Data getData(){
                return this.data;
            }
        }
        private List<Outputs> outputs;
        public void setStatus(Status status){
            this.status = status;
        }
        public Status getStatus(){
            return this.status;
        }
        public void setInput(Input input){
            this.input = input;
        }
        public Input getInput(){
            return this.input;
        }
        public void setOutputs(List<Outputs> outputs){
            this.outputs = outputs;
        }
        public List<Outputs> getOutputs(){
            return this.outputs;
        }
    }
    private List<Results> results;
    public void setStatus(Status status){
        this.status = status;
    }
    public Status getStatus(){
        return this.status;
    }
    public void setWorkflow(Workflow workflow){
        this.workflow = workflow;
    }
    public Workflow getWorkflow(){
        return this.workflow;
    }
    public void setResults(List<Results> results){
        this.results = results;
    }
    public List<Results> getResults(){
        return this.results;
    }
}

