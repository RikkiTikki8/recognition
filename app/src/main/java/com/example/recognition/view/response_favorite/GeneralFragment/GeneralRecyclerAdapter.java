package com.example.recognition.view.response_favorite.GeneralFragment;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recognition.R;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;
import com.example.recognition.types.GeneralDataType;
import com.example.recognition.view.response_favorite.GenDemViewHolder;

public class GeneralRecyclerAdapter extends RecyclerView.Adapter<GenDemViewHolder>{
    int threshold;
    GeneralDataType.Property[] data;
    GenDemViewHolder holder;

    public GeneralRecyclerAdapter(GeneralDataType.Property[] data, int threshold){
        this.data = data;
        this.threshold = threshold;
    }

    @NonNull
    @Override
    public GenDemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_param_list, parent, false);
        return new GenDemViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull GenDemViewHolder holder, int i) {
        this.holder = holder;
        if (data[i].getValue() < threshold) {
            GenDemViewHolder.view.setVisibility(View.GONE);
        } else {
            GenDemViewHolder.view.setVisibility(View.VISIBLE);
            GenDemViewHolder.name.setText(data[i].getName());
            GenDemViewHolder.value.setText(String.format("%.3f", data[i].getValue()));
        }
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

}
