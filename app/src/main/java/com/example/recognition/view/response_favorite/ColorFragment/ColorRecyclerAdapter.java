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

    List<ColorDataType.Color> colors;

    ColorRecyclerAdapter(List<ColorDataType.Color> colors){
        this.colors = colors;
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_color, parent, false);
        ColorViewHolder cvh = new ColorViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int i) {
        ColorViewHolder.container.setBackgroundColor(Color.parseColor(colors.get(i).getColor()));
        ColorViewHolder.name.setText(colors.get(i).getNameColor());
        ColorViewHolder.number.setText(colors.get(i).getColor());
        ColorViewHolder.percent.setText(colors.get(i).getPercent());
    }

    @Override
    public int getItemCount() {
        return colors.size();
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
