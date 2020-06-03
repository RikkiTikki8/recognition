package com.example.recognition.model.remoutdata;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ClarifaiService {
    String BASE_URL = "https://api.clarifai.com/";
    @Headers({"authorization: Key {apyKey}",
            "content-type: application/json"
    })
    @POST("v2/workflows/General/results")
    Call<GeneralResponsePojo> generalRequest(@Path("apyKey") String apiKey, @Body Request request);
    @Headers({"authorization: Key {apyKey}",
            "content-type: application/json"
    })
    @POST("v2/workflows/Demographics/results")
    Call<DemographicResponsePojo> demographicRequest(@Path("apyKey") String apiKey, @Body Request request);
    @Headers({"authorization: Key {apyKey}",
            "content-type: application/json"
    })
    @POST("v2/workflows/Color/results")
    Call<ColorResponsePojo> colorRequest(@Path("apyKey") String apiKey, @Body Request request);
}
