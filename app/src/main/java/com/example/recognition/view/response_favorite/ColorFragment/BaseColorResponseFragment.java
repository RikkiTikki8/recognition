package com.example.recognition.view.response_favorite.ColorFragment;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
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
import com.example.recognition.R;
import com.example.recognition.types.data.ColorDataType;

public abstract class BaseColorResponseFragment extends Fragment implements Observer<ColorDataType>  {

    private View view;
    protected abstract void init();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_choose_image, container, false);
        init();
        return view;
    }

    @Override
    public void onChanged(ColorDataType colorDataType) {
        ScrollView.LayoutParams scrollParams = new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT,
                ScrollView.LayoutParams.WRAP_CONTENT);
        ScrollView scrollView = new ScrollView(view.getContext());
        LinearLayout linearLayout = new LinearLayout(view.getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(linearLayout);

        //ImageView imageView = new ImageView(view.getContext());
        //imageView.setImageURI(Uri.parse(colorDataType.image));

        Integer response_text_size = 16;
        
        ScrollView scroll_view = new ScrollView(view.getContext());
        scroll_view.setId(R.id.scroll_view);
        ScrollView.LayoutParams scroll_layout = new ScrollView.LayoutParams();
        scroll_layout.width = ScrollView.LayoutParams.MATCH_PARENT;
        scroll_layout.height = ScrollView.LayoutParams.MATCH_PARENT;
        scroll_view.setLayoutParams(scroll_layout);

        LinearLayout main_linear_layout = new LinearLayout(view.getContext());
        main_linear_layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams linMatchWrap = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        main_linear_layout.setLayoutParams(linMatchWrap);

        ImageView imageView = new ImageView(view.getContext());
        ViewGroup.LayoutParams linMatchMatch = new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(linMatchMatch);
        main_linear_layout.addView(imageView);

        LinearLayout color_linear_layout = new LinearLayout(view.getContext());
        color_linear_layout.setOrientation(LinearLayout.VERTICAL);
        color_linear_layout.setBackgroundColor(Color.parseColor("#A0A0A0"));
        color_linear_layout.setLayoutParams(linMatchWrap);

        TextView tV_color_name = new TextView(view.getContext());
        //tV_color_name.setText("Color's name");
        tV_color_name.setTextSize(response_text_size);
        tV_color_name.setLayoutParams(linMatchWrap);
        color_linear_layout.addView(tV_color_name);
        
        LinearLayout color_linLayout_second = new LinearLayout(view.getContext());
        color_linLayout_second.setOrientation(LinearLayout.HORIZONTAL);
        color_linLayout_second.setLayoutParams(linMatchWrap);

        TextView tV_color_number = new TextView(view.getContext());
        //tV_color_number.setText("#000000");
        tV_color_number.setTextSize(response_text_size);
        LinearLayout.LayoutParams layout_104 = new LinearLayout.LayoutParams();
        //TODO
        layout_104.width = 0;
        layout_104.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        layout_104.weight = 4;
        tV_color_number.setLayoutParams(layout_104);
        color_linLayout_second.addView(tV_color_number);

        TextView tV_color_percent = new TextView(view.getContext());
        //tV_color_percent.setText("5%");
        tV_color_percent.setTextSize(response_text_size);
        LinearLayout.LayoutParams layout_370 = new LinearLayout.LayoutParams();
        layout_370.width = 0;
        layout_370.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        layout_370.weight = 1;
        tV_color_percent.setLayoutParams(layout_370);
        color_linLayout_second.addView(tV_color_percent);
        color_linear_layout.addView(color_linLayout_second);
        main_linear_layout.addView(color_linear_layout);
        scroll_view.addView(main_linear_layout);

        this.addContentView(layout, layoutParam);

        for (ColorDataType.Color color : colorDataType.getColors()){

        }

    }
}
