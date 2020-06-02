package com.example.recognition.model;

import com.example.recognition.model.remoutdata.BaseResponse;
<<<<<<< HEAD
import com.example.recognition.types.response.Response;
=======
import com.example.recognition.types.GeneralResponse;
>>>>>>> 71d1eea35b61b0fd5a5c1c21c92c58fbec7baef8

public class ResponseConverter {
    public static <T extends BaseResponse> GeneralResponse getResponse(retrofit2.Response<T> response, String model) {
        switch (model) {
            case "General" :

                break;
            case "Demographics":

                break;
            case "Color":

                break;
            default:

                break;
        }
        return null;
    }
}
