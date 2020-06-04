package com.example.recognition.view.response_favorite.ColorFragment;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recognition.R;
import com.example.recognition.model.localdata.room.entity.ColorResponse;
import com.example.recognition.types.ColorDataType;

import java.util.Arrays;

public abstract class BaseColorFragment extends Fragment implements Observer<ColorResponse>  {

    private View view;
    private ImageView imageView;
    protected abstract void init();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_result_color, container, false);
        init();
        imageView = view.findViewById(R.id.color_model_image);
        return view;
    }

    @Override
    public void onChanged(ColorResponse response) {
        imageView.setImageURI(Uri.parse(response.getImage()));
        RecyclerView rv = view.findViewById(R.id.rv_col);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        final ColorRecyclerAdapter adapter = new ColorRecyclerAdapter(response.getData().getColors());
        rv.setAdapter(adapter);
//        Integer response_text_size = 20;
//        ScrollView scroll_view = view.findViewById(R.id.scroll_view);

//        LinearLayout.LayoutParams linMatchWrap = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//
//        LinearLayout main_linear_layout = new LinearLayout(view.getContext());
//        main_linear_layout.setLayoutParams(linMatchWrap);
//        main_linear_layout.setOrientation(LinearLayout.VERTICAL);
//
//        ViewGroup.LayoutParams imageParams = new ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT, 1000);
//
//        ImageView imageView = new ImageView(view.getContext());
//        imageView.setLayoutParams(imageParams);
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setImageURI(Uri.parse(response.getImage()));
//        main_linear_layout.addView(imageView);

//        for (ColorDataType.Color color : response.getData().getColors()) {
//            LinearLayout color_linear_layout_first = new LinearLayout(view.getContext());
//            color_linear_layout_first.setLayoutParams(linMatchWrap);
//            color_linear_layout_first.setOrientation(LinearLayout.VERTICAL);
//            color_linear_layout_first.setBackgroundColor(Color.parseColor(color.getColor()));
//
//            TextView tV_color_name = new TextView(view.getContext());
//            tV_color_name.setLayoutParams(linMatchWrap);
//            tV_color_name.setText(color.getNameColor());
//            tV_color_name.setTextSize(response_text_size);
//            color_linear_layout_first.addView(tV_color_name);
//
//            LinearLayout color_linLayout_second = new LinearLayout(view.getContext());
//            color_linLayout_second.setLayoutParams(linMatchWrap);
//            color_linLayout_second.setOrientation(LinearLayout.HORIZONTAL);
//            color_linLayout_second.setWeightSum(5);
//
//            LinearLayout.LayoutParams tV_color_number_params =
//                    new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 4);
//
//            TextView tV_color_number = new TextView(view.getContext());
//            tV_color_number.setLayoutParams(tV_color_number_params);
//            tV_color_number.setText(color.getColor());
//            tV_color_number.setTextSize(response_text_size);
//            color_linLayout_second.addView(tV_color_number);
//
//            LinearLayout.LayoutParams tV_color_percent_params =
//                    new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
//
//            TextView tV_color_percent = new TextView(view.getContext());
//            tV_color_percent.setLayoutParams(tV_color_percent_params);
//            tV_color_percent.setText(color.getPercent());
//            tV_color_percent.setTextSize(response_text_size);
//            color_linLayout_second.addView(tV_color_percent);
//
//            color_linear_layout_first.addView(color_linLayout_second);
//            main_linear_layout.addView(color_linear_layout_first);
//        }
//        scroll_view.addView(main_linear_layout);
    }
}
