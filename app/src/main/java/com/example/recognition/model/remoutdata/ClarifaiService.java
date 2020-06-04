package com.example.recognition.model.remoutdata;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ClarifaiService {
    String BASE_URL = "https://api.clarifai.com/";
    @Headers({"authorization: Key baf77c8d447d41b2b1bde3950c633a01",
            "content-type: application/json"
    })
    @POST("v2/workflows/General/results")
    Call<GeneralResponsePojo> generalRequest(@Body Request request);
    @Headers({"authorization: Key baf77c8d447d41b2b1bde3950c633a01",
            "content-type: application/json"
    })
    @POST("v2/workflows/Demographics/results")
    Call<DemographicResponsePojo> demographicRequest(@Body Request request);
    @Headers({"authorization: Key baf77c8d447d41b2b1bde3950c633a01",
            "content-type: application/json"
    })
    @POST("v2/workflows/Color/results")
    Call<ColorResponsePojo> colorRequest(@Body Request request);
}
