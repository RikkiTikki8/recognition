package com.example.recognition.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;;
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
    private String apiKey;
    private ClarifaiService service;
    private Context context;
    public RemoteDataSource(Context context, String apiKey) {
        this.context = context;
        this.apiKey = apiKey;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ClarifaiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ClarifaiService.class);
    }
    public Response<GeneralResponsePojo> fetchGeneralData(String uri) throws IOException {
        String path = getRealPathFromURI(context, Uri.parse(uri));
        Call<GeneralResponsePojo> call = service.generalRequest(apiKey, makeRequest(path));
        return call.execute();
    }
    public Response<DemographicResponsePojo> fetchDemographicData(String uri) throws IOException {
        String path = getRealPathFromURI(context, Uri.parse(uri));
        Call<DemographicResponsePojo> call = service.demographicRequest(apiKey, makeRequest(path));
        return call.execute();
    }
    public Response<ColorResponsePojo> fetchColorData(String uri) throws IOException {
        String path = getRealPathFromURI(context, Uri.parse(uri));
        Call<ColorResponsePojo> call = service.colorRequest(apiKey, makeRequest(path));
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
        String filePath = "";
        String wholeID = DocumentsContract.getDocumentId(uri);
        String id = wholeID.split(":")[1];
        String[] column = {
                MediaStore.Images.Media.DATA
        };
        String sel = MediaStore.Images.Media._ID + "=?";
        Cursor cursor = context.getContentResolver()
                .query(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        column,
                        sel,
                        new String[]{
                                id
                        },
                        null
                );
        int columnIndex = cursor.getColumnIndex(column[0]);
        if (cursor.moveToFirst()) {
            filePath = cursor.getString(columnIndex);
        }
        cursor.close();
        return filePath;
    }
}