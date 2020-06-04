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

public class ColorRecyclerAdapter extends RecyclerView.Adapter<ColorRecyclerAdapter.ColorViewHolder>{

    ColorDataType.Color[] data;
    ColorViewHolder holder;

    public ColorRecyclerAdapter(ColorDataType.Color[] data){
        this.data = data;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_color, parent, false);
        return new ColorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int i) {
        this.holder = holder;
        holder.container.setBackgroundColor(Color.parseColor(data[i].getColor()));
        holder.name.setText(data[i].getNameColor());
        holder.number.setText(data[i].getColor());
        holder.percent.setText(data[i].getPercent());
    }

    @Override
    public int getItemCount() {
        return data.length;
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
