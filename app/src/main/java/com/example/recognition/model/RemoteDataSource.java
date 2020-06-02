package com.example.recognition.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;;
import androidx.annotation.NonNull;

import com.example.recognition.model.remoutdata.BaseResponse;
import com.example.recognition.model.remoutdata.ClarifyService;
import com.example.recognition.model.remoutdata.GeneralResponse;
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

    public enum Model {
        GENERAL,
        DEMOGRAPHICS,
        COLOR;

        @NonNull
        @Override
        public String toString() {
            return this.name().substring(0, 1) + this.name().substring(1).toLowerCase();
        }
    }

    private final String prefix = "$(base64 ";
    private final String postfix = ")";
    private String apiKey;
    private ClarifyService service;
    private Context context;
    public RemoteDataSource(Context context, String apiKey) {
        this.context = context;
        this.apiKey = apiKey;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ClarifyService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ClarifyService.class);
    }
    public <T extends BaseResponse> Response<T> fetchData(String uri, String model) throws IOException {
        String path = getRealPathFromURI(context, Uri.parse(uri));
        Request request = new Request(
                new ArrayList<Request.Inputs>(
                        Arrays.asList(
                                new Request.Inputs(
                                        new Request.Inputs.Data(
                                                new Request.Inputs.Data.Image(
                                                        prefix  + path + postfix
                                                )
                                        )
                                )
                        )
                )
        );
        Call<T> call = service.sendRequest(apiKey, model, request);
        return call.execute();
    }
    public List<String> getModels() {
        List<String> listModels = new ArrayList<>();
        Model[] models = Model.values();
        for (Model model : models) {
            listModels.add(model.toString());
        }
        return listModels;
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