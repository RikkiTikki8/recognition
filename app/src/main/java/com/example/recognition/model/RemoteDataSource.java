package com.example.recognition.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;;
import androidx.annotation.NonNull;

import com.example.recognition.model.remoutdata.ClarifaiService;
import com.example.recognition.model.remoutdata.ColorResponsePojo;
import com.example.recognition.model.remoutdata.DemographicResponsePojo;
import com.example.recognition.model.remoutdata.GeneralResponsePojo;
import com.example.recognition.model.remoutdata.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {
    private ClarifaiService service;
    private Context context;
    public RemoteDataSource(Context context) {
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ClarifaiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ClarifaiService.class);
    }
    public Response<GeneralResponsePojo> fetchGeneralData(String uri) throws IOException {
        String path = getRealPathFromURI(context, Uri.parse(uri));
        Call<GeneralResponsePojo> call = service.generalRequest(makeRequest(path));
        return call.execute();
    }
    public Response<DemographicResponsePojo> fetchDemographicData(String uri) throws IOException {
        String path = getRealPathFromURI(context, Uri.parse(uri));
        Call<DemographicResponsePojo> call = service.demographicRequest(makeRequest(path));
        return call.execute();
    }
    public Response<ColorResponsePojo> fetchColorData(String uri) throws IOException {
        String path = getRealPathFromURI(context, Uri.parse(uri));
        Call<ColorResponsePojo> call = service.colorRequest(makeRequest(path));
        return call.execute();
    }
    private Request makeRequest(String path) {
        return new Request(
                new ArrayList<Request.Inputs>(
                        Arrays.asList(
                                new Request.Inputs(
                                        new Request.Inputs.Data(
                                                new Request.Inputs.Data.Image(
                                                        "$(base64 "  + path + ")"
                                                )
                                        )
                                )
                        )
                )
        );
    }
    private String getRealPathFromURI(Context context, Uri uri) {
        String result;
        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        if (cursor == null) {
            result = uri.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }
}