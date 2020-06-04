package com.example.recognition.view.response_favorite.ColorFragment;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recognition.R;
import com.example.recognition.types.ColorDataType;

import java.util.List;

public class ColorRecyclerAdapter extends RecyclerView.Adapter<ColorRecyclerAdapter.ColorViewHolder>{

    ColorDataType.Color[] colors;

    ColorRecyclerAdapter(ColorDataType.Color[] colors){
        this.colors = colors;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_color, parent, false);
        return new ColorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int i) {
        ColorViewHolder.container.setBackgroundColor(Color.parseColor(colors[i].getColor()));
        ColorViewHolder.name.setText(colors[i].getNameColor());
        ColorViewHolder.number.setText(colors[i].getColor());
        ColorViewHolder.percent.setText(colors[i].getPercent());
    }

    @Override
    public int getItemCount() {
        return colors.length;
    }

    public static class ColorViewHolder extends RecyclerView.ViewHolder {
            public static LinearLayout container;
            public static TextView name;
            public static TextView number;
            public static TextView percent;
            public ColorViewHolder(View view){
                super(view);
                container = view.findViewById(R.id.color_rv_container);
                name = view.findViewById(R.id.color_name);
                number = view.findViewById(R.id.color_number);
                percent = view.findViewById(R.id.color_percent);
            }
        }
    }
